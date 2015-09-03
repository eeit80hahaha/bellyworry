package food.combo.model.dao;

import health.model.EatRecordVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import calories.model.FoodCalVO;
import food.combo.model.MealNameDAO;
import food.combo.model.MealNameVO;

public class MealNameDAOjdbc implements MealNameDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=bellyworry";
	private static final String user = "sa";
	private static final String password = "sa123456";

	private static final String SELECT_BY_MEAL_NAME = "select * from meal_name where mealNo=?";

	@Override
	public MealNameVO selectByPrimaryKey(int mealNo) {
		MealNameVO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(SELECT_BY_MEAL_NAME);
			pstmt.setInt(1, mealNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new MealNameVO();
				result.setMealNo(rs.getInt("mealNo"));
				result.setName(rs.getString("name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static final String select_ALL = "select * from meal_name";

	@Override
	public List<MealNameVO> getAll() {
		List<MealNameVO> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(select_ALL);
			rs = pstmt.executeQuery();
			result = new ArrayList<MealNameVO>();
			while (rs.next()) {
				MealNameVO vo = new MealNameVO();
				vo.setMealNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				result.add(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return result;
	}

	private static final String INSERT = "insert into meal_name (name) values(?)";

	@Override
	public MealNameVO insert(MealNameVO vo) {
		MealNameVO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			result = new MealNameVO();
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(INSERT,
					PreparedStatement.RETURN_GENERATED_KEYS);
			if (vo != null) {
				pstmt.setString(1, vo.getName());
			}
			int num = pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				result = this.selectByPrimaryKey(rs.getInt(1));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return result;
	}

	private static final String UPDATE = "update meal_name set name=? where mealno=?";

	@Override
	public MealNameVO update(MealNameVO vo) {
		MealNameVO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			result = new MealNameVO();
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(UPDATE);
			if (vo != null) {
				pstmt.setString(1, vo.getName());
				pstmt.setInt(2, vo.getMealNo());
			}
			int i = pstmt.executeUpdate();
			if (i == 1) { // i�update����嚗���停��憓�蝑�
				result = this.selectByPrimaryKey(vo.getMealNo());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static final String DELETE = "delete from meal_name where mealno=?";
	public static final String DELETE1 = "delete from day_meal where breakfast=? or lunch=? or dinner=?";
	public static final String DELETE2 = "delete from meal_detail where mealNo=?";
	@Override
	public boolean delete(int mealNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(DELETE1);
			pstmt.setInt(1, mealNo);
			pstmt.setInt(2,mealNo);
			pstmt.setInt(3,mealNo);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(DELETE2);
			pstmt.setInt(1, mealNo);
			pstmt.executeUpdate();	
			
			
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, mealNo);
			int i = pstmt.executeUpdate();			
			
			conn.commit();
			conn.setAutoCommit(true);
			if (i == 1) {
				return true;
			}

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
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
