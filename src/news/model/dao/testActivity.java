package news.model.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import news.model.ActivityDAO;
import news.model.ActivityVO;






public class testActivity {
	public static void main(String[] args) throws java.text.ParseException {
//		
		//test selectByPrimaryKey for Exam
//		System.out.println("test selectByPrimaryKey(int) ==========================");
//		ActivityDAO exam1 = new ActivityDAOHbm();
//		ActivityVO examvo1 = exam1.selectByPrimaryKey(100001);
//		System.out.println(examvo1);

//		//test getAll for Exam
//		System.out.println("test getAll() =============================");
		ActivityDAO exam2 = new ActivityDAOHbm();
		List<ActivityVO> list1 = exam2.getAll();

		for(ActivityVO examvo2:list1){
			System.out.println(examvo2);
		}
//		
		//test insert for Exam	
//		System.out.println("test insert() ==================================");
//		ActivityDAO exam3 = new ActivityDAOHbm();
//		ActivityVO examvo3 = new ActivityVO();
//
//		examvo3.setName("2000 宜蘭國道馬拉松賽");
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
//	
//		examvo3.setAddress("台北市政府廣場");		
//		//存圖
//		String inFile = "C:/Users/Student/Desktop/10008.jpg";
//		Path path=Paths.get(inFile);									//Paths.get????
//		byte[] data = null;
//		try {
//			data = Files.readAllBytes(path);							//readAllBytes????      Paths.get轉成byte[]
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//  
//		examvo3.setPicture(data);
//		exam3.insert(examvo3);
//	
//		System.out.println(exam3.insert(examvo3).toString());
		
		//test update for Exam
//		System.out.println("test update() ==================================");
//		ActivityDAO exam4 = new ActivityDAOHbm();
//		ActivityVO examvo4 = new ActivityVO();
//
//		examvo4.setName("河濱公園烤肉團");
//		examvo4.setContent("100001");
//		SimpleDateFormat sFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		try {
//			examvo4.setStartTime(sFormat1.parse("2015-01-07 18:00:00"));
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			examvo4.setEndTime(sFormat1.parse("2015-01-07 18:00:00"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		examvo4.setAddress("宜蘭運動公園");
//		
//		String inFile1 = "C:/Users/sa/Desktop/2.jpg";
//		Path path1=Paths.get(inFile1);									//Paths.get????
//		byte[] data1 = null;
//		try {
//			data1 = Files.readAllBytes(path1);							//readAllBytes????      Paths.get轉成byte[]
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
// 
//		examvo4.setPicture(data1);
//		examvo4.setUrl("www.yahoo.com.tw");
//		examvo4.setBoss("Nike");
//		
//		examvo4.setNo(100012);
//		exam4.update(examvo4);
//		System.out.println(exam4.selectByPrimaryKey(examvo4.getNo()));
		
//		//test delete for Exam
//		System.out.println("test delete() ==================================");
//		ActivityDAO exam5 = new ActivityDAOHbm();
//		System.out.println("delete is " + exam5.delete(100031));
		
		
		
		
		
		
		
//		如果有要降byte[]轉成Blob再來用!!
//		Blob blob = null;
//		try {
//			blob = new javax.sql.rowset.serial.SerialBlob(data);		//byte[]轉成Blob
//		} catch (SerialException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
		
		
		
//		讀圖!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//		Blob b=exam3.selectByPrimaryKey(100037).getPicture();
//		FileOutputStream fos;
//		try {
//			fos = new FileOutputStream("C:/Users/Student/Desktop/duckcopy1.jpg");
//			byte[] data = b.getBytes(1, (int)b.length());
//			fos.write(data);
//			fos.close();		
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}	
//		
//		
		
//		 for(int i=100001;i<100009;i++){
//			 FoodCalVO vo = new FoodCalVO();
//		 FoodCalDAOHbm vo1 = new FoodCalDAOHbm();
//		 FoodCalVO ss=vo1.selectByPrimaryKey(i); 
////		 System.out.println(ss);
//
//		 FoodCalDAOHbm hbm = new FoodCalDAOHbm();
//		 File file = new File("C:/Users/Student/Desktop/"+i+".jpg");
//			FileInputStream fis = null;
//			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//			int read;
//			byte[] data = new byte[1024];
//			try {
//				fis = new FileInputStream(file);
//				while ((read = fis.read(data, 0, data.length)) != -1) {
//					buffer.write(data, 0, read);
//				}
//				buffer.flush();
//			} catch (IOException e) {
//
//				e.printStackTrace();
//				}
//			vo.setFoodNo(ss.getFoodNo());
//			 vo.setName(ss.getName());
//			 vo.setMenuNo(ss.getMenuNo());
//			 vo.setCal(ss.getCal());
//			 vo.setCount(ss.getCount());
//			 vo.setWeight(ss.getWeight());
//			 vo.setCookNo(ss.getCookNo());
//			 vo.setPicture(buffer.toByteArray());
//			 System.out.println(hbm.update(vo)); 
//		 }
	    //test sawstarttime for Activity
//		ActivityDAO exam2 = new ActivityDAOHbm();
//		List<java.sql.Timestamp> list1 = exam2.sawendtime();
//		System.out.println(list1);
//		
//		for(java.sql.Timestamp examvo2: list1){
//			System.out.println(examvo2);
//		}
		
		//test IPtime
//		ActivityDAO exam21 = new ActivityDAOHbm();
//		String time=exam21.getDateTime();
//		System.out.print(time);
		
		//test sawaddress  記得要設String
//		ActivityDAO exam211 = new ActivityDAOHbm();
//		List<String> time1=exam211.sawaddress();
//		List<String> listTemp1 = new ArrayList<String>();
//		System.out.println(time1);
//		for(String tenmp:time1){
//			listTemp1.add(tenmp.substring(0,4));
//		}
//		System.out.println(listTemp1);
		//彭帥的神救援地址
//		List<ActivityVO> vo =  exam211.getAll();
//		List<String> a = new ArrayList<String>();
//		for(ActivityVO b:vo){
//			a.add(b.getAddress().substring(0,4));
//		}
//		System.out.println(a);

		
		//test findBySname for Activity
//		System.out.println("test getAll() =============================");
//		ActivityDAO exam1 = new ActivityDAOHbm();
//		List<ActivityVO> examvo1 =  exam1.findBySname("宜蘭");
//
//		System.out.println(examvo1);
	}
}
