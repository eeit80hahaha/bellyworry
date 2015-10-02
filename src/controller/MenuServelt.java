package controller;

import food.recipes.model.FoodItemVO;
import init.GlobalService;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

import calories.model.FoodCalVO;
import calories.model.MenuService;
import calories.model.MenuVO;

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
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("pages");
		int pageSize=8;//每頁幾筆
		int lastpage;
		System.out.println("pages = " + page);
		if (page == null || "".equals(page)) {
			page = "1";
		}
		int pageNo = GlobalService.convertInt(page);

		List<MenuVO> result1 = service.selectMenu(null);
		request.setAttribute("option", result1);
		String menuNOstr = request.getParameter("menuNo");
		int menuNO;
		if(menuNOstr!=null && !"0".equals(menuNOstr) && !"".equals(menuNOstr)){
			menuNO=GlobalService.convertInt(menuNOstr);
		}else{ 
			menuNO=0;
		}		
		List<FoodCalVO> result = null;
		if (menuNO != 0 ) {
			result = service.page(pageNo,pageSize,menuNO);
		} else {
			result = service.page(pageNo,pageSize, 0);
		}
		/* Neil add */
		StringBuffer cooksDiv = new StringBuffer();
		List<FoodCalVO> ss = null;
//		ListPage<FoodCalVO> listPage = null;
		System.out.println("result=========="+result);
		if (result.size() > 0) {
			/* Neil add */
			System.out.println("sss:" + result);
			ss = (List<FoodCalVO>) service.base(result);
//			listPage = new ListPage<FoodCalVO>(ss, 8);// 每頁6筆
//			ss = result;
			String tempType = "";
			for (int i = 0; i < ss.size(); i++) {
				cooksDiv.append("<div id='cook_");
				cooksDiv.append(ss.get(i).getFoodNo());
				cooksDiv.append("' style='display:none;'>");
				cooksDiv.append("<table width='400'>");
				cooksDiv.append("<tr>");
				if (ss.get(i).getCooks() != null) {
					if (ss.get(i).getCooks().getPicture() != null) {
						cooksDiv.append("<td colspan='3' width='50'><img src='data:image/jpg;base64,");
						System.out.println(ss.get(i).getCooks().getPicture());
						cooksDiv.append(Base64.encodeBase64String(ss.get(i)
								.getCooks().getPicture()));
						cooksDiv.append("' style='width:400px; height:auto;' /></td>");
					} else {
						cooksDiv.append("<td colspan='3' width='50'><img src='images/empty.jpg");
						cooksDiv.append("' style='width:400px; height:auto;' /></td>");
					}
					cooksDiv.append("</tr>");

					Iterator<FoodItemVO> fooditems = ss.get(i).getCooks()
							.getFooditems().iterator();

					tempType = "";

					while (fooditems.hasNext()) {
						FoodItemVO fiVO = fooditems.next();

						cooksDiv.append("<tr>");
						cooksDiv.append("<td width='100'>");
						if (!tempType.equals(fiVO.getType())) {
							cooksDiv.append(fiVO.getType());
						}
						cooksDiv.append("</td>");
						cooksDiv.append("<td width='150'>");
						cooksDiv.append(fiVO.getName());
						cooksDiv.append("</td>");
						cooksDiv.append("<td width='150'>");
						cooksDiv.append(fiVO.getCount());
						cooksDiv.append("</td>");
						cooksDiv.append("</tr>");

						tempType = fiVO.getType();
					}
					cooksDiv.append("<tr style='border-top: 1px solid gray'>");
					cooksDiv.append("<td>作法</td>");
					cooksDiv.append("<td colspan='2'>");
					cooksDiv.append(ss.get(i).getCooks().getWayNo());
					cooksDiv.append("</td></tr></table></div>");
				}
			}
		}
		/* Neil add */
		request.setAttribute("selected", menuNO);

		if (ss != null) {
			request.setAttribute("menu", ss);
			request.setAttribute("cooksDiv", cooksDiv);
			request.setAttribute("pagecount",pageNo);
			if((service.totalCount(menuNO % pageSize) != 0)){
				lastpage = (service.totalCount(menuNO)/pageSize) + 1;
			}
			else{
				lastpage = (service.totalCount(menuNO)/pageSize);
			}
			request.setAttribute("listPage",lastpage);
		}
		/* Neil add */
		RequestDispatcher rd = request.getRequestDispatcher("/menuview.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
