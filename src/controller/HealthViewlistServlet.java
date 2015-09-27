package controller;

import health.model.HeroHealthDiaryVO;
import init.GlobalService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.fasterxml.jackson.databind.util.JSONPObject;

import fun.model.HealthViewPageVO;
import fun.model.HealthViewService;
import fun.model.HealthViewVO;
import fun.model.ViewClassService;
import fun.model.ViewClassVO;
import ranking.model.HeroService;
import ranking.model.HeroVO;


@WebServlet(
		urlPatterns={"/healthViewlist.controller"}
)
public class HealthViewlistServlet extends HttpServlet {
	
	private HealthViewService service;
	private ViewClassService viewService;

	@Override
	public void init() throws ServletException {
		service = new HealthViewService();
		viewService = new ViewClassService();
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
		ViewClassVO vo = viewService.getViewClass(viewClassNo);
		
		HealthViewPageVO healthViewPageVO = service.getPageDate(pageNo, 3, vo);
		//根據Model執行結果導向View
		System.out.println(healthViewPageVO);
		
 
		if(healthViewPageVO !=null){
			request.setAttribute("healthViewPageVO", healthViewPageVO);
//			if(viewClassNo!=0){	//回傳JSON
//				response.setContentType("application/Json;charset=UTF-8");
//				PrintWriter out = response.getWriter();
//				out.write(parseJSONObj(healthViewPageVO).toJSONString());
////				System.out.println(parseJSONObj(healthViewPageVO).toJSONString());
//				out.close();
//				return;
//			}
			//回傳HTML
			request.setAttribute("nowViewClassVO", vo);
			request.getRequestDispatcher(
					"/backend/healthViewManage.jsp").forward(request, response);
//			System.out.println(healthViewPageVO);
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
	
	private JSONObject parseJSONObj(HealthViewPageVO vo){
		JSONObject finalresults = new JSONObject();
		Map map = new TreeMap();
		Map listvos = new LinkedHashMap();
		
		int i = 0;

		List<HealthViewVO> test = vo.getHealthViewPage();
		for(HealthViewVO ele : test){

			Map listvo = new TreeMap();
			
			int r1 = ele.getNo();
			String r2 = ele.getName();
			String r3 = ele.getViewClassVO().getName();
			float r4 = ele.getLat();
			float r5 = ele.getLng();
			
			listvo.put("no", r1);
			listvo.put("name", r2);
			listvo.put("viewClass", r3);
			listvo.put("lat", r4);
			listvo.put("lng", r5);
			
			listvos.put("healthView"+i, listvo);
			i++;
			
			System.out.println(r1+r2+r3+r4);
		}
		JSONObject listjsonobj = new JSONObject(listvos);
		
		map.put("pageNo",vo.getPageNo());
		map.put("pageSize",vo.getPageSize());
		map.put("rowCount", vo.getRowCount());
		map.put("totalPage", vo.getTotalPages());
		map.put("healthViews", listjsonobj);
		
		finalresults = new JSONObject(map);
		
		return  finalresults;
	}

}
