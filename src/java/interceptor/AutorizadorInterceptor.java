/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.portlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Aluno
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter{    
    
    public boolean preHandle(HttpServletRequest request, 
            HttpServletResponse response,
            Object controller) throws Exception {
        
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();

        if( uri.endsWith(contextPath) 
            || uri.contains("index")
            || uri.contains("formLogin")
            || uri.contains("efetuaLogin")
            || uri.contains("listaTarefas")
            || uri.contains("resources")){
            return true;
        }
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("usuarioLogado") != null) {
            return true;
        }
        
        response.sendRedirect("formLogin");
        
        return false;
    }
  
            
}
