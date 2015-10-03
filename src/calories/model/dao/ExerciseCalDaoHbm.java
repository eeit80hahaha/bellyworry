package calories.model.dao;

import hibernate.util.HibernateUtil;
import init.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import calories.model.ExerciseCalDAO;
import calories.model.ExerciseCalVO;
import calories.model.MenuVO;

public class ExerciseCalDaoHbm implements ExerciseCalDAO {	
	@Override
	public ExerciseCalVO selectByPrimaryKey(int exerciseNo) {
		ExerciseCalVO ExerciseCalVO = null;
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	try {
		session.beginTransaction();		
		ExerciseCalVO = (ExerciseCalVO) session.get(ExerciseCalVO.class, exerciseNo);
		session.getTransaction().commit();
		} catch (RuntimeException ex) {
		session.getTransaction().rollback();
		throw ex;
		}
		return ExerciseCalVO;
	}
	@Override
	public List<ExerciseCalVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<ExerciseCalVO> result = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from ExerciseCalVO order by exerciseNo");
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;	
	}

	@Override
	public int insert(ExerciseCalVO vo) {
		int result=0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			session.getTransaction().commit();
			result=vo.getExerciseNo();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			String[] ss=ex.getCause().getMessage().split("'")[0].split(" ");
			String ss1=ss[0]+ss[1]+ss[2]+ss[3];
			if("違反UNIQUEKEY條件約束".equals(ss1)){
				result=-100;//name
			}else{
				result=0;
			}
//			throw ex;
		}
		return result;
	}

	@Override
	public int update(ExerciseCalVO bean) {
		int result=0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();			
			Query query = session
					.createQuery("update ExerciseCalVO set name=?,calHour=? where exerciseNo=?");

			query.setParameter(0, bean.getName());
			query.setParameter(1, bean.getCalHour());
			query.setParameter(2, bean.getExerciseNo());
			int i = query.executeUpdate();
			session.getTransaction().commit();
			if (i > 0) {
				result = i;
			}			
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			String[] ss=ex.getCause().getMessage().split("'")[0].split(" ");
			String ss1=ss[0]+ss[1]+ss[2]+ss[3];
			if("違反UNIQUEKEY條件約束".equals(ss1)){
				result=-100;//name
			}else{
				result=0;
			}
//			throw ex;
		}
		return result;
	}
	

	@Override
	public boolean delete(int exerciseNo) {
		boolean result=false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
			Query query = session.createQuery("delete from ExerciseCalVO where exerciseNo=?");
			query.setParameter(0, exerciseNo);			
			int i = query.executeUpdate();			
			if(i>0){
				result = true;
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;			
		}

//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
//			EmpVO empVO = new EmpVO();
//			empVO.setEmpno(empno);
//			session.delete(empVO);

//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方emp2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			ExerciseCalVO ExerciseCalVO = (ExerciseCalVO) session.get(ExerciseCalVO.class, exerciseNo);
//			session.delete(ExerciseCalVO);
//			session.getTransaction().commit();
//			result =true;
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//			
//		}
		return result;
	}

}
