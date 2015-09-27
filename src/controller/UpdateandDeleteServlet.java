package controller;

import init.GlobalService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.recipes.model.UpdateDeleteMenuService;

/**
 * Servlet implementation class UpdateandDeleteServlet
 */
@WebServlet("/backend/UpdateandDeleteServlet.controller")
public class UpdateandDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpdateDeleteMenuService service;

	@Override
	public void init() throws ServletException {
		service = new UpdateDeleteMenuService();
	}
    public UpdateandDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String foodNo=request.getParameter("${vo.foodNo}");
		String foodNo=request.getParameter("foodNo");
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("meal", errors);
		if(service.selectByFoodNo(GlobalService.convertInt(foodNo))==null){
			errors.put("mealerror", "請先將此菜色從套餐中刪除");
		}else{
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
