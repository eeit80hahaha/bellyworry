package health.model;

import init.GlobalService;

import java.util.ArrayList;
import java.util.List;

import health.model.dao.EatRecordDAOHbm;
import health.model.dao.ExerciseRecordDAOHbm;
import health.model.dao.HealthDiaryDaoHbm;

public class DiaryIndexService {
	private HealthDiaryVO diaryVO = null;
	private HealthDiaryDAO dao = null;
	private ExerciseRecordVO eRecordVO = null;
	private ExerciseRecordDAO exerDao = null;
	private EatRecordVO eatRecordVO = null;
	private EatRecordDAO eatDao = null;

	public DiaryIndexService() {
		dao = new HealthDiaryDaoHbm();
		exerDao = new ExerciseRecordDAOHbm();
		eatDao = new EatRecordDAOHbm();
	}

	public HealthDiaryVO selectByPrimaryKey(HealthDiaryVO vo) {
		List<EatRecordVO> resultEat = new ArrayList<EatRecordVO>();
		List<ExerciseRecordVO> resultExer = new ArrayList<ExerciseRecordVO>();
		HealthDiaryVO result = null;
		List<ExerciseRecordVO> listexer = null;
		List<EatRecordVO> listeat = null;
		
		listexer = exerDao.selectByMemberNo(vo.getMemberNo());
		listeat = eatDao.selectByMemberNo(vo.getMemberNo());		
		result = dao.selectByPrimaryKey(vo.getNo());
		
		for (ExerciseRecordVO exerVo : listexer) {
			if (result.getMemberNo() == exerVo.getMemberNo() && result.getDate().equals(exerVo.getDate())) {
				System.out.println(exerVo);
				resultExer.add(exerVo);
				result.setExerVo(resultExer);
			}
		}
		for (EatRecordVO eatVo : listeat) {
			if (result.getMemberNo() == eatVo.getMemberNo() && result.getDate().equals(eatVo.getDate())) {
				resultEat.add(eatVo);
				result.setEatVo(resultEat);
			}
		}

		return result;
	}

	public List<HealthDiaryVO> selecthealth(int memberNo) {
		List<EatRecordVO> resultEat = new ArrayList<EatRecordVO>();
		List<ExerciseRecordVO> resultExer = new ArrayList<ExerciseRecordVO>();
		List<HealthDiaryVO> list = null;
		List<ExerciseRecordVO> listexer = null;
		List<EatRecordVO> listeat = null;

		list = dao.selectByMemberNo(memberNo);
		listexer = exerDao.selectByMemberNo(memberNo);
		listeat = eatDao.selectByMemberNo(memberNo);
		
//		list = dao.dateSelect(memberNo, GlobalService.convertDate("2015-09-20"));
		
//		for (HealthDiaryVO healthdiaryvo : list) {
//			
//			healthdiaryvo.setEatVo(eatDao.eatday(memberNo, GlobalService.convertDate("2015-09-20")));
//			healthdiaryvo.setExerVo(exerDao.exerday(memberNo, GlobalService.convertDate("2015-09-20")));
//
//		}
		
		
		
		for (HealthDiaryVO vo : list) {
			for (ExerciseRecordVO exerVo : listexer) {
				if (vo.getMemberNo() == exerVo.getMemberNo() && vo.getDate().equals(exerVo.getDate())) {
					resultExer.add(exerVo);
				}
			}
			vo.setExerVo(resultExer);
			resultExer.clear();
//			for (EatRecordVO eatVo : listeat) {
//				if (vo.getMemberNo() == eatVo.getMemberNo()&& vo.getDate().equals(eatVo.getDate())) {
//					
//					vo.setEatVo(resultEat);
//				}
//			}	
		}
//		System.out.println(resultExer);
//		System.out.println(resultEat);
//		listeat.clear();
//		listexer.clear();
		System.out.println(list);
		return list;
	}
	

	
};
