package fun.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import fun.model.HealthViewDAO;
import fun.model.HealthViewVO;


public class HealthViewDAOHbm implements HealthViewDAO {

	private static final String GET_ALL_STMT = "from HealthViewVO order by no";
	@Override
	public HealthViewVO selectByPrimaryKey(int no) {
		HealthViewVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			vo = (HealthViewVO) session.get(HealthViewVO.class, no);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}

	@Override
	public List<HealthViewVO> getAll() {
		List<HealthViewVO> list = null;
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
	public HealthViewVO insert(HealthViewVO vo) {
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
	public HealthViewVO update(HealthViewVO vo) {
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
			HealthViewVO healthviewVO = (HealthViewVO) session.get(HealthViewVO.class, no);
			session.delete(healthviewVO);
			session.getTransaction().commit();
			result = true;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

}
