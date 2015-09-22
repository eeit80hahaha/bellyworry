package controller;

import health.model.HealthDiaryDAO;
import health.model.HealthDiaryService;
import health.model.HealthDiaryVO;
import init.GlobalService;

import java.io.IOException;
import java.util.ArrayList;
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

import register.model.MemberVO;

public class HighChartServlet extends HttpServlet {
	private HealthDiaryService service;

	public void init() throws ServletException {
		service = new HealthDiaryService();
	};

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HealthDiaryVO vo = new HealthDiaryVO();
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<String, String>();
		request.setAttribute("errorMessage", errorMessage);

		MemberVO memberVo = (MemberVO) session.getAttribute("user");
		if (memberVo == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		int memberNo = memberVo.getMemberNo();

		String year = request.getParameter("year");
		String month = request.getParameter("month");

		int yearSelect = 0;
		if (year != null && year.trim().length() != 0) {
			yearSelect = Integer.parseInt(year);
		}

		int monthSelect = 0;
		if (month != null && month.trim().length() != 0) {
			monthSelect = Integer.parseInt(month);
		}

		List<HealthDiaryVO> list = service.gethighChart(memberNo, yearSelect, monthSelect);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/healthDiary.jsp");
		rd.forward(request, response);
		return;

	}

}
