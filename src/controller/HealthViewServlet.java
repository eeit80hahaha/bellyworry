package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fun.model.HealthViewService;
import fun.model.HealthViewVO;
import fun.model.ViewClassService;
import fun.model.ViewClassVO;
import init.GlobalService;

@WebServlet("/healthView.controller")
public class HealthViewServlet extends HttpServlet {
	private HealthViewService service;
	private ViewClassService viewService;
	@Override
	public void init() throws ServletException {
		service = new HealthViewService();
		viewService = new ViewClassService();
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
		// 接收資料
		String temp1 = request.getParameter("no");
		String name = request.getParameter("name");
		String temp2 = request.getParameter("viewClassNo");
		String temp3 = request.getParameter("lat");
		String temp4 = request.getParameter("lng");
		String prodaction = request.getParameter("prodaction");

		// 驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);
		
		if(prodaction!=null) {
//			if(prodaction.equals("Insert")){
//				if(temp1.length()!=0) {
//					errors.put("no", "新增景點不需填寫編號 ");
//				}
//			}
			if(prodaction.equals("Update") || prodaction.equals("Delete")) {
				if(temp1==null || temp1.length()==0) {
					errors.put("no", "修改與刪除操作，請輸入景點編號！");
				}
			}
			if(prodaction.equals("Insert") || prodaction.equals("Update")) {
				if(name==null || name.length()==0) {
					errors.put("name", "進行 新增 修改 時，名稱為必填欄位");
				}
				if(temp2==null || temp2.length()==0) {
					errors.put("viewClassNo", "進行 新增 修改 時，請選擇景點類別");
				}
				if(temp3==null || temp3.length()==0) {
					errors.put("lat", "進行 新增 修改 時，緯度為必填欄位");
				}
				if(temp4==null || temp4.length()==0) {
					errors.put("lng", "進行 新增 修改 時，經度為必填欄位");
				}
			}
		}
		
		//轉換資料
		int no=0;
		if(!prodaction.equals("Insert")){
			if(temp1!=null && temp1.length()!=0) {
				no = GlobalService.convertInt(temp1);
				if(no==-1000) {
					errors.put("no", "編號必須為整數型態");
				}
			}
		}
		int viewClassNo=0;
		if(temp2!=null && temp2.length()!=0) {
			viewClassNo = GlobalService.convertInt(temp2);
			if(viewClassNo==-1000) {
				errors.put("viewClassNo", "景點類型必須為整數型態");
			}
		}
		double lat=0;
		if(temp3!=null && temp3.length()!=0) {
			lat = GlobalService.convertDouble(temp3);
			if(lat==-1000) {
				errors.put("lat", "緯度必須為數值型態");
			}
		}
		double lng=0;
		if(temp4!=null && temp4.length()!=0) {
			lng = GlobalService.convertDouble(temp4);
			if(lng==-1000) {
				errors.put("lng", "經度必須為數值型態");
			}
		}
		if(errors!=null && !errors.isEmpty()) {
			if(prodaction!=null && prodaction.equals("Insert")){
				request.getRequestDispatcher(
						"/backend/healthViewInsert.jsp").forward(request, response);
			return;	
			}else{
				request.getRequestDispatcher(
						"/healthViewCRUD.jsp").forward(request, response);
				return;
			}
		}

		// 呼叫model
		HealthViewVO vo = new HealthViewVO();
		vo.setNo(no);
		vo.setName(name);
		ViewClassVO viewClassVO= viewService.getViewClass(viewClassNo);
		vo.setViewClassVO(viewClassVO);
		vo.setLat((float)lat);
		vo.setLng((float)lng);

		// 根據model執行結果，導向view
		if(prodaction!=null && prodaction.equals("Select")) {
			List<HealthViewVO> result = service.select(vo);
			request.setAttribute("select", result);
			request.getRequestDispatcher(
					"/healthViewDisplay.jsp").forward(request, response);
		} else if(prodaction!=null && prodaction.equals("Insert")) {
			HealthViewVO result = null;
			int temp = service.insert(vo);
			if(temp>0){
				result = service.selectByPrimaryKey(temp);
				request.setAttribute("insert", result);
			}else{
				errors.put("action", "新增失敗");
			}
			request.getRequestDispatcher(
					"/backend/healthViewInsert.jsp").forward(request, response);
//		"/healthViewCRUD.jsp").include(request, response);
		} else if(prodaction!=null && prodaction.equals("Update")) {
			HealthViewVO result = null;
			int temp = service.update(vo);
			if(temp>0){
				result = service.selectByPrimaryKey(vo.getNo());
				request.setAttribute("update", result);
			}else{
				errors.put("action", "修改失敗");
			}
//			response.sendRedirect("/bellyworry/viewClass.controller");
			
			request.getRequestDispatcher(
					"/healthViewCRUD.jsp").forward(request, response);
		} else if(prodaction!=null && prodaction.equals("Delete")) {
			boolean result = service.delete(vo.getNo());
			if(!result) {
				request.setAttribute("delete", 0);
			} else {
				request.setAttribute("delete", 1);
			}
			request.getRequestDispatcher(
					"/healthViewCRUD.jsp").forward(request, response);
		} else  {
			errors.put("action", "未知的操作:"+prodaction);
			request.getRequestDispatcher(
					"/healthViewCRUD.jsp").forward(request, response);
		}
	}

}
