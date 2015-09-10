package ranking.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ranking.model.HeroVO;
import ranking.model.ReflectDAO;
import ranking.model.ReflectVO;

public class ReflectDAOHbm implements ReflectDAO {

	@Override
	public ReflectVO selectByPrimaryKey(int no) {
		ReflectVO reflectVO = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			reflectVO = (ReflectVO) session.get(ReflectVO.class, no);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return reflectVO;
	}

	private static final String GET_ALL_STMT = "from ReflectVO order by no";
	
	@Override
	public List<ReflectVO> getAll() {
		List<ReflectVO> list = null;
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
	public ReflectVO insert(ReflectVO vo) {
		ReflectVO reflectVO = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			reflectVO = (ReflectVO) session.get(ReflectVO.class, vo.getNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return reflectVO;
	}

	@Override
	public ReflectVO update(ReflectVO vo) {
		ReflectVO reflectVO = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			reflectVO = (ReflectVO) session.get(ReflectVO.class, vo.getNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return reflectVO;
	}

	@Override
	public boolean delete(int no) {
		boolean flag1= false;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

			ReflectVO reflectVO = new ReflectVO();
			reflectVO.setNo(no);
			session.delete(reflectVO);

			session.getTransaction().commit();
			flag1= true;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
//			throw ex;
		}
		return flag1;
	}

}
