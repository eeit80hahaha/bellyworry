package fun.model.dao;



import java.util.List;

import fun.model.ViewClassDAO;
import fun.model.ViewClassVO;



public class testViewClass {
	public static void main(String[] args) throws java.text.ParseException {
		
//		test selectByPrimaryKey for Exam
//		System.out.println("test selectByPrimaryKey(int) ==========================");
//		ViewClassDAO exam1 = new ViewClassDAOHbm();
//		ViewClassVO examvo1 = exam1.selectByPrimaryKey(100001);
//		System.out.println(examvo1);

//		//test getAll for Exam
//		System.out.println("test getAll() =============================");
//		ViewClassDAO exam2 = new ViewClassDAOHbm();
//		List<ViewClassVO> list1 = exam2.getAll();
//		for(ViewClassVO examvo2:list1){
//			System.out.println(examvo2);
//		}
//		
//		//test insert for Exam	
//		System.out.println("test insert() ==================================");
//		ViewClassDAO exam3 = new ViewClassDAOHbm();
//		ViewClassVO examvo3 = new ViewClassVO();
//		examvo3.setName("2015 宜蘭國道馬拉松賽1");
//		System.out.println(exam3.insert(examvo3));
		
////		test update for Exam
//		System.out.println("test update() ==================================");
		ViewClassDAO exam4 = new ViewClassDAOHbm();
		ViewClassVO examvo4 = new ViewClassVO();
		examvo4.setName("公園");
		examvo4.setViewClassNo(10006);
		System.out.println(exam4.update(examvo4));
//		
//		//test delete for Exam
//		System.out.println("test delete() ==================================");
//		ViewClassDAO exam5 = new ViewClassDAOHbm();
//		System.out.println(exam5.delete(100003));
		
		
	}
}
