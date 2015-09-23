package school.model;

import java.util.List;

public interface ExamDAO {
	public abstract ExamVO selectByPrimaryKey(int no);

	public abstract List<ExamVO> getAll();

	public abstract int insert(ExamVO vo);

	public abstract int update(ExamVO vo);

	public abstract boolean delete(int no);
	
	//換頁所需要的getDatePage
	public abstract List<ExamVO> getDatePage(int pageNo, int pageSize);
	
	public abstract int getDateTotalCount();
	
}
