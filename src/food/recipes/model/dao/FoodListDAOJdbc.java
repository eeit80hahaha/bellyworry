package food.recipes.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import food.recipes.model.FoodListDAO;
import food.recipes.model.FoodListVO;



public  class FoodListDAOJdbc implements FoodListDAO{
	private static final String URL ="jdbc:sqlserver://localhost:1433;database=BellyWorry";
	private static final String USERNAME ="sa";
	private static final String PASSWORD ="sa123456";
	
	private DataSource dataSource;
	private static final String SELECT_BY_COOKNO_USEFOODNO ="select * from food_list where cookNo=? and useFoodNo=?";
	public FoodListVO selectByPrimaryKey(int cookNo, int useFoodNo){
		FoodListVO result = null;		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_COOKNO_USEFOODNO);
			stmt.setInt(1, cookNo);
			stmt.setInt(2, useFoodNo);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = new FoodListVO();
				result.setCookNo(rset.getInt(1));
				result.setUseFoodNo(rset.getInt(2));			
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

	private static final String SELECT_ALL = "select * from food_list";

	public List<FoodListVO> getAll(){
		List<FoodListVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<FoodListVO>();
			while(rset.next())
			{	
				FoodListVO vo = new FoodListVO();
				vo.setCookNo(rset.getInt(1));
				vo.setUseFoodNo(rset.getInt(2));
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
			"insert into food_list (cookNo, useFoodNo) values (?, ?)";

	@Override
	public FoodListVO insert(FoodListVO vo){
		FoodListVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(INSERT);
			if(vo != null){
					vo = new FoodListVO();
					stmt.setInt(1,vo.getCookNo());
					stmt.setInt(2,vo.getUseFoodNo());
					stmt.executeUpdate();
					rset = stmt.getGeneratedKeys();
					if(rset.next()){
						result = this.selectByPrimaryKey(rset.getInt(1), rset.getInt(2));
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
			"update food_list set cookNo=? and useFoodNo=?";

	@Override
	public FoodListVO update(FoodListVO vo){
		FoodListVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(UPDATE);		
			       conn.setAutoCommit(false);		       
			       
			if (vo != null) {
				vo = new FoodListVO();
				stmt.setInt(1,vo.getCookNo());
				stmt.setInt(2,vo.getUseFoodNo());
				int i = stmt.executeUpdate();
				if(i==1) {
					result = this.selectByPrimaryKey(vo.getCookNo(),vo.getUseFoodNo());
				}
				conn.commit();
				conn.setAutoCommit(true);
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
			"delete from food_list where cookNo=? and useFoodNo=?";

	@Override
	public boolean delete(int cookNo,int useFoodNo){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, cookNo);
			stmt.setInt(2, useFoodNo);
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