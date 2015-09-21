package ranking.model;

import health.model.EatRecordDAO;
import health.model.ExerciseRecordDAO;
import health.model.HealthDiaryVO;
import health.model.HeroHealthDiaryVO;
import health.model.dao.EatRecordDAOHbm;
import health.model.dao.ExerciseRecordDAOHbm;
import health.model.dao.HealthDiaryDaoHbm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ranking.model.dao.HeroDAOHbm;
import register.model.MemberDAO;
import register.model.dao.MemberDAOHbm;

public class HeroService {

	private HeroDAO heroDao = new HeroDAOHbm();
	private MemberDAO memberDao = new MemberDAOHbm();
	private HealthDiaryDaoHbm healthdiarydao = new HealthDiaryDaoHbm();
	private EatRecordDAO eatDao = new EatRecordDAOHbm();
	private ExerciseRecordDAO exerDao = new ExerciseRecordDAOHbm();
	SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public List<HeroVO> select(HeroVO vo) {
		List<HeroVO> result = null;
		if(vo!=null && vo.getMemberNo() !=0) {
			HeroVO votmp = heroDao.selectByPrimaryKey(vo.getMemberNo());
			if(votmp!=null) {
				votmp.setMembervo(memberDao.selectByPrimaryKey(votmp.getMemberNo()));
				result = new ArrayList<HeroVO>();
				result.add(votmp);
			}
		} else {
			result = heroDao.getAll(); 
			for(HeroVO votmp:result){
				votmp.setMembervo(memberDao.selectByPrimaryKey(votmp.getMemberNo()));
			}
		}
		return result;
	}
	
	public HeroHealthDiaryVO getDatePage(int pageNo, int pageSize, int memberNo, int year, int month){
		List<HealthDiaryVO> list = healthdiarydao.getDatePage(pageNo, pageSize, memberNo, year, month);
		
		for (HealthDiaryVO healthdiaryvo : list) {
		
			int eatsum = -1000;
			try {
				eatsum = eatDao.eatcal(healthdiaryvo.getMemberNo(), 
						sFormat.parse(healthdiaryvo.getDate().toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(eatsum != -1000){
				healthdiaryvo.setEatcalcount(eatsum);
			}
		
			int exersum = -1000;
			try {
				exersum = exerDao.exercal(healthdiaryvo.getMemberNo(), 
						sFormat.parse(healthdiaryvo.getDate().toString()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(exersum != -1000){
				healthdiaryvo.setExercalcount(exersum);
			}
		
		}
		
		int rowCount = healthdiarydao.getDateTotalCount(memberNo, year, month);
		
		HeroHealthDiaryVO result = new HeroHealthDiaryVO(pageNo, pageSize, rowCount, list);
		
		return result;
	}
		
	public List<HealthDiaryVO> getHealtDiaryBydata(int memberNo, java.util.Date date){
		List<HealthDiaryVO> result;
		result = healthdiarydao.dateSelect(memberNo, date);
		
		return result;
	}
	
	public List<HealthDiaryVO> Selectday(int memberNo, java.util.Date date) {
		List<HealthDiaryVO> result = null;

		result = healthdiarydao.dateSelect(memberNo, date);
		
		for (HealthDiaryVO healthdiaryvo : result) {
			
			healthdiaryvo.setEatVo(eatDao.eatday(memberNo, date));
			healthdiaryvo.setExerVo(exerDao.exerday(memberNo, date));

		}
		
		return result;
	}
	
}
