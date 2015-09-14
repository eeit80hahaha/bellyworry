package food.recipes.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import food.recipes.model.CookDAO;
import food.recipes.model.CookVO;

public class CookDAOHbm implements CookDAO {
	@Override
	public CookVO selectByPrimaryKey(int cookNo) {

		CookVO cookVO = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			cookVO = (CookVO) session.get(CookVO.class, cookNo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return cookVO;
	}

	private static final String GET_ALL_STMT = "from CookVO order by cookNo";
	@Override
	public List<CookVO> getAll() {
		List<CookVO> list = null;
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
	public int insert(CookVO vo) {
		CookVO cookVO = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			cookVO = (CookVO) session.get(CookVO.class, vo.getCookNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return cookVO.getCookNo();
	}
	@Override
	public int update(CookVO vo) {
		CookVO cookVO = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			cookVO = (CookVO) session.get(CookVO.class, vo.getCookNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return cookVO.getCookNo();
	}
	@Override
	public boolean delete(int cookNo) {
		
		boolean flag1= false;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

			CookVO examVO = new CookVO();
			examVO.setCookNo(cookNo);
			session.delete(examVO);

			session.getTransaction().commit();
			flag1= true;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
		}	
		return flag1;
	}
}
