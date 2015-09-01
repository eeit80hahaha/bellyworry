package health.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import health.model.ExerciseRecordDAO;
import health.model.ExerciseRecordVO;

public class ExerciseRecordDAOJdbc implements ExerciseRecordDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=bellyworry";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";
	
	private static final String SELECT_BY_NO = "select * from exercise_record where No=?";
	
	@Override
	public ExerciseRecordVO selectByPrimaryKey(long no) {
		ExerciseRecordVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_NO);
			stmt.setLong(1, no);
			rset = stmt.executeQuery();
			if(rset.next())
			{	
				result = new ExerciseRecordVO();
				result.setNo(rset.getLong(1));
				result.setMemberNo(rset.getInt(2));
				result.setExerciseNo(rset.getInt(3));
				result.setDate(rset.getDate(4));
				result.setCount(rset.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static final String SELECT_ALL = "select * from exercise_record";

	@Override
	public List<ExerciseRecordVO> getAll() {
		List<ExerciseRecordVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<ExerciseRecordVO>();
			while(rset.next())
			{	
				ExerciseRecordVO vo = new ExerciseRecordVO();
				vo.setNo(rset.getLong(1));
				vo.setMemberNo(rset.getInt(2));
				vo.setExerciseNo(rset.getInt(3));
				vo.setDate(rset.getDate(4));
				vo.setCount(rset.getInt(5));
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static final String INSERT =
			"insert into exercise_record (memberNo, exerciseNo, date, count) values (?, ?, ?, ?)";

	@Override
	public ExerciseRecordVO insert(ExerciseRecordVO vo) {
		ExerciseRecordVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(INSERT);
			if(vo != null){
				stmt.setInt(1, vo.getMemberNo());
				stmt.setInt(2, vo.getExerciseNo());
				if(vo.getDate()==null){
					long date = vo.getDate().getTime();
					stmt.setDate(3, new java.sql.Date(date));
				}else{
					stmt.setDate(3, null);
				}
				stmt.setInt(4, vo.getCount());
				stmt.executeUpdate();
				rset = stmt.getGeneratedKeys();
				if(rset.next()){
					result = this.selectByPrimaryKey(rset.getLong(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (rset!=null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static final String UPDATE =
			"update exercise_record set memberNo=?, exerciseNo=?, date=?, count=? where No=?";
	
	@Override
	public ExerciseRecordVO update(ExerciseRecordVO vo) {
		ExerciseRecordVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(UPDATE);
			if (vo != null) {
				stmt.setInt(1, vo.getMemberNo());
				stmt.setInt(2, vo.getExerciseNo());
				if (vo.getDate() != null) {
					long date = vo.getDate().getTime();
					stmt.setDate(3, new java.sql.Date(date));
				} else {
					stmt.setDate(3, null);
				}
				stmt.setInt(4, vo.getCount());
				int i = stmt.executeUpdate();
				if (i == 1) {
					result = this.selectByPrimaryKey(vo.getNo());
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static final String DELETE =
			"delete from exercise_record where no=?";

	@Override
	public boolean delete(long no) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(DELETE);
			stmt.setLong(1, no);
			int i = stmt.executeUpdate();
			if(i==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
