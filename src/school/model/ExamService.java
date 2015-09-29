package school.model;

import java.util.ArrayList;
import java.util.List;

import school.model.dao.ExamDAOHbm;



public class ExamService {
	private ExamDAO examDao = new ExamDAOHbm();
	
//	public List<ExamVO> base (List<ExamVO> vo){
//		List<ExamVO> bean = new ArrayList<ExamVO>();		
//		 for(ExamVO element : vo) {
//			 ExamVO element1=new ExamVO();
//			 element1.setNo(element.getNo());
//			 element1.setContent(element.getContent());
//			 element1.setCorrect(element.getCorrect());
//			 element1.setOptA(element.getOptA());
//			 element1.setOptB(element.getOptB());
//			 element1.setOptC(element.getOptC());
//		     bean.add(element1);
//		 }
//		return bean;
//	}
	
	public List<ExamVO> selcetall() {
		List<ExamVO> result = null;	
			List<ExamVO> vo = examDao.getAll();
			if(vo!=null) {
				result = new ArrayList<ExamVO>();
				result.addAll(vo);
			}
			return result;
	}
	
	public List<ExamVO> select(ExamVO vo) {
		List<ExamVO> result = null;
		if(vo!=null && vo.getNo() !=0) {
			ExamVO temp = examDao.selectByPrimaryKey(vo.getNo());
			if(temp!=null) {
				result = new ArrayList<ExamVO>();
				result.add(temp);
			}
		} else {
			result = examDao.getAll(); 
		}
		return result;
	}
	
	public ExamVO selectByPrimaryKey(int no){
		ExamVO temp = examDao.selectByPrimaryKey(no);

		return temp;
	}
	
	public int insert(ExamVO vo) {
		int result = 0;
		if(vo!=null) {
			result = examDao.insert(vo);
		}
		return result;
	}
	
	public int update(ExamVO vo) {
		int result = 0;
		if(vo!=null) {
			result = examDao.update(vo);
		}
		return result;
	}
	
	public boolean delete(ExamVO vo) {
		boolean result = false;
		if(vo!=null) {
			result = examDao.delete(vo.getNo());
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		ExamService service = new ExamService();
		List<ExamVO> list = service.select(null);
		System.out.println("beans="+list);
	}
	
	//換頁所使用的
	public PageExamVO getDatePage(int pageNo, int pageSize){
		List<ExamVO> list = examDao.getDatePage(pageNo, pageSize);
					
		int rowCount = examDao.getDateTotalCount();
		
		PageExamVO result = new PageExamVO(pageNo, pageSize, rowCount, list);
		System.out.println(result);
		
		return result;
	}
}
