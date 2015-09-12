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
//import fun.model.ViewClassDAO;
//import fun.model.ViewClassVO;
//
//
//
//public class ViewClassDAOjdbc implements ViewClassDAO {
////	private static final String URL = "jdbc:sqlserver://localhost:1433;database=bellyworry";
////	private static final String USERNAME = "sa";
////	private static final String PASSWORD = "sa123456";
//	
//	private static final String SELECT_BY_VIEWCLASSNO = "select * from view_class where viewClassNo=?";
//
//	@Override
//	public ViewClassVO selectByPrimaryKey(int viewClassNo){
//		ViewClassVO result = null;
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rset = null;
//		try {
//			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			stmt = conn.prepareStatement(SELECT_BY_VIEWCLASSNO);
//			stmt.setInt(1, viewClassNo);
//			rset = stmt.executeQuery();
//			if(rset.next())
//			{	
//				result = new ViewClassVO();
//				result.setViewClassNo(rset.getInt(1));
//				result.setName(rset.getString(2));
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
//	
//	private static final String SELECT_ALL = "select * from view_class";
//
//	@Override
//	public List<ViewClassVO> getAll(){
//		List<ViewClassVO> result = null;
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rset = null;
//		try {
//			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			stmt = conn.prepareStatement(SELECT_ALL);
//			rset = stmt.executeQuery();
//			result = new ArrayList<ViewClassVO>();
//			while(rset.next())
//			{	
//				ViewClassVO vo = new ViewClassVO();
//				vo.setViewClassNo(rset.getInt(1));
//				vo.setName(rset.getString(2));
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
//			"insert into view_class (name) values (?) ";
//
//	@Override
//	public ViewClassVO insert(ViewClassVO vo){
//		ViewClassVO result = null;
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rset = null;
//		try {
//			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			stmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
//			if(vo != null){
//				stmt.setString(1, vo.getName());
//				stmt.executeUpdate();
//				rset = stmt.getGeneratedKeys();
//				if(rset.next()){
//					result = this.selectByPrimaryKey(vo.getViewClassNo());
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
//	
//	private static final String UPDATE =
//			"update view_class set name=? where viewClassNo=?";
//
//	@Override
//	public ViewClassVO update(ViewClassVO vo){
//		ViewClassVO result = null;
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		try {
//			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			stmt = conn.prepareStatement(UPDATE);
//			if (vo != null) {				
//				stmt.setString(1, vo.getName());
//				stmt.setInt(2, vo.getViewClassNo());
//				int i =stmt.executeUpdate();
//				if (i == 1) {
//					result = this.selectByPrimaryKey(vo.getViewClassNo());
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
//	
//	private static final String DELETE ="delete from view_class where ViewClassNo=?";
//
//	@Override
//	public boolean delete(int viewClassNo){
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		try {
//			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			stmt = conn.prepareStatement(DELETE);
//			stmt.setInt(1, viewClassNo);
//			int i = stmt.executeUpdate();
//
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
//}
