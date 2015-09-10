package school.model.dao;

import java.util.List;

import school.model.ExamDAO;
import school.model.ExamVO;

public class Test {
	//test MS SQL for Exam to Hibernate
	public static void main(String[] args) {
		
		//test selectByPrimaryKey for Exam ok
//		System.out.println("test selectByPrimaryKey(int) ==========================");
//		ExamDAO exam1 = new ExamDAOHbm();
//		ExamVO examvo1 = exam1.selectByPrimaryKey(100007);
//		System.out.println(examvo1);

		//test getAll for Exam ok
		System.out.println("test getAll() =============================");
		ExamDAO exam2 = new ExamDAOHbm();
		List<ExamVO> list1 = exam2.getAll();

		for(ExamVO examvo2:list1){
			System.out.println(examvo2);
		}
		
		//test insert for Exam ok
//		System.out.println("test insert() ==================================");
//		ExamDAO exam3 = new ExamDAOHbm();
//		ExamVO examvo3 = new ExamVO();
//		examvo3.setContent("測試題目3");
//		examvo3.setCorrect("測試正解3");
//		examvo3.setOptA("A");
//		examvo3.setOptB("B");
//		examvo3.setOptC("C");
//		System.out.println(exam3.insert(examvo3).toString());
	
		//test update for Exam ok
//		System.out.println("test update() ==================================");
//		ExamDAO exam4 = new ExamDAOHbm();
//		ExamVO examvo4 = new ExamVO();
//		examvo4.setNo(100008);
//		examvo4.setContent("測試題目1a");
//		examvo4.setCorrect("測試正解1a");
//		examvo4.setOptA("Aa");
//		examvo4.setOptB("Ba");
//		examvo4.setOptC("Ca");
//		System.out.println(exam4.update(examvo4).toString());
		
		//test delete for Exam delete is null error
//		System.out.println("test delete() ==================================");
//		ExamDAO exam5 = new ExamDAOHbm();
//		System.out.println("delete is " + exam5.delete(100012));
	
		
	}
}
