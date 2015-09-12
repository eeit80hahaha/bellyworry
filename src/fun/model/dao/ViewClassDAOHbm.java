package fun.model.dao;

import hibernate.util.HibernateUtil;
import init.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import news.model.ActivityVO;

import org.hibernate.Query;
import org.hibernate.Session;

import register.model.MemberVO;
import fun.model.ViewClassDAO;
import fun.model.ViewClassVO;

public class ViewClassDAOHbm implements ViewClassDAO {
	
	private static final String SELECT_BY_NAME =
			"from ViewClassVO where name=?";

	@Override
	public ViewClassVO selectByName(String name){
		ViewClassVO viewclassVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_NAME);
			query.setParameter(0, name);
			List<ViewClassVO> list = query.list();
			if(list.size()!=0){
				viewclassVO = list.get(0);
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return viewclassVO;
	}
	
	private static final String GET_ALL_STMT = "from ViewClassVO order by viewClassNo";

	@Override
	public ViewClassVO selectByPrimaryKey(int viewClassNo) {
		ViewClassVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			vo = (ViewClassVO) session.get(ViewClassVO.class, viewClassNo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}

	@Override
	public List<ViewClassVO> getAll() {
		List<ViewClassVO> list = null;
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
	public int insert(ViewClassVO vo) {
		ViewClassVO viewclassVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);			
			viewclassVO = (ViewClassVO) session.get(ViewClassVO.class, vo.getViewClassNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return viewclassVO.getViewClassNo();
	}
	private static final String UPDATE = "update ViewClassVO set"
			+ " name=?  where viewClassNo=?";

	@Override
	public int update(ViewClassVO vo) {   //100004運動中心
		int result = 0;
		ViewClassVO temp1 = this.selectByName(vo.getName());//100001運動中心 
		if(temp1!=null && temp1.getViewClassNo()!=vo.getViewClassNo()){
			result = -100;
		}else{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				Query query = session.createQuery(UPDATE);
				query.setParameter(0, vo.getName());
				query.setParameter(1, vo.getViewClassNo());
				result = query.executeUpdate();
				session.getTransaction().commit();
			} catch (RuntimeException ex) {
				session.getTransaction().rollback();
				throw ex;
			}
		}
		return result;
	}

	@Override
	public boolean delete(int viewClassNo) {
		boolean result = false;
		if( this.selectByPrimaryKey(viewClassNo) != null){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				ViewClassVO deptVO = (ViewClassVO) session.get(ViewClassVO.class, viewClassNo);
				session.delete(deptVO);
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
