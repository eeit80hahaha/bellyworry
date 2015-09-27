package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calories.model.MenuDAO;
import calories.model.MenuVO;
import calories.model.dao.MenuDaoHbm;

/**
 * Servlet implementation class ClassOptionServlet
 */
@WebServlet("/ClassOptionServlet.controller")
public class ClassOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDAO service;

	@Override
	public void init() throws ServletException {
		service = new MenuDaoHbm();
	}
    public ClassOptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MenuVO> ss=service.getAll();
		
		HttpSession session = request.getSession();
		session.setAttribute("option", ss);
		String path = request.getContextPath();
		response.sendRedirect(path + "/backend/foodCalInsert.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
