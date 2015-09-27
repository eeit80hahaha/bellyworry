package health.model.dao;

import init.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import ranking.model.ReflectVO;
//import calories.model.MenuVO;
import health.model.HealthDiaryDAO;
import health.model.HealthDiaryVO;

public class HealthDiaryDaoJdbc implements HealthDiaryDAO {
//	private static final String URL = "jdbc:sqlserver://localhost:1433;database=bellyworry";
//	private static final String USERNAME = "sa";
//	private static final String PASSWORD = "sa123456";
//	private DataSource dataSource;
//	public MenuDaoJdbc() {
//		try {
//			Context ctx = new InitialContext();
//			this.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xxx");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
	private static final String SELECT_BY_ID =
			"select * from health_diary where no =?";
	@Override
	public HealthDiaryVO selectByPrimaryKey(long no) {
		HealthDiaryVO result = null;
		ResultSet rset = null;
		try(
			Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			
			stmt.setLong(1, no);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = new HealthDiaryVO();
				result.setNo(rset.getLong("no"));
				result.setMemberNo(rset.getInt("memberNo"));
				result.setDate(rset.getDate("date"));
				result.setHeight(rset.getFloat("height"));
				result.setWeight(rset.getFloat("weight"));
				result.setWaistline(rset.getFloat("waistline"));
				result.setTitle(rset.getString("title"));
				result.setContent(rset.getString("content"));
				result.setShare(rset.getString("share"));
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
		}
		return result;
	}
	
	private static final String SELECT_BY_memberNo =
			"select * from health_diary where memberNo =?";
	@Override
	public List<HealthDiaryVO> selectByMemberNo(int memberNo ) {
		List<HealthDiaryVO> result = null;
		ResultSet rset = null;
		try(
			Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_memberNo);) {
			
			stmt.setInt(1, memberNo);
			rset = stmt.executeQuery();			
			while(rset.next()) {
				HealthDiaryVO bean = new HealthDiaryVO();
				bean.setNo(rset.getLong("no"));
				bean.setMemberNo(rset.getInt("memberNo"));
				bean.setDate(rset.getDate("date"));
				bean.setHeight(rset.getFloat("height"));
				bean.setWeight(rset.getFloat("weight"));
				bean.setWaistline(rset.getFloat("waistline"));
				bean.setTitle(rset.getString("title"));
				bean.setContent(rset.getString("content"));
				bean.setShare(rset.getString("share"));
				result.add(bean);
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
		}
		return result;
	}
	
	private static final String SELECT_ALL =
			"select * from health_diary";
	@Override
	public List<HealthDiaryVO> getAll() {
		List<HealthDiaryVO> result = null;
		try(
				Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
			
			result = new ArrayList<HealthDiaryVO>();
			while(rset.next()) {
				HealthDiaryVO bean = new HealthDiaryVO();
				bean.setNo(rset.getLong("no"));
				bean.setMemberNo(rset.getInt("memberNo"));
				bean.setDate(rset.getDate("date"));
				bean.setHeight(rset.getFloat("height"));
				bean.setWeight(rset.getFloat("weight"));
				bean.setWaistline(rset.getFloat("waistline"));
				bean.setTitle(rset.getString("title"));
				bean.setContent(rset.getString("content"));
				bean.setShare(rset.getString("share"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String INSERT =
			"insert into health_diary "
			+ "(memberNo,date,height,weight,waistline,title,content,share) "
			+ "values (?,?,?,?,?,?,?,?)";
	@Override
	public long insert(HealthDiaryVO vo) {
		long result = 0;
		try(
				Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			if(vo!=null) {				
				stmt.setInt(1,vo.getMemberNo());
				java.util.Date date = vo.getDate();
				if(date!=null) {
					long time = date.getTime();
					stmt.setDate(2, new java.sql.Date(time));
				} else {
					stmt.setDate(2, null);				
				}
				stmt.setFloat(3,vo.getHeight());
				stmt.setFloat(4,vo.getWeight());
				stmt.setFloat(5,vo.getWaistline());
				stmt.setString(6,vo.getTitle());
				stmt.setString(7,vo.getContent());
				stmt.setString(8,vo.getShare());				
				int i = stmt.executeUpdate();
				if(i==1) {
					result = vo.getNo();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String UPDATE =
			"update health_diary set MemberNo=?, date=?,height=?,weight=?,waistline=?,"
			+ "title=?,content=?,share=? where no=?";
	@Override
	public int update(HealthDiaryVO vo) {
		int result = 0;
		try(
				Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setInt(1, vo.getMemberNo());
			if(vo.getDate()!=null) {
				long time = vo.getDate().getTime();
				stmt.setDate(2, new java.sql.Date(time));
			} else {
				stmt.setDate(2, null);				
			}
			stmt.setFloat(3, vo.getHeight());
			stmt.setFloat(4, vo.getWeight());
			stmt.setFloat(5, vo.getWaistline());
			stmt.setString(6, vo.getTitle());
			stmt.setString(7, vo.getContent());
			stmt.setString(8, vo.getShare());
			stmt.setLong(9, vo.getNo());
			int i = stmt.executeUpdate();
			if(i==1) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return result;		
	}

	private static final String DELETE =
			"delete from health_diary where no=?";
	@Override
	public boolean delete(long no) {
		try(
				Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE);) {			
			stmt.setLong(1,no);
			int i = stmt.executeUpdate();
			if(i==1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<HealthDiaryVO> dateSelect(int memberNo, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HealthDiaryVO> selectMemberNo(int memberNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<HealthDiaryVO> getDatePage(int pageNo, int pageSize, 
			int memberNo ,int year ,int month){
		return null;
	}
	@Override
	public int getDateTotalCount(int memberNo ,int year ,int month) {
		return 0;
	}

	@Override
	public int repeatDiary(int memberNo, java.util.Date date) {
		
		
		return 0;
	}
	@Override
	public List<HealthDiaryVO> gethighChart(int memberNo, int year, int month) {

		return null;
	}
	@Override
	public HealthDiaryVO getCalendar(int memberNo, Date date) {
		
		return null;
	}
	
}
