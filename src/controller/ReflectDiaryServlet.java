package controller;

import health.model.HealthDiaryService;
import health.model.HealthDiaryVO;
import init.GlobalService;

import java.io.IOException;
import java.text.ParseException;
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
import javax.servlet.http.HttpSession;

import ranking.model.HeroService;
import ranking.model.HeroVO;
import ranking.model.ReflectService;
import ranking.model.ReflectVO;
import register.model.MemberVO;


@WebServlet(
		urlPatterns={"/reflectdiary.controller"}
)
public class ReflectDiaryServlet extends HttpServlet {
	
	private static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");

	
	private ReflectService reflectService;
	private HeroService heroservice;

	@Override
	public void init() throws ServletException {
		
		reflectService = new ReflectService();
		heroservice = new HeroService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//接收資料
		String memberNoTemp = request.getParameter("memberno");
		String dateTemp = request.getParameter("date");
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
		
		java.util.Date date = new java.util.Date();
		if(dateTemp!=null && dateTemp.length()!=0) {
			date = GlobalService.convertDate(dateTemp);
			if(memberNo==-1000) {
				errorMessage.put("date", "date must be an date");
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
		HttpSession session = request.getSession();
		MemberVO memberbean = (MemberVO) session.getAttribute("user");
		java.util.Date authorDate = new java.util.Date();
		
		ReflectVO reflectvo = new ReflectVO();
		reflectvo.setReflectedNo(memberNo);
		reflectvo.setAuthorNo(memberbean.getMemberNo());
		reflectvo.setReflectedDate(date);
		reflectvo.setAuthorDate(authorDate);
		
		HeroVO herovo = new HeroVO();
		herovo.setMemberNo(memberNo);
		
		//根據Model執行結果導向View
		
		int result = reflectService.insert(reflectvo);

		if(result == -300){
			request.setAttribute("error", "資料庫存取錯誤");
			request.getRequestDispatcher(
			"/reflecterror.jsp").forward(request, response);
		}else if(result == -400){
			request.setAttribute("error", "無此篇會員的日誌");
			request.getRequestDispatcher(
			"/reflecterror.jsp").forward(request, response);
		}else if(result == -100){
			request.setAttribute("error", "該會員的日誌已被檢舉過");
			request.getRequestDispatcher(
			"/reflecterror.jsp").forward(request, response);
		}else{
			ReflectVO reflectvoel = reflectService.selectByPrimaryKey(result);
			List<HeroVO> herovolist = heroservice.select(herovo);
			
			request.setAttribute("memberNo", memberNo);	
			request.setAttribute("pageNo", pageNo);		
			request.setAttribute("reflectvo", reflectvoel);
			request.setAttribute("herovo", herovolist.get(0));
			request.getRequestDispatcher(
			"/reflectok.jsp").forward(request, response);
		}
	

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doGet(request, response);
	}

}
