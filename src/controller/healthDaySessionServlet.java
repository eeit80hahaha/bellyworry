package controller;

import init.GlobalService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/healthDaySessionServlet.collection")
public class healthDaySessionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		java.util.Date date = null;
		String time = request.getParameter("time");
		if(time!=null){
			date = GlobalService.convertDate(time);
		}
		HttpSession session = request.getSession();
		session.removeAttribute("healthDate");
		session.setAttribute("healthDate", date);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
