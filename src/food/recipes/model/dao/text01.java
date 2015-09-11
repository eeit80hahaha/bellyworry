package food.recipes.model.dao;

import java.util.List;

import food.recipes.model.FoodListDAO;
import food.recipes.model.FoodListVO;

public class text01 {
	public static void main(String[] args) {
		
//		//test selectByPrimaryKey for Cook
//		System.out.println("test selectByPrimaryKey(int) ==========================");
//		CookDAO cook1 = new CookDAOHbm();
//		CookVO cookvo1 = cook1.selectByPrimaryKey(100002);
//		System.out.println(cookvo1);
//
//		//test getAll for Cook
//		System.out.println("test getAll() =============================");
//		CookDAO cook2 = new CookDAOHbm();
//		List<CookVO> list1 = cook2.getAll();
//
//		for(CookVO examvo2:list1){
//			System.out.println(examvo2);
//		}
//		
		//test insert for Cook	
//		System.out.println("test insert() ==================================");
//		CookDAO exam3 = new CookDAOHbm();
//		CookVO examvo3 = new CookVO();
//		examvo3.setWayNo("111111111111111111111");
//		examvo3.setPicture(null);
//		System.out.println(exam3.insert(examvo3).toString());
//		
//		//test update for Cook
//		System.out.println("test update() ==================================");
//		CookDAO exam4 = new CookDAOHbm();
//		CookVO examvo4 = new CookVO();
//		examvo4.setCookNo(100014);
//		examvo4.setWayNo("1233211234567aaaaaa");
//		examvo4.setPicture(null);
//
//		System.out.println(exam4.update(examvo4).toString());
//		
		//test delete for Cook
//		System.out.println("test delete() ==================================");
//		CookDAO exam5 = new CookDAOHbm();
//		System.out.println("delete is " + exam5.delete(100013));
//		
//============================================================================================分隔線
		
		//test selectByPrimaryKey for FoodItem
//		System.out.println("test selectByPrimaryKey(int) ==========================");
//		FoodItemDAO fooditem1 = new FoodItemDAOHbm();
//		FoodItemVO fooditemvo1 = fooditem1.selectByPrimaryKey(100001);
//		System.out.println(fooditemvo1);
//
//		//test getAll for FoodItem
//		System.out.println("test getAll() =============================");
//		FoodItemDAO exam2 = new FoodItemDAOHbm();
//		List<FoodItemVO> list1 = exam2.getAll();
//
//		for(FoodItemVO examvo2:list1){
//			System.out.println(examvo2);
//		}
		
		//test insert for FoodItem	
//		System.out.println("test insert() ==================================");
//		FoodItemDAO exam3 = new FoodItemDAOHbm();
//		FoodItemVO examvo3 = new FoodItemVO();
//		examvo3.setName("甜辣醬");
//		examvo3.setType("調味料");
//		examvo3.setCount("1小把");
//		System.out.println(exam3.insert(examvo3).toString());
//		
//		//test update for FoodItem
//		System.out.println("test update() ==================================");
//		FoodItemDAO exam4 = new FoodItemDAOHbm();
//		FoodItemVO examvo4 = new FoodItemVO();
//		examvo4.setUseFoodNo(100078);
//		examvo4.setName("綠豆");
//		examvo4.setType("醬汁醬汁");
//		examvo4.setCount("適量");
//
//		System.out.println(exam4.update(examvo4).toString());
		
		//test delete for FoodItem  
//		System.out.println("test delete() ==================================");
//		FoodItemDAO exam5 = new FoodItemDAOJdbc();
//		System.out.println("delete is " + exam5.delete(100080));
		
//============================================================================================分隔線
		//test selectByPrimaryKey for FoodList 
		System.out.println("test selectByPrimaryKey(int) ==========================");
		FoodListDAO exam1 = new FoodListDAOHbm();
		FoodListVO examvo1 = exam1.selectByPrimaryKey(100003 , 100014);
		System.out.println(examvo1);

//		//test getAll for FoodList
//		System.out.println("test getAll() =============================");
//		FoodListDAO exam2 = new FoodListDAOHbm();
//		List<FoodListVO> list1 = exam2.getAll();
//
//		for(FoodListVO examvo2:list1){
//			System.out.println(examvo2);
//		}
		
		//test insert for FoodList 
//		System.out.println("test insert() ==================================");
//		FoodListDAO exam3 = new FoodListDAOHbm();
//		FoodListVO examvo3 = new FoodListVO();		
//		examvo3.setCookNo(100003);
//		examvo3.setUseFoodNo(100002);
//		System.out.println(exam3.insert(examvo3).toString());
		
//		//test update for FoodList  
//		System.out.println("test update() ==================================");
//		FoodListDAO exam4 = new FoodListDAOJdbc();
//		FoodListVO examvo4 = new FoodListVO();
//		examvo4.setUseFoodNo(100073);
//		examvo4.setName("綠豆");
//		examvo4.setType("醬汁醬汁");
//		examvo4.setCount("適量");

//		System.out.println(exam4.update(examvo4).toString());
////		
//		 //test delete for FoodList
//		System.out.println("test delete() ==================================");
//		FoodListDAO exam5 = new FoodListDAOHbm();
//		System.out.println("delete is " + exam5.delete(100004,100042));
	}
}
