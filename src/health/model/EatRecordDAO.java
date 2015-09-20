package health.model;

import java.util.List;

public interface EatRecordDAO {

	public abstract EatRecordVO selectByPrimaryKey(long no);

	public abstract List<EatRecordVO> selectByMemberNo(int memberNo);

	public abstract List<EatRecordVO> getAll();

	public abstract long insert(EatRecordVO vo);

	public abstract int update(EatRecordVO vo);

	public abstract boolean delete(long no);

	public abstract int eatcal(int memberNo, java.util.Date date);
	
	public abstract List<EatRecordVO> eatday(int memberNo, java.util.Date date);

}