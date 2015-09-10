package register.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.util.HibernateUtil;
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
			"from MemberVO where id=?";

	@Override
	public MemberVO selectById(String id){
		MemberVO memberVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_ID);
			query.setParameter(0, id);
			List<MemberVO> list = query.list();
			if(list.size()!=0){
				memberVO = list.get(0);
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return memberVO;
	}
	
	private static final String SELECT_BY_EMAIL =
			"from MemberVO where email=?";

	@Override
	public MemberVO selectByEmail(String email){
		MemberVO memberVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_EMAIL);
			query.setParameter(0, email);
			List<MemberVO> list = query.list();
			if(list.size()!=0){
				memberVO = list.get(0);
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return memberVO;
	}
	
	private static final String SELECT_BY_PURVIEW =
			"from MemberVO where Purview=?";

	@Override
	public List<MemberVO> selectByPurview(int purview){
		List<MemberVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_PURVIEW);
			query.setParameter(0, purview);
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}
	
	private static final String SELECT_ALL =
			"from MemberVO order by memberNo";

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
	public boolean delete(int memberNo){
		boolean result = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			MemberVO vo = (MemberVO) session.get(MemberVO.class, memberNo);
			if(vo != null){
				session.delete(vo);
				result = true;
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}		
		return result;
	}
}