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
import school.model.ExamVO;
import news.model.ActivityService;
import news.model.ActivityVO;

/**
 * Servlet implementation class ActivityServlet
 */
@WebServlet(		  
		urlPatterns={"/backend/examupdate.controller"}
		)
public class ExamUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ExamService service;
	@Override
	public void init() throws ServletException {
		service = new ExamService();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//接收資料
				String temp1 = request.getParameter("no");
				String temp2 = request.getParameter("content");
				String temp3 = request.getParameter("correct");
				String temp4 = request.getParameter("optA");
				String temp5 = request.getParameter("optB");
				String temp6 = request.getParameter("optC");
		//驗證資料
				Map<String, String> errors = new HashMap<String, String>();
				request.setAttribute("error", errors);
//				
//				if(Cookion!=null) {
//					if(Cookion.equals("Insert") || Cookion.equals("Update") || Cookion.equals("Delete")) {
//						if(temp1==null || temp1.length()==0) {
//							errors.put("no", "Please enter no for "+Cookion);
//						}
//					}
//				}
//		//轉換資料
				int no = 0;
				if(temp1!=null && temp1.length()!=0) {
					no = GlobalService.convertInt(temp1);
					if(no==-1000) {
						errors.put("no", "no must be an integer");
					}
				}
//				
//				System.out.println("test1:"+no);
//				java.util.Date startTime = null;
//				if(temp4!=null && temp4.length()!=0) {
//					startTime = GlobalService.convertDate(temp4);
//					if(new java.util.Date(0).equals(startTime)) {
//						errors.put("startTime", "startTime must be a date of YYYY-MM-DD");
//					}
//				}
//				
//				java.util.Date endTime = null;
//				if(temp5!=null && temp5.length()!=0) {
//					endTime = GlobalService.convertDate(temp5);
//					if(new java.util.Date(0).equals(endTime)) {
//						errors.put("startTime", "startTime must be a date of YYYY-MM-DD");
//					}
//				}
				
				//呼叫model
//				ActivityVO vo = new ActivityVO();
//				vo.setNo(no);
//				vo.setName(temp2);
//				vo.setContent(temp3);
//				vo.setStartTime(startTime);
//				vo.setEndTime(endTime);
//				vo.setAddress(temp6);
//				vo.setPicture(picture);
				
//				測試
//				List<ActivityVO> result = service.select(vo);
//				request.setAttribute("no", result);
//				request.getRequestDispatcher("/exam.jsp").forward(request,response);
				
//				圖片測試
//				List<ActivityVO> result= service.select(vo);
//				System.out.println(result);
//				List<ActivityVO> ss=service.base(result);
//				System.out.println(ss);
//				request.setAttribute("menu", ss);
				
//				模糊收索
////				List<ActivityVO> result = service.select(vo);	
//				
//				List<ActivityVO> ss=service.findBySname(temp6);
//				request.setAttribute("aa",ss);
				
				//about帶過來的PK no
				ExamVO selectByPrimaryKey=service.selectByPrimaryKey(no);
				request.setAttribute("selectByPrimaryKey",selectByPrimaryKey);
				
//System.out.println(selectByPrimaryKey.getAddress());				
				

				
				
				RequestDispatcher rd = request.getRequestDispatcher("/backend/examupdate.jsp");
				rd.forward(request, response);		
//				
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
