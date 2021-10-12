package com.eunjy.stockid.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.eunjy.stockid.domain.common.SessionUser;
import com.eunjy.stockid.utiliy.Consts;
import com.eunjy.stockid.utiliy.ConfigurationYaml;

import lombok.extern.slf4j.Slf4j;

/**
 * @author YunJi
 * 로그인 인터셉터
 */
@Slf4j
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private String redirectPage = "";
	private List<String> noSession;
	private List<String> noSessionPattern;
	
	@Autowired
	private ConfigurationYaml propertiesYaml;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.debug("==================== BEGIN ====================");
		log.debug("Request URI ===> " + request.getRequestURI());
		// log.debug("redirectPage ===> " + tests.get(0).get("name"));
		
		// uri 주소 정보
		String requestUri = request.getRequestURI();
		String[] requestArr = requestUri.split("/");

		// 세선 사용자 정보
		String usrId = "";
		HttpSession httpSession = request.getSession();
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);

		// login check
		if ( !isChkSession(requestUri) ) {
			log.debug("세션 체크 페이지 아님");
			return super.preHandle(request, response, handler);
		} else {
			if (sessionUser == null) {
				log.debug("로그인 되어있지 않음");
				response.sendRedirect(redirectPage);
				return false;
			}
			
			usrId = sessionUser.getUsrId();
			log.debug("사용자 아이디 ===> {}", usrId);
		}
		// login check end
		
		// TODO
		/*
		Menu menu = new Menu();
		menu.setUrl(requestUri);
		menu.setUsr_grp_id(usr_grp_id);
		menu.setUsr_id(usr_id);
		
		if (requestArr[1].equals("admin")) {
			if (menuService.countMenuAuth(menu) == 0) {
		    	// 권한 체크하여 권한이 없으면  permission denied 페이지로
				request.setAttribute("errCode", "SERVICE_DENIED");
				response.sendRedirect(redirectPermissionDeniedPage);
				return false;
			} 
		}
		
		List<Menu> menuList = menuService.getUserGroupMenuList(usr_grp_id, usr_id);

		request.setAttribute("userGroupMenuList", menuList);
		request.setAttribute("language", MessageUtil.getMessage("label.common.language"));
		// get menu end

		// menu activation start
		this.activateMenu(request, menuList, requestUri);
		// menu activation end
		
		logger.debug("55555");
		*/

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
	
	private boolean isChkSession(String reqURI) {
		noSession = propertiesYaml.getNoSession();
		noSessionPattern = propertiesYaml.getNoSessionPattern();
		
		if ( noSession.contains(reqURI) ) { // 세션 체크 예외 페이지
			return false;
		}
		
		for ( String pathPattern : noSessionPattern ) { // 세션 체크 예외 페이지 패턴
			if ( reqURI.matches(pathPattern) ) {
				return false;
			}
			
			if (StringUtils.countMatches(reqURI, "/") != StringUtils.countMatches(pathPattern, "/")) {
				continue;
			}
		}
		
		return true;
	}

}
