package fun.model.dao;



import fun.model.ViewClassDAO;
import fun.model.ViewClassVO;



public class testViewClass {
	public static void main(String[] args) throws java.text.ParseException {
		
//		test selectByPrimaryKey for Exam
//		System.out.println("test selectByPrimaryKey(int) ==========================");
//		ViewClassDAO exam1 = new ViewClassDAOjdbc();
//		ViewClassVO examvo1 = exam1.selectByPrimaryKey(100001);
//		System.out.println(examvo1);

//		//test getAll for Exam
//		System.out.println("test getAll() =============================");
//		ViewClassDAOjdbc exam2 = new ViewClassDAOjdbc();
//		List<ViewClassVO> list1 = exam2.getAll();
//		for(ViewClassVO examvo2:list1){
//			System.out.println(examvo2);
//		}
//		
//		//test insert for Exam	
//		System.out.println("test insert() ==================================");
//		ViewClassDAO exam3 = new ViewClassDAOjdbc();
//		ViewClassVO examvo3 = new ViewClassVO();
//		examvo3.setName("2015 宜蘭國道馬拉松賽");
//		exam3.insert(examvo3);
////		System.out.println(exam3.insert(examvo3).toString());
		
////		test update for Exam
//		System.out.println("test update() ==================================");
//		ViewClassDAO exam4 = new ViewClassDAOjdbc();
//		ViewClassVO examvo4 = new ViewClassVO();
//		examvo4.setName("河濱公園11111");
//		examvo4.setViewClassNo(100019);
//		exam4.update(examvo4);
////		System.out.println(exam4.update(examvo4).toString());
//		
//		//test delete for Exam
		System.out.println("test delete() ==================================");
		ViewClassDAO exam5 = new ViewClassDAOjdbc();
		exam5.delete(100018);
//		
//		
	}
}
