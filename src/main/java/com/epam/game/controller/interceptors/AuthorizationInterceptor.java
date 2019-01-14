package com.epam.game.controller.interceptors;

import com.epam.game.constants.AttributesEnum;
import com.epam.game.controller.exceptions.ForbiddenException;
import com.epam.game.domain.Authority;
import com.epam.game.domain.Client;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Interceptor for user authorization
 * 
 * @author Roman_Spiridonov
 * 
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute(AttributesEnum.CLIENT);
        if (client == null
                || !client.hasAnyRole(Authority.ROLE_ADMIN.toString())) {
            throw new ForbiddenException();
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
}
