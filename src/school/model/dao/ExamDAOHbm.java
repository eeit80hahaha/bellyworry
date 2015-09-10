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

	private static final String GET_ALL_STMT = "from ExamVO order by no";
	
	@Override
	public List<ExamVO> getAll() {
		List<ExamVO> list = null;
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
	public ExamVO insert(ExamVO vo) {
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
		return examVO;
	}

	@Override
	public ExamVO update(ExamVO vo) {
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
		return examVO;
	}

	@Override
	public boolean delete(int no) {
		
		boolean flag1= false;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

			ExamVO examVO = new ExamVO();
			examVO.setNo(no);
			session.delete(examVO);

			session.getTransaction().commit();
			flag1= true;
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
//			throw ex;
		}
		
		return flag1;
	}

}
