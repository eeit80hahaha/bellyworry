package news.model.dao;

import init.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import news.model.ActivityDAO;
import news.model.ActivityVO;

public class ActivityDAOjdbc implements ActivityDAO {
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=bellyworry";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "sa123456";
	private static final String SELECT_BY_NO =
			"select * from activity where no=?";

	@Override
	public ActivityVO selectByPrimaryKey(int no) {
		ActivityVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_NO);
			stmt.setInt(1, no);
			rset = stmt.executeQuery();
			if(rset.next()){
				result = new ActivityVO();
				result.setNo(rset.getInt("no"));
				result.setName(rset.getString("name"));
				result.setContent(rset.getString("content"));
				result.setStartTime(rset.getDate("startTime"));
				result.setEndTime(rset.getDate("endTime"));
				result.setAddress(rset.getString("address"));
				result.setPicture(rset.getBlob("picture"));
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
	
	private static final String SELECT_ALL = "select * from activity";
	@Override
	public List<ActivityVO> getAll() {
		List<ActivityVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<ActivityVO>();
			while(rset.next())
			{	
				ActivityVO vo = new ActivityVO();
				vo.setNo(rset.getInt(1));
				vo.setName(rset.getString(2));
				vo.setContent(rset.getString(3));
				vo.setStartTime(rset.getDate(4));
				vo.setEndTime(rset.getDate(5));
				vo.setAddress(rset.getString(6));
				vo.setPicture(rset.getBlob(7));                        
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
			"insert into activity (name, content, startTime, endTime, address,picture) values (?, ?, ?, ?, ?, ?)";
	@Override
	public ActivityVO insert(ActivityVO vo) {
		ActivityVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
			if(vo != null){
				stmt.setString(1, vo.getName());
				stmt.setString(2, vo.getContent());
				if(vo.getStartTime()!=null){
					long date = vo.getStartTime().getTime();
					stmt.setTimestamp(3, new Timestamp(date));
				}else{
					stmt.setTimestamp(3, null);
				}
				if(vo.getEndTime()!=null){
					long date = vo.getEndTime().getTime();
					stmt.setTimestamp(4, new Timestamp(date));
				}else{
					stmt.setTimestamp(4, null);
				}
				stmt.setString(5, vo.getAddress());
				stmt.setBlob(6, vo.getPicture());						
				stmt.executeUpdate();
//				rset = stmt.getGeneratedKeys();
//				if(rset.next()){
					result = this.selectByPrimaryKey(vo.getNo());
//				}
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
			"update activity set name=?, content=?, startTime=?, endTime=?, address=?, picture=?  where No=?";
	@Override
	public ActivityVO update(ActivityVO vo) {
		ActivityVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(UPDATE);
			if (vo != null) {
				
				stmt.setString(1, vo.getName());
				stmt.setString(2, vo.getContent());
				if(vo.getStartTime()!=null){
					long date = vo.getStartTime().getTime();
					stmt.setDate(3, new java.sql.Date(date));
				}else{
					stmt.setDate(3, null);
				}
				if(vo.getEndTime()!=null){
					long date = vo.getEndTime().getTime();
					stmt.setDate(4, new java.sql.Date(date));
				}else{
					stmt.setDate(4, null);
				}
				stmt.setString(5, vo.getAddress());
				stmt.setBlob(6, vo.getPicture());							
				stmt.setInt(7, vo.getNo());
				int i = stmt.executeUpdate();
				if (i == 1) {
					result = this.selectByPrimaryKey(vo.getNo());
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
			"delete from activity where no=?";

	@Override
	public boolean delete(int no) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(DELETE);
			stmt.setInt(1, no);
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
