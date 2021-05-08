package com.eunjy.stockid.controller.login;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eunjy.stockid.domain.common.CommonResultVo;
import com.eunjy.stockid.domain.common.CommonResultVo.ResultStatus;
import com.eunjy.stockid.domain.common.RSAUtil;
import com.eunjy.stockid.domain.user.UsrGrpVO;
import com.eunjy.stockid.service.login.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService; 

	@RequestMapping(value = {"/", "/login/login.do"}, method = RequestMethod.GET) 
	public String login(Model model) { 
		System.out.println("home controller start"); 
		return "login/login"; 
	}
	
	@RequestMapping(value = "/login/loginProcess.do", method = RequestMethod.POST) 
	public String loginProcess(Model model) { 
		System.out.println("home controller start"); 
		return "login/loginProcess"; 
	}

	@RequestMapping(value = "/login/join.do", method = {RequestMethod.POST, RequestMethod.GET}) 
	public String join(Model model) { 
		System.out.println("home controller start"); 
		return "login/join"; 
	}
	
	@RequestMapping(value = "/login/joinUsr.do", method = RequestMethod.POST) 
	public @ResponseBody CommonResultVo getUserList(Model model, UsrGrpVO usrGrpVO) { 
		int result = 0;
		
		try {
			usrGrpVO.setUsrPw( encryptRSAResult(usrGrpVO.getUsrPw()) );
			result = loginService.insertUsr(usrGrpVO);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException
				| IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (result == 1) {
			return new CommonResultVo(ResultStatus.SUCCESS, "회원가입이 성공적으로 완료되었습니다.");
		} else {
			return new CommonResultVo(ResultStatus.FAIL, "회원가입에 실패하였습니다.");
		}
	}
	
	private String encryptRSAResult(String encryptStr) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
		// RSA 키쌍을 생성
        KeyPair keyPair = RSAUtil.genRSAKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Base64 인코딩된 암호화 문자열
        String encrypted = RSAUtil.encryptRSA(encryptStr, publicKey);

        System.out.println("###");
        System.out.println(publicKey);
        System.out.println(privateKey);
        System.out.println(encrypted);
        System.out.println("###");
        
        return encrypted;
	}
	
}
