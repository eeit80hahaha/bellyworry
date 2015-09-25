package controller;

import health.model.HeroHealthDiaryVO;
import init.GlobalService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fun.model.HealthViewPageVO;
import fun.model.HealthViewService;
import fun.model.HealthViewVO;
import fun.model.ViewClassService;
import ranking.model.HeroService;
import ranking.model.HeroVO;


@WebServlet(
		urlPatterns={"/healthViewlist.controller"}
)
public class HealthViewlistServlet extends HttpServlet {
	
	private HealthViewService service;

	@Override
	public void init() throws ServletException {
		service = new HealthViewService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//接收資料
		String temp1 = request.getParameter("viewClassNo");
		String temp2 = request.getParameter("pageNo");
		System.out.println(temp1+" "+temp2);
		
		//驗證資料
		Map<String, String> errorMessage = new HashMap<String, String>();
		request.setAttribute("error", errorMessage);
		
		//轉換資料
		int viewClassNo = 0;
		if(temp1!=null && temp1.length()!=0) {
			viewClassNo = GlobalService.convertInt(temp1);
			if(viewClassNo==-1000) {
				errorMessage.put("viewClassNo", "景點編號必須為整數");	//程式沒寫好才會出現這個
			}
		}
		
		int pageNo = 0;
		if(temp2!=null && temp2.length()!=0) {
			pageNo = GlobalService.convertInt(temp2);
			if(pageNo==-1000) {
				errorMessage.put("pageNo", "頁碼必須為整數");
			}
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/backend/healthViewManage.jsp");
			rd.forward(request, response);
			return;
		}
				
		//呼叫Model
		HealthViewVO vo = new HealthViewVO();
		vo.setViewClassVO(new ViewClassService().getViewClass(viewClassNo));
		
		//根據Model執行結果導向View
	    HealthViewPageVO healthViewPageVO = service.getPageDate(pageNo, 8, vo);
	    
		request.setAttribute("HealthViewVO", vo);
		if(healthViewPageVO !=null){
			request.setAttribute("healthViewPageVO", healthViewPageVO);
			request.getRequestDispatcher(
					"/backend/healthViewManage.jsp").forward(request, response);
			System.out.println("111");
			System.out.println(healthViewPageVO);
		}else {
			errorMessage.put("action", "查無紀錄");
			request.getRequestDispatcher(
					"/backend/healthViewManage.jsp").forward(request, response);
			System.out.println("222");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		super.doGet(request, response);
	}

}
