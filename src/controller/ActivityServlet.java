package controller;

import init.GlobalService;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

import news.model.ActivityService;
import news.model.ActivityVO;
import news.model.PagesActivityVO;

/**
 * Servlet implementation class ActivityServlet
 */
@WebServlet(
		urlPatterns={"/activity.controller"}
		)
public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ActivityService service;
	@Override
	public void init() throws ServletException {
		service = new ActivityService();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//接收資料
//				String temp1 = request.getParameter("no");
				String temp2 = request.getParameter("name");
//				String temp3 = request.getParameter("content");
//				String temp4 = request.getParameter("startTime");
//				String temp5 = request.getParameter("endTime");
//				String temp6 = request.getParameter("address");
//				String temp7 = request.getParameter("picture");
//				String temp8 = request.getParameter("url");
//				String temp9 = request.getParameter("boss");
//				String Cookion = request.getParameter("Cookion");
				String pageNoTemp = request.getParameter("pageNo");
//				System.out.print("PageNo"+":"+pageNoTemp);
		
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
		//轉換資料
//				int no = 0;
//				if(temp1!=null && temp1.length()!=0) {
//					no = GlobalService.convertInt(temp1);
//					if(no==-1000) {
//						errors.put("no", "no must be an integer");
//					}
//				}
				int pageNo = 0;
				if(pageNoTemp!=null && pageNoTemp.length()!=0) {
					pageNo = GlobalService.convertInt(pageNoTemp);
					if(pageNo==-1000) {
						errors.put("pageNo", "pageNo must be an integer");
					}
				}
//				
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


//selectall
				List<ActivityVO> selectallvo=service.selcetall();
				
		
//endtime部分
//					List<java.sql.Timestamp> selectallvo1=service.sawendtime();						
//					request.setAttribute("sawendtime", selectallvo1);
//					String endttime = null;														//1
//					List<String> listTemp=new ArrayList<String>();									//2弄成list    才能jsp一一列出
//					for(java.sql.Timestamp element : selectallvo1) {				   				//Timestamp轉int
//						SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");//201509180851
//						endttime = df.format(element);												//1
//						listTemp.add(endttime);													//2
//					}			
//				request.setAttribute("endtime", listTemp);
				
				//address截字部分
//				List<String> selectallvo11=service.sawaddress();						
//				request.setAttribute("sawaddress", selectallvo11);
//				String endttime1 = null;														
//				List<String> listTemp1=new ArrayList<String>();									
//					for(String element : selectallvo11) {				   				
//						String threeaddress = element.substring(0,3);
//						listTemp1.add(threeaddress);													
//					}			
				//System.out.println(listTemp1);
//				request.setAttribute("threeaddress", listTemp1);
				
//getDateTime部分
				String getDateTime=service.getDateTime();
				
//page
				PagesActivityVO PagesActivityVO = service.getDatePage(pageNo, 7);
				PagesActivityVO.setActivitypage(service.base(PagesActivityVO.getActivitypage()));
				
				
//findBySname
				if(temp2 == null){
					List<ActivityVO> temp = new ArrayList<ActivityVO>();
					temp=null;
					request.setAttribute("temp", temp);
				}else{
					List<ActivityVO> findBySname=service.findBySname(temp2);				
					List<ActivityVO> temp = new ArrayList<ActivityVO>();
					for(ActivityVO vo:findBySname){
						ActivityVO tempVo = new ActivityVO();
						SimpleDateFormat dd = new SimpleDateFormat("yyyyMMddHHmm");
						tempVo.setNo(vo.getNo());
						tempVo.setContent(vo.getContent());;
						tempVo.setAddress(vo.getAddress());
						tempVo.setEndTime1(dd.format(vo.getEndTime()));
						tempVo.setName(vo.getName());
						tempVo.setEndTime(vo.getEndTime());
						tempVo.setStartTime(vo.getStartTime());
						tempVo.setPicture1(vo.getPicture1());
						tempVo.setUrl(vo.getUrl());
						tempVo.setBoss(vo.getBoss());
						temp.add(tempVo);
//						System.out.println(vo.getAddress());
						//模糊收索截字 address  轉圖&3 address
						request.setAttribute("findBySname", temp);
					}
				}
				
				

				//getdatetime部分 
				request.setAttribute("getDateTime", getDateTime);
				//selectall部分   轉圖&40 content
				request.setAttribute("selectallvo",selectallvo);
				//page
				request.setAttribute("PagesActivityVO", PagesActivityVO);
				RequestDispatcher rd = request.getRequestDispatcher("/activity1.jsp");
				rd.forward(request, response);								
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
