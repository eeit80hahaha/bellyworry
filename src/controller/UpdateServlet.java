package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import register.model.LoginService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet.controller")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService service;
	@Override
	public void init() throws ServletException {
		service = new LoginService();
	}
    
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
