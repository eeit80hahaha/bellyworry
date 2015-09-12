package calories.model.dao;

import init.GlobalService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;

import sun.misc.IOUtils;
import calories.model.FoodCalDAO;
import calories.model.FoodCalVO;
import food.combo.model.MealNameVO;

public class FoodCalDAOjdbc implements FoodCalDAO {

	private static String inFile = "C:/Users/Kuei/Desktop/1.jpg";
	private static final String SELECT_BY_FOOD_CAL = "select * from food_cal where foodNo=?";

	@Override
	public FoodCalVO selectByPrimaryKey(int foodNo) {
		FoodCalVO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			pstmt = conn.prepareStatement(SELECT_BY_FOOD_CAL);
			pstmt.setInt(1, foodNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new FoodCalVO();
				result.setFoodNo(rs.getInt("foodNo"));
				result.setCookNo(rs.getInt("cookNo"));
				result.setName(rs.getString("name"));
				result.setMenuNo(rs.getInt("menuno"));
				result.setCal(rs.getInt("cal"));
				result.setCount(rs.getString("count"));
				result.setWeight(rs.getInt("weight"));
				result.setCookNo(rs.getInt("cookno"));
				result.setPicture(rs.getBytes("picture"));

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

	private static final String select_ALL = "select * from food_cal";

	@Override
	public List<FoodCalVO> getAll() {
		List<FoodCalVO> result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			pstmt = conn.prepareStatement(select_ALL);
			rs = pstmt.executeQuery();
			result = new ArrayList<FoodCalVO>();
			while (rs.next()) {
				FoodCalVO vo = new FoodCalVO();
				vo.setFoodNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setMenuNo(rs.getInt(3));
				vo.setCal(rs.getInt(4));
				vo.setCount(rs.getString(5));
				vo.setWeight(rs.getInt(6));
				vo.setCookNo(rs.getInt(7));
				vo.setPicture(rs.getBytes(8));
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

	private static final String INSERT = "insert into food_cal(name,menuNo,cal,count,weight,cookNo,picture)values(?,?,?,?,?,?,?)";

	@Override
	public int insert(FoodCalVO vo) {
		int r = 0;
		FoodCalVO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			result = new FoodCalVO();
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			pstmt = conn.prepareStatement(INSERT,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getMenuNo());
			pstmt.setInt(3, vo.getCal());
			pstmt.setString(4, vo.getCount());
			pstmt.setInt(5, vo.getWeight());
			pstmt.setInt(6, vo.getCookNo());
			File f = new File(inFile);
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				pstmt.setBytes(7, vo.getPicture());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		return r;
	}

	private static final String UPDATE = "update food_cal set name=?,menuNo=?,cal=?,count=?,weight=?,cookNo=?,picture=? where foodNo=?";

	@Override
	public int update(FoodCalVO vo) {
		int r = 0;
		FoodCalVO result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			result = new FoodCalVO();
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			pstmt = conn.prepareStatement(UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getMenuNo());
			pstmt.setInt(3, vo.getCal());
			pstmt.setString(4, vo.getCount());
			pstmt.setInt(5, vo.getWeight());
			pstmt.setInt(6, vo.getCookNo());
			pstmt.setBytes(7, null);
			pstmt.setInt(8, vo.getFoodNo());

			int num = pstmt.executeUpdate();
			result = this.selectByPrimaryKey(vo.getFoodNo());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

		return r;
	}

	public static final String DELETE = "delete from food_cal where foodNo=?";

	@Override
	public boolean delete(int foodNo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setInt(1, foodNo);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

		return false;

	}

	// public static final String DELETE =
	// "delete from food_cal where foodNo=?";
	// public static final String DELETE1 =
	// "delete from meal_detail where foodNo=?";
	// public static final String DELETE2 =
	// "delete from eat_record where foodNo=?";
	//
	// @Override
	// public boolean delete(int foodNo) {
	// boolean result = false;
	// Connection conn = null;
	// PreparedStatement pstmt = null;
	// try {
	// conn = DriverManager.getConnection(URL, user, password);
	// conn.setAutoCommit(false);
	// pstmt = conn.prepareStatement(DELETE2);
	// pstmt.setInt(1, foodNo);
	// pstmt.executeUpdate();
	// pstmt = conn.prepareStatement(DELETE1);
	// pstmt.setInt(1, foodNo);
	// pstmt.executeUpdate();
	// pstmt = conn.prepareStatement(DELETE);
	// pstmt.setInt(1, foodNo);
	// int i = pstmt.executeUpdate();
	// conn.commit();
	// conn.setAutoCommit(true);
	// if (i == 1) {
	// result = true;
	// }
	// } catch (SQLException e) {
	// try {
	// conn.rollback();
	// } catch (SQLException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// e.printStackTrace();
	// } finally {
	// if (pstmt != null) {
	// try {
	// pstmt.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// if (conn != null) {
	// try {
	// conn.close();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	//
	// return result;
	// }

}
