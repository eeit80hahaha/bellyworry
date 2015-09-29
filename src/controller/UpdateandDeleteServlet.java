package controller;

import hibernate.util.HibernateUtil;
import init.GlobalService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import calories.model.FoodCalVO;
import food.recipes.model.CookVO;
import food.recipes.model.FoodItemVO;
import food.recipes.model.FoodListVO;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// String foodNo=request.getParameter("${vo.foodNo}");
		String foodNo = request.getParameter("foodNo");

		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("meal", errors);
		System.out.println(foodNo);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query0 = session
					.createQuery("from MealDetailVO where foodNo="
							+ GlobalService.convertInt(foodNo));
			if (query0.list().size() != 0) {
				System.out.println("=============mealname!=null"+query0.list().size());
				errors.put("mealerror", "請先將此菜色從套餐中刪除");
			} else {
				int no = GlobalService.convertInt(foodNo);
				System.out.println("1111111111111111111");
				FoodCalVO v0Copy = new FoodCalVO();
				FoodCalVO v0 = service.selectbyId(no);
				v0Copy = v0;
				System.out.println("3333333333333333333");
				Query query = session
						.createQuery("delete from FoodCalVO where foodNo=" + no);
				System.out.println("222222222222222222");
				query.executeUpdate();
				
				System.out.println("=============foodcal-delete"+query.executeUpdate());
				if (v0Copy.getCookNo() != 0) {
					List<FoodListVO> foodlist = service.selectbyCookNo(v0
							.getCookNo());
					List<FoodListVO> foodlistCopy = new ArrayList<FoodListVO>();
					foodlistCopy = foodlist;
					for (FoodListVO v1 : foodlist) {
						Query query1 = session
								.createQuery("delete from FoodListVO where cookNo="
										+ no
										+ " and useFoodNo="
										+ v1.getUseFoodNo());
						query1.executeUpdate();
				System.out.println("=============foodList-delete"+query1.executeUpdate());
					}

					for (FoodListVO v1 : foodlistCopy) {
						Query query2 = session
								.createQuery("delete from FoodItemVO where useFoodNo="
										+ v1.getUseFoodNo());
						query2.executeUpdate();
				System.out.println("=============foodItem-delete"+query2.executeUpdate());
					}

					Query query3 = session
							.createQuery("delete from CookVO where cookNo="
									+ v0Copy.getCookNo());
					query3.executeUpdate();
					System.out.println("=============cook-delete"+query3.executeUpdate());
				}
				
				// String path = request.getContextPath();
				// response.sendRedirect(path + "/backend/foodCalInsert.jsp");
			}
			session.getTransaction().commit();
			errors.put("mealSuccess", "刪除成功");
		} catch (Exception e) {
			errors.put("mealfail", "刪除失敗");
			session.getTransaction().rollback();

		}
		request.getRequestDispatcher("/backend/index.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
