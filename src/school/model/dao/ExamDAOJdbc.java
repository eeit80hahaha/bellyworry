package school.model.dao;

import init.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import school.model.ExamDAO;
import school.model.ExamVO;

public class ExamDAOJdbc implements ExamDAO {

//	private static final String URL = "jdbc:sqlserver://192.168.149.128:1433;database=bellyworry";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "sa123456";
	
	private static final String SELECT_BY_NO = "select no, content, correct, optA, optB, optC "
			+ "from exam where No=?";
	@Override
	public ExamVO selectByPrimaryKey(int no) {
		ExamVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, 
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_NO);
			stmt.setLong(1, no);
			rset = stmt.executeQuery();
			if(rset.next())
			{	
				result = new ExamVO();
				result.setNo(rset.getInt(1));
				result.setContent(rset.getString(2));
				result.setCorrect(rset.getString(3));
				result.setOptA(rset.getString(4));
				result.setOptB(rset.getString(5));
				result.setOptC(rset.getString(6));
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
	
	private static final String SELECT_ALL = "select no, content, correct, optA, optB, optC"
			+ " from exam";
	@Override
	public List<ExamVO> getAll() {
		List<ExamVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, 
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<ExamVO>();
			while(rset.next())
			{	
				ExamVO vo = new ExamVO();
				vo.setNo(rset.getInt(1));
				vo.setContent(rset.getString(2));
				vo.setCorrect(rset.getString(3));
				vo.setOptA(rset.getString(4));
				vo.setOptB(rset.getString(5));
				vo.setOptC(rset.getString(6));
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
			"insert into exam (content, correct, optA, optB, optC) values (?, ?, ?, ?, ?)";
	@Override
	public int insert(ExamVO vo) {
		ExamVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, 
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(INSERT , PreparedStatement.RETURN_GENERATED_KEYS);
			if(vo != null){
				stmt.setString(1, vo.getContent());
				stmt.setString(2, vo.getCorrect());
				stmt.setString(3, vo.getOptA());
				stmt.setString(4, vo.getOptB());
				stmt.setString(5, vo.getOptC());
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
//		return result;
		return 100;
	}

	
	private static final String UPDATE =
			"update exam set content=?, correct=?, optA=?, optB=?, optC=? where no=?";
	@Override
	public int update(ExamVO vo) {
		ExamVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, 
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(UPDATE);
			if (vo != null) {
				stmt.setString(1, vo.getContent());
				stmt.setString(2, vo.getCorrect());
				stmt.setString(3, vo.getOptA());
				stmt.setString(4, vo.getOptB());
				stmt.setString(5, vo.getOptC());
				stmt.setInt(6, vo.getNo());
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
//		return result;
		return 100;
	}

	private static final String DELETE =
			"delete from exam where no=?";
	@Override
	public boolean delete(int no) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, 
					GlobalService.USERNAME, GlobalService.PASSWORD);
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
