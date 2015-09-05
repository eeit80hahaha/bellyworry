package news.model.dao;



import fun.model.ViewClassDAO;
import fun.model.ViewClassVO;
import fun.model.dao.ViewClassDAOjdbc;



public class testExamDAO {
	public static void main(String[] args) {
//		
//		//test selectByPrimaryKey for Exam
//		System.out.println("test selectByPrimaryKey(int) ==========================");
//		ActivityDAO exam1 = new ActivityDAOjdbc();
//		ActivityVO examvo1 = exam1.selectByPrimaryKey(100001);
//		System.out.println(examvo1);
//
//		//test getAll for Exam
//		System.out.println("test getAll() =============================");
//		ActivityDAO exam2 = new ActivityDAOjdbc();
//		List<ActivityVO> list1 = exam2.getAll();
//
//		for(ActivityVO examvo2:list1){
//			System.out.println(examvo2);
//		}
//		
//		//test insert for Exam	
		System.out.println("test insert() ==================================");
		ViewClassDAO exam3 = new ViewClassDAOjdbc();
		ViewClassVO examvo3 = new ViewClassVO();
		examvo3.setName("測試題目1aaa");
		exam3.insert(examvo3);
//		System.out.println(exam3.insert(examvo3).toString());
		
//		//test update for Exam
//		System.out.println("test update() ==================================");
//		ActivityDAO exam4 = new ActivityDAOjdbc();
//		ActivityVO examvo4 = new ActivityVO();
//
//		examvo4.setName("河濱公園999");
//		examvo4.setContent("100001");
//		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		try {
//			examvo4.setStartTime(sFormat.parse("2015-11-07 18:00:00"));
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			examvo4.setEndTime(sFormat.parse("2015-11-07 18:00:00"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		examvo4.setAddress("宜蘭運動公園");
//		examvo4.setPicture(null);
//		examvo4.setNo(100029);
//		exam4.update(examvo4);
//		System.out.println(exam4.update(examvo4).toString());
		
//		//test delete for Exam
//		System.out.println("test delete() ==================================");
//		ActivityDAO exam5 = new ActivityDAOjdbc();
//		System.out.println("delete is " + exam5.delete(100006));
//		
//		
	}
}
