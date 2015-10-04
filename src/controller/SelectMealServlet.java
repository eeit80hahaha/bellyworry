package controller;

import food.combo.model.MealNameVO;
import init.GlobalService;
import init.ListPage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calories.model.FoodCalVO;
import calories.model.MenuService;
import calories.model.MenuVO;

/**
 * Servlet implementation class SelectMealServlet
 */
@WebServlet("/backend/SelectMealServlet.controller")
public class SelectMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private MenuService service;
	
	@Override
	public void init() throws ServletException {
		
		service = new MenuService();
		
	}
    public SelectMealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("pages");
		int pageNo=GlobalService.convertInt(page);
//		List<MenuVO> result1= service.selectMenu(null);
//		request.setAttribute("option", result1);		
//		String menuname = request.getParameter("menuNo");
		List<MealNameVO> result=null;
//		if(menuname!=null && !"0".equals(menuname) && !"".equals(menuname)){
//			result= service.selectbyMenuNo(GlobalService.convertInt(menuname));
//		}else{
			result= service.selectMealName(null);
//		}
		
		/*Neil add*/
		List<MealNameVO> ss=null;
		ListPage<MealNameVO> listPage=null;
		if(result.size()>0){
			/*Neil add*/
		ss=result;
		
		listPage = new ListPage<MealNameVO>(ss,10);//每頁6筆
		
		ss = listPage.getPageList(pageNo);
		
		/*Neil add*/
//		request.setAttribute("selected", menuname);
		
		if(ss!=null && listPage!=null){
		request.setAttribute("menu", ss);
		request.setAttribute("pagecount", listPage.getPageNo());
		request.setAttribute("listPage", listPage.getLastPage());
		}
		/*Neil add*/
		request.getRequestDispatcher("/backend/mealDetail.jsp")
		.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
