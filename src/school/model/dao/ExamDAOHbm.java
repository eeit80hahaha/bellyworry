package school.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import school.model.ExamDAO;
import school.model.ExamVO;

public class ExamDAOHbm implements ExamDAO {

	@Override
	public ExamVO selectByPrimaryKey(int no) {

		ExamVO examVO = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
			examVO = (ExamVO) session.get(ExamVO.class, no);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
		return examVO;
	}

	private static final String SELECT_ALL = "from ExamVO order by no";
	
	@Override
	public List<ExamVO> getAll() {
		List<ExamVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_ALL);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public int insert(ExamVO vo) {
		ExamVO examVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			examVO = (ExamVO) session.get(ExamVO.class, vo.getNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return examVO.getNo();
	}

	private static final String UPDATE = "update ExamVO set"
			+ " content=?, correct=?, optA=?, optB=?, optC=? where no=?";

	@Override
	public int update(ExamVO vo) {
		int result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(UPDATE);
			query.setParameter(0, vo.getContent());
			query.setParameter(1, vo.getCorrect());
			query.setParameter(2, vo.getOptA());
			query.setParameter(3, vo.getOptB());
			query.setParameter(4, vo.getOptC());
			query.setParameter(5, vo.getNo());
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
					ExamVO examVO = new ExamVO();
					examVO.setNo(no);
					session.delete(examVO);
					session.getTransaction().commit();
					result= true;
	
			} catch (RuntimeException ex) {
				session.getTransaction().rollback();
				throw ex;
			}
		}		
		return result;
	}
	
private static final String GETDATEPAGE = "from ExamVO";
	
	@Override
	public List<ExamVO> getDatePage(int pageNo, int pageSize){
		
		List<ExamVO> result = null;
		
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

	private static final String GETDATETOTALCOUNT = "select count(no) from ExamVO";
	
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

}
