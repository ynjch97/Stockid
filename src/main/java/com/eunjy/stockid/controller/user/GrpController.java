package com.eunjy.stockid.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eunjy.stockid.domain.common.ResultVo;
import com.eunjy.stockid.domain.common.ResultVo.ResultStatus;
import com.eunjy.stockid.domain.common.SessionUser;
import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.service.user.GrpService;
import com.eunjy.stockid.utiliy.Consts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/grp")
public class GrpController {
	
	@Autowired
	GrpService grpService; 

	// 그룹 목록 조회
	@RequestMapping(value = "/grpList.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String grpList(Model model, UsrGrpVO usrGrpVO, HttpSession httpSession) { 
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);
		if (sessionUser != null) usrGrpVO.setUsrNum( sessionUser.getUsrNum() );
		
		ObjectMapper obj = new ObjectMapper(); 
		List<UsrGrpVO> myGrpList = grpService.getMyGrpList(usrGrpVO);
		try {
			model.addAttribute("myGrpList", obj.writeValueAsString(myGrpList));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "grp/grpList"; 
	}
	
	// 그룹 생성 화면
	@RequestMapping(value = "/addGrp.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String addGrp(Model model, UsrGrpVO usrGrpVO, HttpSession httpSession) { 
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);
		if (sessionUser != null) usrGrpVO.setUsrNum( sessionUser.getUsrNum() );
		
		List<UsrGrpVO> myGrpList = grpService.getMyGrpList(usrGrpVO);
		int myGrpCnt = 0;
		if (myGrpList.size() != 0) {
			myGrpCnt = myGrpList.get(0).getTotalCnt();
		}
		
		model.addAttribute("myGrpCnt", myGrpCnt);
		
		return "grp/addGrp"; 
	}
	
	// 그룹 생성 수행
	@RequestMapping(value = "/ajax.addGrpProcess.do", method = RequestMethod.POST) 
	public @ResponseBody ResultVo addGrpProcess(Model model, UsrGrpVO usrGrpVO, HttpSession httpSession) throws Exception { 
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);

		ResultVo resultVo = new ResultVo();
		int result = grpService.addGrp(usrGrpVO, sessionUser);
		
		if (result == 2) {
			resultVo = new ResultVo(ResultStatus.SUCCESS);
		} else {
			resultVo = new ResultVo(ResultStatus.FAIL);
		}
		
		log.debug("loginProcess resultMsg : {}", result); 
		
		return resultVo;
	}
	
	// 그룹명, 그룹 URL 중복 여부 조회
	@RequestMapping(value = "/ajax.grpInfoDuplChk.do", method = RequestMethod.POST) 
	public @ResponseBody ResultVo grpInfoDuplChk(Model model, UsrGrpVO usrGrpVO, HttpSession httpSession) throws Exception { 
		int result = grpService.getDuplGrpCnt(usrGrpVO);
		
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("grpCnt", Integer.toString(result));
		ResultVo resultVo = new ResultVo(ResultStatus.SUCCESS);
		resultVo.setResultMap(resultMap);
		
		log.debug("grpInfoDuplChk result : {}", result); 
		
		return resultVo;
	}
	
	// 그룹 참여 화면
	@RequestMapping(value = "/joinGrp.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String joinGrp(Model model, UsrGrpVO usrGrpVO, HttpSession httpSession) { 
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);
		if (sessionUser != null) usrGrpVO.setUsrNum( sessionUser.getUsrNum() );
		
		List<UsrGrpVO> myGrpList = grpService.getMyGrpList(usrGrpVO);
		int myGrpCnt = 0;
		if (myGrpList.size() != 0) {
			myGrpCnt = myGrpList.get(0).getTotalCnt();
		}
		
		model.addAttribute("myGrpCnt", myGrpCnt);
		
		return "grp/joinGrp"; 
	}
	
	// 그룹 참여 수행
	@RequestMapping(value = "/ajax.joinGrpProcess.do", method = RequestMethod.POST) 
	public @ResponseBody ResultVo joinGrpProcess(Model model, UsrGrpVO usrGrpVO, HttpSession httpSession) throws Exception { 
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute(Consts.SessionAttr.USER);

		ResultVo resultVo = new ResultVo();
		int result = grpService.joinGrp(usrGrpVO, sessionUser);
		
		if (result == 1) {
			resultVo = new ResultVo(ResultStatus.SUCCESS);
		} else {
			resultVo = new ResultVo(ResultStatus.FAIL);
		}
		
		log.debug("joinGrpProcess resultMsg : {}", result); 
		
		return resultVo;
	}
	
}
