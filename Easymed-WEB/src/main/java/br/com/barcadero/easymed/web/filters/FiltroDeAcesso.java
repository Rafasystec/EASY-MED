package br.com.barcadero.easymed.web.filters;

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

import br.com.barcadero.easymed.core.tables.Usuario;
import br.com.barcadero.web.util.Attributs;

/**
 * Este filtro é uma outra maneira de implementar controle de sessao com usuario.
 * @author Rafael Rocha
 * Criado dia 29/11/2013 as 18:28
 */
@WebFilter(urlPatterns={"/private/*","/client/*","/admin/*"})
public class FiltroDeAcesso implements Filter{

	private HttpServletRequest req 		= null;
	private HttpServletResponse resp 	= null;
	private HttpSession session	   		= null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,	FilterChain chain) throws IOException, ServletException {
		try {
			verifyNow(request, response, chain);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Verifica as credenciais.
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	public void verifyNow(ServletRequest request, ServletResponse response,	FilterChain chain) throws IOException, ServletException {
		req     = (HttpServletRequest)request;
		session = req.getSession(false);
		Usuario usuario = null;
		if(session != null){
			if(session.getAttribute(Attributs.USER) != null){
				usuario = (Usuario)session.getAttribute(Attributs.USER);	
			}
			if(usuario == null){
				redirectToLogin(request, response);
			}else{
				chain.doFilter(request, response);
			}
		}else{
			redirectToLogin(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	private void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		String contextPath = ((HttpServletRequest) request).getContextPath();
		resp = (HttpServletResponse) response;
		resp.sendRedirect(contextPath + "/index.xhtml");
	}
	
}
