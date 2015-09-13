package food.recipes.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import food.recipes.model.CookDAO;
import food.recipes.model.CookVO;

public class CookDAOJdbc implements CookDAO{
	private static final String URL ="jdbc:sqlserver://localhost:1433;database=BellyWorry";
	private static final String USERNAME ="sa";
	private static final String PASSWORD ="sa123456";
	
	public CookDAOJdbc() {
		super();
	}

	private DataSource dataSource;
	private static final String SELECT_BY_COOKNO ="select * from cook where cookNo=?";
	@Override
	public CookVO selectByPrimaryKey(int cookno){
		CookVO result = null;		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_COOKNO);
			stmt.setInt(1, cookno);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = new CookVO();
				result.setCookNo(rset.getInt(1));
				result.setWayNo(rset.getString(2));
				result.setPicture(rset.getBytes(3));
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

	private static final String SELECT_ALL = "select * from cook";
	@Override
	public List<CookVO> getAll(){
		List<CookVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<CookVO>();
			while(rset.next())
			{	
				CookVO vo = new CookVO();
				vo.setCookNo(rset.getInt(1));
				vo.setWayNo(rset.getString(2));
				vo.setPicture(rset.getBytes(3));
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
			"insert into cook (wayno, picture) values (?, ?)";

	@Override
	public int insert(CookVO vo){
		CookVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			if(vo != null){
					stmt.setString(1,vo.getWayNo());
					stmt.setBytes(2,vo.getPicture());
					stmt.executeUpdate();
					rset = stmt.getGeneratedKeys();
					if(rset.next()){
						result = this.selectByPrimaryKey(rset.getInt(0));
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
		return 100;
	}
	private static final String UPDATE =
			"update cook set wayno=?, picture=? where cookno=?";

	@Override
	public int update(CookVO vo){
		CookVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(UPDATE);
			if (vo != null) {
				stmt.setString(1,vo.getWayNo());
				stmt.setBytes(2,vo.getPicture());
				stmt.setInt(3,vo.getCookNo());
				int i = stmt.executeUpdate();
				if(i==1) {
					result = this.selectByPrimaryKey(vo.getCookNo());
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
		return 100;
	}
//	private static final String DELETE_LISTCOOKNO ="delete from food_cal where cookno=?";
	private static final String DELETE = "delete from cook where cookno=?";
	
	@Override
	public boolean delete(int cookno){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
//			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			stmt = conn.prepareStatement(DELETE_LISTCOOKNO);
//			stmt.setInt(1, cookno);
//			stmt.executeUpdate();
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, cookno);
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