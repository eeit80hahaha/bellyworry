package news.model.dao;



import java.text.SimpleDateFormat;

import news.model.ActivityDAO;
import news.model.ActivityVO;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;



public class testActivity {
	public static void main(String[] args) throws java.text.ParseException {
//		
		//test selectByPrimaryKey for Exam
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
		//test insert for Exam	
//		System.out.println("test insert() ==================================");
//		ActivityDAO exam3 = new ActivityDAOjdbc();
//		ActivityVO examvo3 = new ActivityVO();
//		examvo3.setName("2015 宜蘭國道馬拉松賽");
//		examvo3.setContent("原視今（2015年）已邁向10年穩健成熟的發展階段，在這個重要的10年里程碑，原視特別規劃全台首創的原住民族主題路跑活動，早期的原住民以跑步作為傳遞訊息的方式，10年來原視也兼負這項文化傳承及訊息傳遞的使命，今年首次舉辦大眾喜愛的路跑活動，邀請每位參賽者都能成為原住民族文化傳遞的一份子，共同扎根、跨越、跑向原視界。");
//		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		try {
//			examvo3.setStartTime(sFormat.parse("2015-11-07 18:00:00"));
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			examvo3.setEndTime(sFormat.parse("2015-11-07 18:00:00"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		examvo3.setAddress("台北市政府廣場");		
//		
//		exam3.insert(examvo3,null,0);
//		System.out.println(exam3.insert(examvo3).toString());
		
		//test update for Exam
		System.out.println("test update() ==================================");
		ActivityDAO exam4 = new ActivityDAOjdbc();
		ActivityVO examvo4 = new ActivityVO();

		examvo4.setName("河濱公園99999999999");
		examvo4.setContent("100007");
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			examvo4.setStartTime(sFormat.parse("2015-11-07 18:00:00"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			examvo4.setEndTime(sFormat.parse("2015-11-07 18:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		examvo4.setAddress("宜蘭運動公園");
		examvo4.setNo(100007);
		exam4.update(examvo4);
//		System.out.println(exam4.update(examvo4).toString());
		
//		//test delete for Exam
//		System.out.println("test delete() ==================================");
//		ActivityDAO exam5 = new ActivityDAOjdbc();
//		System.out.println("delete is " + exam5.delete(100006));
//		
//		
	}
}
