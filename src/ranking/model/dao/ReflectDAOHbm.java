package ranking.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ranking.model.HeroVO;
import ranking.model.ReflectDAO;
import ranking.model.ReflectVO;

public class ReflectDAOHbm implements ReflectDAO {

	@Override
	public ReflectVO selectByPrimaryKey(int no) {
		ReflectVO reflectVO = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			reflectVO = (ReflectVO) session.get(ReflectVO.class, no);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return reflectVO;
	}

	private static final String GET_ALL_STMT = "from ReflectVO order by no";
	
	@Override
	public List<ReflectVO> getAll() {
		List<ReflectVO> list = null;
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
	public int insert(ReflectVO vo) {
		ReflectVO reflectVO = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			reflectVO = (ReflectVO) session.get(ReflectVO.class, vo.getNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return reflectVO.getNo();
	}

	private static final String UPDATE = "update ReflectVO set "
			+ " reflectedNo=?, authorNo=?, reflectedDate=?, authorDate=? where no=?";

	@Override
	public int update(ReflectVO vo) {
		int result = 0;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(UPDATE);
			query.setParameter(0, vo.getReflectedNo());
			query.setParameter(1, vo.getAuthorNo());
			query.setParameter(2, vo.getReflectedDate());
			query.setParameter(3, vo.getAuthorDate());
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
		boolean result= false;
		if( this.selectByPrimaryKey(no) != null){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				ReflectVO reflectVO = new ReflectVO();
				reflectVO.setNo(no);
				session.delete(reflectVO);
				session.getTransaction().commit();
				result= true;
			} catch (RuntimeException ex) {
				session.getTransaction().rollback();
				throw ex;
			}
		}
		return result;
	}

}
