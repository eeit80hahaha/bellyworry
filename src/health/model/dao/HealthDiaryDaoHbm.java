package health.model.dao;

import init.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import ranking.model.ReflectVO;
//import calories.model.MenuVO;
import health.model.HealthDiaryDAO;
import health.model.HealthDiaryVO;
import hibernate.util.HibernateUtil;

public class HealthDiaryDaoHbm implements HealthDiaryDAO {

	@Override
	public HealthDiaryVO selectByPrimaryKey(long no) {
		HealthDiaryVO healthDiaryVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			healthDiaryVO = (HealthDiaryVO) session
					.get(HealthDiaryVO.class, no);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return healthDiaryVO;
	}

	@Override
	public List<HealthDiaryVO> selectByMemberNo(int memberNo) {
		List<HealthDiaryVO> healthDiaryVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session
					.createQuery("from HealthDiaryVO where memberNo=? order by date desc");
			query.setParameter(0, memberNo);
			healthDiaryVO = query.list();
			// healthDiaryVO = (HealthDiaryVO) session.get(HealthDiaryVO.class,
			// memberNo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return healthDiaryVO;
	}

	@Override
	public List<HealthDiaryVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<HealthDiaryVO> result = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from HealthDiaryVO order by no");
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	@Override
	public long insert(HealthDiaryVO vo) {
		long result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			session.getTransaction().commit();
			result = vo.getNo();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			result = 0;
			throw ex;
		}
		return result;
	}

	@Override
	public int update(HealthDiaryVO vo) {
		int result = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session
					.createQuery("update HealthDiaryVO set memberNo=?,date=?,height=?,weight=?,waistline=?,title=?,content=?,share=? where no=?");

			query.setParameter(0, vo.getMemberNo());
			query.setParameter(1, vo.getDate());
			query.setParameter(2, vo.getHeight());
			query.setParameter(3, vo.getWeight());
			query.setParameter(4, vo.getWaistline());
			query.setParameter(5, vo.getTitle());
			query.setParameter(6, vo.getContent());
			query.setParameter(7, vo.getShare());
			query.setParameter(8, vo.getNo());
			int i = query.executeUpdate();
			session.getTransaction().commit();
			if (i > 0) {
				result = i;
			}
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			result = 0;
			throw ex;
		}
		return result;
	}

	@Override
	public boolean delete(long no) {
		boolean result = false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

			// 【此時多方(宜)可採用HQL刪除】
			// Query query =
			// session.createQuery("delete from menu where menuNo=?");
			// query.setParameter(0, menuNo);
			// System.out.println("刪除的筆數=" + query.executeUpdate());
			Query query = session
					.createQuery("delete from HealthDiaryVO where no=?");
			query.setParameter(0, no);
			int i = query.executeUpdate();
			if (i > 0) {
				result = true;
			}
			session.getTransaction().commit();
			System.out.println("刪除的筆數=" + i);
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		// 【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
		// EmpVO empVO = new EmpVO();
		// empVO.setEmpno(empno);
		// session.delete(empVO);

		// 【此時多方不可(不宜)採用cascade聯級刪除】
		// 【多方emp2.hbm.xml如果設為 cascade="all"或
		// cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
		// HealthDiaryVO healthDiaryVO = (HealthDiaryVO)
		// session.get(HealthDiaryVO.class, no);
		// session.delete(healthDiaryVO);
		// session.getTransaction().commit();
		// result =true;
		// } catch (RuntimeException ex) {
		// session.getTransaction().rollback();
		// throw ex;
		//
		// }
		return result;
	}

	public List<HealthDiaryVO> dateSelect(int memberNo, java.util.Date date) {
		List<HealthDiaryVO> vo = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session
					.createQuery("from HealthDiaryVO where memberNo=? and date=? ");
			query.setParameter(0, memberNo);
			query.setParameter(1, date);
			vo = query.list();
			// healthDiaryVO = (HealthDiaryVO) session.get(HealthDiaryVO.class,
			// memberNo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return vo;
	}

	private static final String GETDATEPAGE = "from HealthDiaryVO where memberNo=? and year(date)=? and month(date)=? and share='1' order by date";

	@Override
	public List<HealthDiaryVO> getDatePage(int pageNo, int pageSize,
			int memberNo, int year, int month) {

		List<HealthDiaryVO> result = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GETDATEPAGE);

			query.setParameter(0, memberNo);
			query.setParameter(1, year);
			query.setParameter(2, month);
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

	private static final String GETDATETOTALCOUNT = "select count(no) from HealthDiaryVO where memberNo=? and year(date)=? and month(date)=? and share='1'";

	@Override
	public int getDateTotalCount(int memberNo, int year, int month) {
		int result = -1000;
		long sum = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GETDATETOTALCOUNT);

			query.setParameter(0, memberNo);
			query.setParameter(1, year);
			query.setParameter(2, month);

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

	private static final String GethighChart = " from HealthDiaryVO where memberNo=? and year(date)=? and month(date)=?";

	@Override
	public List<HealthDiaryVO> gethighChart(int memberNo, int year, int month) {

		List<HealthDiaryVO> result = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GethighChart);

			query.setParameter(0, memberNo);
			query.setParameter(1, year);
			query.setParameter(2, month);

			result = query.list();

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

	private static final String REPEATDIARY = "from HealthDiaryVO where memberNo=? and date=?";

	@Override
	public int repeatDiary(int memberNo, java.util.Date date) {
		int result = -300;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(REPEATDIARY);

			query.setParameter(0, memberNo);
			query.setParameter(1, date);

			List<ReflectVO> tmp = query.list();
			if (tmp.isEmpty()) {
				// Not available
				result = -400;
			} else {
				// ok
				result = 1000;
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}

}
