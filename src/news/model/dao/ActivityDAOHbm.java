package news.model.dao;

import fun.model.HealthViewVO;
import hibernate.util.HibernateUtil;

import java.io.InputStream;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import news.model.ActivityDAO;
import news.model.ActivityVO;

public class ActivityDAOHbm implements ActivityDAO {
	
	private static final String GET_ALL_STMT = "from ActivityVO order by no";

	@Override
	public ActivityVO selectByPrimaryKey(int no) {
		ActivityVO vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			vo = (ActivityVO) session.get(ActivityVO.class, no);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}

	@Override
	public List<ActivityVO> getAll() {
		List<ActivityVO> list = null;
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
	public int insert(ActivityVO vo) {
		ActivityVO activityVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			activityVO = (ActivityVO) session.get(ActivityVO.class, vo.getNo());
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return activityVO.getNo();
	}

	private static final String UPDATE = "update ActivityVO set"
			+ " name=?, content=?, startTime=?, endTime=?, address=?, picture=?  where no=?";
	@Override
	public int update(ActivityVO vo) {
		int result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(UPDATE);
			query.setParameter(0, vo.getName());
			query.setParameter(1, vo.getContent());
			query.setParameter(2, vo.getStartTime());
			query.setParameter(3, vo.getEndTime());
			query.setParameter(4, vo.getAddress());
			query.setParameter(5, vo.getPicture());
			query.setParameter(6, vo.getNo());
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
				ActivityVO activityVO = (ActivityVO) session.get(ActivityVO.class, no);
				session.delete(activityVO);
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
