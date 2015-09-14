package food.combo.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import food.combo.model.DayMealDAO;
import food.combo.model.DayMealVO;

public class DayMealDAOHbm implements DayMealDAO {
	private static final String GET_ALL = "from DayMealVO order by no";

	@Override
	public DayMealVO selectByPrimaryKey(int no) {
		DayMealVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			vo = (DayMealVO) session.get(DayMealVO.class, no);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<DayMealVO> getAll() {
		List<DayMealVO> list = null;
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
	public int insert(DayMealVO vo) {
		int result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			result = (int) session.getIdentifier(vo);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			String error = e.getCause().getMessage();
			int i = error.indexOf("違反 UNIQUE KEY 條件約束");
			if(i != -1){
				return -100;
			}
		}
		return result;
	}

	@Override
	public int update(DayMealVO vo) {
		int result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session
					.createQuery("update DayMealVO set name=?,breakfast=?,lunch=?,dinner=? where no=?");
			query.setParameter(0, vo.getName());
			query.setParameter(1, vo.getBreakfast());
			query.setParameter(2, vo.getLunch());
			query.setParameter(3, vo.getDinner());
			query.setParameter(4, vo.getNo());
			int i = query.executeUpdate();
			session.getTransaction().commit();
			if (i > 0) {
				result = i;
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			String error = e.getCause().getMessage();
			int i = error.indexOf("違反 UNIQUE KEY 條件約束");
			if(i != -1){
				return -100;
			}
		}
		return result;
	}

	@Override
	public boolean delete(int no) {
		boolean result = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session
					.createQuery("delete from DayMealVO where no=?");
			query.setParameter(0, no);
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
