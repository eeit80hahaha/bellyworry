package calories.model.dao;

import food.combo.model.MealNameVO;
import health.model.HealthDiaryVO;
import hibernate.util.HibernateUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import calories.model.FoodCalDAO;
import calories.model.FoodCalVO;

public class FoodCalDAOHbm implements FoodCalDAO {
	private static final String GET_ALL = "from FoodCalVO ";

	@Override
	public FoodCalVO selectByPrimaryKey(int foodNo) {
		FoodCalVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			vo = (FoodCalVO) session.get(FoodCalVO.class, foodNo);
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return vo;

	}

	@Override
	public List<FoodCalVO> getAll() {
		List<FoodCalVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL);
			list = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}

		return list;
	}

	@Override
	public int insert(FoodCalVO vo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int result = 0;
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			result = (int) session.getIdentifier(vo);
			session.getTransaction().commit();

		} catch (Exception e) {
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
	public int update(FoodCalVO vo) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		int result = 0;
		try {
			session.beginTransaction();

			Query query = session
					.createQuery("update FoodCalVO e set name=?,menuNo=?,cal=?,e.count=?,weight=?,cookNo=?,picture=? where foodNo=?");

			query.setParameter(0, vo.getName());
			query.setParameter(1, vo.getMenuNo());
			query.setParameter(2, vo.getCal());
			query.setParameter(3, vo.getCount());
			query.setParameter(4, vo.getWeight());
			query.setParameter(5, vo.getCookNo());
			query.setParameter(6, vo.getPicture());
			query.setParameter(7, vo.getFoodNo());
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
	public boolean delete(int foodNo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		boolean result = false;
		try {
			session.beginTransaction();

			Query query = session
					.createQuery("delete from FoodCalVO where foodNo=?");
			query.setParameter(0, foodNo);
			int i = query.executeUpdate();

			if (i == 1) {
				result = true;
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}

		return result;
	}
	
private static final String GETDATEPAGE = "from FoodCalVO";
	
	@Override
	public List<FoodCalVO> getDatePage(int pageNo, int pageSize){
		
		List<FoodCalVO> result = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GETDATEPAGE);
			
	        query.setFirstResult((pageNo - 1) * pageSize);  
	        query.setMaxResults(pageSize);  
			
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	private static final String GETDATETOTALCOUNT = "select count(foodNo) from FoodCalVO";
	
	@Override
	public int getDateTotalCount() {
		int result=-1000;
		long sum=0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GETDATETOTALCOUNT);
			
			
			List<Object> tmp = query.list();
		    if(tmp.get(0)!=null){
		    	sum = (long) tmp.get(0);
		    }
			result = (int) sum;
			
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return result;
	}

	private static final String selectByMenuNo = "from FoodCalVO where menuNo=?";
	@Override
	public List<FoodCalVO> selectByMenuNo (int menuNo) {
		List<FoodCalVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {			
			session.beginTransaction();
			Query query = session.createQuery(selectByMenuNo);
			query.setParameter(0, menuNo);
			list = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return list;

	}
	

}
