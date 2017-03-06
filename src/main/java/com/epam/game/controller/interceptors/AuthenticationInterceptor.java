package com.epam.game.controller.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.epam.game.constants.AttributesEnum;
import com.epam.game.constants.ViewsEnum;
import com.epam.game.domain.Client;
import com.epam.game.utils.SessionUtils;

/**
 * Interceptor for authentication of user.
 * 
 * @author Roman_Spiridonov
 * 
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        Client client = SessionUtils.getClient(request);
        String contextPath = request.getContextPath();
        String requestPath = request.getRequestURL().toString();
        if (!request.getRequestURI().equals(contextPath + "/")
                && !isPublicPage(requestPath)
                && (client == null || client.getId() == null) ) {
            response.sendRedirect(contextPath + "/");
            return false;
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    private boolean isPublicPage(String pagePath) {
        String[] pathParts = pagePath.split("/");
        if (pathParts.length > 0) {
            String pageName = pathParts[pathParts.length - 1];
            if (ViewsEnum.isPublicPage(pageName)) {
                return true;
            }
        }
        return false;
    }
}
