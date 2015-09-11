package fun.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import fun.model.ViewClassDAO;
import fun.model.ViewClassVO;

public class ViewClassDAOHbm implements ViewClassDAO {
	
	private static final String GET_ALL_STMT = "from ViewClassVO order by viewClassNo";

	@Override
	public ViewClassVO selectByPrimaryKey(int viewClassNo) {
		ViewClassVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			vo = (ViewClassVO) session.get(ViewClassVO.class, viewClassNo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}

	@Override
	public List<ViewClassVO> getAll() {
		List<ViewClassVO> list = null;
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
	public ViewClassVO insert(ViewClassVO vo) {
		
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
	public ViewClassVO update(ViewClassVO vo) {
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
	public boolean delete(int viewClassNo) {
		boolean result = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ViewClassVO deptVO = (ViewClassVO) session.get(ViewClassVO.class, viewClassNo);
			session.delete(deptVO);
			session.getTransaction().commit();
			result = true;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

}
