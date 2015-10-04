package controller;

import init.GlobalService;
import init.MyServletFileUpload;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

import school.model.ExamService;
import school.model.ExamVO;

/**
 * Servlet implementation class CreateMenuServlet
 */
@WebServlet("/backend/examupdateservlet.controller2")
public class ExamUpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExamService service;

	@Override
	public void init() throws ServletException {
		service = new ExamService();
	}
    public ExamUpdateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		// 接收資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		Map<String, FileItem> fileItemMap = null;
		
		try {
			fileItemMap = MyServletFileUpload.fileUpload(request, response);
		}
		catch (IOException ioe) {
			errors.put("wrongFileType", "圖片檔案格式錯誤");
		}
		catch (FileUploadException e){
//			System.out.println(e);
		}
		
		String content = fileItemMap.get("content").getString("utf-8");
		String correct = fileItemMap.get("correct").getString("utf-8");
		String optA = fileItemMap.get("optA").getString("utf-8");
		String optB = fileItemMap.get("optB").getString("utf-8");
		String optC = fileItemMap.get("optC").getString("utf-8");
		String no = fileItemMap.get("no").getString("utf-8");;
		// 驗證資料
		if (no == null || no.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("no", "請輸入選項C");
		}
		
		if (optC == null || optC.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("optC", "請輸入");
		}
		if (optB == null || optB.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("optB", "請輸入選項B");
		}
		if (optA == null || optA.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("optA", "請輸入選項A");
		}
		if (correct == null || correct.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("correct", "請輸入正確選項");
		}
		if (content == null || content.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("content", "請輸入題目內容");
		}
		if (errors != null && !errors.isEmpty()) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("wrong", "格式錯誤請，請重新輸入");
			request.getRequestDispatcher("/backend/foodCalInsert.jsp")
					.forward(request, response);
			return;
		}
		//轉換
		int No = 0;
		if(no!=null && no.length()!=0) {
			No = GlobalService.convertInt(no);
			if(No==-1000) {
				errors.put("No", "No must be an integer");
			}
		}
		
		// 呼叫model
		ExamVO  examvo=new ExamVO();
		examvo.setContent(content);
		examvo.setCorrect(correct);
		examvo.setOptA(optA);
		examvo.setOptB(optB);
		examvo.setOptC(optC);
		examvo.setNo(No);
		service.update(examvo);
//		if(activityvo!=null){
			request.getRequestDispatcher("/backend/examsuccess.jsp").forward(request,
					response);
//		}else{
//			request.getRequestDispatcher("/backend/fail.jsp").forward(request,
//					response);
//		}
		
		
//		MemberVO bean = service.login(username, password);
//		System.out.println(bean);
//		// 根據model執行結果，導向view
//		if (bean == null) {
//			errors.put("open", "$(\"#dialog0\").dialog(\"open\");");
//			errors.put("er1", "無此帳號密碼，請重新輸入");
//			request.getRequestDispatcher("/login.jsp").forward(request,
//					response);
//		} else {
//			if (bean.getPurview() == 800) {
//				errors.put("open", "$(\"#dialog0\").dialog(\"open\");");
//				errors.put("stop", "您已經被停權，請E-mail到本網站，我們將盡快您處理");
//				request.getRequestDispatcher("/login.jsp").forward(request,
//						response);
//			} else if (bean.getPurview() == 901) {
//				HttpSession session = request.getSession();
//				session.setAttribute("user", bean);
//				Map<String, String> success = new HashMap<String, String>();
//				session.setAttribute("suc", success);
//				success.put("update", "<a href='" + request.getContextPath()
//						+ "/updatemember.jsp'>修改管理者資料</a>");
//				success.put("out", "'<a href='" + request.getContextPath()
//						+ "/logout.controller'>登出</a>");
//				String path = request.getContextPath();
//				response.sendRedirect("http://tw.yahoo.com");//待改為URL============
//			} else {
//				errors.put("open", "$(\"#dialog0\").dialog(\"open\");");
//				errors.put("success1", "登入成功");
//				HttpSession session = request.getSession();
//				session.setAttribute("user", bean);
//				Map<String, String> success = new HashMap<String, String>();
//				session.setAttribute("suc", success);
//
//				success.put("update", "<a href='" + request.getContextPath()
//						+ "/updatemember.jsp'>修改會員資料</a>");
//				success.put("out", "'<a href='" + request.getContextPath()
//						+ "/logout.controller'>登出</a>");
//				String dest = (String) session.getAttribute("dest");
//				if (dest != null && dest.length() != 0) {
//					session.removeAttribute("dest");
//					response.sendRedirect(dest);
//				} else {
//					String path = request.getContextPath();
//					response.sendRedirect(path + "/index.jsp");
//				}
//			}
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	

}
