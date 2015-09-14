package health.model.dao;

import health.model.HealthDiaryVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import health.model.EatRecordDAO;
import health.model.EatRecordVO;
import health.model.ExerciseRecordDAO;
import health.model.ExerciseRecordVO;
import health.model.HealthDiaryVO;



public class test {

	public static void main(String[] args) {
		

		// *****HealthDiaryDaoHbm 測試檔!*****		
		HealthDiaryDaoHbm result=new HealthDiaryDaoHbm();
//		System.out.println(result.selectByPrimaryKey(1000001));
//		System.out.println(result.selectByMemberNo(1000008));
//		System.out.println(result.getAll());
		HealthDiaryVO result1=new HealthDiaryVO();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		result1.setMemberNo(1000002);
		try {
			result1.setDate(sFormat.parse("2003-03-21"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		result1.setHeight(182.5f);//why 要型別轉換?
		result1.setWeight(83.2f);//why 要型別轉換?
		result1.setWaistline(100.5f);//why 要型別轉換?
		result1.setTitle("測試測試");
		result1.setContent("測試試測試測試");
		result1.setShare("1");
		result1.setNo(1000009);
//		System.out.println(result.insert(result1));
		System.out.println(result.update(result1));
//		System.out.println(result.delete(1000008));
		
		// =========================================================

//		result.update(result1);
//		System.out.println(result.delete(1000009));
//		
//		// =========================================================
//		
//		//EatRecordDAOHbm test
//		EatRecordDAO eatDao = new EatRecordDAOHbm();
//		//selectByPrimaryKey
//		EatRecordVO eatVo = eatDao.selectByPrimaryKey(10);
//		System.out.println("PK(10): "+eatVo);
//		EatRecordVO eatVo1 = eatDao.selectByPrimaryKey(100);
//		System.out.println("PK(100): "+eatVo1);
//		//selectByMemberNo
//		System.out.println("MemberNo(11): "+eatDao.selectByMemberNo(1000011));
//		System.out.println("MemberNo(100): "+eatDao.selectByMemberNo(1000100));
//		//getAll
//		System.out.println("ALL: "+eatDao.getAll());
//		//insert
//		EatRecordVO eatVo2 = new EatRecordVO();
//		eatVo2.setMemberNo(1000009);
//		eatVo2.setDate(new java.util.Date(0));
//		eatVo2.setTime("早上");
//		eatVo2.setFoodNo(100006);
//		eatVo2.setCount(300);
//		long temp = eatDao.insert(eatVo2);
//		System.out.println(eatDao.selectByPrimaryKey(temp));
//		//update
//		EatRecordVO eatVo3 = new EatRecordVO();
//		eatVo3.setNo(temp);
//		eatVo3.setMemberNo(1000005);
//		eatVo3.setDate(new java.util.Date());
//		eatVo3.setTime("中午");
//		eatVo3.setCount(30);
//		eatVo3.setFoodNo(100001);
//		System.out.println("update: "+eatDao.update(eatVo3));
//		System.out.println("after update: "+eatDao.selectByPrimaryKey(temp));
//		System.out.println("delete: "+eatDao.delete(eatVo3.getNo()));	
//
//		// =========================================================
//		// ExerciseRecordDAOJdbc test	
//		//selectByPrimaryKey
//		ExerciseRecordDAO exDao = new ExerciseRecordDAOHbm();
//		ExerciseRecordVO exVo = exDao.selectByPrimaryKey(3);
//		ExerciseRecordVO exVo1 = exDao.selectByPrimaryKey(300);
//		System.out.println("PK(3): "+exVo);
//		System.out.println("PK(300): "+exVo1);
//		//selectByMemberNo
//		System.out.println("MemberNo(11): "+exDao.selectByMemberNo(1000011));
//		System.out.println("MemberNo(500): "+exDao.selectByMemberNo(1000500));
//		//getAll
//		System.out.println("ALL: "+exDao.getAll());
//		//insert
//		ExerciseRecordVO exVo2 = new ExerciseRecordVO();
//		exVo2.setMemberNo(1000009);
//		exVo2.setExerciseNo(100003);
//		exVo2.setDate(new java.util.Date(0));
//		exVo2.setCount(300);
//		long temp2 = exDao.insert(exVo2);
//		System.out.println(exDao.selectByPrimaryKey(temp2));
//		//update
//		ExerciseRecordVO exVo3 = new ExerciseRecordVO();
//		exVo3.setNo(temp2);
//		exVo3.setMemberNo(1000005);
//		exVo3.setExerciseNo(100002);		
//		exVo3.setDate(new java.util.Date());
//		exVo3.setCount(20);
//		System.out.println("update: "+exDao.update(exVo3));
//		System.out.println("after update: "+exDao.selectByPrimaryKey(exVo3.getNo()));
//		System.out.println("delete: "+exDao.delete(exVo3.getNo()));

	}
}
