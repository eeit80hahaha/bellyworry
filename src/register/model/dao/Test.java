package register.model.dao;
import register.model.MemberDAO;
import register.model.MemberVO;

public class Test {

	public static void main(String[] args) {
		MemberDAO memDao = new MemberDAOHbm();
		MemberVO memVo = memDao.selectByPrimaryKey(1000006);
		System.out.println("PK(6): "+memVo);
		System.out.println("Id('saas'): "+memDao.selectById("saas"));
		System.out.println("Email('suuklook456123@google.com'): "+memDao.selectByEmail("suuklook456123@google.com"));
		System.out.println("Purview(901): "+memDao.selectByPurview(901));
		System.out.println("ALL: "+memDao.getAll());
		MemberVO memVo2 = new MemberVO();
		memVo2.setId("I_like_hahaha");
		memVo2.setPassword("132");
		memVo2.setFirstName("興糧");
		memVo2.setLastName("林");
		memVo2.setNickname("樑格格");
		memVo2.setEmail("132@13.co.tw");
		memVo2.setBirthday(new java.util.Date(System.currentTimeMillis()));
		memVo2.setGender("男");
		memVo2.setPurview(101);

		System.out.println("insert: "+memDao.selectByPrimaryKey(memDao.insert(memVo2)));
		
		memVo2.setEmail("mei1978@hotmail.tw");
		memVo2.setId("1978mei");
		System.out.println("update: "+memDao.update(memVo2));
		System.out.println("delete: "+memDao.delete(memVo2.getMemberNo()));
	}
}
