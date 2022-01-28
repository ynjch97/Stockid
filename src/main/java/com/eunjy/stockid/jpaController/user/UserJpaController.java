package com.eunjy.stockid.jpaController.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eunjy.stockid.domain.common.ResultVo;
import com.eunjy.stockid.domain.common.ResultVo.ResultStatus;
import com.eunjy.stockid.domain.common.SessionUser;
import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.jpaDomain.user.UsrJpaSpec;
import com.eunjy.stockid.jpaDomain.user.UsrJpaSpec.SearchKey;
import com.eunjy.stockid.jpaDomain.user.UsrJpaVO;
import com.eunjy.stockid.jpaRepository.user.UserRepository;
import com.eunjy.stockid.jpaService.user.UserJpaService;
import com.eunjy.stockid.service.login.LoginService;
import com.eunjy.stockid.utiliy.Consts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserJpaController {

	@Autowired
	UserJpaService userJpaService; 

	@Autowired
	UserRepository userRepository; 
	
	@Autowired
	LoginService loginService;

	@RequestMapping("/userInfo2.do")
	public String userInfo2(Model model, @RequestParam Map<String, Object> searchRequest, HttpSession httpSession) { 
		log.debug("searchRequest ===> " + searchRequest.get("usrNum"));
		log.debug("searchRequest ===> " + searchRequest.get("usrId"));
		
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);
		if (sessionUser != null) searchRequest.put("USR_NUM", sessionUser.getUsrNum());
		searchRequest.put("USE_YN", "Y");
		
		ObjectMapper obj = new ObjectMapper(); 
		UsrJpaVO userInfo = userJpaService.getUserInfo(searchRequest);
		try {
			model.addAttribute("userInfo", obj.writeValueAsString(userInfo));
		} catch (JsonProcessingException e)	 {
			e.printStackTrace();
		}
	    
		return "user/userInfo2"; 
	}

	@PostMapping("/changeUserInfo2.do") 
	public @ResponseBody ResultVo changeUserInfo(UsrGrpVO usrGrpVO, HttpSession httpSession) { 
		int result = 0;
		
		Map<String, Object> searchRequest = new HashMap<>();
		Optional<UsrJpaVO> userJpaVo = Optional.of(new UsrJpaVO());
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);
		if (sessionUser != null) userJpaVo = userRepository.findByUsrNum(sessionUser.getUsrNum());

		userJpaVo.ifPresent(selectUser->{
			selectUser.setUsrNm("dd");
		});
		
		try {	
			searchRequest.put("usrPw", loginService.getEncryptResult(searchRequest.get("usrPw").toString()));
			result =0; 
		} catch (Exception ex) {
			log.error("Error : {}", ex);
		}
				
		if (result == 1) {
			return new ResultVo(ResultStatus.SUCCESS, "회원정보가 성공적으로 수정되었습니다.");
		} else {
			return new ResultVo(ResultStatus.FAIL, "오류가 발생했습니다.");
		}
	}
	
}
