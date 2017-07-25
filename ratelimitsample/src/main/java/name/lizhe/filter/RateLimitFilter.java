package name.lizhe.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimitFilter implements Filter{
	
	private RateLimiter limiter = null;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        System.out.println("doFilter ... ");
        
        if(limiter.tryAcquire()) {
             System.out.println("Accessed sucessfully");
             chain.doFilter(request, response);
        } else {
        	System.out.println("Accessed Failed");
             req.getRequestDispatcher("/myerrorjsp").forward(req,res);
        }
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		limiter = RateLimiter.create(1); //10 request per second
	}

}
