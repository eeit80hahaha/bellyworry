package ranking.model.dao;

import init.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ranking.model.HeroDAO;
import ranking.model.HeroVO;
import school.model.ExamVO;

public class HeroDAOJdbc implements HeroDAO {

//	private static final String URL = "jdbc:sqlserver://192.168.149.128:1433;database=bellyworry";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "sa123456";
	
	
	private static final String SELECT_BY_NO = "select memberNo, weightDiff, num from hero where memberNo=?";
	@Override
	public HeroVO selectByPrimaryKey(int memberNo) {
		HeroVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, 
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_NO);
			stmt.setInt(1, memberNo);
			rset = stmt.executeQuery();
			if(rset.next())
			{	
				result = new HeroVO();
				result.setMemberNo(rset.getInt(1));
				result.setWeightDiff(rset.getDouble(2));
				result.setNum(rset.getInt(3));
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

	
	private static final String SELECT_ALL = "select memberNo, weightDiff, num from hero";
	@Override
	public List<HeroVO> getAll() {
		List<HeroVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, 
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<HeroVO>();
			while(rset.next())
			{	
				HeroVO vo = new HeroVO();
				vo.setMemberNo(rset.getInt(1));
				vo.setWeightDiff(rset.getDouble(2));
				vo.setNum(rset.getInt(3));
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
	private static final String INSERT = "insert into hero (memberNo,weightDiff, num) values (?, ?, ?)";
	@Override
	public HeroVO insert(HeroVO vo) {
		HeroVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, 
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(INSERT , PreparedStatement.RETURN_GENERATED_KEYS);
			if(vo != null){
				stmt.setInt(1, vo.getMemberNo());
				stmt.setDouble(2, vo.getWeightDiff());
				stmt.setInt(3, vo.getNum());
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

	private static final String UPDATE ="update hero set weightDiff=?, num=? where memberNo=?";
	@Override
	public HeroVO update(HeroVO vo) {
		HeroVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, 
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(UPDATE);
			if (vo != null) {
				stmt.setDouble(1, vo.getWeightDiff());
				stmt.setInt(2, vo.getNum());
				stmt.setInt(3, vo.getMemberNo());
				
				int i = stmt.executeUpdate();
				if (i == 1) {
					result = this.selectByPrimaryKey(vo.getMemberNo());
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

	
	private static final String DELETE ="delete from hero where memberNo=?";
	@Override
	public boolean delete(int memberNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, 
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, memberNo);
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
