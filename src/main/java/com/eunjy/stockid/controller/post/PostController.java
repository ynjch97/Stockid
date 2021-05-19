package com.eunjy.stockid.controller.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eunjy.stockid.utiliy.Consts;


/**
 * @author YunJi
 * 카테고리 별 포스트
 */
@Controller
public class PostController {

	@RequestMapping(value = "/{investType}/list.do", method = RequestMethod.GET) 
	public String postList(@PathVariable("investType") String investType, Model model) {
		String investTypeVal = "00"; // CMMN_CD_INFO 의 INVEST_TYPE(투자 유형) 그룹 값 (01:주식/02:코인) 
		if (Consts.InvestType.INVEST_STOCK.equals(investType)) {
			investTypeVal = "01";
		} else if (Consts.InvestType.INVEST_COIN.equals(investType)) {
			investTypeVal = "02";
		} else {
			return "";
		}
		System.out.println("investType : " + investType);
		System.out.println("investTypeVal : " + investTypeVal);
		
		return "post/postList"; 
	}
	
	@RequestMapping(value = "/post/write.do", method = RequestMethod.GET) 
	public String postWrite(Model model) { 
		return "post/postWrite"; 
	}

}
