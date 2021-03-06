package filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

/**
 * Servlet Filter implementation class Login
 */
@WebFilter(
urlPatterns = { "/UpdateServlet.controller",
		"/diaryIndex.controller","/reflectdiary.controller","/backend/*" }
		)
public class LoginFilter implements Filter {
	@Override
	public void destroy() {

	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		HttpSession session = request.getSession();
		MemberVO bean = (MemberVO) session.getAttribute("user");
		if(bean!=null) {
			chain.doFilter(request, response);
		} else {
			String uri=null;
			if(request.getQueryString()!=null){
				uri = request.getRequestURI()+"?"+request.getQueryString();
			}else{
				uri = request.getRequestURI();
			}
			session.setAttribute("dest", uri);
			String path = request.getContextPath();
			response.sendRedirect(path+"/login.jsp");
			
		}
	}

	private FilterConfig config;
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
}
