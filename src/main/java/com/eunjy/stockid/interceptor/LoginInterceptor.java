package com.eunjy.stockid.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.eunjy.stockid.domain.common.SessionUser;
import com.eunjy.stockid.utiliy.Consts;

import lombok.extern.slf4j.Slf4j;

/**
 * @author YunJi
 * 로그인 인터셉터
 */
@Slf4j
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.debug("==================== BEGIN ====================");
		log.debug("Request URI ===> " + request.getRequestURI());

		HttpSession httpSession = request.getSession();
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);
		
		if (sessionUser == null) {
			log.debug("로그인 되어있지 않음");
		} else {
			log.debug("사용자 아이디 ===> {}", sessionUser.getUsrId());
		}
		
		log.debug("===============================================");
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		log.debug("===================== END =====================");
		log.debug("===============================================");
		
		super.postHandle(request, response, handler, modelAndView);
	}

}
