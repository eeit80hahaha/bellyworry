package fun.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;

import news.model.ActivityVO;

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
	public int insert(HealthViewVO vo) {
		HealthViewVO healthViewVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			healthViewVO = (HealthViewVO) session.get(HealthViewVO.class, vo.getNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return healthViewVO.getNo();
	}

	private static final String UPDATE = "update HealthViewVO set"
			+ " name=?, viewClassNo=?, lat=?, lng=?  where no=?";
	@Override
	public int update(HealthViewVO vo) {
		int result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(UPDATE);
			query.setParameter(0, vo.getName());
			query.setParameter(1, vo.getViewClassNo());
			query.setParameter(2, vo.getLat());
			query.setParameter(3, vo.getLng());
			query.setParameter(4, vo.getNo());
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
				HealthViewVO healthviewVO = (HealthViewVO) session.get(HealthViewVO.class, no);
				session.delete(healthviewVO);
				session.getTransaction().commit();
				result = true;
			} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
			}
		}
		return result;
	}

}
