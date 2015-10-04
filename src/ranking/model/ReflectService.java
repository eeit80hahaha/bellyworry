package ranking.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import health.model.HealthDiaryDAO;
import health.model.HealthDiaryVO;
import health.model.HeroHealthDiaryVO;
import health.model.dao.HealthDiaryDaoHbm;
import ranking.model.dao.ReflectDAOHbm;
import register.model.MemberDAO;
import register.model.MemberVO;
import register.model.dao.MemberDAOHbm;

public class ReflectService {
	
	private ReflectDAO reflectdao = new ReflectDAOHbm();
	private HealthDiaryDAO healthdiarydao = new HealthDiaryDaoHbm();
	private MemberDAO memberdao = new MemberDAOHbm();
	
	public int insert(ReflectVO vo){
		
		int repeatD = healthdiarydao.repeatDiary(vo.getReflectedNo(),
				vo.getReflectedDate());
		if(repeatD==1000){
			int repeatR = reflectdao.repeatReflect(vo);
			if(repeatR == 1000){
				int ins = reflectdao.insert(vo);
				if(ins == -300){
					//-300  SQL error
					return ins;
				}else{
					//insert success return ReflectVO.getNo()
					return ins;
				}
				
			}else if(repeatR == -100){
				//-100  unique
				return repeatR;
			}else {
				//-300  SQL error
				return repeatR;
			}
		}else if(repeatD == -400){
			//-400  Not available
			return repeatD;
		}else {
			//-300  SQL error
			return repeatD;
		}
	}
	
	public ReflectVO selectByPrimaryKey(int no){
		ReflectVO result = null;
		
		result = reflectdao.selectByPrimaryKey(no);
		
		return result;
	}
	
	public ReflectPageVO getPage(int pageNo, int pageSize, String reflectedid){
		List<ReflectVO> list = new ArrayList<ReflectVO>();
		int rowCount = 0;
		MemberVO vo = memberdao.selectById(reflectedid);
		if(vo==null){
			list = reflectdao.getPageNo(pageNo, pageSize);
			rowCount = reflectdao.getPageTotalCount();
		}else{
			list = reflectdao.getPageNoID(pageNo, pageSize, vo.getMemberNo());
			rowCount = reflectdao.getPageIDTotalCount(vo.getMemberNo());
		}
		
		for (ReflectVO reflectvo : list) {
			
			
			reflectvo.setReflectedId(
					memberdao.selectByPrimaryKey(reflectvo.getReflectedNo()).getId());
			
			reflectvo.setAuthorId(
					memberdao.selectByPrimaryKey(reflectvo.getAuthorNo()).getId());

		}
		
		ReflectPageVO result = new ReflectPageVO(pageNo, pageSize, rowCount, list);
		
		return result;
	}
	
	public int reflectday(int memberNo,java.util.Date date){
		int result = 0;
		List<HealthDiaryVO> list = healthdiarydao.dateSelect(memberNo, date);
		if(!list.isEmpty()){
			int reflectday = healthdiarydao.reflectday(list.get(0));
			if(reflectday >0){
				reflectdao.deleteByND(memberNo, date);
				return reflectday;
			}
		}
		return result;
	}
	
	
}
