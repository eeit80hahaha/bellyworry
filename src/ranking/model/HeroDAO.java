package ranking.model;

import java.util.List;

public interface HeroDAO {
	public abstract HeroVO selectByPrimaryKey(int memberNo);

	public abstract List<HeroVO> getAll();

	public abstract int insert(HeroVO vo);

	public abstract int update(HeroVO vo);

	public abstract boolean delete(int memberNo);
}
