package controller;

import java.io.IOException;

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
		
		//驗證資料
		
		//轉換資料
		
		//呼叫Model
		
		//根據Model執行結果導向View

		ReflectPageVO reflectpagevo = reflectservice.getPage(1, 5, 1000002);

						
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
