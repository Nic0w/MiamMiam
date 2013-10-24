package fr.esiea.web_dev.miammiam;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class MiamFilter
 */
@WebFilter("/MiamFilter")
public class MiamFilter implements Filter {
	
	private String contextPath;
	
	private List<String> ignoreList;
	
    /**
     * Default constructor. 
     */
    public MiamFilter() {
        
    	
    	this.ignoreList = Arrays.asList(new String[] {  "css", "img", "img2", "js" });
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	private String getAction(String requestedURI) {
		
		return requestedURI.replace(this.contextPath+"/", "");
		
	}
	
	
	private boolean ignoreRequest(String s) {
		
		for(String ignore : this.ignoreList)
			if(s.contains(ignore))
				return true;
		
		return false;
	}
	
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		
		if(ignoreRequest(req.getRequestURI())) {
			chain.doFilter(req, response);
			return;
		}
			
		
		String action = this.getAction(req.getRequestURI()).toLowerCase();
		
		System.out.println("Action = '" + action+ "' zzqrfggsdfgsdgdfgdfggdgdf");
		System.out.println("Parameters = " + req.getQueryString());
		
		/*if(action.equalsIgnoreCase("")) {
			System.out.println("redirecting to home");
			
			
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			return;
		}*/
		
		
		req.setAttribute("action", action);
		
		request.getRequestDispatcher("/MiamServlet").forward(request, response);
		
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		this.contextPath = fConfig.getServletContext().getContextPath();
		
	}

}
