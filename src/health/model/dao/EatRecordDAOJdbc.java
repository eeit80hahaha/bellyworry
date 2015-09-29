package health.model.dao;

import health.model.EatRecordDAO;
import health.model.EatRecordVO;
import init.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EatRecordDAOJdbc implements EatRecordDAO {
	
	private static final String SELECT_BY_NO = "select * from eat_Record where No=?";

	@Override
	public EatRecordVO selectByPrimaryKey(long no){
		EatRecordVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_NO);
			stmt.setLong(1, no);
			rset = stmt.executeQuery();
			if(rset.next())
			{	
				result = new EatRecordVO();
				result.setNo(rset.getLong(1));
				result.setMemberNo(rset.getInt(2));
				result.setDate(rset.getDate(3));
				result.setTime(rset.getString(4));
//				result.setFoodNo(rset.getInt(5));
				result.setCount(rset.getInt(6));
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
	
	private static final String SELECT_BY_MEMBER_NO = "select * from eat_Record where memberNo=?";

	@Override
	public List<EatRecordVO> selectByMemberNo(int memberNo){
		List<EatRecordVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_MEMBER_NO);
			stmt.setInt(1, memberNo);
			rset = stmt.executeQuery();
			result = new ArrayList<EatRecordVO>();
			while(rset.next())
			{	
				EatRecordVO vo = new EatRecordVO();
				vo.setNo(rset.getLong(1));
				vo.setMemberNo(rset.getInt(2));
				vo.setDate(rset.getDate(3));
				vo.setTime(rset.getString(4));
//				vo.setFoodNo(rset.getInt(5));
				vo.setCount(rset.getInt(6));
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
	
	private static final String SELECT_ALL = "select * from eat_Record";

	@Override
	public List<EatRecordVO> getAll(){
		List<EatRecordVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<EatRecordVO>();
			while(rset.next())
			{	
				EatRecordVO vo = new EatRecordVO();
				vo.setNo(rset.getLong(1));
				vo.setMemberNo(rset.getInt(2));
				vo.setDate(rset.getDate(3));
				vo.setTime(rset.getString(4));
//				vo.setFoodNo(rset.getInt(5));
				vo.setCount(rset.getInt(6));
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
			"insert into eat_Record (memberNo, date, time, foodNo, count) values (?, ?, ?, ?, ?)";

	@Override
	public long insert(EatRecordVO vo){
		long result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			if(vo != null){
				stmt.setInt(1, vo.getMemberNo());
				if(vo.getDate()!=null){
					long date = vo.getDate().getTime();
					stmt.setDate(2, new java.sql.Date(date));
				}else{
					stmt.setDate(2, null);
				}
				stmt.setString(3, vo.getTime());
//				stmt.setInt(4, vo.getFoodNo());
				stmt.setInt(5, vo.getCount());
				stmt.executeUpdate();
				rset = stmt.getGeneratedKeys();
				if(rset.next()){
					result = rset.getLong(1);
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
			"update eat_Record set memberNo=?, date=?, time=?, foodNo=?, count=? where No=?";

	@Override
	public int update(EatRecordVO vo){
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(UPDATE);
			if (vo != null) {
				stmt.setInt(1, vo.getMemberNo());
				if (vo.getDate() != null) {
					long date = vo.getDate().getTime();
					stmt.setDate(2, new java.sql.Date(date));
				} else {
					stmt.setDate(2, null);
				}
				stmt.setString(3, vo.getTime());
//				stmt.setInt(4, vo.getFoodNo());
				stmt.setInt(5, vo.getCount());
				stmt.setLong(6, vo.getNo());
				result = stmt.executeUpdate();
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
			"delete from eat_Record where no=?";

	@Override
	public boolean delete(long no){
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(DELETE);
			stmt.setLong(1, no);
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
	
	@Override
	public int eatcal(int memberNo, java.util.Date date) {
		return 0;
	}

	@Override
	public List<EatRecordVO> eatday(int memberNo, Date date) {
		return null;
	}

	@Override
	public List<EatRecordVO> getEatrmdt(int memberNo, Date healthDate,
			String eattime) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
