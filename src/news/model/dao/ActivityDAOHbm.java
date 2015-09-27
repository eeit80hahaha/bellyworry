package news.model.dao;

import fun.model.HealthViewVO;
import hibernate.util.HibernateUtil;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import news.model.ActivityDAO;
import news.model.ActivityVO;

public class ActivityDAOHbm implements ActivityDAO {
	
	private static final String GET_ALL_STMT = "from ActivityVO order by no";

	@Override
	public ActivityVO selectByPrimaryKey(int no) {
		ActivityVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			vo = (ActivityVO) session.get(ActivityVO.class, no);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}
	
	@Override
	public List<java.sql.Timestamp> sawendtime() {
	List<java.sql.Timestamp> list = null;
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("select endTime from ActivityVO");
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
				session.getTransaction().rollback();
			throw ex;
			}
		return list;
	}
	
	@Override
	public List<String> sawaddress() {
	List<String> list = null;
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("select address from ActivityVO");
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
				session.getTransaction().rollback();
			throw ex;
			}
		return list;
	}
	
	@Override
	public List<ActivityVO> getAll() {
		List<ActivityVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	public String getDateTime(){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
//		System.out.println(strDate);
		return strDate;
		}

	@Override
	public int insert(ActivityVO vo) {
		ActivityVO activityVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			activityVO = (ActivityVO) session.get(ActivityVO.class, vo.getNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return activityVO.getNo();
	}

	private static final String UPDATE = "update ActivityVO set"
			+ " name=?, content=?, startTime=?, endTime=?, address=?, picture=?, url=?, boss=?  where no=?";
	@Override
	public int update(ActivityVO vo) {
		int result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(UPDATE);
			query.setParameter(0, vo.getName());
			query.setParameter(1, vo.getContent());
			query.setParameter(2, vo.getStartTime());
			query.setParameter(3, vo.getEndTime());
			query.setParameter(4, vo.getAddress());
			query.setParameter(5, vo.getPicture());
			query.setParameter(6, vo.getUrl());
			query.setParameter(7, vo.getBoss());
			query.setParameter(8, vo.getNo());
			result = query.executeUpdate();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public boolean delete(int no) {
		boolean result = false;
		if( this.selectByPrimaryKey(no) != null){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				ActivityVO activityVO = (ActivityVO) session.get(ActivityVO.class, no);
				session.delete(activityVO);
				session.getTransaction().commit();
				result = true;
			} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
			}
		}
		return result;
	}
	
	
	@Override
	public List<ActivityVO> findBySname(String aa) {
		List<ActivityVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from ActivityVO s where s.address like'%"+aa+"%'");
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	//page
private static final String GETDATEPAGE = "from ActivityVO";
	
	@Override
	public List<ActivityVO> getDatePage(int pageNo, int pageSize){
		
		List<ActivityVO> result = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GETDATEPAGE);
			
	        query.setFirstResult((pageNo - 1) * pageSize);  
	        query.setMaxResults(pageSize);  
			
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	private static final String GETDATETOTALCOUNT = "select count(no) from ActivityVO";
	
	@Override
	public int getDateTotalCount() {
		int result=-1000;
		long sum=0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GETDATETOTALCOUNT);
			
			
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
	
}