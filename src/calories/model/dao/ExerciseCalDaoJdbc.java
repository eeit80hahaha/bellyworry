package calories.model.dao;

import init.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import calories.model.ExerciseCalDAO;
import calories.model.ExerciseCalVO;

public class ExerciseCalDaoJdbc implements ExerciseCalDAO {
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=bellyworry";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "sa123456";
//	private DataSource dataSource;
//	public MenuDaoJdbc() {
//		try {
//			Context ctx = new InitialContext();
//			this.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xxx");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
	private static final String SELECT_BY_ID =
			"select * from exercise_cal where exerciseNo=?";
	@Override
	public ExerciseCalVO selectByPrimaryKey(int exerciseNo) {
		ExerciseCalVO result = null;
		ResultSet rset = null;
		try(
			Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			
			stmt.setInt(1, exerciseNo);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = new ExerciseCalVO();
				result.setExerciseNo(rset.getInt("exerciseNo"));
				result.setName(rset.getString("name"));
				result.setCalHour(rset.getFloat("CalHour"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
		
	private static final String SELECT_ALL =
			"select * from exercise_cal";
	@Override
	public List<ExerciseCalVO> getAll() {
		List<ExerciseCalVO> result = null;
		try(
				Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
			
			result = new ArrayList<ExerciseCalVO>();
			while(rset.next()) {
				ExerciseCalVO bean = new ExerciseCalVO();
				bean.setExerciseNo(rset.getInt("exerciseNo"));
				bean.setName(rset.getString("name"));
				bean.setCalHour(rset.getFloat("CalHour"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT =
			"insert into exercise_cal (name,calHour) values (?,?)";
	@Override
	public ExerciseCalVO insert(ExerciseCalVO vo) {
		ExerciseCalVO result = null;
		try(
				Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);) {
			if(vo!=null) {
				stmt.setString(1, vo.getName());
				stmt.setFloat(2, vo.getCalHour());
				int i = stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
				if(i==1) {
					 if (rs.next()) { 						
						 result = this.selectByPrimaryKey(rs.getInt(1));;
                         
                 } 
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}

	private static final String UPDATE =
			"update exercise_cal set name=?,calHour=? where exerciseNo=?";
	@Override
	public ExerciseCalVO update(ExerciseCalVO vo) {
		ExerciseCalVO result = null;
		try(
				Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, vo.getName());
			stmt.setFloat(2, vo.getCalHour());
			stmt.setInt(3, vo.getExerciseNo());
			
			int i = stmt.executeUpdate();
			if(i==1) {
				result = this.selectByPrimaryKey(vo.getExerciseNo());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	private static final String DELETE1 =
			"delete from exercise_record where exerciseNo=?";
	private static final String DELETE2 =
			"delete from exercise_cal where exerciseNo=?";
	@Override
	public boolean delete(int exerciseNo) {
		
//		try(
//				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
////				Connection conn = dataSource.getConnection();
//					
//			PreparedStatement stmt1 = conn.prepareStatement(DELETE1);
//			PreparedStatement stmt2 = conn.prepareStatement(DELETE2);) {			
//			conn.setAutoCommit(false);
//			stmt1.setInt(1, exerciseNo);
//			stmt2.setInt(1, exerciseNo);
//			int i = stmt1.executeUpdate();
//			int j = stmt2.executeUpdate();
//			conn.commit();
//			conn.setAutoCommit(true);
//			if(j==1) {								
//					return true;					
//				
//				}else{
//					conn.rollback();				
//			}
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		return false;
		try(
			Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			Connection conn = dataSource.getConnection();			
			PreparedStatement stmt = conn.prepareStatement(DELETE2);) {			
			conn.setAutoCommit(false);			
			stmt.setInt(1, exerciseNo);
			int i = stmt.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
			if(i==1) {								
					return true;				
				}else{
					conn.rollback();				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
