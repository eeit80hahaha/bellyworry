package controller;

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
 * Servlet implementation class UpdatePwd
 */
@WebServlet("/UpdatePwd.controller")
public class UpdatePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
	
	public void init() throws ServletException {
		service = new MemberService();
	}
    public UpdatePwd() {
        super();
      }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//接收資料
				String account = request.getParameter("changeaccount");		
				String oldpwd = request.getParameter("oldpwd");
				String newpwd = request.getParameter("newpwd");		
				String checknewpwd = request.getParameter("checknewpwd");
		//驗證資料
				Map<String, String> errors = new HashMap<String, String>();
				request.setAttribute("change", errors);
				if(account==null || account.length()==0) {
					errors.put("open","$(\"#dialog\").dialog(\"open\");");
					errors.put("elaccount", "請輸入帳號");			
				}
				if(oldpwd==null || oldpwd.length()==0) {
					errors.put("open","$(\"#dialog\").dialog(\"open\");");
					errors.put("eloldpwd", "請輸入密碼");			
				}
				if(newpwd==null || newpwd.length()==0) {
					errors.put("open","$(\"#dialog\").dialog(\"open\");");
					errors.put("elnewpwd", "請輸入帳號");			
				}
				if(checknewpwd==null || checknewpwd.length()==0) {
					errors.put("open","$(\"#dialog\").dialog(\"open\");");
					errors.put("elchecknewpwd", "請輸入密碼");			
				}
				if(newpwd.equals(checknewpwd) != true) {
					errors.put("open","$(\"#dialog\").dialog(\"open\");");
					errors.put("erchecknewpwd", "新密碼與確認新密碼欄位不相同");			
				}
				if(errors!=null && !errors.isEmpty()) {
					errors.put("open","$(\"#dialog\").dialog(\"open\");");
					errors.put("error", "修改失敗，請重新修改");
					request.getRequestDispatcher(
							"updatemember.jsp").forward(request, response);
					return;
				}
				
		//呼叫model
				MemberVO bean = service.selectbyId(account);
				System.out.println(bean);
		//根據model執行結果，導向view
				if(bean==null) {
					errors.put("open","$(\"#dialog1\").dialog(\"open\");");
					errors.put("error1", "無此帳號密碼，請重新輸入");			
					request.getRequestDispatcher(
							"/updatemember.jsp").forward(request, response);
				} else {
					service.changePassword(account, oldpwd, newpwd);
					errors.put("openpwd","$(\"#dialog0\").dialog(\"open\");");
					errors.put("success1", "修改成功");
					
					request.getRequestDispatcher(
							"/index.jsp").forward(request, response);
//					String path = request.getContextPath();
//					response.sendRedirect(path+"/index.jsp");
					
				}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
