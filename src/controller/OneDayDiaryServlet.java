package controller;

import health.model.DiaryIndexService;
import health.model.HealthDiaryService;
import health.model.HealthDiaryVO;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.aso.h;
import register.model.MemberVO;
@WebServlet(
		urlPatterns={"/oneday.controller"}
)

public class OneDayDiaryServlet extends HttpServlet{
	DiaryIndexService service = new DiaryIndexService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HealthDiaryVO vo = new HealthDiaryVO();
		HttpSession session = request.getSession(); 				
		request.setCharacterEncoding("UTF-8");
		MemberVO memberVO = (MemberVO) session.getAttribute("user");
		int memberNo = memberVO.getMemberNo();		
		String no = request.getParameter("no");
		int memberNoChange = 0;

		int noSelect = 0;
		if(no!=null && no.trim().length()!=0){
			try {
				noSelect = Integer.parseInt(no);
			} catch (NumberFormatException e) {
//				response.sendRedirect("");    error-page
			}
		}
		vo.setNo(noSelect);
		vo.setMemberNo(memberNo);
		System.out.println(vo);
		HealthDiaryVO list = service.selectByPrimaryKey(vo);
		
		System.out.println(list);
		request.setAttribute("list",list);
		//response.sendRedirect(request.getContextPath()+"/onedayDiary.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/onedayDiary.jsp");
		rd.forward(request, response);
		return;
		

	}
	

}
