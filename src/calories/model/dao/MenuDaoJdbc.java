package calories.model.dao;

import init.GlobalService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import calories.model.MenuDAO;
import calories.model.MenuVO;

public class MenuDaoJdbc implements MenuDAO{
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
			"select * from menu where menuNo=?";
	@Override
	public MenuVO selectByPrimaryKey(int menuNo) {
		MenuVO result = null;
		ResultSet rset = null;
		try(
			Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {
			
			stmt.setInt(1, menuNo);
			rset = stmt.executeQuery();
			if(rset.next()) {
				result = new MenuVO();
				result.setMenuNo(rset.getInt("menuNo"));
				result.setName(rset.getString("name"));

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
			"select * from menu";
	@Override
	public List<MenuVO> getAll() {
		List<MenuVO> result = null;
		try(
				Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rset = stmt.executeQuery();) {
			
			result = new ArrayList<MenuVO>();
			while(rset.next()) {
				MenuVO bean = new MenuVO();
				bean.setMenuNo(rset.getInt("menuNo"));
				bean.setName(rset.getString("name"));
				result.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String INSERT =
			"insert into Menu (name) values (?)";
	@Override
	public MenuVO insert(MenuVO vo) {
		MenuVO result = null;
		try(
				Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT);) {
			if(vo!=null) {
				stmt.setString(1, vo.getName());
				int i = stmt.executeUpdate();
				if(i==1) {
					result = vo;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static final String UPDATE =
			"update menu set name=? where menuNo=?";
	@Override
	public MenuVO update(MenuVO bean) {
		MenuVO result = null;
		try(
				Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {
			stmt.setString(1, bean.getName());
			stmt.setInt(2, bean.getMenuNo());
			int i = stmt.executeUpdate();
			if(i==1) {
				result = this.selectByPrimaryKey(bean.getMenuNo());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String DELETE =
			"delete from menu where menuNo=?";	
	@Override
	public boolean delete(int menuNo) {
		try(
			Connection conn = DriverManager.getConnection(GlobalService.URL, GlobalService.USERNAME, GlobalService.PASSWORD);
//			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE);) {			
			conn.setAutoCommit(false);
			stmt.setInt(1, menuNo);			
			int l = stmt.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
			if(l==1) {
				return true	;			
			}else{
				conn.rollback();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
		
}
