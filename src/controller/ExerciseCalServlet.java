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

import calories.model.ExerciseCalVO;
import calories.model.ExercoseCalService;
import calories.model.FoodCalVO;
import calories.model.PagesFoodCalVO;


@WebServlet(
		urlPatterns={"/ranking/execiseCal.controller"}
)
public class ExerciseCalServlet extends HttpServlet{
		private ExercoseCalService service;
		@Override
		public void init() throws ServletException {
			service = new ExercoseCalService();
		}
		@Override
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
//			HttpSession session = request.getSession();
			//接收資料
//			String logintmp = (String) session.getAttribute("login");
			String temp1 = request.getParameter("exerciseNo");
			String temp2 = request.getParameter("name");
			String temp3 = request.getParameter("calHour");
			String execrisecalion = request.getParameter("execrisecalion");
			
			//驗證資料
			Map<String, String> errors = new HashMap<String, String>();
			request.setAttribute("error", errors);
			

			//轉換資料
			int exerciseNo = 0;
			if(temp1!=null && temp1.length()!=0) {
				exerciseNo = GlobalService.convertInt(temp1);
				if(exerciseNo==-1000) {
					errors.put("exerciseNo", "exerciseNo must be an integer");
				}
			}
			float calHour = 0;
			if(temp3!=null && temp3.length()!=0) {
				calHour = GlobalService.convertFloat(temp3);
				if(calHour==-1000) {
					errors.put("calHour", "calHour must be an integer");
				}
			}
						
			//呼叫model
			ExerciseCalVO vo = new ExerciseCalVO();
			vo.setExerciseNo(exerciseNo);
			vo.setName(temp2);
			vo.setCalHour(calHour);

			
			
//			List<ExerciseCalVO> result1 = service.select(vo);	
//			request.setAttribute("ExerciseNo", result1);
//			request.getRequestDispatcher("/ranking/exerciseCaling.jsp").forward(request, response);
			
			
			
			
			
//			List<ExerciseCalVO> result = service.select(vo);
//			request.setAttribute("exerciseNo", result);
//			request.getRequestDispatcher(
//					"/ranking/exerciseCalingproduct.jsp").forward(request, response);
			
			//根據Model執行結果導向View
			if(execrisecalion!=null && execrisecalion.equals("Select")) {
				List<ExerciseCalVO> result = service.select(vo);
				request.setAttribute("select", result);
				request.getRequestDispatcher(
						"/ranking/exerciseCalingindisplay.jsp").forward(request, response);
			} else if(execrisecalion!=null && execrisecalion.equals("Insert")) {
				int result = service.insert(vo);
				System.out.println(result);
				if(result>0) {
					errors.put("action", "Insert fail");
				} else {
					request.setAttribute("insert", result);
				}
				request.getRequestDispatcher(
						"/ranking/exerciseCalingproduct.jsp").forward(request, response);

			} else if(execrisecalion!=null && execrisecalion.equals("Update")) {
				int result = service.update(vo);
				if(result>0) {
					errors.put("action", "Update fail");
				} else {
					request.setAttribute("update", result);
				}
				request.getRequestDispatcher(
						"/ranking/exerciseCalingproduct.jsp").forward(request, response);
			} else if(execrisecalion!=null && execrisecalion.equals("Delete")) {
				boolean result = service.delete(vo);
				if(!result) {
					request.setAttribute("delete", 0);
				} else {
					request.setAttribute("delete", 1);
				}
				request.getRequestDispatcher(
						"/ranking/exerciseCalingproduct.jsp").forward(request, response);
			} else  {
				errors.put("action", "Unknown Action:"+execrisecalion);
				request.getRequestDispatcher(
						"/ranking/exerciseCalingproduct.jsp").forward(request, response);
			}
			
					
		}
			
					
			
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			super.doGet(request, response);
		}
	
}