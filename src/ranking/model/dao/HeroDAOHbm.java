package ranking.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ranking.model.HeroDAO;
import ranking.model.HeroVO;
import school.model.ExamVO;

public class HeroDAOHbm implements HeroDAO {

	@Override
	public HeroVO selectByPrimaryKey(int memberNo) {
		HeroVO heroVO = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			heroVO = (HeroVO) session.get(HeroVO.class, memberNo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return heroVO;
	}

	private static final String GET_ALL_STMT = "from HeroVO order by memberNo";
	
	@Override
	public List<HeroVO> getAll() {
		List<HeroVO> list = null;
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

	@Override
	public int insert(HeroVO vo) {
		HeroVO heroVO = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			heroVO = (HeroVO) session.get(HeroVO.class, vo.getMemberNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return heroVO.getMemberNo();
	}

	private static final String UPDATE = "update HeroVO set "
			+ " weightDiff=?, num=? where memberNo=?";
	
	@Override
	public int update(HeroVO vo) {
		int result = 0;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(UPDATE);
			query.setParameter(0, vo.getWeightDiff());
			query.setParameter(1, vo.getNum());
			query.setParameter(2, vo.getMemberNo());
			result = query.executeUpdate();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public boolean delete(int memberNo) {
		boolean result= false;
		if( this.selectByPrimaryKey(memberNo) != null){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				HeroVO heroVO = new HeroVO();
				heroVO.setMemberNo(memberNo);
				session.delete(heroVO);
				session.getTransaction().commit();
				result= true;
			} catch (RuntimeException ex) {
				session.getTransaction().rollback();
				throw ex;
			}
		}
		return result;
	}

}
