package food.combo.model.dao;

import calories.model.FoodCalDAO;
import calories.model.FoodCalVO;
//import calories.model.dao.FoodCalDAOjdbc;
import food.combo.model.DayMealDAO;
import food.combo.model.DayMealVO;
import food.combo.model.MealNameDAO;
import food.combo.model.MealNameVO;

public class test {

	public static void main(String[] args) {

		// *****MealNameDAOjdbc 測試檔!*****
		// MealNameVO vo = new MealNameVO();
		// MealNameDAO dao = new MealNameDAOjdbc();
		// MealNameDAOHbm hbm = new MealNameDAOHbm();

		// // selectByPrimaryKey
		// vo = dao.selectByPrimaryKey(100006);
		// vo = hbm.selectByPrimaryKey(100004);
		// System.out.println(vo);

		// // select_ALL
		// System.out.println(dao.getAll());
		// System.out.println(hbm.getAll());

		// // INSERT
		// vo.setName("叔字輩套餐");
		// System.out.println(hbm.insert(vo));
		// System.out.println(vo=dao.insert(vo));

		// // UPDATE
		// vo.setMealNo(100002);
		// vo.setName("八大蝴套餐");
		// System.out.println(hbm.update(vo));
		// System.out.println(dao.update(vo));

		// // DELETE
		// System.out.println(hbm.delete(100020));
		// System.out.println(dao.delete(100007));

		// =========================================================

		// *****MealDetailDAOjdbc 測試檔!*****
		// MealDetailVO vo = new MealDetailVO();
		// MealDetailDAO dao = new MealDetailDAOjdbc();
		// MealDetailDAOHbm hbm = new MealDetailDAOHbm();

		// //selectByPrimaryKey
		// vo = dao.selectByPrimaryKey(100004, 100004);
		// vo = hbm.selectByPrimaryKey(100005, 100005);
		// System.out.println(vo);

		// //select_ALL
		// System.out.println(dao.getAll());
		// System.out.println(hbm.getAll());

		// // //INSERT
		// vo.setMealNo(100001);
		// vo.setFoodNo(100001);
		//
		// System.out.println(hbm.insert(vo));
		// System.out.println(dao.insert(vo));

		// ********不能update,update沒有實質意義,但為了之後或許有其他功能,所以暫時保留,以備不時之需********
		// //UPDATE
		// vo.setFoodNo(100006);
		// vo.setMealNo(100002);
		// System.out.println(dao.update(vo));

		// DELETE
		// System.out.println(dao.delete(100005, 100005));
		// System.out.println(hbm.delete(100001, 100001));

		// =========================================================

		// *****DayMealDAOjdbc 測試檔!*****
		// DayMealVO vo = new DayMealVO();
		// DayMealDAO dao = new DayMealDAOjdbc();
		// DayMealDAOHbm hbm = new DayMealDAOHbm();

		// //selectByPrimaryKey
		// vo = dao.selectByPrimaryKey(100004);
		// vo = hbm.selectByPrimaryKey(100005);
		// System.out.println(vo);

		// //select_ALL
		// System.out.println(dao.getAll());
		// System.out.println(hbm.getAll());

		// INSERT
		// vo.setName("可達鴨");
		// vo.setBreakfast(100004);
		// vo.setLunch(100003);
		// vo.setDinner(100002);
		// System.out.println(dao.insert(vo));
		// System.out.println(hbm.insert(vo));

		// //UPDATE
		// vo.setNo(100005);
		// vo.setName("少了雞塊");
		// vo.setBreakfast(100002);
		// vo.setLunch(100001);
		// vo.setDinner(100004);
		// System.out.println(dao.update(vo));
		// System.out.println(hbm.update(vo));

		// //DELETE
		// System.out.println(dao.delete(100005));
		// System.out.println(hbm.delete(100004));

	}

}
