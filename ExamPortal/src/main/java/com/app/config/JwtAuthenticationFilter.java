package com.app.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.app.exception.CustomException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

	
//	response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"401 Unauthorized : Server");
		
		 System.out.println("\n=================================================================================================================\n"
		           + "         Message: 401 Unauthorized Request  \n"
		           + "==========================================================================================================================");
		

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getOutputStream().println("{\"a\":\"=================================================================================================\","
        		+ " \"Exception\": \"" + new CustomException("401 Unauthorized Request").getMessage() + "\" ,"
        		+ "\"b\":\"==============================================================================================================\"}");

}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
