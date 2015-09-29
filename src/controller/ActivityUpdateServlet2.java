package controller;

import init.GlobalService;
import init.MyServletFileUpload;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import news.model.ActivityService;
import news.model.ActivityVO;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

/**
 * Servlet implementation class CreateMenuServlet
 */
@WebServlet("/backend/activityupdateservlet.controller2")
public class ActivityUpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActivityService service;

	@Override
	public void init() throws ServletException {
		service = new ActivityService();
	}
    public ActivityUpdateServlet2() {
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
			System.out.println(e);
		}
		
		ByteArrayOutputStream fileBufferBig = MyServletFileUpload.getFileOutputStream(fileItemMap.get("PictureBig"));
		String activityname = fileItemMap.get("activityname").getString("utf-8");
		String startTime = fileItemMap.get("startTime").getString("utf-8");
		String endTime = fileItemMap.get("endTime").getString("utf-8");
		String address = fileItemMap.get("address").getString("utf-8");
		String url = fileItemMap.get("url").getString("utf-8");
		String boss = fileItemMap.get("boss").getString("utf-8");
		String content = fileItemMap.get("content").getString("utf-8");
		String no = fileItemMap.get("no").getString("utf-8");;
		// 驗證資料
		if (no == null || no.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("no", "請輸入活動no");
		}
		
		if (activityname == null || activityname.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("activityname", "請輸入活動名稱");
		}
		if (startTime == null || startTime.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("startTime", "請輸入活動開始名稱");
		}
		if (endTime == null || endTime.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("endTime", "請輸入活動結束名稱");
		}
		if (address == null || address.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("address", "請輸入活動地點");
		}
		if (url == null || url.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("url", "請輸入活動地點");
		}
		if (boss == null || boss.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("boss", "請輸入主辦廠商");
		}
		if (fileBufferBig == null) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("PictureBig", "請輸入活動圖片");
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
		
		Date start = GlobalService.convertTime(startTime);
		Date end = GlobalService.convertTime(endTime);
		
		// 呼叫model
		ActivityVO  activityvo=new ActivityVO();
		activityvo.setName(activityname);
		activityvo.setStartTime(start);
		activityvo.setEndTime(end);
		activityvo.setAddress(address);
		activityvo.setUrl(url);
		activityvo.setBoss(boss);
		activityvo.setPicture(fileBufferBig.toByteArray());	
		activityvo.setContent(content);
		activityvo.setNo(No);
		service.update(activityvo);
//		if(activityvo!=null){
			request.getRequestDispatcher("/backend/success.jsp").forward(request,
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
