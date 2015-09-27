package controller;

import init.GlobalService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calories.model.ExerciseCalVO;


@WebServlet("/ranking/ExerciseCalSessionServlect")
public class ExerciseCalSessionServlect extends HttpServlet {
 
       
    public ExerciseCalSessionServlect() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		//接收資料
		String temp1 = request.getParameter("exerciseNo");
		String temp2 = request.getParameter("name");
		String temp3 = request.getParameter("calHour");
		
		//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		
		
		
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
				errors.put("calHour", "calHour must be an flost");
			}
		}
		if(errors!=null && !errors.isEmpty() ){
			request.getRequestDispatcher("/ranking/execiseCal.controller").forward(request, response);
			return;
		}
		//呼叫model
		ExerciseCalVO vo = new ExerciseCalVO();
		vo.setExerciseNo(exerciseNo);
		vo.setName(temp2);
		vo.setCalHour(calHour);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}
}
