package calories.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import register.model.MemberVO;
import calories.model.MenuDAO;
import calories.model.MenuVO;

public class MenuDaoHbm implements MenuDAO{

	@Override
	public MenuVO selectByPrimaryKey(int menuNo) {
		MenuVO menuVO = null;
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
	try {
		session.beginTransaction();
		menuVO = (MenuVO) session.get(MenuVO.class, menuNo);
		session.getTransaction().commit();
		} catch (RuntimeException ex) {
		session.getTransaction().rollback();
		throw ex;
		}
		return menuVO;
	}
	
	private static final String SELECT_BY_NAME =
			"from MenuVO where name=?";

	public MenuVO selectByName(String name){
		MenuVO menuVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_BY_NAME);
			query.setParameter(0, name);
			List<MenuVO> list = query.list();
			if(list.size()!=0){
				menuVO = list.get(0);
			}
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return menuVO;
	}
	
	@Override
	public List<MenuVO> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<MenuVO> result = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("from MenuVO order by menuNo");
			result = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return result;
	}
	
	@Override
	public int insert(MenuVO vo) {
		int result=0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(vo);
			session.getTransaction().commit();
			result=vo.getMenuNo();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
//			System.out.println("違反UNIQUEKEY條件約束");
			String[] ss=ex.getCause().getMessage().split("'")[0].split(" ");
			String ss1=ss[0]+ss[1]+ss[2]+ss[3];
			if("違反UNIQUEKEY條件約束".equals(ss1)){
				result=-100;
			}else{
				result=0;
			}
//			throw ex;
		}
		return result;
	}
	@Override
	public int update(MenuVO bean) {
		int result=0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();		
			Query query = session
					.createQuery("update MenuVO set name=? where menuNo=?");

			query.setParameter(0, bean.getName());
			query.setParameter(1, bean.getMenuNo());
			int i = query.executeUpdate();
			session.getTransaction().commit();
			if (i > 0) {
				result = i;
			}
			
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
//			System.out.println("違反UNIQUEKEY條件約束");
			String[] ss=ex.getCause().getMessage().split("'")[0].split(" ");
			String ss1=ss[0]+ss[1]+ss[2]+ss[3];
			if("違反UNIQUEKEY條件約束".equals(ss1)){
				result=-100;
			}else{
				result=0;
			}
//			throw ex;
		}
		return result;
	}

	@Override
	public boolean delete(int menuNo) {
		boolean result=false;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//        【此時多方(宜)可採用HQL刪除】
			Query query = session.createQuery("delete from MenuVO where menuNo=?");
			query.setParameter(0, menuNo);			
			int i = query.executeUpdate();			
			if(i>0){
				result = true;
			}
			session.getTransaction().commit();
			System.out.println("刪除的筆數=" + i);
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;			
		}
//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
//			EmpVO empVO = new EmpVO();
//			empVO.setEmpno(empno);
//			session.delete(empVO);

//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方emp2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			MenuVO menuVO = (MenuVO) session.get(MenuVO.class, menuNo);
//			session.delete(menuVO);
//			session.getTransaction().commit();
//			result =true;
//		} catch (RuntimeException ex) {
//			session.getTransaction().rollback();
//			throw ex;
//			
//		}
		return result;
	}
		
}
