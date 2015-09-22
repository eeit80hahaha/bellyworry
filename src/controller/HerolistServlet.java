package controller;

import health.model.HeroHealthDiaryVO;
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
		urlPatterns={"/herolist.controller"}
)
public class HerolistServlet extends HttpServlet {
	
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
		String memberNoTemp = request.getParameter("memberNo");
		String pageNoTemp = request.getParameter("pageNo");
		
		
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
		
		int pageNo = 0;
		if(pageNoTemp!=null && pageNoTemp.length()!=0) {
			pageNo = GlobalService.convertInt(pageNoTemp);
			if(pageNo==-1000) {
				errorMessage.put("pageNo", "pageNo must be an integer");
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
		java.util.Calendar cal = java.util.Calendar.getInstance();
	    cal.setTime(new java.util.Date());
	    int year = cal.get(java.util.Calendar.YEAR);
	    int month = cal.get(java.util.Calendar.MONTH);
		
	    HeroHealthDiaryVO herohealthdiaryvo = 
	    		heroservice.getDatePage(pageNo, 3, memberNo, year, month);
	    
	    List<HeroVO> herovolist = heroservice.select(herovo);
	    
		request.setAttribute("memberNo", memberNo);
		if(herohealthdiaryvo !=null ){
			request.setAttribute("herovo", herovolist.get(0));
			request.setAttribute("herohealthdiaryvo", herohealthdiaryvo);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.getRequestDispatcher(
					"/rankinglist.jsp").forward(request, response);
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
