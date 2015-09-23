package register.model;

import init.GlobalService;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import register.model.dao.MemberDAOHbm;
import sun.print.resources.serviceui;

public class MemberService {
	private MemberDAO memberDAO=new MemberDAOHbm();
	
	public MemberVO selectbyId(String vo) {
		MemberVO result = null;
		if(vo!=null) {
			result = memberDAO.selectById(vo);
		}
		return result;
	}
	
	public int insert(MemberVO vo) {
		int result = 0;
		if(vo!=null) {
			result = memberDAO.insert(vo);
		}
		return result;
	}
	
	public boolean mailcheck(String acc ,String mail) {
		boolean result=false;
		MemberVO vo=memberDAO.selectById(acc);
		if (vo!=null){
			System.out.println(vo.getId()+":"+vo.getEmail());
			if(vo.getEmail().trim().equals(mail.trim())){
				result=true;
				
			}
		}
		return result;
	}
	
	public void sendmail(String name,String mail){
		String host = "smtp.gmail.com";
		  int port = 587;
		  final String username = "c02360236@gmail.com";
		  final String password = "f720221f";//your password

		  Properties props = new Properties();
		  props.put("mail.smtp.host", host);
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.port", port);
		  Session session = Session.getInstance(props, new Authenticator() {
		   
		  protected PasswordAuthentication getPasswordAuthentication() {
		    return new PasswordAuthentication(username, password);
		   }
		  });

		  try {

		   Message message = new MimeMessage(session);
		   message.setFrom(new InternetAddress("c02360236@gmail.com"));
		   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
		   //==========================================
		   StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyz");   
	        StringBuffer sb = new StringBuffer();   
	        Random r = new Random();   
	        int range = buffer.length();   
	        for (int i = 0; i < 6; i ++) {   
	            sb.append(buffer.charAt(r.nextInt(range)));	            
	        }   
		   //==========================================
	           MemberVO vo =memberDAO.selectById(name);		  
		       MemberVO vo1=new MemberVO();
		       vo1.setBirthday(vo.getBirthday());
		       vo1.setEmail(vo.getEmail());
		       vo1.setFirstName(vo.getFirstName());
		       vo1.setGender(vo.getGender());
		       vo1.setId(vo.getId());
		       vo1.setLastName(vo.getLastName());
		       vo1.setMemberNo(vo.getMemberNo());
		       vo1.setNickname(vo.getNickname());
		       System.out.println(1);
		       vo1.setPassword(sb.toString());
		       System.out.println(2);
		       vo1.setPurview(vo.getPurview());
		       System.out.println(vo1);
		       memberDAO.update(vo1);
		       
	       message.setSubject("密碼確認信");
		   message.setText("Dear "+vo.getId()+" 您好, \n\n 您新密碼為"+sb+"請登入後立即更新您的密碼 !");
		   Transport transport = session.getTransport("smtp");
		   transport.connect(host, port, username, password);

		   Transport.send(message);
		   System.out.println("寄送email結束.");

		  } catch (MessagingException e) {
			  System.out.println("Exception====================");
		   throw new RuntimeException(e);
		  }
	}
		
	public int changePassword(String username, String oldPassword, String newPassword) {
		int result=0;
		MemberVO bean = this.selectbyId(username);
		if(bean!=null) {
//			byte[] temp = newPassword.getBytes();		//使用者輸入：明碼
//			temp = mDigest.digest(temp);				//使用者輸入：one-way hash
			MemberVO vo=new MemberVO();
			vo.setBirthday(bean.getBirthday());
			vo.setEmail(bean.getEmail());
			vo.setFirstName(bean.getFirstName());
			vo.setGender(bean.getGender());
			vo.setId(bean.getId());
			vo.setLastName(bean.getLastName());
			vo.setMemberNo(bean.getMemberNo());
			vo.setNickname(bean.getNickname());
			vo.setPassword(newPassword);
			vo.setPurview(bean.getPurview());
			return memberDAO.update(vo);
		}
		return result;
	}
	
	public int update(MemberVO vo){
		int result=0;
		if(vo!=null) {
			result = memberDAO.update(vo);
		}
		return result;
	}
}
