package controller;

import health.model.EatRecordService;
import health.model.EatRecordVO;

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

import calories.model.FoodCalVO;

@WebServlet("/FoodCalServletSave")
public class FoodCalServletSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EatRecordService eatRservice;
    public FoodCalServletSave() {
    	eatRservice = new EatRecordService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();	
		
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		
		String[] ratrsession = {"eatBreakfast","eatLunch","eatDinner"};
		
		if( (session.getAttribute("eatBreakfast")==null ||
	        ( ( (List<?>) session.getAttribute("eatBreakfast")).isEmpty() ))&&
	        (session.getAttribute("eatLunch")==null ||
	        ( ((List<?>) session.getAttribute("eatLunch")).isEmpty() ))	&&
	        (session.getAttribute("eatDinner")==null ||
	        ( ((List<?>) session.getAttribute("eatDinner")).isEmpty() ))
				){
			errors.put("eatr", "沒有資料要保存");
			
		}else{
			for(int i=0;i<=2;i++){
				if(session.getAttribute(ratrsession[i])!=null &&
						!((List<?>)session.getAttribute(ratrsession[i])).isEmpty()){
						
					List<EatRecordVO> eatrlist = (List<EatRecordVO>)
							session.getAttribute(ratrsession[i]);
					
					eatRservice.insertList(eatrlist);
				}
			}
		}
		if(errors!=null && !errors.isEmpty()){

			request.getRequestDispatcher("/foodCal.controller?pageNo=1").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/diaryIndex.controller").forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
