package food.combo.model.dao;

import calories.model.FoodCalDAO;
import calories.model.FoodCalVO;
import calories.model.dao.FoodCalDAOjdbc;
import food.combo.model.DayMealDAO;
import food.combo.model.DayMealVO;
import food.combo.model.MealNameDAO;
import food.combo.model.MealNameVO;

public class test {

	public static void main(String[] args) {

		// MealNameVO vo = new MealNameVO();
		// MealNameDAO dao = new MealNameDAOjdbc();

		// // selectByPrimaryKey
		// vo = dao.selectByPrimaryKey(100006);
		// System.out.println(vo);

		// // select_ALL
		// System.out.println(dao.getAll());

		// // INSERT
		// vo.setName("少女夢幻套餐");
		// System.out.println(vo=dao.insert(vo));

		// // UPDATE
		// vo.setMealNo(100002);
		// vo.setName("鮮肉套餐");
		// System.out.println(dao.update(vo));

		// // DELETE
		// System.out.println(dao.delete(100007));

		// =========================================================
		// MealDetailVO vo = new MealDetailVO();
		// MealDetailDAO dao = new MealDetailDAOjdbc();

		// //selectByPrimaryKey
		// vo = dao.selectByPrimaryKey(100004, 100004);
		// System.out.println(vo);

		// //select_ALL
		// System.out.println(dao.getAll());

		// //INSERT
		// vo.setFoodNo(100003);
		// vo.setMealNo(100001);
		// System.out.println(dao.insert(vo));

		// ********不能update,update沒有實質意義,但為了之後或許有其他功能,所以暫時保留,以備不時之需********
		// //UPDATE
		// vo.setFoodNo(100006);
		// vo.setMealNo(100002);
		// System.out.println(dao.update(vo));

		// DELETE
		// System.out.println(dao.delete(100005, 100005));

		// =========================================================
		// DayMealVO vo = new DayMealVO();
		// DayMealDAO dao = new DayMealDAOjdbc();

		// //selectByPrimaryKey
		// vo = dao.selectByPrimaryKey(100004);
		// System.out.println(vo);

		// //select_ALL
		// System.out.println(dao.getAll());

		// //INSERT
		// vo.setName("好想睡覺");
		// vo.setBreakfast(100004);
		// vo.setLunch(100003);
		// vo.setDinner(100002);
		// System.out.println(dao.insert(vo));

		// //UPDATE
		// vo.setNo(100001);
		// vo.setName("大麥克");
		// vo.setBreakfast(100003);
		// vo.setLunch(100001);
		// vo.setDinner(100002);
		// System.out.println(dao.update(vo));

		// //DELETE
		// System.out.println(dao.delete(100005));

		// =========================================================
		// FoodCalVO vo = new FoodCalVO();
		// FoodCalDAO dao = new FoodCalDAOjdbc();

		// // selectByPrimaryKey
		// vo = dao.selectByPrimaryKey(100009);
		// System.out.println(vo);

		// // select_ALL
		// System.out.println(dao.getAll());

		// // INSERT
		// vo.setName("水蜜桃");
		// vo.setMenuNo(100007);
		// vo.setCal(38);
		// vo.setCount("顆");
		// vo.setWeight(102);
		// vo.setCookNo(100001);
		// System.out.println(dao.insert(vo,null,0));
		// System.out.println(dao.selectByPrimaryKey(100018));

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

	}

}
