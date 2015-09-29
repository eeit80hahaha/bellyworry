package controller;

import init.GlobalService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import school.model.ExamService;
import school.model.PageExamVO;

/**
 * Servlet implementation class ActivityServlet
 */
@WebServlet(			
		urlPatterns={"/backend/exambase1.controller"}
		)
public class ExamBaseServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ExamService service;
	@Override
	public void init() throws ServletException {
		service = new ExamService();
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
				PageExamVO PageExamVO = service.getDatePage(pageNo,5);					
				
				
				

				
				


				//setAttribute
				request.setAttribute("PageExamVO", PageExamVO);				
				
				RequestDispatcher rd = request.getRequestDispatcher("/backend/ExamNewFile.jsp");
				rd.forward(request, response);								
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
