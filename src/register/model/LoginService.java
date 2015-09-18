package register.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import register.model.dao.MemberDAOHbm;



public class LoginService {
	private MemberDAO memberDao = new MemberDAOHbm();
	private MessageDigest mDigest;
	private boolean dd;
	public LoginService() {
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO login(String username, String password) {
		
		MemberVO bean = memberDao.selectById(username); 
		
		if(bean!=null) {
			if(password!=null && password.length()!=0) {
				
				String pass = bean.getPassword().trim();
//				byte[] pass = bean.getPassword().getBytes();		//資料庫抓出：one-way hash
//				byte[] temp = password.getBytes();		//使用者輸入：明碼
//				temp = mDigest.digest(temp);			//使用者輸入：one-way hash
//				if(Arrays.equals(pass, temp))
				if(pass.equals(password)){
					
					return bean;
					
				}
			}
		}
		return null;
	}
	public boolean changePassword(String username, String oldPassword, String newPassword) {
//		String regex = "^.*(?=.{6,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
//		if(!newPassword.matches(regex)) {
//			return false;
//		}
		 
//		MemberVO bean = this.login(username, oldPassword);
//		if(bean!=null) {
//			byte[] temp = newPassword.getBytes();		//使用者輸入：明碼
////			temp = mDigest.digest(temp);				//使用者輸入：one-way hash
//			return memberDao.update(bean.getId(),temp,bean.getFirstName(),bean.getLastName(),bean.getNickname(),
//					bean.getEmail(), bean.getBirthday(),bean.getGender(),bean.getPurview(),bean.getMemberNo());
//		}
		return false;
	}
}
