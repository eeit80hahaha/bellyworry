package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

import calories.model.MenuService;
import calories.model.FoodCalVO;


/**
 * Servlet implementation class Menuselect
 */
@WebServlet("/Menuservelt.controller")
public class MenuServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService service;
	
	@Override
	public void init() throws ServletException {
		
		service = new MenuService();
		
	}
    public MenuServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<FoodCalVO> result= service.select(null);
		System.out.println(result);
		List<FoodCalVO> ss=service.base(result);
		System.out.println(ss);
		request.setAttribute("menu", ss);
		
		RequestDispatcher rd = request.getRequestDispatcher("/menuview.jsp");
		rd.forward(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}


}
