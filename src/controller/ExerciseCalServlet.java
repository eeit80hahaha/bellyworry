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

import calories.model.ExerciseCalVO;
import calories.model.ExercoseCalService;
import calories.model.FoodCalVO;


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
			//接收資料
			String temp1 = request.getParameter("exerciseNo");
			String temp2 = request.getParameter("name");
			String temp3 = request.getParameter("calHour");
			String execrisecalion = request.getParameter("execrisecalion");
			
			//驗證資料
			Map<String, String> errors = new HashMap<String, String>();
			request.setAttribute("error", errors);
			
			if(execrisecalion!=null) {
				if(execrisecalion.equals("Insert") || execrisecalion.equals("Update") || execrisecalion.equals("Delete")) {
					if(temp1==null || temp1.length()==0) {
						errors.put("cookNo", "Please enter cookNo for "+execrisecalion);
					}
				}
			}
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

			
			
			List<ExerciseCalVO> result = service.select(vo);
			request.setAttribute("exerciseNo", result);
			request.getRequestDispatcher(
					"/ranking/cookCaling.jsp").forward(request, response);
			
					
		}
			
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			super.doGet(request, response);
		}
	
}