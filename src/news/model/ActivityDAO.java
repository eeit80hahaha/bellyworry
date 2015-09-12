package news.model;

import java.io.InputStream;
import java.util.List;

public interface ActivityDAO {
	public abstract ActivityVO selectByPrimaryKey(int no);

	public abstract List<ActivityVO> getAll();

	public abstract int insert(ActivityVO vo);

	public abstract int update(ActivityVO vo);

	public abstract boolean delete(int no);
}
