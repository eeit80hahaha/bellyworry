package ranking.model.dao;

import health.model.HealthDiaryVO;
import hibernate.util.HibernateUtil;

import java.util.Date;
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
		int result = -300;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			reflectVO = (ReflectVO) session.get(ReflectVO.class, vo.getNo());
			session.getTransaction().commit();
			result=reflectVO.getNo();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
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

	private static final String REPEATREFLECT = "from ReflectVO where reflectedNo=? and authorNo=? and reflectedDate=?";
	
	@Override
	public int repeatReflect(ReflectVO vo) {
		int result = -300;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(REPEATREFLECT);
			
			query.setParameter(0, vo.getReflectedNo());
			query.setParameter(1, vo.getAuthorNo());
			query.setParameter(2, vo.getReflectedDate()); 
			
			List<ReflectVO> tmp = query.list();
		    if(tmp.isEmpty()){
		    	//ok
		    	result = 1000;
		    }else{
		    	//Repeat
		    	result = -100;
		    }
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	private static final String GETPAGEID = "from ReflectVO where reflectedNo=? order by authorDate desc";

	@Override
	public List<ReflectVO> getPageNoID(int pageNo, int pageSize, int reflectedNo) {

		List<ReflectVO> result = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GETPAGEID);

			query.setParameter(0, reflectedNo);

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
	
	private static final String GETIDTOTALCOUNT = "select count(no) from ReflectVO where reflectedNo=?";

	@Override
	public int getPageIDTotalCount(int reflectedNo) {
		int result = -1000;
		long sum = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GETIDTOTALCOUNT);

			query.setParameter(0, reflectedNo);

			List<Object> tmp = query.list();
			if (tmp.get(0) != null) {
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
	
	
	private static final String GETPAGE = "from ReflectVO order by authorDate desc";

	@Override
	public List<ReflectVO> getPageNo(int pageNo, int pageSize) {

		List<ReflectVO> result = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GETPAGE);

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

	private static final String GETTOTALCOUNT = "select count(no) from ReflectVO";

	@Override
	public int getPageTotalCount() {
		int result = -1000;
		long sum = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GETTOTALCOUNT);


			List<Object> tmp = query.list();
			if (tmp.get(0) != null) {
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

//	private static final String a = "select count(no) from ReflectVO where reflectedNo=?";
	
	@Override
	public boolean deleteByND(int memberNo, Date date) {
		boolean result = false; 
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session
					.createQuery("delete from ReflectVO where reflectedNo=? and reflectedDate=?");
			query.setParameter(0, memberNo);
			query.setParameter(1, date);
			
			int i = query.executeUpdate();
			if (i > 0) {
				result = true;
			}
			session.getTransaction().commit();
//			System.out.println("刪除的筆數=" + i);
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;

		}
		return result;
	}
	
}
