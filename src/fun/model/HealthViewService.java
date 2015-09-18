package fun.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fun.model.dao.HealthViewDAOHbm;
import fun.model.dao.ViewClassDAOHbm;

@Path("/healthview")
public class HealthViewService {
	private HealthViewDAO healthViewDAO = new HealthViewDAOHbm();
	private ViewClassDAO viewClassDAO = new ViewClassDAOHbm();
	
	public HealthViewVO selectByPrimaryKey(int no){
		return healthViewDAO.selectByPrimaryKey(no);
	}
	
	@GET
	@Path("/{no}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HealthViewVO> selectByViewClassNo(@PathParam("no") int viewClassNo){
		ViewClassVO temp = viewClassDAO.selectByPrimaryKey(viewClassNo);
		return healthViewDAO.selectByViewClassVO(temp);
	}
	
	public List<HealthViewVO> select(HealthViewVO vo) {
		List<HealthViewVO> result = null;
		if(vo!=null && vo.getNo()!=0) {
			HealthViewVO temp = healthViewDAO.selectByPrimaryKey(vo.getNo());
			if(temp!=null) {
				result = new ArrayList<HealthViewVO>();
				result.add(temp);
			}
		} else if(vo!=null && vo.getViewClassVO()!=null) {
			result = healthViewDAO.selectByViewClassVO(vo.getViewClassVO());
		} else {
			result = healthViewDAO.getAll(); 
		}
		return result;
	}
	public int insert(HealthViewVO vo){
		return healthViewDAO.insert(vo);
	}
	public int update(HealthViewVO vo){
		return healthViewDAO.update(vo);
	}
	public boolean delete(int no){
		return healthViewDAO.delete(no);
	}
	public static void main(String[] args){
		HealthViewService service = new HealthViewService();
//		System.out.println(service.selectByPrimaryKey(100001));
		HealthViewVO vo = new HealthViewVO();
		vo.setNo(3);
		System.out.println(service.update(vo));
	}
}
