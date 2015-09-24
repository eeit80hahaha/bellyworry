package controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calories.model.FoodCalVO;
import calories.model.MenuService;
import food.combo.model.DayMealVO;
import food.combo.model.MealNameVO;


/**
 * Servlet implementation class Menuselect
 */
@WebServlet("/Mealservelt.controller")
public class MealServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService service;
	
	@Override
	public void init() throws ServletException {
		
		service = new MenuService();
		
	}
    public MealServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MealNameVO> result= service.selectMealName(null);
		List<DayMealVO> result1= service.selectDayMeal(null);
		//System.out.println(result);
//		List<FoodCalVO> ss=service.base(result);
		for(MealNameVO vo:result){
//			Set<FoodCalVO> aa=vo.getFoodcals();
			vo.setMealNo(vo.getMealNo());
			vo.setName(vo.getName());
			vo.setFoodcals((Set<FoodCalVO>)service.base(vo.getFoodcals()));
			System.out.println(vo.getName());
		}
		request.setAttribute("menu", result);
		System.out.println(result1);
		request.setAttribute("menu1", result1);
		RequestDispatcher rd = request.getRequestDispatcher("/meal.jsp");
		rd.forward(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}


}
