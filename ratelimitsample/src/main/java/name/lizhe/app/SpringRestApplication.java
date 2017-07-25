package name.lizhe.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import name.lizhe.filter.RateLimitFilter;  
  

  
@SpringBootApplication  
@ComponentScan("name.lizhe")
public class SpringRestApplication {  
  
    public static void main(String[] args) {  
        SpringApplication.run(SpringRestApplication.class, args);  
    }  
      
    @Bean  
    public FilterRegistrationBean  filterRegistrationBean() {  
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();  
        RateLimitFilter rateLimitFilter = new RateLimitFilter();  
        registrationBean.setFilter(rateLimitFilter);  
        List<String> urlPatterns = new ArrayList<String>();  
        urlPatterns.add("/ratelimit/*");  
        registrationBean.setUrlPatterns(urlPatterns);  
        return registrationBean;  
    }  
}  
