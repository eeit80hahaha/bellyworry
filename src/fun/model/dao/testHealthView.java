package fun.model.dao;



import fun.model.HealthViewDAO;



public class testHealthView {
	public static void main(String[] args) throws java.text.ParseException {
//		
//		test selectByPrimaryKey for Exam
//		System.out.println("test selectByPrimaryKey(int) ==========================");
//		HealthViewDAO exam1 = new HealthViewDAOjdbc();
//		HealthViewVO examvo1 = exam1.selectByPrimaryKey(100001);
//		System.out.println(examvo1);

//		//test getAll for Exam
//		System.out.println("test getAll() =============================");
//		HealthViewDAO exam2 = new HealthViewDAOjdbc();
//		List<HealthViewVO> list1 = exam2.getAll();
//
//		for(HealthViewVO examvo2:list1){
//			System.out.println(examvo2);
//		}
//		
//		//test insert for Exam	
//		System.out.println("test insert() ==================================");
//		HealthViewDAO exam3 = new HealthViewDAOjdbc();
//		HealthViewVO examvo3 = new HealthViewVO();
//		examvo3.setName("2015 宜蘭國道馬拉松賽");
//		examvo3.setViewClassNo(100001);
//		examvo3.setLat((float) 24.9926349);
//		examvo3.setLng((float) 24.9926349);
//		exam3.insert(examvo3);
////		System.out.println(exam3.insert(examvo3).toString());
		
////		test update for Exam
//		System.out.println("test update() ==================================");
//		HealthViewDAO exam4 = new HealthViewDAOjdbc();
//		HealthViewVO examvo4 = new HealthViewVO();
//
//		examvo4.setName("河濱公園99999999999");
//		examvo4.setViewClassNo(100002);		
//		examvo4.setLat((float) 24.9926349);
//		examvo4.setLng((float) 24.9926349);
//		examvo4.setNo(100007);
//		exam4.update(examvo4);
////		System.out.println(exam4.update(examvo4).toString());
//		
		//test delete for Exam
		System.out.println("test delete() ==================================");
		HealthViewDAO exam5 = new HealthViewDAOjdbc();
		exam5.delete(100007);
		
		
	}
}
