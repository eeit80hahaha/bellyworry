package news.model.dao;

import hibernate.util.HibernateUtil;
import init.GlobalService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.classic.Session;

import calories.model.MenuVO;
import news.model.ActivityDAO;
import news.model.ActivityVO;

public class ActivityDAOHbm implements ActivityDAO {
	
	private static final String INSERT =
			"insert into activity (name, content, startTime, endTime, address,picture) values (?, ?, ?, ?, ?, ?)";
	@Override
	public ActivityVO insert(ActivityVO vo, InputStream is, long size) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}
	@Override
	public ActivityVO selectByPrimaryKey(int no) {		
		ActivityVO activityVO = null;
			Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			activityVO = (ActivityVO) session.get(ActivityVO.class, no);
			session.getTransaction().commit();
			} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
			}
			return activityVO;
	}
	@Override
	public List<ActivityVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ActivityVO update(ActivityVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean delete(int no) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
