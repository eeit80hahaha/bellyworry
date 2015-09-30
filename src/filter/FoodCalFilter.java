package filter;

import health.model.EatRecordService;
import health.model.HealthDiaryService;
import health.model.HealthDiaryVO;
import init.GlobalService;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import register.model.MemberVO;

@WebFilter(
		urlPatterns = {"/foodCal.controller"}
)
public class FoodCalFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		HttpSession session = request.getSession(); //產生session
		
//		String dayno = request.getParameter("no");
//		System.out.println(dayno);
		
//		int no = GlobalService.convertInt(dayno);
		

		MemberVO bean = (MemberVO) session.getAttribute("user"); 
		if(bean!=null){
			
//			HealthDiaryService hdS= new HealthDiaryService();
//			HealthDiaryVO hdVO =  hdS.selectByPrimaryKey(no);
//			System.out.println(hdVO.getDate());
//			if(hdVO!=null){
//				session.setAttribute("healthDate", hdVO.getDate());
//			}
			
			
			if(((java.util.Date) session.getAttribute("healthDate"))==null){
				
				session.setAttribute("healthDate", new java.util.Date());
				
			}
			String[] eattime = {"早上","中午","晚上"};
			String[] eatsession = {"eatBreakfast","eatLunch","eatDinner"};
			java.util.Date healthDate = (java.util.Date) session.getAttribute("healthDate");
			
			EatRecordService ers = new EatRecordService();
			
			for(int i=0;i<=2;i++){
				if(session.getAttribute(eatsession[i]) == null ){
					
				session.setAttribute(eatsession[i] ,
						ers.getEatrmdt(bean.getMemberNo(),healthDate,eattime[i]));
				
				}
			}
			
			session.setAttribute("login", "600");
			chain.doFilter(request, response);
		}else{
			session.setAttribute("login", "601");
			chain.doFilter(request, response);
		}
	}
	private FilterConfig config;
	@Override
	public void init(FilterConfig config) throws ServletException { //初始化
		this.config = config;
	}

}
