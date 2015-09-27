package controller;

import init.GlobalService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calories.model.FoodCalService;
import calories.model.FoodCalVO;
import calories.model.PagesFoodCalVO;


@WebServlet(
		urlPatterns={"/ranking/foodCal.controller"}
)
public class FoodCalServlet extends HttpServlet{
		private FoodCalService service;
		@Override
		public void init() throws ServletException {
			service = new FoodCalService();
		}
		@Override
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();		
			//接收資料
			String logintmp = (String) session.getAttribute("login");
//			session.removeAttribute("login");

			String pageNoTemp = request.getParameter("pageNo");

			
			//驗證資料

			//轉換資料
		
			
			int pageNo = 0;
			if(pageNoTemp!=null && pageNoTemp.length()!=0) {
				pageNo = GlobalService.convertInt(pageNoTemp);
				if(pageNo==-1000) {

				}
			}
			int login = 0 ;
			if(logintmp!=null && logintmp.length()!=0) {
				login = GlobalService.convertInt(logintmp);
				if(login == 601){

				}
			}
			
			//呼叫model

	
			//換頁所呼叫的Service
			PagesFoodCalVO PagesFoodCalVO = service.getDatePage(pageNo, 3);	
			System.out.println(PagesFoodCalVO);
			PagesFoodCalVO.setFoodCalpage(service.base(PagesFoodCalVO.getFoodCalpage()));
			
			
			
			request.setAttribute("PagesFoodCalVO1", PagesFoodCalVO);
			
//			request.setAttribute("login", login);
			request.getRequestDispatcher(
					"/ranking/cookCaling.jsp").forward(request, response);		
		}
			
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			super.doGet(request, response);
		}
	
}