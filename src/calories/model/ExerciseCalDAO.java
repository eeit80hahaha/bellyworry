package calories.model;

import java.util.List;

public interface ExerciseCalDAO {
	public abstract ExerciseCalVO selectByPrimaryKey(int exerciseNo);

	public abstract List<ExerciseCalVO> getAll();

	public abstract int insert(ExerciseCalVO vo);

	public abstract int update(ExerciseCalVO vo);

	public abstract boolean delete(int exerciseNo);
}
