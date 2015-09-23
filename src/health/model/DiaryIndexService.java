package health.model;

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
		HealthDiaryVO result = null;
		List<ExerciseRecordVO> listexer = null;
		List<EatRecordVO> listeat = null;
		listexer = exerDao.selectByMemberNo(vo.getMemberNo());
		listeat = eatDao.selectByMemberNo(vo.getMemberNo());		
		result = dao.selectByPrimaryKey(vo.getNo());
		
		for (ExerciseRecordVO exerVo : listexer) {
			if (vo.getMemberNo() == exerVo.getMemberNo()&& vo.getDate().toString().equals(exerVo.getDate().toString())) {
				resultExer.add(exerVo);
				vo.setExerVo(resultExer);
			}
		}
		for (EatRecordVO eatVo : listeat) {
			if (vo.getMemberNo() == eatVo.getMemberNo()&& vo.getDate().toString().equals(eatVo.getDate().toString())) {
				resultEat.add(eatVo);
				vo.setEatVo(resultEat);
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
		
		for (HealthDiaryVO vo : list) {
			for (ExerciseRecordVO exerVo : listexer) {
				if (vo.getMemberNo() == exerVo.getMemberNo()&& vo.getDate().toString().equals(exerVo.getDate().toString())) {
					resultExer.add(exerVo);
					vo.setExerVo(resultExer);
				}
			}
			for (EatRecordVO eatVo : listeat) {
				if (vo.getMemberNo() == eatVo.getMemberNo()&& vo.getDate().toString().equals(eatVo.getDate().toString())) {
					resultEat.add(eatVo);
					vo.setEatVo(resultEat);
				}
			}
		}
		listeat.clear();
		listexer.clear();
		return list;
	}
	

	
};
