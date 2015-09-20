package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ranking.model.HeroService;
import ranking.model.HeroVO;


@WebServlet(
		urlPatterns={"/hero.controller"}
)
public class HeroServlet extends HttpServlet {
	
	private HeroService heroservice;
	@Override
	public void init() throws ServletException {
		
		heroservice = new HeroService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//接收資料
		
		//驗證資料
		
		//轉換資料
		
		//呼叫Model
		
		//根據Model執行結果導向View
		List<HeroVO> herovolist = heroservice.select(null);
						
		if(herovolist !=null ){
			request.setAttribute("herovolist", herovolist);
			request.getRequestDispatcher(
					"/ranking.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher(
					"/heroerroe.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}

}
