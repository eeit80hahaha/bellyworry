package calories.model.dao;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import calories.model.FoodCalDAO;
import calories.model.FoodCalVO;


public class test00000 {

	public static void main(String[] args) {


		//test insert for Exam 
//	  System.out.println("test insert() ==================================");
//	  FoodCalDAO exam3 = new FoodCalDAOHbm();
//	  FoodCalVO examvo3 = new FoodCalVO();
//	
//	  examvo3.setName("榴槤");
//	  examvo3.setMenuNo(100001);
//	  examvo3.setCal(38);
//	  examvo3.setCount("顆");
//	  examvo3.setWeight(102);
//	  examvo3.setCookNo(100001);
//
//	  //存圖
//	  String inFile = "C:/Users/Student/Desktop/10008.jpg";
//	  Path path=Paths.get(inFile);         //Paths.get????
//	  byte[] data = null;
//	  try {
//	   data = Files.readAllBytes(path);       //readAllBytes????      Paths.get轉成byte[]
//	  } catch (IOException e1) {
//	   e1.printStackTrace();
//	  }
//	  examvo3.setPicture(data);
//	  exam3.insert(examvo3);
//	 
//	  System.out.println(exam3.insert(examvo3));
	  
	  
	  //test update for Exam
	//  System.out.println("test update() ==================================");
		FoodCalDAO exam4 = new FoodCalDAOHbm();
		FoodCalVO examvo4 = new FoodCalVO();	
		examvo4.setFoodNo(100009);
		examvo4.setName("水蜜桃");
		examvo4.setMenuNo(100001);
		examvo4.setCal(38);
		examvo4.setCount("顆");
		examvo4.setWeight(102);
		examvo4.setCookNo(100001);	
		
		  //存圖
		  String inFile = "C:/Users/Student/Desktop/10009.jpg";
		  Path path=Paths.get(inFile);         //Paths.get????
		  byte[] data = null;
		  try {
		   data = Files.readAllBytes(path);       //readAllBytes????      Paths.get轉成byte[]
		  } catch (IOException e1) {
		   e1.printStackTrace();
		  }
		  examvo4.setPicture(data);
		  exam4.insert(examvo4);
		 
		  System.out.println(exam4.insert(examvo4));
		  
		  
		
		
	//  examvo4.setName("河濱公園烤肉團");
	//  examvo4.setContent("100001");
	//  SimpleDateFormat sFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//  try {
	//   examvo4.setStartTime(sFormat1.parse("2015-11-07 18:00:00"));
	//  } catch (ParseException e1) {
	//   // TODO Auto-generated catch block
	//   e1.printStackTrace();
	//  }
	//  try {
	//   examvo4.setEndTime(sFormat1.parse("2015-11-07 18:00:00"));
	//  } catch (ParseException e) {
	//   // TODO Auto-generated catch block
	//   e.printStackTrace();
	//  } 
	//  examvo4.setAddress("宜蘭運動公園");
	//  
	//  String inFile1 = "C:/Users/Student/Desktop/100007.jpg";
	//  Path path1=Paths.get(inFile1);         //Paths.get????
	//  byte[] data1 = null;
	//  try {
	//   data1 = Files.readAllBytes(path1);       //readAllBytes????      Paths.get轉成byte[]
	//  } catch (IOException e) {
	//   e.printStackTrace();
	//  }
	// 
	//  examvo4.setPicture(data1);
	//  
	//  examvo4.setNo(100041);
	//  exam4.update(examvo4);
	//  System.out.println(exam4.selectByPrimaryKey(examvo4.getNo()));
}
}