package controller;

import health.model.HealthDiaryService;
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


@WebServlet(
		urlPatterns={"/herodiary.controller"}
)
public class HeroDiaryServlet extends HttpServlet {
	
	private HeroService heroservice;

	@Override
	public void init() throws ServletException {
		
		heroservice = new HeroService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//接收資料
		String memberNoTemp = request.getParameter("memberno");
		String dateTemp = request.getParameter("date");
		
		//驗證資料
		Map<String, String> errorMessage = new HashMap<String, String>();
		request.setAttribute("error", errorMessage);
		
		//轉換資料
		int memberNo = 0;
		if(memberNoTemp!=null && memberNoTemp.length()!=0) {
			memberNo = GlobalService.convertInt(memberNoTemp);
			if(memberNo==-1000) {
				errorMessage.put("memberNo", "memberNo must be an integer");
			}
		}
		java.util.Date date = new java.util.Date();
		if(dateTemp!=null && dateTemp.length()!=0) {
			date = GlobalService.convertDate(dateTemp);
			if(memberNo==-1000) {
				errorMessage.put("date", "date must be an date");
			}
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/healthForm.jsp");
			rd.forward(request, response);
			return;
		}
		
		//呼叫Model
		HeroVO herovo = new HeroVO();
		herovo.setMemberNo(memberNo);
		
		//根據Model執行結果導向View
	    List<HeroVO> herovolist = heroservice.select(herovo);
		List<HealthDiaryVO> healthdiarylist = heroservice.Selectday(memberNo, date);
		
		request.setAttribute("memberNo", memberNo);		
		if(healthdiarylist != null){
			request.setAttribute("herovo", herovolist.get(0));
			request.setAttribute("healthdiary", healthdiarylist.get(0));
			request.getRequestDispatcher(
					"/herodiary.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher(
					"/heroerroe.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doGet(request, response);
	}

}
