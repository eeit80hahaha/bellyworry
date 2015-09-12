package register.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import init.GlobalService;
import register.model.MemberDAO;
import register.model.MemberVO;

public class MemberDAOJdbc implements MemberDAO {
	private static final String SELECT_BY_MEMBER_NO =
			"select * from Member where memberNo=?";

	@Override
	public MemberVO selectByPrimaryKey(int memberNo){
		MemberVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_MEMBER_NO);
			stmt.setInt(1, memberNo);
			rset = stmt.executeQuery();
			if(rset.next()){
				result = new MemberVO();
				result.setMemberNo(rset.getInt("memberNo"));
				result.setId(rset.getString("id"));
				result.setPassword(rset.getString("password"));
				result.setFirstName(rset.getString("firstName"));
				result.setLastName(rset.getString("lastName"));
				result.setNickname(rset.getString("nickname"));
				result.setEmail(rset.getString("email"));
				result.setBirthday(rset.getDate("birthday"));
				result.setGender(rset.getString("gender"));
				result.setPurview(rset.getInt("purview"));
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
	
	private static final String SELECT_BY_ID =
			"select * from Member where id=?";

	@Override
	public MemberVO selectById(String id){
		MemberVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setString(1, id);
			rset = stmt.executeQuery();
			if(rset.next()){
				result = new MemberVO();
				result.setMemberNo(rset.getInt("memberNo"));
				result.setId(rset.getString("id"));
				result.setPassword(rset.getString("password"));
				result.setFirstName(rset.getString("firstName"));
				result.setLastName(rset.getString("lastName"));
				result.setNickname(rset.getString("nickname"));
				result.setEmail(rset.getString("email"));
				result.setBirthday(rset.getDate("birthday"));
				result.setGender(rset.getString("gender"));
				result.setPurview(rset.getInt("purview"));
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
	
	private static final String SELECT_BY_EMAIL =
			"select * from Member where email=?";

	@Override
	public MemberVO selectByEmail(String email){
		MemberVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_EMAIL);
			stmt.setString(1, email);
			rset = stmt.executeQuery();
			if(rset.next()){
				result = new MemberVO();
				result.setMemberNo(rset.getInt("memberNo"));
				result.setId(rset.getString("id"));
				result.setPassword(rset.getString("password"));
				result.setFirstName(rset.getString("firstName"));
				result.setLastName(rset.getString("lastName"));
				result.setNickname(rset.getString("nickname"));
				result.setEmail(rset.getString("email"));
				result.setBirthday(rset.getDate("birthday"));
				result.setGender(rset.getString("gender"));
				result.setPurview(rset.getInt("purview"));
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
	
	private static final String SELECT_BY_PURVIEW =
			"select * from Member where Purview=?";

	@Override
	public List<MemberVO> selectByPurview(int purview){
		List<MemberVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_PURVIEW);
			stmt.setInt(1, purview);
			rset = stmt.executeQuery();
			result = new ArrayList<MemberVO>();
			while(rset.next()){
				MemberVO bean = new MemberVO();
				bean.setMemberNo(rset.getInt("memberNo"));
				bean.setId(rset.getString("id"));
				bean.setPassword(rset.getString("password"));
				bean.setFirstName(rset.getString("firstName"));
				bean.setLastName(rset.getString("lastName"));
				bean.setNickname(rset.getString("nickname"));
				bean.setEmail(rset.getString("email"));
				bean.setBirthday(rset.getDate("birthday"));
				bean.setGender(rset.getString("gender"));
				bean.setPurview(rset.getInt("purview"));
				result.add(bean);
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
	
	private static final String SELECT_ALL =
			"select * from Member";

	@Override
	public List<MemberVO> getAll(){
		List<MemberVO> result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(SELECT_ALL);
			rset = stmt.executeQuery();
			result = new ArrayList<MemberVO>();
			while(rset.next()){
				MemberVO bean = new MemberVO();
				bean.setMemberNo(rset.getInt("memberNo"));
				bean.setId(rset.getString("id"));
				bean.setPassword(rset.getString("password"));
				bean.setFirstName(rset.getString("firstName"));
				bean.setLastName(rset.getString("lastName"));
				bean.setNickname(rset.getString("nickname"));
				bean.setEmail(rset.getString("email"));
				bean.setBirthday(rset.getDate("birthday"));
				bean.setGender(rset.getString("gender"));
				bean.setPurview(rset.getInt("purview"));
				result.add(bean);
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
			"insert into Member (id, password, firstName, lastName,"
			+ "nickname, email, birthday, gender, purview) values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public int insert(MemberVO bean){
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		if(this.selectById(bean.getId())!=null){
			result = -100;
		}else if(this.selectByEmail(bean.getEmail())!=null){
			result = -100;
		}else{
			try {
				conn = DriverManager.getConnection(GlobalService.URL,
						GlobalService.USERNAME,GlobalService.PASSWORD);
				stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
				if (bean!=null) {
					stmt.setString(1, bean.getId());
					stmt.setString(2, bean.getPassword());
					stmt.setString(3, bean.getFirstName());
					stmt.setString(4, bean.getLastName());
					stmt.setString(5, bean.getNickname());
					stmt.setString(6, bean.getEmail());
					java.util.Date birthday = bean.getBirthday();
					if (birthday != null) {
						stmt.setDate(7, new java.sql.Date(birthday.getTime()));
					} else {
						stmt.setDate(7, null);
					}
					stmt.setString(8, bean.getGender());
					stmt.setInt(9, bean.getPurview());
					stmt.executeUpdate();
					rset = stmt.getGeneratedKeys();
					if(rset.next()){
						result = rset.getInt(1);
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
		}
		return result;
	}
	private static final String UPDATE =
			"update Member set id=?, password=?, firstName=?, lastName=?, nickname=?, email=?, birthday=?, gender=?, purview=? where memberNo=?";

	@Override
	public int update(MemberVO bean){
		int result = 0;
		MemberVO temp1 = this.selectById(bean.getId());
		MemberVO temp2 = this.selectByEmail(bean.getEmail());
		if(temp1!=null && temp1.getMemberNo()!=bean.getMemberNo()){
			result = -100;
		}else if(temp2!=null && temp2.getMemberNo()!=bean.getMemberNo()){
			result = -100;
		}else{
			try(
					Connection conn = DriverManager.getConnection(GlobalService.URL,
							GlobalService.USERNAME, GlobalService.PASSWORD);
					PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
				stmt.setString(1, bean.getId());
				stmt.setString(2, bean.getPassword());
				stmt.setString(3, bean.getFirstName());
				stmt.setString(4, bean.getLastName());
				stmt.setString(5, bean.getNickname());
				stmt.setString(6, bean.getEmail());
				if(bean.getBirthday()!=null){
					long date = bean.getBirthday().getTime();
					stmt.setDate(7, new java.sql.Date(date));
				}else {
					stmt.setDate(7, null);				
				}
				stmt.setString(8, bean.getGender());
				stmt.setInt(9, bean.getPurview());
				stmt.setInt(10, bean.getMemberNo());
				result = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private static final String DELETE =
			"delete from Member where MemberNo = ?";

	@Override
	public boolean delete(int memberNo){
		Connection conn = null;
		PreparedStatement stmt = null;
		int i=0;
		try {
			conn = DriverManager.getConnection(GlobalService.URL,
					GlobalService.USERNAME, GlobalService.PASSWORD);
			stmt = conn.prepareStatement(DELETE);			
			stmt.setInt(1, memberNo);
			i = stmt.executeUpdate();
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
