package controller;

import init.GlobalService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import school.model.ExamService;



@WebServlet(
		urlPatterns={"/examsession.controller"}
		)
public class ExamsessionServlet extends HttpServlet {
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
		String temp7 = request.getParameter("ans");
		System.out.println("temp7"+":"+temp7);
		
		//驗證資料
//		Map<String, String> errors = new HashMap<String, String>();
//		request.setAttribute("error", errors);
//		
//		if(Cookion!=null) {
//			if(Cookion.equals("Insert") || Cookion.equals("Update") || Cookion.equals("Delete")) {
//				if(temp1==null || temp1.length()==0) {
//					errors.put("no", "Please enter no for "+Cookion);
//				}
//			}
//		}
		//轉換資料
		int sess = 0;
		if(temp7!=null && temp7.length()!=0) {
			sess = GlobalService.convertInt(temp7);
		}
		
		
		HttpSession session = request.getSession();
		Integer gread = (Integer)session.getAttribute("gread");
		if(gread==null){
			gread = 0;
		}		
		if(sess==10){
			gread=gread+10;
		}else{
			gread=gread+0;
		}
		System.out.println(gread);

		
		Integer combol = (Integer)session.getAttribute("combol");
		if(combol==null){
			combol = 1;
		}
		if(sess==10 || sess==0){
			combol=combol+1;
		}
		session.setAttribute("combol", combol);
		System.out.println(combol);
		session.removeAttribute("gread");
		session.setAttribute("gread", gread);
		if(combol==1){
			response.sendRedirect(request.getContextPath()+"/exam.controller?pageNo=1");
			return;
		}else if(combol==2){
			response.sendRedirect(request.getContextPath()+"/exam.controller?pageNo=2");
			return;
		}
		else if(combol==3){
			response.sendRedirect(request.getContextPath()+"/exam.controller?pageNo=3");
			return;
		}else if(combol==4){
			response.sendRedirect(request.getContextPath()+"/exam.controller?pageNo=4");
			return;
		}else if(combol==5){
			response.sendRedirect(request.getContextPath()+"/exam.controller?pageNo=5");
			return;
		}else if(combol==6){
			response.sendRedirect(request.getContextPath()+"/exam.controller?pageNo=6");
			return;
		}else if(combol==7){
			response.sendRedirect(request.getContextPath()+"/exam.controller?pageNo=7");
			return;
		}else if(combol==8){
			response.sendRedirect(request.getContextPath()+"/exam.controller?pageNo=8");
			return;
		}else if(combol==9){
			response.sendRedirect(request.getContextPath()+"/exam.controller?pageNo=9");
			return;
		}else if(combol==10){
			session.removeAttribute("combol");
			request.setAttribute("a", session.getAttribute("gread"));
			session.removeAttribute("gread");
			request.getRequestDispatcher("/gread.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/gread.jsp");
			return;
		}
//		else{
//			RequestDispatcher rd = request.getRequestDispatcher("/exam.jsp");
//			rd.forward(request, response);	
//		}
						
	}



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
		

		
		
		
//		String path = request.getContextPath();
//		response.sendRedirect(path+"/index.jsp");
		

	
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}
}
