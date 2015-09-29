package filter;

import health.model.EatRecordService;

import java.io.IOException;

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
		MemberVO bean = (MemberVO) session.getAttribute("user"); 
		if(bean!=null){
			
			if(((java.util.Date) session.getAttribute("healthDate"))==null){
				
				session.setAttribute("healthDate", new java.util.Date());
				
			}
			String[] eattime = {"早上","中午","晚上"};
			String[] eatsession = {"eatBreakfast","eatLunch","eatDinner"};
			java.util.Date healthDate = (java.util.Date) session.getAttribute("healthDate");
			
			EatRecordService ers = new EatRecordService();
			
			for(int i=0;i<=2;i++){
				session.setAttribute(eatsession[i] ,
						ers.getEatrmdt(bean.getMemberNo(),healthDate,eattime[i]));
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
