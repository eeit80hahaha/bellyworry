package food.combo.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import food.combo.model.DayMealDAO;
import food.combo.model.DayMealVO;
import food.combo.model.MealNameVO;

public class DayMealDAOjdbc implements DayMealDAO {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=bellyworry";
	private static final String user = "sa";
	private static final String password = "sa123456";

	private static final String SELECT_BY_DAY_MEAL = "select * from day_meal where no=?";

	@Override
	public DayMealVO selectByPrimaryKey(int no) {
		DayMealVO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(SELECT_BY_DAY_MEAL);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new DayMealVO();
				result.setNo(rs.getInt("no"));
				result.setName(rs.getString("name"));
				result.setBreakfast(rs.getInt("breakfast"));
				result.setLunch(rs.getInt("lunch"));
				result.setDinner(rs.getInt("dinner"));
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

	private static final String select_ALL = "select * from day_meal";

	@Override
	public List<DayMealVO> getAll() {
		List<DayMealVO> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(select_ALL);
			rs = pstmt.executeQuery();
			result = new ArrayList<DayMealVO>();
			while (rs.next()) {
				DayMealVO vo = new DayMealVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setBreakfast(rs.getInt(3));
				vo.setLunch(rs.getInt(4));
				vo.setDinner(rs.getInt(5));
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

	private static final String INSERT = "insert into day_meal(name,breakfast,lunch,dinner)values(?,?,?,?)";

	@Override
	public DayMealVO insert(DayMealVO vo) {
		DayMealVO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			result = new DayMealVO();
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(INSERT,
					PreparedStatement.RETURN_GENERATED_KEYS);
			if (vo != null) {
				pstmt.setString(1, vo.getName());
				pstmt.setInt(2, vo.getBreakfast());
				pstmt.setInt(3, vo.getLunch());
				pstmt.setInt(4, vo.getDinner());
			}
			pstmt.executeUpdate();
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

	private static final String UPDATE = "update day_meal set name=?,breakfast=?,lunch=?,dinner=? where no=?";

	@Override
	public DayMealVO update(DayMealVO vo) {
		DayMealVO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			result = new DayMealVO();
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(UPDATE);
			if (vo != null) {
				pstmt.setString(1, vo.getName());
				pstmt.setInt(2, vo.getBreakfast());
				pstmt.setInt(3, vo.getLunch());
				pstmt.setInt(4, vo.getDinner());
				pstmt.setInt(5, vo.getNo());
				int i = pstmt.executeUpdate();
				if (i == 1) {
					result = this.selectByPrimaryKey(vo.getNo());
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

	public static final String DELETE = "delete from day_meal where no=?";

	@Override
	public boolean delete(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, no);
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
