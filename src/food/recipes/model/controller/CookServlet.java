package food.recipes.model.controller;

import food.recipes.model.CookVO;
import init.GlobalService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CookServlet extends HttpServlet{
		private CookServlet service;
		@Override
		public void init() throws ServletException {
			service = new CookServlet();
		}
		@Override
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			//接收資料
			String temp1 = request.getParameter("cookNo");
			String temp2 = request.getParameter("wayNo");
			String temp3 = request.getParameter("picture");
			String Cookion = request.getParameter("Cookion");
			
			//驗證資料
			Map<String, String> errors = new HashMap<String, String>();
			request.setAttribute("error", errors);
			
			if(Cookion!=null) {
				if(Cookion.equals("Insert") || Cookion.equals("Update") || Cookion.equals("Delete")) {
					if(temp1==null || temp1.length()==0) {
						errors.put("cookNo", "Please enter cookNo for "+Cookion);
					}
				}
			}
			//轉換資料
			int cookNo = 0;
			if(temp1!=null && temp1.length()!=0) {
				cookNo = GlobalService.ConvertInt(temp1);
				if(cookNo==-1000) {
					errors.put("cookNo", "cookNo must be an integer");
				}
			}
			
			//呼叫model
			CookVO vo = new CookVO();
			vo.setCookNo(cookNo);
			vo.setWayNo(temp2);
			
			
//			List<CookVO> result = service.select(null);
//			request.setAttribute("cookvo", result);
//			request.getRequestDispatcher(
//					"/pages/display.jsp").forward(request, response);
//					
		}
			
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			super.doGet(request, response);
		}
	
}