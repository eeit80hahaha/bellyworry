package register.model;

import java.util.List;

public interface MemberDAO {

	public abstract MemberVO selectByPrimaryKey(int memberNo);

	public abstract MemberVO selectById(String id);

	public abstract MemberVO selectByEmail(String email);

	public abstract List<MemberVO> selectByPurview(int purview);

	public abstract List<MemberVO> getAll();

	public abstract int insert(MemberVO bean);

	public abstract int update(MemberVO bean);

	public abstract boolean delete(int memberNo);

}