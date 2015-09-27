package controller;

import health.model.EatRecordVO;
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
import javax.servlet.http.HttpSession;

import register.model.MemberVO;
import calories.model.FoodCalVO;

@WebServlet("/foodCalSessionServlect")
public class FoodCalSessionServlect extends HttpServlet {
 
       
    public FoodCalSessionServlect() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		//接收資料
		String temp1 = request.getParameter("foodNo");
		String temp2 = request.getParameter("time");
		String temp3 = request.getParameter("count");
		String temp4 = request.getParameter("page");
		String temp5 = request.getParameter("cal");
		String temp6 = request.getParameter("name");
		String prodaction = request.getParameter("prodaction");
		
		
		//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		
//		if(prodaction!=null){
//			if(prodaction.equals("加入")){
//				if(temp3==null || temp3.length()==0){
//					errors.put("count", "count不能為空值");
//				}
//			}
//		}
		
		//轉換資料
		int foodNo = 0;
		if(temp1!=null && temp1.length()!=0) {
			foodNo = GlobalService.convertInt(temp1);
			if(foodNo==-1000) {
				errors.put("foodNo", "foodNo must be an integer");
			}
		}

		int page = 0;
		if(temp4!=null && temp4.length()!=0) {
			page = GlobalService.convertInt(temp4);
			if(page==-1000) {
				errors.put("page", "page must be an integer");
			}
		}
		int cal = 0;
		if(temp5!=null && temp5.length()!=0) {
			cal = GlobalService.convertInt(temp5);
			if(cal==-1000) {
				errors.put("cal", "cal must be an integer");
			}
		}

		int count=0;
		if(temp3!=null && temp3.length()!=0) {
			count = GlobalService.convertInt(temp3);
			if(count==-1000) {
				errors.put("count", "只能為數字");
			}
		}else if(temp3.isEmpty()){
			errors.put("count", "不能為空");
		}
		
		if(errors!=null && !errors.isEmpty() ){
			request.getRequestDispatcher("/foodCal.controller?pageNo="+page).forward(request, response);
			return;
		}
		
		//呼叫model
		FoodCalVO vo =new FoodCalVO();
		vo.setFoodNo(foodNo);
		vo.setName(temp6);
		vo.setCal(cal);
		
		EatRecordVO vo1 = new EatRecordVO();
		if(session.getAttribute("login").equals("600")){
			MemberVO bean =(MemberVO) session.getAttribute("user");
			vo1.setMemberNo(bean.getMemberNo());
			java.util.Date healthDate = (java.util.Date) session.getAttribute("healthDate");
			
			vo1.setDate(new java.sql.Date(healthDate.getTime()));
		}
		
//		vo1.setMemberNo(100004);
		vo1.setTime(temp2);
//		vo1.setDate("");
		vo1.setFoodCalVO(vo);
		vo1.setCount(count);
//		System.out.println(vo1);
		
		List<EatRecordVO> eatrsession = new ArrayList<EatRecordVO>();
		String eattime = "eatBreakfast";
		if(temp2.equals("午餐")){
			eattime = "eatLunch";
		}else if(temp2.equals("晚餐")){
			eattime = "eatDinner";
		}
		if(prodaction.equals("加入")){
			if(session.getAttribute(eattime)==null){
				eatrsession.add(vo1);
				session.setAttribute(eattime, eatrsession);
			}else{
				boolean voistrue =false;
				eatrsession = (List<EatRecordVO>) session.getAttribute(eattime);
				for(EatRecordVO vobr :eatrsession){
					if(vobr.getFoodCalVO().getFoodNo()==vo1.getFoodCalVO().getFoodNo()){
						vobr.setCount(vo1.getCount());
						voistrue = true;
						break;
					}
				}
				if(!voistrue){
					eatrsession.add(vo1);
				}
				session.setAttribute(eattime, eatrsession);
			}
		}else if(prodaction.equals("清除")){
			if(session.getAttribute(eattime)==null){
				errors.put("eatr",eattime + " not find, cat't del");
			}else{
				boolean voistrue =false;
				int listindex =0;
				eatrsession = (List<EatRecordVO>) session.getAttribute(eattime);
				for(EatRecordVO vobr :eatrsession){
					if(vobr.getFoodCalVO().getFoodNo()==vo1.getFoodCalVO().getFoodNo()){
					voistrue = true;
					break;
				}
				listindex++;
			}
			if(voistrue){
				eatrsession.remove(listindex);
			}else{
				errors.put("eatr",eattime + " not find, cat't del");
			}
			session.setAttribute(eattime, eatrsession);
		}
	
	}
	//根據Model執行結果導向View
	request.getRequestDispatcher(
			"/foodCal.controller?pageNo=1").forward(request, response);
		
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		super.doGet(request, response);
		this.doGet(request, response);
	}
}
