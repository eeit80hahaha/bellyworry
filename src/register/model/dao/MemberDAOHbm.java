package register.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;
import init.GlobalService;
import register.model.MemberDAO;
import register.model.MemberVO;

public class MemberDAOHbm implements MemberDAO {
	
	@Override
	public MemberVO selectByPrimaryKey(int memberNo){
		MemberVO memberVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			memberVO = (MemberVO) session.get(MemberVO.class, memberNo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return memberVO;
	}
	
	private static final String SELECT_BY_ID =
			"from Member where id=?";

	@Override
	public MemberVO selectById(String id){
		MemberVO memberVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_ID);
			query.setParameter(1, id);
			List<MemberVO> list = query.list();
			memberVO = list.get(0);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return memberVO;
	}
	
	private static final String SELECT_BY_EMAIL =
			"from Member where email=?";

	@Override
	public MemberVO selectByEmail(String email){
		MemberVO memberVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_EMAIL);
			query.setParameter(1, email);
			List<MemberVO> list = query.list();
			memberVO = list.get(0);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return memberVO;
	}
	
	private static final String SELECT_BY_PURVIEW =
			"from Member where Purview=?";

	@Override
	public List<MemberVO> selectByPurview(int purview){
		List<MemberVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_PURVIEW);
			query.setParameter(1, purview);
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}
	
	private static final String SELECT_ALL =
			"from Member order by memberNo";

	@Override
	public List<MemberVO> getAll(){
		List<MemberVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_ALL);
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public int insert(MemberVO vo){
		int result = 0;
		if(this.selectById(vo.getId())!=null){
			result = -100;
		}else if(this.selectByEmail(vo.getEmail())!=null){
			result = -100;
		}else{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				session.saveOrUpdate(vo);
				result = vo.getMemberNo();
				session.getTransaction().commit();
			} catch (RuntimeException ex) {
				session.getTransaction().rollback();
				throw ex;
			}			
		}
		return result;
	}

	@Override
	public int update(MemberVO vo){
		int result = 0;
		if(this.selectByPrimaryKey(vo.getMemberNo())==null){
			result = 0;
		}else if(this.selectById(vo.getId())!=null){
			result = -100;
		}else if(this.selectByEmail(vo.getEmail())!=null){
			result = -100;
		}else{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				session.saveOrUpdate(vo);
				result = vo.getMemberNo();
				session.getTransaction().commit();
			} catch (RuntimeException ex) {
				session.getTransaction().rollback();
				throw ex;
			}			
		}
		return result;
	}

	@Override
	public boolean delete(int memberNo){
		boolean result = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MemberVO vo = (MemberVO) session.get(MemberVO.class, memberNo);
			session.delete(vo);
			session.getTransaction().commit();
			result = true;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}		
		return result;
	}
}