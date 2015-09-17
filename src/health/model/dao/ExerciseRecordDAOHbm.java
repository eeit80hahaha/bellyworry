package health.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import health.model.EatRecordVO;
import health.model.ExerciseRecordDAO;
import health.model.ExerciseRecordVO;
import hibernate.util.HibernateUtil;
import init.GlobalService;

public class ExerciseRecordDAOHbm implements ExerciseRecordDAO {
	
	@Override
	public ExerciseRecordVO selectByPrimaryKey(long no) {
		ExerciseRecordVO exerciseRecordVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			exerciseRecordVO = (ExerciseRecordVO) session.get(ExerciseRecordVO.class, no);
			session.getTransaction().commit();
		}catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return exerciseRecordVO;
	}
	
	private static final String SELECT_BY_MEMBER_NO = "from ExerciseRecordVO where memberNo=? order by no";

	@Override
	public List<ExerciseRecordVO> selectByMemberNo(int memberNo){
		List<ExerciseRecordVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_MEMBER_NO);
			query.setParameter(0, memberNo);
			result = query.list();
			session.getTransaction().commit();
		}catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}
	
	private static final String SELECT_ALL = "from ExerciseRecordVO order by no";

	@Override
	public List<ExerciseRecordVO> getAll() {
		List<ExerciseRecordVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(SELECT_ALL);
			result = query.list();
			session.getTransaction().commit();
		}catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}
	
	@Override
	public long insert(ExerciseRecordVO vo) {
		long result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			session.saveOrUpdate(vo);
			session.getTransaction().commit();
			result = vo.getNo();
		}catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}
	
	private static final String UPDATE =
			"update ExerciseRecordVO e set e.memberNo=?, e.exerciseNo=?, e.date=?, e.count=? where e.no=?";
	
	@Override
	public int update(ExerciseRecordVO vo) {
		int result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try{
			session.beginTransaction();
			Query query = session.createQuery(UPDATE);
			query.setParameter(0, vo.getMemberNo());
			query.setParameter(1, vo.getExerciseCalVO());
			query.setParameter(2, vo.getDate());
			query.setParameter(3, vo.getCount());
			query.setParameter(4, vo.getNo());
			result = query.executeUpdate();
			session.getTransaction().commit();
		}catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public boolean delete(long no) {
		boolean result = false;
		if(this.selectByPrimaryKey(no)!=null){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			try {
				session.beginTransaction();
				ExerciseRecordVO exerciseRecordVO = (ExerciseRecordVO) session.get(ExerciseRecordVO.class, no);
				session.delete(exerciseRecordVO);
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
