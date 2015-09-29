package controller;

import init.GlobalService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calories.model.MenuVO;
import news.model.ActivityService;
import news.model.ActivityVO;
import news.model.PagesActivityVO;

/**
 * Servlet implementation class ActivityServlet
 */
@WebServlet(			
		urlPatterns={"/backend/activitybase1.controller"}
		)
public class ActivityBaseServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ActivityService service;
	@Override
	public void init() throws ServletException {
		service = new ActivityService();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//接收資料
				String pageNoTemp = request.getParameter("pageNo");		
		//驗證資料
				Map<String, String> errors = new HashMap<String, String>();
				request.setAttribute("error", errors);
		//轉換資料
				int pageNo = 0;
				if(pageNoTemp!=null && pageNoTemp.length()!=0) {
					pageNo = GlobalService.convertInt(pageNoTemp);
					if(pageNo==-1000) {
						errors.put("pageNo", "pageNo must be an integer");
					}
				}
				
		//呼叫model													
				//page
				PagesActivityVO PagesActivityVO = service.getDatePage(pageNo,5);					
				PagesActivityVO.setActivitypage(service.base(PagesActivityVO.getActivitypage()));
				
				
				

				
				


				//setAttribute
				request.setAttribute("PagesActivityVO", PagesActivityVO);				
				
				RequestDispatcher rd = request.getRequestDispatcher("/backend/NewFile.jsp");
				rd.forward(request, response);								
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
