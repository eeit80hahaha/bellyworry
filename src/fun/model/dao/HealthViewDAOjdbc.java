//package fun.model.dao;
//
//import init.GlobalService;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import fun.model.HealthViewDAO;
//import fun.model.HealthViewVO;
//
//public class HealthViewDAOjdbc implements HealthViewDAO {
////	private static final String URL = "jdbc:sqlserver://localhost:1433;database=bellyworry";
////	private static final String USERNAME = "sa";
////	private static final String PASSWORD = "sa123456";
//	
//	private static final String SELECT_BY_NO = "select * from health_view where no=?";
//
//	@Override
//	public HealthViewVO selectByPrimaryKey(int no) {
//		HealthViewVO result = null;
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rset = null;
//		try {
//			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			stmt = conn.prepareStatement(SELECT_BY_NO);
//			stmt.setInt(1, no);
//			rset = stmt.executeQuery();
//			if(rset.next())
//			{	
//				result = new HealthViewVO();
//				result.setNo(rset.getInt(1));
//				result.setName(rset.getString(2));
//				result.setViewClassNo(rset.getInt(3));
//				result.setLat(rset.getFloat(4));
//				result.setLng(rset.getFloat(5));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			if (rset!=null) {
//				try {
//					rset.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (stmt!=null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
//	private static final String SELECT_ALL = "select * from health_view";
//	@Override
//	public List<HealthViewVO> getAll() {
//		List<HealthViewVO> result = null;
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rset = null;
//		try {
//			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			stmt = conn.prepareStatement(SELECT_ALL);
//			rset = stmt.executeQuery();
//			result = new ArrayList<HealthViewVO>();
//			while(rset.next())
//			{	
//				HealthViewVO vo = new HealthViewVO();
//				vo.setNo(rset.getInt(1));
//				vo.setName(rset.getString(2));
//				vo.setViewClassNo(rset.getInt(3));
//				vo.setLat(rset.getFloat(4));
//				vo.setLng(rset.getFloat(5));
//				result.add(vo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			if (rset!=null) {
//				try {
//					rset.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (stmt!=null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
//	private static final String INSERT =
//			"insert into health_view (name,ViewClassNo,Lat,Lng) values (?,?,?,?)";
//	@Override
//	public HealthViewVO insert(HealthViewVO vo) {
//		HealthViewVO result = null;
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rset = null;
//		try {
//			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			stmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
//			if(vo != null){
//				stmt.setString(1, vo.getName());
//				stmt.setInt(2, vo.getViewClassNo());
//				stmt.setFloat(3, vo.getLat());
//				stmt.setFloat(4, vo.getLng());
//				stmt.executeUpdate();
//				rset = stmt.getGeneratedKeys();
//				if(rset.next()){
//					result = this.selectByPrimaryKey(vo.getNo());
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			if (rset!=null) {
//				try {
//					rset.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (stmt!=null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
//	private static final String UPDATE =
//			"update health_view set  name=?, viewClassNo=?, lat=?, lng=? where no=?";
//	@Override
//	public HealthViewVO update(HealthViewVO vo) {
//		HealthViewVO result = null;
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		try {
//			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			stmt = conn.prepareStatement(UPDATE);
//			if (vo != null) {
//				
//				stmt.setString(1, vo.getName());
//				stmt.setInt(2, vo.getViewClassNo());
//				stmt.setFloat(3, vo.getLat());
//				stmt.setFloat(4, vo.getLng());
//				stmt.setInt(5, vo.getNo());
//				int i = stmt.executeUpdate();
//				if (i == 1) {
//					result = this.selectByPrimaryKey(vo.getNo());
//				} 
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			if (stmt!=null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
//	private static final String DELETE =
//			"delete from health_view where no=?";
//	@Override
//	public boolean delete(int no) {
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		try {
//			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			stmt = conn.prepareStatement(DELETE);
//			stmt.setInt(1, no);
//			int i = stmt.executeUpdate();
//			if(i==1) {
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			if (stmt!=null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn!=null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return false;
//	}
//
//}
