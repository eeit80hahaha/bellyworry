package ranking.model.dao;

import health.model.EatRecordVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ranking.model.HeroVO;
import ranking.model.ReflectDAO;
import ranking.model.ReflectVO;

public class ReflectDAOJdbc implements ReflectDAO {

	private static final String URL = "jdbc:sqlserver://192.168.149.128:1433;database=bellyworry";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "P@ssw0rd";
	
	private static final String SELECT_BY_NO = "select no, reflectedNo, authorNo, reflectedDate, authorDate from reflect where No=?";
	@Override
	public ReflectVO selectByPrimaryKey(int no) {
		ReflectVO result = null;
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
				result = new ReflectVO();
				result.setNo(rset.getInt(1));
				result.setReflectedNo(rset.getInt(2));
				result.setAuthorNo(rset.getInt(3));
				result.setReflectedDate(rset.getDate(4));
				result.setAuthorDate(rset.getDate(5));
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

	private static final String SELECT_ALL = "select no, reflectedNo, authorNo, reflectedDate, authorDate from reflect";
	@Override
	public List<ReflectVO> getAll() {
		List<ReflectVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<ReflectVO>();
			while(rset.next())
			{	
				ReflectVO vo = new ReflectVO();
				
				vo.setNo(rset.getInt(1));
				vo.setReflectedNo(rset.getInt(2));
				vo.setAuthorNo(rset.getInt(3));
				vo.setReflectedDate(rset.getDate(4));
				vo.setAuthorDate(rset.getDate(5));
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

	
	private static final String INSERT = "insert into reflect (reflectedNo, authorNo, reflectedDate, authorDate) values (?, ?, ?, ?)";
	@Override
	public ReflectVO insert(ReflectVO vo) {
		ReflectVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(INSERT);
			if(vo != null){
				stmt.setInt(1, vo.getReflectedNo());
				stmt.setInt(2, vo.getAuthorNo());
				if (vo.getReflectedDate() != null) {
					long date = vo.getReflectedDate().getTime();
					stmt.setDate(3, new java.sql.Date(date));
				} else {
					stmt.setDate(3, null);
				}
				if (vo.getAuthorDate() != null) {
					long date = vo.getAuthorDate().getTime();
					stmt.setDate(4, new java.sql.Date(date));
				} else {
					stmt.setDate(4, null);
				}
				stmt.executeUpdate();
				rset = stmt.getGeneratedKeys();
				if(rset.next()){
					result = this.selectByPrimaryKey(rset.getInt(1));
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

	private static final String UPDATE ="update reflect set reflectedNo=?, authorNo=?, reflectedDate=?, authorDate=? where no=?";
	@Override
	public ReflectVO update(ReflectVO vo) {
		ReflectVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(UPDATE);
			if (vo != null) {
				stmt.setInt(1, vo.getReflectedNo());
				stmt.setInt(2, vo.getAuthorNo());
				if (vo.getReflectedDate() != null) {
					long date = vo.getReflectedDate().getTime();
					stmt.setDate(3, new java.sql.Date(date));
				} else {
					stmt.setDate(3, null);
				}
				if (vo.getAuthorDate() != null) {
					long date = vo.getAuthorDate().getTime();
					stmt.setDate(4, new java.sql.Date(date));
				} else {
					stmt.setDate(4, null);
				}
				stmt.setInt(5, vo.getNo());
				
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

	private static final String DELETE ="delete from reflect where no=?";
	@Override
	public boolean delete(int no) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, no);
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
