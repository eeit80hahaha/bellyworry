package food.combo.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import food.combo.model.MealDetailDAO;
import food.combo.model.MealDetailVO;
import food.combo.model.MealNameVO;

public class MealDetailDAOjdbc implements MealDetailDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=bellyworry";
	private static final String user = "sa";
	private static final String password = "sa123456";

	private static final String SELECT_BY_MEAL_DETAIL = "select * from meal_detail where mealNo=? and foodNo=?";

	@Override
	public MealDetailVO selectByPrimaryKey(int mealNo, int foodNo) {
		MealDetailVO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(SELECT_BY_MEAL_DETAIL);
			pstmt.setInt(1, mealNo);
			pstmt.setInt(2, foodNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new MealDetailVO();
				result.setMealNo(rs.getInt("mealNo"));
				result.setFoodNo(rs.getInt("foodNo"));
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

	private static final String select_ALL = "select * from meal_detail";

	@Override
	public List<MealDetailVO> getAll() {
		List<MealDetailVO> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(select_ALL);
			rs = pstmt.executeQuery();
			result = new ArrayList<MealDetailVO>();
			while (rs.next()) {
				MealDetailVO vo = new MealDetailVO();
				vo.setMealNo(rs.getInt(1));
				vo.setFoodNo(rs.getInt(2));
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

	private static final String INSERT = "insert into meal_detail(mealNo,foodNo)values(?,?)";

	@Override
	public MealDetailVO insert(MealDetailVO vo) {

		MealDetailVO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// ResultSet rs = null;
		try {
			result = new MealDetailVO();
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(INSERT);
			if (vo != null) {
				pstmt.setInt(1, vo.getMealNo());
				pstmt.setInt(2, vo.getFoodNo());
				pstmt.executeUpdate();
				result = this
						.selectByPrimaryKey(vo.getMealNo(), vo.getFoodNo());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// 無法update!
	// ********不能update,update沒有實質意義,但為了之後或許有其他功能,所以暫時保留,以備不時之需********
	private static final String UPDATE = "update meal_detail set foodNo=? where mealno=?";

	@Override
	public MealDetailVO update(MealDetailVO vo) {
		MealDetailVO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(UPDATE);
			if (vo != null) {
				pstmt.setInt(1, vo.getFoodNo());
				pstmt.setInt(2, vo.getMealNo());
				int i = pstmt.executeUpdate();
				if (i == 1) {
					result = this.selectByPrimaryKey(vo.getFoodNo(),
							vo.getMealNo());
				}
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

	public static final String DELETE = "delete from meal_detail where mealno=? and foodno=?";

	@Override
	public boolean delete(int mealNo, int foodNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, mealNo);
			pstmt.setInt(2, foodNo);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				return true;
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

		return false;
	}

}
