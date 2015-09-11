package news.model.dao;

import fun.model.HealthViewVO;
import hibernate.util.HibernateUtil;

import java.io.InputStream;
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

	@Override
	public ActivityVO insert(ActivityVO vo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}

	@Override
	public ActivityVO update(ActivityVO vo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}

	@Override
	public boolean delete(int no) {
		boolean result = false;
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
		return result;
	}
}
