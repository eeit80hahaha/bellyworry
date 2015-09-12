package school.model;

import java.util.List;

public interface ExamDAO {
	public abstract ExamVO selectByPrimaryKey(int no);

	public abstract List<ExamVO> getAll();

	public abstract int insert(ExamVO vo);

	public abstract int update(ExamVO vo);

	public abstract boolean delete(int no);
}
