package controller;

import food.recipes.model.CookVO;
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

import calories.model.FoodCalService;
import calories.model.FoodCalVO;


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
			//接收資料
			String temp1 = request.getParameter("foodNo");
			String temp2 = request.getParameter("name");
			String temp3 = request.getParameter("menuNo");
			String temp4 = request.getParameter("cal");
			String temp5 = request.getParameter("count");
			String temp6 = request.getParameter("weight");
			String temp7 = request.getParameter("cookNo");
			String temp8 = request.getParameter("picture1");
			String foodcalion = request.getParameter("foodcalion");
			
			//驗證資料
			Map<String, String> errors = new HashMap<String, String>();
			request.setAttribute("error", errors);
			
			if(foodcalion!=null) {
				if(foodcalion.equals("Insert") || foodcalion.equals("Update") || foodcalion.equals("Delete")) {
					if(temp1==null || temp1.length()==0) {
						errors.put("cookNo", "Please enter cookNo for "+foodcalion);
					}
				}
			}
			//轉換資料
			int foodNo = 0;
			if(temp1!=null && temp1.length()!=0) {
				foodNo = GlobalService.convertInt(temp1);
				if(foodNo==-1000) {
					errors.put("foodNo", "foodNo must be an integer");
				}
			}
			int menuNo = 0;
			if(temp3!=null && temp3.length()!=0) {
				menuNo = GlobalService.convertInt(temp3);
				if(menuNo==-1000) {
					errors.put("menuNo", "menuNo must be an integer");
				}
			}
			int cal = 0;
			if(temp4!=null && temp4.length()!=0) {
				cal = GlobalService.convertInt(temp4);
				if(cal==-1000) {
					errors.put("cal", "cal must be an integer");
				}
			}
			int weight = 0;
			if(temp6!=null && temp6.length()!=0) {
				weight = GlobalService.convertInt(temp6);
				if(weight==-1000) {
					errors.put("count", "count must be an integer");
				}
			}
			int cookNo = 0;
			if(temp7!=null && temp7.length()!=0) {
				cookNo = GlobalService.convertInt(temp7);
				if(cookNo==-1000) {
					errors.put("cookNo", "cookNo must be an integer");
				}
			}
			
			//呼叫model
			FoodCalVO vo = new FoodCalVO();
			vo.setCookNo(foodNo);
			vo.setName(temp2);
			vo.setMenuNo(menuNo);
			vo.setCal(cal);
			vo.setCount(temp5);
			vo.setWeight(weight);
			vo.setCookNo(cookNo);
			vo.setPicture1(temp8);
			
			
			System.out.println();
			List<FoodCalVO> result = service.base(service.select(vo));
			
			
			request.setAttribute("foodNo", result);
			request.getRequestDispatcher(
					"/ranking/cookCaling.jsp").forward(request, response);
			
					
		}
			
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			super.doGet(request, response);
		}
	
}