package health.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import health.model.EatRecordDAO;
import health.model.EatRecordVO;
import hibernate.util.HibernateUtil;

public class EatRecordDAOHbm implements EatRecordDAO {

	@Override
	public EatRecordVO selectByPrimaryKey(long no){
		EatRecordVO eatRecordVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			eatRecordVO = (EatRecordVO) session.get(EatRecordVO.class, no);
			session.getTransaction().commit();
		}catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return eatRecordVO;
	}
	
	private static final String SELECT_BY_MEMBER_NO = "from EatRecordVO where memberNo=? order by no";

	@Override
	public List<EatRecordVO> selectByMemberNo(int memberNo){
		List<EatRecordVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_MEMBER_NO);
			query.setParameter(0, memberNo);
			result = query.list();
			session.getTransaction().commit();
		}catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}
	
	private static final String SELECT_ALL =
			"from EatRecordVO order by no";
	
	@Override
	public List<EatRecordVO> getAll(){
		List<EatRecordVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_ALL);
			result = query.list();
			session.getTransaction().commit();
		}catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public long insert(EatRecordVO vo){
		long result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			session.saveOrUpdate(vo);
			session.getTransaction().commit();
			result = vo.getNo();
		}catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}
	
	private static final String UPDATE = " update EatRecordVO e set e.memberNo=?, e.date=?, e.time=?, e.foodNo=?, e.count=? where e.no=?";

	@Override
	public int update(EatRecordVO vo){
		int result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(UPDATE);
			query.setParameter(0, vo.getMemberNo());
			query.setParameter(1, vo.getDate());
			query.setParameter(2, vo.getTime());
			query.setParameter(3, vo.getFoodCalVO());
			query.setParameter(4, vo.getCount());
			query.setParameter(5, vo.getNo());
			result = query.executeUpdate();
			session.getTransaction().commit();
		}catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public boolean delete(long no){
		boolean result = false;
		if(this.selectByPrimaryKey(no)!=null){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				EatRecordVO eatRecordVO = (EatRecordVO) session.get(EatRecordVO.class, no);
				session.delete(eatRecordVO);
				session.getTransaction().commit();
				result = true;
			} catch (RuntimeException ex) {
				session.getTransaction().rollback();
				throw ex;
			}
		}		
		return result;
	}
	

	private static final String GETEATCALLIST = "select sum(e.count) from EatRecordVO e where e.memberNo=? and e.date=?";
	
	@Override
	public int eatcal(int memberNo, java.util.Date date) {
		int result = -1000;
		long sum=0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GETEATCALLIST);
			query.setParameter(0, memberNo);
			query.setParameter(1, date);
			List<Object> tmp = query.list();
		    if(tmp.get(0)!=null){
		    	sum = (long) tmp.get(0);
		    }
			result = (int) sum;
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	private static final String GETEATDAY = "from EatRecordVO e where e.memberNo=? and e.date=?";
	
	@Override
	public List<EatRecordVO> eatday(int memberNo, java.util.Date date) {
		List<EatRecordVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GETEATDAY);
			query.setParameter(0, memberNo);
			query.setParameter(1, date);
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}
	
	private static final String SELECT_BY_MEMBER_DATE_TIME = 
			"from EatRecordVO where memberNo=? and  date=? and time=?";

	@Override
	public List<EatRecordVO> getEatrmdt(int memberNo,java.util.Date healthDate,String eattime){
		List<EatRecordVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_MEMBER_DATE_TIME);
			query.setParameter(0, memberNo);
			query.setParameter(1, healthDate);
			query.setParameter(2, eattime);	
			result = query.list();
			session.getTransaction().commit();
		}catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}
	
}
