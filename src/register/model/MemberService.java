package register.model;

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

import calories.model.FoodCalVO;
import register.model.dao.MemberDAOHbm;

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
				this.sendmail(vo.getLastName(),vo.getEmail());
			}
		}
		return result;
	}
	
	public void sendmail(String name,String mail){
		String host = "smtp.gmail.com";
		  int port = 587;
		  final String username = "c02360236@gmail.com";
		  final String password = "f711111f";//your password

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
		   message.setSubject("密碼確認信");
		   message.setText("Dear "+name+" 您好, \n\n 您新密碼為"+sb+"請登入後立即更新您的密碼 !");

		   Transport transport = session.getTransport("smtp");
		   transport.connect(host, port, username, password);

		   Transport.send(message);

		   System.out.println("寄送email結束.");

		  } catch (MessagingException e) {
		   throw new RuntimeException(e);
		  }
	}
	
	
}
