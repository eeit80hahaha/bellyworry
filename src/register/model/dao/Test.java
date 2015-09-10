package register.model.dao;
import register.model.MemberDAO;
import register.model.MemberVO;

public class Test {

	public static void main(String[] args) {
		MemberDAO memDao = new MemberDAOHbm();
		//selectByPrimaryKey
		MemberVO memVo = memDao.selectByPrimaryKey(1000006);
		System.out.println("PK(6): "+memVo);
		//selectById
		System.out.println("Id('saas'): "+memDao.selectById("saas"));
		//selectByEmail
		System.out.println("Email('suuklook456123@google.com'): "+memDao.selectByEmail("suuklook456123@google.com"));
		//selectByPurview
		System.out.println("Purview(901): "+memDao.selectByPurview(901));
		//getAll
		System.out.println("ALL: "+memDao.getAll());
		//insert
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
		int temp1 = memDao.insert(memVo2);
		if(temp1>0){
			System.out.println("insert: "+memDao.selectByPrimaryKey(temp1));
		}else{
			System.out.println("insert error: "+temp1);
		}
		//update
		MemberVO memVo3 = new MemberVO();
		memVo3.setMemberNo(memVo2.getMemberNo());
		memVo3.setId("dididi");
		memVo3.setPassword("168168");
		memVo3.setFirstName("皓皓");
		memVo3.setLastName("方");
		memVo3.setNickname("白白");
		memVo3.setEmail("mei1978@hotmail.tw");
		memVo3.setBirthday(new java.util.Date(System.currentTimeMillis()));
		memVo3.setGender("男");
		memVo3.setPurview(101);
		int temp2 = memDao.update(memVo3);
		if(temp2>0){
			System.out.println("update: "+memDao.selectByPrimaryKey(temp2));
		}else{
			System.out.println("update error: "+temp2);
		}
		//delete
		if(memDao.delete(memVo3.getMemberNo())){
			System.out.println("delete: OK!!");
		}else{
			System.out.println("delete: error!!");
		}
	}
}
