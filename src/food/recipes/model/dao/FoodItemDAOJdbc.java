package food.recipes.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import food.recipes.model.FoodItemDAO;
import food.recipes.model.FoodItemVO;



public  class FoodItemDAOJdbc implements FoodItemDAO{
	private static final String URL ="jdbc:sqlserver://localhost:1433;database=BellyWorry";
	private static final String USERNAME ="sa";
	private static final String PASSWORD ="sa123456";
	
	private DataSource dataSource;
	private static final String SELECT_BY_USEFOODNO ="select * from food_item where useFoodNo=?";
	public FoodItemVO selectByPrimaryKey(int useFoodNo){
		FoodItemVO result = null;		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_USEFOODNO);
			stmt.setInt(1, useFoodNo);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = new FoodItemVO();
				result.setUseFoodNo(rset.getInt(1));
				result.setName(rset.getString(2));
				result.setType(rset.getString(3));
				result.setCount(rset.getString(4));				
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

	private static final String SELECT_ALL = "select * from food_item";

	public List<FoodItemVO> getAll(){
		List<FoodItemVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<FoodItemVO>();
			while(rset.next())
			{	
				FoodItemVO vo = new FoodItemVO();
				vo.setUseFoodNo(rset.getInt(1));
				vo.setName(rset.getString(2));
				vo.setType(rset.getString(3));
				vo.setCount(rset.getString(4));
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
			"insert into food_item (name, type, count) values (?, ?, ?)";

	@Override
	public FoodItemVO insert(FoodItemVO vo){
		FoodItemVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			if(vo != null){
					stmt.setString(1,vo.getName());
					stmt.setString(2,vo.getType());
					stmt.setString(3,vo.getCount());
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
	private static final String UPDATE =
			"update food_item set  name=?, type=?, count=? where useFoodNo=?";

	@Override
	public FoodItemVO update(FoodItemVO vo){
		FoodItemVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(UPDATE);
			if (vo != null) {			
				stmt.setString(1,vo.getName());
				stmt.setString(2,vo.getType());
				stmt.setString(3,vo.getCount());
				stmt.setInt(4,vo.getUseFoodNo());
				int i = stmt.executeUpdate();
				if(i==1) {
					result = this.selectByPrimaryKey(vo.getUseFoodNo());
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
			"delete from food_item where useFoodNo=?";

	@Override
	public boolean delete(int useFoodNo){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, useFoodNo);
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