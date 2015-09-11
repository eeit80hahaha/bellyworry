package news.model.dao;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import news.model.ActivityDAO;
import news.model.ActivityVO;



public class testActivity {
	public static void main(String[] args) throws java.text.ParseException {
	
		ActivityDAO exam3 = new ActivityDAOHbm();
		ActivityVO examvo3 = new ActivityVO();
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
//		String inFile = "C:\\Users\\user\\Desktop\\duck.jpg";
//		Path path=Paths.get(inFile);
//		byte[] data = null;
//		try {
//			data = Files.readAllBytes(path);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		Blob blob = null;
//		try {
//			blob = new javax.sql.rowset.serial.SerialBlob(data);
//		} catch (SerialException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}   
//		examvo3.setPicture(blob);
//		examvo3.setAddress("avcc");
//		exam3.insert(examvo3, null, 0);
		Blob b=exam3.selectByPrimaryKey(100008).getPicture();
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("C:\\Users\\user\\Desktop\\duckcopy1.jpg");
			byte[] data = b.getBytes(1, (int)b.length());
			fos.write(data);
			fos.close();		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		
	}
}
