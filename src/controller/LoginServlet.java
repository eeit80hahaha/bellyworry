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
import register.model.MemberVO;

@WebServlet("/LoginServlet.controller")
public class LoginServlet extends HttpServlet {
	private LoginService service;

	@Override
	public void init() throws ServletException {
		service = new LoginService();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// 接收資料
		String username = request.getParameter("loginaccount");
		String password = request.getParameter("loginpwd");
		// 驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		if (username == null || username.length() == 0) {
			errors.put("username1", "請輸入帳號");
		}
		if (password == null || password.length() == 0) {
			errors.put("password1", "請輸入密碼");
		}
		if (errors != null && !errors.isEmpty()) {
			errors.put("open", "$(\"#dialog0\").dialog(\"open\");");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
			return;
		}

		// 呼叫model
		MemberVO bean = service.login(username, password);
		System.out.println(bean);
		// 根據model執行結果，導向view
		if (bean == null) {
			errors.put("open", "$(\"#dialog0\").dialog(\"open\");");
			errors.put("er1", "無此帳號密碼，請重新輸入");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		} else {
			if (bean.getPurview() == 800) {
				errors.put("open", "$(\"#dialog0\").dialog(\"open\");");
				errors.put("stop", "您已經被停權，請E-mail到本網站，我們將盡快您處理");
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			} else if (bean.getPurview() == 901) {
				HttpSession session = request.getSession();
				session.setAttribute("user", bean);
				Map<String, String> success = new HashMap<String, String>();
				session.setAttribute("suc", success);
				success.put("update", "<a href='" + request.getContextPath()
						+ "/updatemember.jsp'>修改管理者資料</a>");
				success.put("out", request.getContextPath()
						+ "/logout.controller");
				String path = request.getContextPath();
				response.sendRedirect(path+"/backend/index.jsp");//待改為URL============
			} else {
				errors.put("opensuccess", "$(\"#dialog0\").dialog(\"open\");");
				errors.put("success1", "登入成功");
				HttpSession session = request.getSession();
				session.setAttribute("user", bean);
				Map<String, String> success = new HashMap<String, String>();
				session.setAttribute("suc", success);

				success.put("update", "<a href='" + request.getContextPath()
						+ "/updatemember.jsp'>修改會員資料</a>");
				success.put("out", "'<a href='" + request.getContextPath()
						+ "/logout.controller'>登出</a>");
				String dest = (String) session.getAttribute("dest");
				
				request.getSession().removeAttribute("eatBreakfast");
				request.getSession().removeAttribute("eatLunch");
				request.getSession().removeAttribute("eatDinner");
				
				if (dest != null && dest.length() != 0) {
					session.removeAttribute("dest");
					response.sendRedirect(dest);
				} else {
					
					String path = request.getContextPath();
					response.sendRedirect(path + "/index.jsp");
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
