package fun.model;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fun.model.dao.ViewClassDAOHbm;

@Path("/viewclass")
public class ViewClassService {
	private ViewClassDAO viewClassDAO = new ViewClassDAOHbm();
	
	public ViewClassVO getViewClass(int viewClassNo){
		return viewClassDAO.selectByPrimaryKey(viewClassNo);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
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
		ViewClassService Service = new ViewClassService();
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
