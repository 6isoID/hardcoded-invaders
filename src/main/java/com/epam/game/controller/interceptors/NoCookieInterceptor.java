/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.game.controller.interceptors;

import com.epam.game.constants.ViewsEnum;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergey_Fedorov
 */
public class NoCookieInterceptor extends HandlerInterceptorAdapter {

    private static int count = 0;

    public void displayHeaderInfo() {
        //...
    }



    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler ) throws Exception {
        HttpSession session = request.getSession( false );
        if ( request.isRequestedSessionIdFromCookie() ) {

            return super.preHandle( request, response, handler );
        }
        
        response.sendRedirect( request.getContextPath() + '/' + ViewsEnum.NO_COOKIE + ViewsEnum.EXTENSION );
        return false;
    }



    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView ) throws Exception {
        super.postHandle( request, response, handler, modelAndView );
    }



    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex )
            throws Exception {
        super.afterCompletion( request, response, handler, ex );
    }


}
