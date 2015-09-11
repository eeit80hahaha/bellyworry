package food.recipes.model.dao;


import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import food.recipes.model.FoodListDAO;
import food.recipes.model.FoodListVO;

public class FoodListDAOHbm implements FoodListDAO {
	@Override
	public FoodListVO selectByPrimaryKey(int cookNo,int useFoodNo) {

		FoodListVO foodListVO = null;
		

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery("from FoodListVO where cookNo=? and useFoodNo=?");
			query.setParameter(0, cookNo);
			query.setParameter(1, useFoodNo);
			List<FoodListVO> list = query.list();
			if(list.size()>0){
				foodListVO = list.get(0);
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return foodListVO;
	}

	private static final String GET_ALL_STMT = "from FoodListVO";
	@Override
	public List<FoodListVO> getAll() {
		List<FoodListVO> list = null;
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
	public FoodListVO insert(FoodListVO vo) {
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
//	@Override
//	public FoodListVO update(FoodListVO vo) {
//		FoodListVO foodListVO = null;
//		
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			session.saveOrUpdate(vo);
//			foodListVO = (FoodListVO) session.get(FoodListVO.class, vo.getCookNo());
//			session.getTransaction().commit();
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//		}
//		return foodListVO;
//	}
	@Override
	public boolean delete(int cookNo,int useFoodNo) {
		
		boolean flag1= false;	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("delete from FoodListVO where cookNo=? and useFoodNo=?");
			query.setParameter(0,cookNo);
			query.setParameter(1,useFoodNo);
			int update = query.executeUpdate();
			if(update==1){
				flag1 = true;
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
		}	
		return flag1;
	}
}
