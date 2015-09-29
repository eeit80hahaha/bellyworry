package food.combo.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import food.combo.model.MealDetailDAO;
import food.combo.model.MealDetailVO;
import food.combo.model.MealNameVO;

public class MealDetailDAOHbm implements MealDetailDAO {
	private static final String GET_ALL = "from MealDetailVO";

	@Override
	public MealDetailVO selectByPrimaryKey(int mealNo, int foodNo) {

		MealDetailVO result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

			Query query = session
					.createQuery("from MealDetailVO where mealNo=? and foodNo=?");
			query.setParameter(0, mealNo);
			query.setParameter(1, foodNo);
			List<MealDetailVO> list = query.list();
			result = list.get(0);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<MealDetailVO> getAll() {
		List<MealDetailVO> list = null;
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
	public MealDetailVO insert(MealDetailVO vo) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.save(vo);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			String error = e.getCause().getMessage();
			// e.printStackTrace();
			int i = error.indexOf("違反 PRIMARY KEY 條件約束 ");
			if (i != -1) {
				return null;
			}

		}
		return vo;
	}

	// 無法update!
	// ********不能update,update沒有實質意義,但為了之後或許有其他功能,所以暫時保留,以備不時之需********
	@Override
	public MealDetailVO update(MealDetailVO vo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public boolean delete(int mealNo, int foodNo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		boolean result = false;
		try {
			session.beginTransaction();
			Query query = session
					.createQuery("delete from MealDetailVO where mealNo=? and foodNo=?");
			query.setParameter(0, mealNo);
			query.setParameter(1, foodNo);
			int i = query.executeUpdate();
			if (i == 1) {
				result = true;
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		// MealDetailVO vo = (MealDetailVO) session.get
		// session.delete(vo);

		return result;
	}

	
	@Override
	public List<MealDetailVO> selectByFoodNo(int foodno) {
		List<MealDetailVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {

			session.beginTransaction();
			Query query = session.createQuery("from MealDetailVO where foodNo=?");
			list = query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return list;
	}
}
