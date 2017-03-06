/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.game.controller.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.epam.game.constants.AttributesEnum;
import com.epam.game.constants.ViewsEnum;
import com.epam.game.domain.Authority;
import com.epam.game.domain.Client;
import javax.servlet.http.Cookie;

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
    public boolean preHandle( HttpServletRequest request,
                              HttpServletResponse response, Object handler ) throws Exception {
        HttpSession session = request.getSession( false );
        if ( request.isRequestedSessionIdFromCookie() ) {

            return super.preHandle( request, response, handler );
        }
        
        response.sendRedirect( request.getContextPath() + '/' + ViewsEnum.NO_COOKIE + ViewsEnum.EXTENSION );
        return false;
    }



    @Override
    public void postHandle( HttpServletRequest request,
                            HttpServletResponse response, Object handler,
                            ModelAndView modelAndView ) throws Exception {
        super.postHandle( request, response, handler, modelAndView );
    }



    @Override
    public void afterCompletion( HttpServletRequest request,
                                 HttpServletResponse response, Object handler, Exception ex )
            throws Exception {
        super.afterCompletion( request, response, handler, ex );
    }


}
