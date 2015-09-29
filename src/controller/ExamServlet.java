package controller;

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
import javax.servlet.http.HttpSession;

import school.model.ExamService;
import school.model.ExamVO;
import school.model.PageExamVO;

@WebServlet(
		urlPatterns={"/exam.controller"}
		)
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExamService service;
	@Override
	public void init() throws ServletException {
		service = new ExamService();
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//接收資料
//		String temp1 = request.getParameter("no");
//		String temp2 = request.getParameter("content");
//		String temp3 = request.getParameter("correct");
//		String temp4 = request.getParameter("optA");
//		String temp5 = request.getParameter("optB");
//		String temp6 = request.getParameter("optC");
//		String Cookion = request.getParameter("Cookion");
//		String temp7 = request.getParameter("ans");
//		System.out.println("temp7"+":"+temp7);
		String pageNoTemp = request.getParameter("pageNo");
		
		//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
//		
//		if(Cookion!=null) {
//			if(Cookion.equals("Insert") || Cookion.equals("Update") || Cookion.equals("Delete")) {
//				if(temp1==null || temp1.length()==0) {
//					errors.put("no", "Please enter no for "+Cookion);
//				}
//			}
//		}
		//轉換資料
		int pageNo = 0;
		if(pageNoTemp!=null && pageNoTemp.length()!=0) {
			pageNo = GlobalService.convertInt(pageNoTemp);
			if(pageNo==-1000) {
				errors.put("pageNo", "pageNo must be an integer");
			}
		}
//		int sess = 0;
//		if(temp7!=null && temp7.length()!=0) {
//			sess = GlobalService.convertInt(temp7);
//			if(ans==-1000) {
//				errors.put("no", "no must be an integer");
//			}
//		}
		
		
//		HttpSession session = request.getSession();
//		Integer gread = (Integer)session.getAttribute("gread");
//		if(gread==null){
//			gread = 0;
//		}		
//		if(sess==10){
//			gread=gread+10;
//		}else{
//			gread=gread+0;
//		}
//		System.out.println(gread);
//
//		
//		Integer combol = (Integer)session.getAttribute("combol");
//		if(combol==null){
//			combol = 0;
//		}
//		if(sess==10 || sess==0){
//			combol=combol+1;
//		}
//		System.out.println(combol);
//		session.removeAttribute("combol");
//		session.setAttribute("combol", combol);
//		
//		session.removeAttribute("gread");
//		session.setAttribute("gread", gread);
//		
//		if(combol==10){
//			RequestDispatcher rd = request.getRequestDispatcher("/gread.jsp");
//			rd.forward(request, response);	
//		}



//
//		if(errors!=null && !errors.isEmpty()) {
//			request.getRequestDispatcher(
//					"/pages/product.jsp").forward(request, response);
//			return;
//		}
		
		//呼叫model
//		ExamVO vo = new ExamVO();
//		vo.setNo(no);
//		vo.setContent(temp2);
//		vo.setCorrect(temp3);
//		vo.setOptA(temp4);
//		vo.setOptA(temp5);
//		vo.setOptA(temp6);
		
		
		//根據Model執行結果導向View
//		if(prodaction!=null && prodaction.equals("Select")) {
//		List<ProductBean> result = service.select(bean);
//		request.setAttribute("select", result);
//		request.getRequestDispatcher("/pages/display.jsp").forward(request, response);
//				}
//		List<ExamVO> result = service.select(vo);
//		request.setAttribute("no", result);
//		request.getRequestDispatcher("/exam.jsp").forward(request,response);
		
		//換頁所呼叫的Service
		PageExamVO PageExamVO = service.getDatePage(pageNo, 1);	

//		PageExamVO.setExampage(PageExamVO.getExampage());
		
//		List<FoodCalVO> result = service.base(service.select(vo));
		
		
//		request.setAttribute("foodNo", result);
		request.setAttribute("PageExamVO", PageExamVO);
		request.getRequestDispatcher("/exam.jsp").forward(request, response);
		
		
		
//		List<ExamVO> selcetall=service.selcetall();
//		request.setAttribute("selcetall",selcetall);
		
//		String path = request.getContextPath();
//		response.sendRedirect(path+"/index.jsp");
		
//		RequestDispatcher rd = request.getRequestDispatcher("/exam.jsp");
//		rd.forward(request, response);					
	}
	
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}
}
