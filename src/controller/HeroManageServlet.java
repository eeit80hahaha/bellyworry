package controller;

import init.GlobalService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ranking.model.ReflectPageVO;
import ranking.model.ReflectService;
import ranking.model.ReflectVO;



@WebServlet(
		urlPatterns={"/backend/heromanage.controller"}
)
public class HeroManageServlet extends HttpServlet {
	
	private ReflectService reflectservice;
	@Override
	public void init() throws ServletException {
		
		reflectservice = new ReflectService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//接收資料
		String id = request.getParameter("id");
		String pageNoTemp = request.getParameter("pageNo");
		
		//驗證資料
		Map<String, String> errorMessage = new HashMap<String, String>();
		request.setAttribute("error", errorMessage);
		
		//轉換資料
		
		int pageNo = 0;
		if(pageNoTemp!=null && pageNoTemp.length()!=0) {
			pageNo = GlobalService.convertInt(pageNoTemp);
			if(pageNo==-1000) {
				errorMessage.put("pageNo", "pageNo must be an integer");
			}
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/backend/HeroManage.jsp");
			rd.forward(request, response);
			return;
		}
		
		//呼叫Model
		
		//根據Model執行結果導向View
		
		ReflectPageVO reflectpagevo = reflectservice.getPage(pageNo, 5, id);

						
		if(reflectpagevo !=null ){
			request.setAttribute("reflectpagevo", reflectpagevo);
			request.getRequestDispatcher(
					"/backend/HeroManage.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher(
					"/backend/HeroManageError.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}

}
