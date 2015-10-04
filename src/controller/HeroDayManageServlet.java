package controller;

import health.model.HealthDiaryVO;
import init.GlobalService;

import java.io.IOException;
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
		urlPatterns={"/backend/herodaymanage.controller"}
)
public class HeroDayManageServlet extends HttpServlet {
	
	private HeroService heroservice;
	@Override
	public void init() throws ServletException {
		
		heroservice = new HeroService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//接收資料
		String reflectedNotmp = request.getParameter("reflectedNo");
//		String reflectedId = request.getParameter("reflectedId");
		
		String authorDatetmp = request.getParameter("authorDate");
		
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
		HeroVO herovo = new HeroVO();
		herovo.setMemberNo(memberNo);
		
		//根據Model執行結果導向View
	    List<HeroVO> herovolist = heroservice.select(herovo);
		List<HealthDiaryVO> healthdiarylist = heroservice.selectday(memberNo, date);
		
			
			if(healthdiarylist != null){
				request.setAttribute("herovo", herovolist.get(0));
				request.setAttribute("healthdiary", healthdiarylist.get(0));
				request.getRequestDispatcher(
						"/backend/HeroManageDay.jsp").forward(request, response);
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
