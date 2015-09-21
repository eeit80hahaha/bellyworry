//package controller;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import fun.model.HealthViewService;
//import fun.model.ViewClassService;
//import fun.model.ViewClassVO;
//
//@WebServlet("/viewClass.controller")
//public class ViewClassServlet extends HttpServlet {
//	private ViewClassService service;
//	
//	@Override
//	public void init() throws ServletException {
//		service = new ViewClassService();
//	}
//	@Override
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		this.doPost(request, response);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		// 接收資料
////		String username = request.getParameter("viewClass");
//		
//		
//		// 驗證資料
//		Map<String, String> errors = new HashMap<String, String>();
//		request.setAttribute("error", errors);
//		
////		if (username == null || username.length() == 0) {
////			errors.put("username", "Please enter ID for login");
////		}
////		if (password == null || password.length() == 0) {
////			errors.put("password", "Please enter PWD for login");
////		}
////
////		if (errors != null && !errors.isEmpty()) {
////			request.getRequestDispatcher("/secure/login.jsp").forward(request,
////					response);
////			return;
////		}
////		Map<String, String> test = (Map<String, String>) request.getAttribute("error");
////		System.out.println(test.get("action")+"123123456");
//		// 呼叫model
//		List<ViewClassVO> viewClass = service.getAll();
//		// 根據model執行結果，導向view
//		if(viewClass==null) {
//			errors.put("action", "Update fail");
//		} else {
//			request.setAttribute("viewClass", viewClass);
//		}
//		request.getRequestDispatcher(
//				"/healthViewCRUD.jsp").forward(request, response);
//	}
//
//}
