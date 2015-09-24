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

import register.model.MemberService;
import register.model.MemberVO;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet.controller")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
	@Override
	public void init() throws ServletException {
		service = new MemberService();
	}
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("account");		
		String password = request.getParameter("pwd");
		String password1 = request.getParameter("pwd1");
		String firstName = request.getParameter("firstname");		
		String lastName = request.getParameter("lastname");
		String nickname = request.getParameter("nickname");		
		String email = request.getParameter("mail");
		String birthday = request.getParameter("date");		
		String gender = request.getParameter("gender");
		
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		
		if(id==null || id.length()==0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("username", "請輸入帳號");			
		}
		if(password==null || password.length()==0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("password", "請輸入密碼");			
		}
		if(password1==null || password1.length()==0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("password1", "請輸入密碼確認");			
		}
		if(password.equals(password1)==false) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("password2", "請確認兩次密碼輸入是否相同");			
		}
		if(firstName==null || firstName.length()==0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("firstName", "請輸入姓氏");			
		}
		if(lastName==null || lastName.length()==0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("lastName", "請輸入名字");			
		}
		if(email==null || email.length()==0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("email", "請輸入e-mail");			
		}
		if(birthday==null || birthday.length()==0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("birth", "請選擇生日");			
		}
		if(gender==null || gender.length()==0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("gender", "請選擇性別");			
		}
		if(errors!=null && !errors.isEmpty()) {
			errors.put("open1","$(\"#dialog0\").dialog(\"open\");");
			errors.put("add", "註冊失敗，請重新輸入");
			request.getRequestDispatcher(
					"/index.jsp").forward(request, response);
			return;
		}
		
//呼叫model
		
		MemberVO bean = service.selectbyId(id);
	System.out.println(bean);
//根據model執行結果，導向view
		if(bean!=null) {
			System.out.println(1);
			errors.put("open1","$(\"#dialog0\").dialog(\"open\");");
			errors.put("er", "帳號重複，請重新輸入");			
			request.getRequestDispatcher(
					"/index.jsp").forward(request, response);
		} else {
			bean =new MemberVO();
			bean.setEmail(email);
			bean.setFirstName(firstName);
			if(gender.equals("female")){
				bean.setGender("女");
			}else{
				bean.setGender("男");
			}	
			bean.setId(id);
			bean.setLastName(lastName);
			bean.setNickname(nickname);
			bean.setPassword(password);
			bean.setPurview(101);
			String[] ss=birthday.split("/");
			String ss1=ss[2]+"-"+ss[0]+"-"+ss[1];			
			bean.setBirthday(GlobalService.convertDate(ss1));
			service.insert(bean);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", bean);
			Map<String, String> success = new HashMap<String, String>();
			session.setAttribute("suc", success);

			success.put("update", "<a href='" + request.getContextPath()+"/updatemember.jsp'>修改會員資料</a>");
			success.put("out", "'<a href='"+request.getContextPath()+"/logout.controller'>登出</a>");
			errors.put("open1","$(\"#dialog0\").dialog(\"open\");");
			errors.put("success", "新增會員成功");
			request.getRequestDispatcher(
					"index.jsp").forward(request, response);			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
