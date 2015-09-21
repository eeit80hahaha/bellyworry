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
 * Servlet implementation class ForgetpwsServlet
 */
@WebServlet("/ForgetpwsServlet.controller")
public class ForgetpwsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
	@Override
	public void init() throws ServletException {
		service = new MemberService();
	}
    
    public ForgetpwsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("forgetaccount");		
		String mail = request.getParameter("forgetmail");
		
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		
		if(account==null || account.length()==0) {
			errors.put("uc", "請輸入帳號");			
		}		
		if(mail==null || mail.length()==0) {
			errors.put("em", "請輸入e-mail");			
		}		
		if(errors!=null && !errors.isEmpty()) {
			errors.put("open","$(\"#dialog0\").dialog(\"open\");");
			errors.put("in", "欄位請勿空白，請重新輸入");
			request.getRequestDispatcher(
					"/login.jsp").forward(request, response);
			return;
		}
		
//呼叫model
		
		boolean bean = service.mailcheck(account.trim(), mail.trim());
		System.out.println(bean);
//根據model執行結果，導向view
		if(bean!=true) {
			System.out.println(1);
			errors.put("open","$(\"#dialog0\").dialog(\"open\");");
			errors.put("mailer", "無此帳號或E-mail錯誤，請重新輸入");			
			request.getRequestDispatcher(
					"/login.jsp").forward(request, response);
		} else {
			System.out.println(account);
			service.sendmail(service.selectbyId(account).getId(), mail);
			
			errors.put("open","$(\"#dialog0\").dialog(\"open\");");
			errors.put("success2", "寄信完成，請至您的E-mail信箱確認新密碼!");
			request.getRequestDispatcher(
					"index.jsp").forward(request, response);
//			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
