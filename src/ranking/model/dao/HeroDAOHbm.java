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
	public HeroVO insert(HeroVO vo) {
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
		return heroVO;
	}

	@Override
	public HeroVO update(HeroVO vo) {
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
		return heroVO;
	}

	@Override
	public boolean delete(int memberNo) {
		boolean flag1= false;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

			HeroVO heroVO = new HeroVO();
			heroVO.setMemberNo(memberNo);
			session.delete(heroVO);

			session.getTransaction().commit();
			flag1= true;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
//			throw ex;
		}
		return flag1;
	}

}
