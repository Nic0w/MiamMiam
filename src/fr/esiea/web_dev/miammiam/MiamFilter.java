package fr.esiea.web_dev.miammiam;

import java.io.IOException;

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
	
    /**
     * Default constructor. 
     */
    public MiamFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	private String getAction(String requestedURI) {
		
		return requestedURI.replace(this.contextPath+"/", "");
		
	}
	
	
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		
		
		if(req.getRequestURI().contains("/MiamServlet"))
			chain.doFilter(req, response);
		
		String action = this.getAction(req.getRequestURI()).toLowerCase();
		
		System.out.println("Action = " + action);
		System.out.println("Parameters = " + req.getQueryString());
		
		req.setAttribute(action, null);
		
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
