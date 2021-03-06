package ranking.model.dao;

import health.model.HealthDiaryDAO;
import health.model.dao.HealthDiaryDaoHbm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import ranking.model.HeroDAO;
import ranking.model.HeroVO;
import ranking.model.ReflectDAO;
import ranking.model.ReflectVO;



public class Test {
	
	private static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	//test MS SQL for Hero to Hibernate
	public static void main(String[] args) throws ParseException {
		
		//test selectByPrimaryKey for Hero ok
//		System.out.println("test selectByPrimaryKey(int) ==========================");
//		HeroDAO hero1 = new HeroDAOHbm();
//		HeroVO herovo1 = hero1.selectByPrimaryKey(1000015);
//		System.out.println(herovo1);

		//test getAll for Hero ok
//		System.out.println("test getAll() =============================");
//		HeroDAO hero2 = new HeroDAOHbm();
//		List<HeroVO> list1 = hero2.getAll();
//		for(HeroVO herovo2:list1){
//			System.out.println(herovo2);
//		}
		
		//test insert for Hero ok
//		System.out.println("test insert() ==================================");
//		HeroDAO hero3 = new HeroDAOHbm();
//		HeroVO herovo3 = new HeroVO();
//		herovo3.setMemberNo(1000017);
//		herovo3.setWeightDiff(3);
//		herovo3.setNum(32);
//		System.out.println(hero3.selectByPrimaryKey(hero3.insert(herovo3)));
		
		//test update for Hero ok
//		System.out.println("test update() ==================================");
//		HeroDAO hero4 = new HeroDAOHbm();
//		HeroVO herovo4 = new HeroVO();
//		herovo4.setMemberNo(1000017);
//		herovo4.setWeightDiff(3);
//		herovo4.setNum(27);
//		System.out.println("update num :"+hero4.update(herovo4));
//		System.out.println(hero4.selectByPrimaryKey(herovo4.getMemberNo()));
		
		//test delete for Hero delete is null error
//		System.out.println("test delete() ==================================");
//		HeroDAO hero5 = new HeroDAOHbm();
//		System.out.println("delete is " + hero5.delete(1000017));
		
		
		
		//test MS SQL for Reflect to Hibernate******************************************		
		
		//test selectByPrimaryKey for Reflect date format error
//		System.out.println("test selectByPrimaryKey(int) ==========================");
//		ReflectDAO reflect1 = new ReflectDAOHbm();
//		ReflectVO reflectvo1 = reflect1.selectByPrimaryKey(100001);
//		System.out.println(reflectvo1);

		//test getAll for Reflect date format error
//		System.out.println("test getAll() =============================");
//		ReflectDAO reflect2 = new ReflectDAOHbm();
//		List<ReflectVO> list1 = reflect2.getAll();
//		for(ReflectVO reflectvo2:list1){
//			System.out.println(reflectvo2);
//		}
		
		//test insert for Reflect date format error
//		System.out.println("test insert() ==================================");
//		ReflectDAO reflect3 = new ReflectDAOHbm();
//		ReflectVO reflectvo3 = new ReflectVO();
//		reflectvo3.setReflectedNo(1000004);
//		reflectvo3.setAuthorNo(1000003);
//		reflectvo3.setReflectedDate((java.util.Date) sFormat.parse("2015-09-07"));
//		reflectvo3.setAuthorDate((java.util.Date) sFormat.parse("2015-09-07"));
//		System.out.println(reflect3.selectByPrimaryKey(reflect3.insert(reflectvo3)));
		//Date 未完成
		
		//test update for Reflect date format error
//		System.out.println("test update() ==================================");
//		ReflectDAO reflect4 = new ReflectDAOHbm();
//		ReflectVO reflectvo4 = new ReflectVO();
//		reflectvo4.setNo(100015);
//		reflectvo4.setReflectedNo(1000004);
//		reflectvo4.setAuthorNo(1000005);
//		reflectvo4.setReflectedDate((java.util.Date) sFormat.parse("2015-09-08"));
//		reflectvo4.setAuthorDate((java.util.Date) sFormat.parse("2015-09-06"));
//		System.out.println("update num :"+reflect4.update(reflectvo4));
//		System.out.println(reflect4.selectByPrimaryKey(reflectvo4.getNo()));		
		
		//Date 未完成
		
		//test delete for Reflect  date format error
//		System.out.println("test delete() ==================================");
//		ReflectDAO reflect5 = new ReflectDAOHbm();
//		System.out.println("delete is " + reflect5.delete(100015));
		
		//test repeat for Reflect  date format error
//		System.out.println("test repeat() ==================================");		
//		ReflectDAO reflect = new ReflectDAOHbm();
//		ReflectVO reflectvo = new ReflectVO();
//		reflectvo.setReflectedNo(1000002);
//		reflectvo.setAuthorNo(1000001);
//		reflectvo.setReflectedDate((java.util.Date) sFormat.parse("2015-08-06"));
//		System.out.println(reflect.repeatReflect(reflectvo));
		
		
//		HealthDiaryDAO xxx = new HealthDiaryDaoHbm();
//		ReflectVO xxxvo = new ReflectVO();
//		xxxvo.setReflectedNo(1000002);
//		xxxvo.setAuthorNo(1000001);
//		xxxvo.setReflectedDate((java.util.Date) sFormat.parse("2015-08-04"));
//		System.out.println(xxx.repeatDiary(xxxvo.getReflectedNo(), xxxvo.getReflectedDate()));
		
		
	}
}
