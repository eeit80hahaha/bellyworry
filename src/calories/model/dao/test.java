package calories.model.dao;

import calories.model.FoodCalDAO;
import calories.model.FoodCalVO;

public class test {

	public static void main(String[] args) {

		// *****FoodCalDAOjdbc 測試檔!*****
		FoodCalVO vo = new FoodCalVO();
		FoodCalDAO dao = new FoodCalDAOjdbc();

		// // selectByPrimaryKey
		// vo = dao.selectByPrimaryKey(100009);
		// System.out.println(vo);

		// // select_ALL
		// System.out.println(dao.getAll());

		// // INSERT
		 vo.setName("水蜜桃");
		 vo.setMenuNo(100007);
		 vo.setCal(38);
		 vo.setCount("顆");
		 vo.setWeight(102);
		 vo.setCookNo(100001);
		 System.out.println(dao.insert(vo,null,0));
		 System.out.println(dao.selectByPrimaryKey(100018));

		// vo.setName("美式咖啡");
		// vo.setMenuNo(100018);
		// vo.setCal(2);
		// vo.setCount("杯");
		// vo.setWeight(240);
		// vo.setCookNo(100003);
		// System.out.println(dao.insert(vo,null,0));
		// System.out.println(dao.selectByPrimaryKey(100001));

		// // UPDATE
		// vo.setFoodNo(100007);
		// vo.setName("烤肋排");
		// vo.setMenuNo(100002);
		// vo.setCal(999);
		// vo.setCount("份");
		// vo.setCookNo(100007);
		// vo.setWeight(300);
		// System.out.println(dao.update(vo));

		// // DELETE
		// System.out.println(dao.delete(100008));

		// =========================================================

		// *****MenuDaoJdbc 測試檔!*****
//		MenuDaoJdbc temp=new MenuDaoJdbc();
//		System.out.println(temp.selectByPrimaryKey(100015));
//		System.out.println(temp.getAll());
//		MenuVO temp1=new MenuVO();	
//		temp1.setMenuNo(100019);
//		temp1.setName("類");
//		System.out.println(temp.insert(temp1));
//		System.out.println(temp.update(temp1));
//		System.out.println(temp.delete(100019));
		
		// =========================================================
		
		// *****ExerciseCalDaoJdbc 測試檔!*****
//		ExerciseCalDaoJdbc test=new ExerciseCalDaoJdbc();
//		System.out.println(test.selectByPrimaryKey(100001));
//		System.out.println(test.getAll());
//		ExerciseCalVO test1=new ExerciseCalVO();		
//		test1.setName("千球4");
//		test1.setCalHour( 50.7F);//why 要型別轉換?
//		test1.setExerciseNo(100008);
//		System.out.println(test.insert(test1));
//		System.out.println(test.update(test1));
//		System.out.println(test.delete(100008));
		
		// =========================================================
		
	}

}
