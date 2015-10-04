package controller;

import health.model.HealthDiaryVO;
import init.GlobalService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ranking.model.HeroService;
import ranking.model.HeroVO;
import ranking.model.ReflectPageVO;
import ranking.model.ReflectService;
import ranking.model.ReflectVO;



@WebServlet(
		urlPatterns={"/backend/dayreflectmanage.controller"}
)
public class DayReflectManageServlet extends HttpServlet {
	
	private HeroService heroservice;
	private ReflectService reflectservice;
	private static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public void init() throws ServletException {
		
		heroservice = new HeroService();
		reflectservice = new ReflectService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//接收資料
		String reflectedNotmp = request.getParameter("reflectedNo");
		String reflectedID = request.getParameter("reflectedID");
		String authorDatetmp = request.getParameter("date");
		
		//驗證資料
		Map<String, String> errorMessage = new HashMap<String, String>();
		request.setAttribute("error", errorMessage);
		
		//轉換資料
		int memberNo = 0;
		if(reflectedNotmp!=null && reflectedNotmp.length()!=0) {
			memberNo = GlobalService.convertInt(reflectedNotmp);
			if(memberNo==-1000) {
				errorMessage.put("memberNo", "memberNo must be an integer");
			}
		}
		
		java.util.Date date = new java.util.Date();
		if(authorDatetmp!=null && authorDatetmp.length()!=0) {
			date = GlobalService.convertDate(authorDatetmp);
			if(memberNo==-1000) {
				errorMessage.put("date", "date must be an date");
			}
		}
		
		//呼叫Model

		
		//根據Model執行結果導向View
		int result = reflectservice.reflectday(memberNo, date);
		
			
			if(result > 0){
				request.setAttribute("reflectok","會員"+ reflectedID + "的"+ sFormat.format(date) + "日誌封鎖成功");
				request.getRequestDispatcher(
						"/backend/heromanage.controller?pageNo=1").forward(request, response);
			}else if(result == 0){
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
