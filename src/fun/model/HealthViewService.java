package fun.model;

import java.util.List;

import fun.model.dao.ViewClassDAOHbm;

public class HealthViewService {
	private ViewClassDAO viewClassDAO = new ViewClassDAOHbm();
	
	public ViewClassVO getViewClass(int viewClassNo){
		return viewClassDAO.selectByPrimaryKey(viewClassNo);
	}
	public List<ViewClassVO> getAll(){
		return viewClassDAO.getAll();
	}
	public int insert(ViewClassVO vo){
		return viewClassDAO.insert(vo);
	}
	public int update(ViewClassVO vo){
		return viewClassDAO.update(vo);
	}
	public boolean delete(int viewClassNo){
		return viewClassDAO.delete(viewClassNo);
	}
	
	public static void main(String[] args) {
		HealthViewService Service = new HealthViewService();
		System.out.println(Service.getAll());
		ViewClassVO vo = new ViewClassVO();
		vo.setName("健身123");
		System.out.println(Service.getViewClass(Service.insert(vo)));
		ViewClassVO vo2 = new ViewClassVO();
		vo2.setViewClassNo(vo.getViewClassNo());
		vo2.setName("健身好棒");
		System.out.println(Service.update(vo2));
		System.out.println(Service.delete(vo2.getViewClassNo()));
	}
}
