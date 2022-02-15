package com.eunjy.stockid.controller.user;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
class UserControllerTest {
	
	@Autowired
	MockMvc mvc;

	@BeforeEach
	public void setup(){
		// UserController를 MockMvc 객체로
		mvc = MockMvcBuilders.standaloneSetup(new UserController())
				.addFilters(new CharacterEncodingFilter("UTF-8", true))
				.build();
	}
	
	@Test
	void test() throws Exception {
		//given
        String test = "test";
        
        try {
        	//when
	        final ResultActions actions = mvc.perform(get("/user/test.do") // MockMvc를 통해 해당 주소로 GET 요청
	        		.characterEncoding("UTF-8")
	        		.contentType(MediaType.APPLICATION_JSON) 
	        		.accept(MediaType.APPLICATION_JSON));

	        //then
			actions
				    // mvc.perform()의 결과를 검증
					.andDo(print())
				    .andExpect(status().isOk()); // 200 상태
				    // .andExpect(content().string(test)); // 응답 본문의 내용을 검증
		} catch (Exception e) {
			fail("FAILED :: " + e.getMessage());
		}
	}

}
