package controller;

import health.model.DiaryIndexService;
import health.model.HealthDiaryVO;
import init.GlobalService;

import java.io.IOException;
import java.sql.Date;
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

import ranking.model.HeroService;
import register.model.MemberVO;

@WebServlet("/diaryIndex.controller")
public class DiaryIndexServlet extends HttpServlet {
	private DiaryIndexService serviceDiary;
	private HeroService service;

	public void init() throws ServletException {
		serviceDiary = new DiaryIndexService();
		service = new HeroService();
	};

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HealthDiaryVO vo = new HealthDiaryVO();
		HttpSession session = request.getSession(); 					// 登入session

		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("errorMsg", errorMsg);
		// 接收資料
//		 String memberNo = request.getParameter("memberNo");

		MemberVO memberVO = (MemberVO) session.getAttribute("user");	// 登入session
		int memberNo = memberVO.getMemberNo();							//登入取得會員編號
		// String memberNo = "1000001";
		// System.out.println(memberNo);
		// 驗證資料
		if (memberVO.equals(null)) {									//驗證若未登入不能使用此功能
			response.sendRedirect("login.jsp");
		}
		String no = request.getParameter("no");

		if(no != null){
			HealthDiaryVO vo2 = new HealthDiaryVO();
			vo2.setNo(Integer.parseInt(no));
			vo2.setMemberNo(memberNo);
			vo2 = serviceDiary.selectByPrimaryKey(vo2);
			request.setAttribute("bean", vo2);
		}
		
		// ****************************************************************************//
		// 轉換資料
//		 int id = Integer.parseInt(memberNo);
		// 呼叫model
		vo.setMemberNo(memberNo);

		// ****************************************************************************//
//		List<HealthDiaryVO> list = service.selecthealth(vo.getMemberNo());
		List<HealthDiaryVO> list = service.selectMemberNo(vo.getMemberNo());
		request.setAttribute("list", list);
		System.out.println(list);
		RequestDispatcher rd = request.getRequestDispatcher("/healthDiary.jsp");
		rd.forward(request, response);
		return;
	}

}
// 聯合映射日誌join會員運動,會員飲食,join食物熱量表,運動熱量表
//查詢用表單