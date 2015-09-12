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

		// *****MealNameDAOjdbc 測試檔!*****
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

		// *****MealDetailDAOjdbc 測試檔!*****
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

		// *****DayMealDAOjdbc 測試檔!*****
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

	}

}
