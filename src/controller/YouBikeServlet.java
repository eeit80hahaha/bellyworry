package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

import fun.model.HealthViewService;
import fun.model.ViewClassService;
import fun.model.YouBikeService;

@WebServlet("/YouBike.controller")
public class YouBikeServlet extends HttpServlet {
	private YouBikeService service;
    
	@Override
	public void init() throws ServletException {
		service = new YouBikeService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收資料
		//驗證資料
		//轉換資料
		//呼叫model
		String url = "http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=ddb80380-f1b3-4f8e-8016-7ed9cba571d5";
		service.setUrlString(url);
		
		String result = null;
		try {
//			result = service.getJsonData();
			result = service.getJsonDataFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 根據model執行結果，導向view
		
		if(result!=null){
			result = JSONValue.toJSONString(JSONValue.parse(result));
			request.getSession().setAttribute("station", result);
			response.sendRedirect(request.getContextPath()+"/enter.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
