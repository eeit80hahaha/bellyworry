package food.combo.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.sql.Insert;
import org.hibernate.util.JDBCExceptionReporter;

import food.combo.model.MealNameDAO;
import food.combo.model.MealNameVO;

public class MealNameDAOHbm implements MealNameDAO {

	private static final String GET_ALL = "from MealNameVO";

	@Override
	public MealNameVO selectByPrimaryKey(int mealNo) {
		MealNameVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			vo = (MealNameVO) session.get(MealNameVO.class, mealNo);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<MealNameVO> getAll() {
		List<MealNameVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL);
			list = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insert(MealNameVO vo) {
		int result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			result = (int) session.getIdentifier(vo);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			session.getTransaction().rollback();
			String error = ex.getCause().getMessage();
			int i = error.indexOf("違反 UNIQUE KEY 條件約束");
			if (i != -1) {
				return -100;
			}
			// ex.printStackTrace();
			// throw ex;
		}
		return result;
	}

	@Override
	public int update(MealNameVO vo) {
		int result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

			Query query = session
					.createQuery("update MealNameVO set name=? where mealNo=?");
			query.setParameter(0, vo.getName());
			query.setParameter(1, vo.getMealNo());

			int i = query.executeUpdate();
			session.getTransaction().commit();
			if (i > 0) {
				result = i;
			}

		} catch (HibernateException e) {

			session.getTransaction().rollback();
			String error = e.getCause().getMessage();
			int i = error.indexOf("違反 UNIQUE KEY 條件約束");
			if (i != -1) {
				return -100;
			}
		}
		return result;
	}

	@Override
	public boolean delete(int mealNo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		boolean result = false;
		try {
			session.beginTransaction();

			Query query = session
					.createQuery("delete from MealNameVO where mealNo=?");
			query.setParameter(0, mealNo);
			int i = query.executeUpdate();

			if (i == 1) {
				result = true;
			}

			session.getTransaction().commit();

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}
}
