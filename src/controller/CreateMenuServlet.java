package controller;

import hibernate.util.HibernateUtil;
import init.MyServletFileUpload;
import init.GlobalService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.hibernate.Query;
import org.hibernate.Session;

import register.model.MemberVO;
import calories.model.FoodCalVO;
import calories.model.MenuVO;
import food.recipes.model.CookVO;
import food.recipes.model.CreateMenuService;
import food.recipes.model.FoodItemVO;
import food.recipes.model.FoodListVO;

/**
 * Servlet implementation class CreateMenuServlet
 */
@WebServlet("/backend/CreateMenuServlet.controller")
public class CreateMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CreateMenuService service;

	@Override
	public void init() throws ServletException {
		service = new CreateMenuService();
	}
    public CreateMenuServlet() {
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
		}
		
		ByteArrayOutputStream fileBufferBig = MyServletFileUpload.getFileOutputStream(fileItemMap.get("PictureBig"));
		ByteArrayOutputStream fileBufferSmall = MyServletFileUpload.getFileOutputStream(fileItemMap.get("PictureSmall"));
		String foodname = fileItemMap.get("foodname").getString("utf-8");
		String collection = fileItemMap.get("collection").getString("utf-8");
		String cal = fileItemMap.get("cal").getString("utf-8");
		String count = fileItemMap.get("count").getString("utf-8");
		String weight = fileItemMap.get("weight").getString("utf-8");
		String itemname1 = fileItemMap.get("itemname1").getString("utf-8");
		String itemclass1 = fileItemMap.get("itemclass1").getString("utf-8");
		String itemweight1 = fileItemMap.get("itemweight1").getString("utf-8");
		int itemCounts = Integer.parseInt(fileItemMap.get("itemCounts").getString());
		String way = fileItemMap.get("way").getString("utf-8");
		// 驗證資料
		
		if (foodname == null || foodname.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("foodname", "請輸入菜色名稱");
		}
		if(!cal.matches("[1-9]*[0-9]*")){
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("calvlaue", "請輸入合法數字值");
		}
		if (cal == null || cal.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("cal", "請輸入熱量值");
		}
		if (count == null || count.length() == 0) {
			errors.put("count", "請輸入份量單位");
		}if(!weight.matches("[1-9]*[0-9]*")){
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("weightvlaue", "請輸入合法數字值");
		}
		if (weight == null || weight.length() == 0) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("weight", "請輸入每份公克數");
		}
//		if (itemname1 == null || itemname1.length() == 0) {
//			errors.put("itemname", "請輸入食材名稱");
//		}
//		if ( itemclass1 == null || itemclass1.length() == 0) {
//			errors.put("", "請輸入食材類型");
//		}
//		if (itemweight1 == null || itemweight1.length() == 0) {
//			errors.put("itemweight", "請輸入食材份量");
//		}
//		if ( way == null || way.length() == 0) {
//			errors.put("way", "請輸入做法");
//		}
		if (errors != null && !errors.isEmpty()) {
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("wrong", "格式錯誤請，請重新輸入");
			request.getRequestDispatcher("/backend/foodCalInsert.jsp")
					.forward(request, response);
			return;
		}

		// 呼叫model
		CookVO  bean1=new CookVO();
		FoodItemVO bean2=new FoodItemVO();
		FoodListVO bean3=new FoodListVO();
		FoodCalVO bean4=new FoodCalVO();
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			bean1.setWayNo(way);
			bean1.setPicture(fileBufferBig.toByteArray());
			session.saveOrUpdate(bean1);
			
			String itemname = "";
			String itemclass = "";
			String itemweight = "";
			for(int i=1; i<=itemCounts; i++){
				bean2=new FoodItemVO();
				bean3=new FoodListVO();
				
				itemname = fileItemMap.get("itemname"+i).getString("utf-8");
				itemclass = fileItemMap.get("itemclass"+i).getString("utf-8");
				itemweight = fileItemMap.get("itemweight"+i).getString("utf-8");
				bean2.setName(itemname);
				bean2.setType(itemclass);
				bean2.setCount(itemweight);
				session.saveOrUpdate(bean2);
				
				bean3.setCookNo(bean1.getCookNo());
				bean3.setUseFoodNo(bean2.getUseFoodNo());
				session.saveOrUpdate(bean3);
			}
			
			bean4.setName(foodname);
			bean4.setMenuNo(GlobalService.convertInt(collection));
			bean4.setCal(GlobalService.convertInt(cal));
			bean4.setCount(count);
			bean4.setWeight(GlobalService.convertInt(weight));
			bean4.setCookNo(bean1.getCookNo());
			bean4.setPicture(fileBufferSmall.toByteArray());
			session.saveOrUpdate(bean4);
			session.getTransaction().commit();
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("success", "新增成功");
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			errors.put("open","$(\"#dialog\").dialog(\"open\");");
			errors.put("file", "新增失敗");
		}
//		String path = request.getContextPath();
//		response.sendRedirect(path + "/backend/foodCalInsert.jsp");
		request.getRequestDispatcher("/backend/foodCalInsert.jsp").forward(request,
				response);
		
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
