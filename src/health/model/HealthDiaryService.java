package health.model;

import java.util.List;

import health.model.dao.HealthDiaryDaoHbm;

public class HealthDiaryService {
	HealthDiaryVO diaryVo = null;
	HealthDiaryDAO dao = null;
	
	public HealthDiaryVO selectByPrimaryKey(int no) {
		diaryVo = new HealthDiaryVO();
		dao = new HealthDiaryDaoHbm();
		diaryVo = dao.selectByPrimaryKey(no);

		if (diaryVo != null) {
			return diaryVo;
		}
		return null;
	}
	public long insert(HealthDiaryVO vo) {
		long no = 0;
		dao = new HealthDiaryDaoHbm();
		if (vo != null) {
			no = dao.insert(vo);
			System.out.println(no);
			return no;
		}
		return no;
	}

	
	public int update(HealthDiaryVO vo){
		int result = 0;
		dao = new HealthDiaryDaoHbm();
		if(vo!=null){
			result = dao.update(vo);
			System.out.println(result);
			return result;
		}
		return 0;
		
	}
	public List<HealthDiaryVO> dateSelect(int memberNo, java.util.Date date) {
		List<HealthDiaryVO> list = null;
		dao = new HealthDiaryDaoHbm();
		diaryVo = new HealthDiaryVO();
		if (memberNo != 0 && date != null) {
			list = dao.dateSelect(memberNo, date);
		}
		return list;
	}
	public List<HealthDiaryVO> gethighChart(int memberNo ,int year ,int month) {
		List<HealthDiaryVO> list = null;
		dao = new HealthDiaryDaoHbm();
		diaryVo = new HealthDiaryVO();
		if(memberNo!=0 && year!=0 && month!=0){
			list = dao.gethighChart(memberNo, year, month);
		}
		return list;
	}
};
