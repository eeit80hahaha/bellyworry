package food.recipes.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import food.recipes.model.FoodItemDAO;
import food.recipes.model.FoodItemVO;

public class FoodItemDAOHbm implements FoodItemDAO {
	@Override
	public FoodItemVO selectByPrimaryKey(int useFoodNo) {

		FoodItemVO foodItemVO = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			foodItemVO = (FoodItemVO) session.get(FoodItemVO.class, useFoodNo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return foodItemVO;
	}

	private static final String GET_ALL_STMT = "from FoodItemVO order by useFoodNo";
	@Override
	public List<FoodItemVO> getAll() {
		List<FoodItemVO> list = null;
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
	public FoodItemVO insert(FoodItemVO vo) {
		FoodItemVO foodItemVO = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			foodItemVO = (FoodItemVO) session.get(FoodItemVO.class, vo.getUseFoodNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return foodItemVO;
	}
	@Override
	public FoodItemVO update(FoodItemVO vo) {
		FoodItemVO foodItemVO = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			foodItemVO = (FoodItemVO) session.get(FoodItemVO.class, vo.getUseFoodNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return foodItemVO;
	}
	@Override
	public boolean delete(int useFoodNo) {
		
		boolean flag1= false;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

			FoodItemVO examVO = new FoodItemVO();
			examVO.setUseFoodNo(useFoodNo);
			session.delete(examVO);

			session.getTransaction().commit();
			flag1= true;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
		}	
		return flag1;
	}
}
