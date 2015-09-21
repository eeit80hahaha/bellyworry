package fun.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fun.model.HealthViewDAO;
import fun.model.HealthViewVO;
import fun.model.ViewClassVO;
import hibernate.util.HibernateUtil;


public class HealthViewDAOHbm implements HealthViewDAO {

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
	
	private static final String SELECT_BY_LAT_LNG = "from HealthViewVO where lat=? and lng=?";
	public HealthViewVO selectByLatLng(float lat,float lng) {
		HealthViewVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_LAT_LNG);
			query.setParameter(0, lat);
			query.setParameter(1, lng);
			List<HealthViewVO> list = query.list();
			if(list.size()!=0){
				vo = list.get(0);
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}
	
	private static final String SELECT_BY_CLASS = "from HealthViewVO where viewClassVO=? order by no";
	public List<HealthViewVO> selectByViewClassVO(ViewClassVO vo) {
		List<HealthViewVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_CLASS);
			query.setParameter(0, vo);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	private static final String GET_ALL_STMT = "from HealthViewVO order by no";
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
		int result = 0;
		if(this.selectByLatLng(vo.getLat(), vo.getLng())!=null){	//相同地點座標
			result = -100;
		}else{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				session.saveOrUpdate(vo);
				result = vo.getNo();
				session.getTransaction().commit();
			} catch (RuntimeException ex) {
				session.getTransaction().rollback();
				throw ex;
			}
		}
		return result;
	}

	private static final String UPDATE = "update HealthViewVO set"
			+ " name=?, viewClassVO=?, lat=?, lng=?  where no=?";
	@Override
	public int update(HealthViewVO vo) {
		int result = 0;
		HealthViewVO temp1 = this.selectByLatLng(vo.getLat(), vo.getLng());
		if(temp1!=null && temp1.getNo()!=vo.getNo()){
			result = -100;
		}
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(UPDATE);
			query.setParameter(0, vo.getName());
			query.setParameter(1, vo.getViewClassVO());
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