package controller;

import init.GlobalService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import register.model.LoginService;
import register.model.MemberService;
import register.model.MemberVO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet.controller")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
	
	@Override
	public void init() throws ServletException {
		service = new MemberService();
	}
    
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("account");			
		String firstName = request.getParameter("firstname");		
		String lastName = request.getParameter("lastname");
		String nickname = request.getParameter("nickname");		
		String email = request.getParameter("mail");
		String birthday = request.getParameter("date");		
		String gender = request.getParameter("gender");
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("up", errors);
		
		if(id==null || id.length()==0) {			
			errors.put("username", "請輸入帳號");			
		}		
		if(firstName==null || id.length()==0) {			
			errors.put("firstName", "請輸入姓氏");			
		}
		if(lastName==null || lastName.length()==0) {
			errors.put("lastName", "請輸入名字");			
		}
		if(email==null || email.length()==0) {			
			errors.put("email", "請輸入e-mail");			
		}
		if(birthday==null || birthday.length()==0) {			
			errors.put("birth", "請選擇生日");			
		}
		if(gender==null || gender.length()==0) {
			errors.put("gender", "請選擇性別");			
		}
		if(errors!=null && !errors.isEmpty()) {
			errors.put("open1","$(\"#dialog1\").dialog(\"open\");");			
			errors.put("add", "修改失敗，請重新輸入");
			request.getRequestDispatcher(
					"updatemember.jsp").forward(request, response);
			return;
		}
		
//呼叫model
		HttpSession session = request.getSession();
		MemberVO vo=(MemberVO) session.getAttribute("user");
		MemberVO bean = new MemberVO();
		bean.setBirthday(GlobalService.convertDate(birthday));
		bean.setEmail(email);
		bean.setFirstName(firstName);
		if(gender.equals("female")){
			bean.setGender("女");
		}else{
			bean.setGender("男");
		}
		bean.setId(id);
		bean.setLastName(lastName);
		bean.setMemberNo(vo.getMemberNo());
		if(nickname!=null){
			bean.setNickname(nickname);
		}else{
			bean.setNickname(vo.getNickname());
		}		
		bean.setPassword(vo.getPassword());
		bean.setPurview(vo.getPurview());		
	
//根據model執行結果，導向view
		
		if(service.update(bean)==1){
			session.setAttribute("user", bean);
			errors.put("suc","$(\"#dialog0\").dialog(\"open\");");
			errors.put("update", "修改成功");
			request.getRequestDispatcher(
					"index.jsp").forward(request, response);	
		}else{
			errors.put("open1","$(\"#dialog1\").dialog(\"open\");");
			errors.put("er", "帳號或E-mail重複，請重新修改");			
			request.getRequestDispatcher(
					"/updatemember.jsp").forward(request, response);		
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
