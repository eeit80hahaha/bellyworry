package fun.model;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fun.model.dao.HealthViewDAOHbm;

@Path("/healthview")
public class HealthViewService {
	private HealthViewDAO healthViewDAO = new HealthViewDAOHbm();
	
//	@GET
//	@Path("/{no}")
//	@Produces(MediaType.APPLICATION_ATOM_XML)
//	public HealthViewVO getHealthView(@PathParam("no") int no){
//		return healthViewDAO.selectByPrimaryKey(no);
//	}
	
	@GET
	@Path("/{no}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HealthViewVO> getHealthViews(@PathParam("no") int viewClassNo){
		return healthViewDAO.selectByViewClassNo(viewClassNo);
	}
	
	public List<HealthViewVO> getAll(){
		return healthViewDAO.getAll();
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
		System.out.println(service.getHealthViews(100001));
	}
}
