/*
* 페이지 이벤트 관련
*/ 

// 페이지 이동
function movePage(urlStr, param) {
	/*
		param 값은 다음과 같이 작성
		var obj = new Object();
		obj.grpNum = grpNum;
	*/
	
	$("#_tempForm").remove();
	
	var tempForm = $("<form>", {
		id: "_tempForm", 
		method: "post", 
		// target: target, 
		action: urlStr
	}).appendTo("body");
	
	if (param != null) {
		var inpHtml = ""; 
		for (var [key, value] of Object.entries(param)) {
		  console.log(key + " : " + value);
		  inpHtml += '<input type="hidden" name="' + key + '" value="' + value + '" />'; 
		}
		$("#_tempForm").appendTo(inpHtml);
	}
	 
	tempForm.submit();

	/*if (param != null) {
		var keys = Object.keys(param);
		for (var i=0; i<keys.length; i++) {
			var key = keys[i];
			$("#_tempForm").append('<input type="hidden" name="' + key + '"/>');
			$("#_tempForm input:last").val(param[key]);
		}
	}*/
}

/*
* 입력값 관련
*/ 

// 빈값 체크
function isEmpty(str) {
	var chkVal = true;
	if (str != "" && str != null) {
		chkVal = false;
	}
	return chkVal;
}

// 빈값 체크 (trim 값)
function isTrimEmpty(str) {
	var strVal = $.trim(str);
	var chkVal = true;
	if (strVal != "" && strVal != null) {
		chkVal = false;
	}
	return chkVal;
}

// 문자열 비교
function compareStr(str1, str2) {
	var chkVal = false;
	if (str1 == str2) {
		chkVal = true;
	}
	return chkVal;
}

// 메일 형식 체크
function isValidEmail(str) {
	return /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i.test(str);
}

// 비밀번호 형식 체크
function isValidPassword(str) {
	return /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[`,!,”,￡,$,%,^,&,*,(,),_,+,\-,=,{,},\[,\],:,@,~,;,’,#,<,>,?,.,\/,\,|])[0-9a-zA-Z`,!,”,￡,$,%,^,&,*,(,),_,+,\-,=,{,},\[,\],:,@,~,;,’,#,<,>,?,.,\/,\,|]{8,16}$/.test(str);
}

// 숫자 형식 체크
function isValidNumber(str) {
	return /^[0-9]+$/.test(str);
}

// url 유효성 검사
function isValidUrl(str) {
	var pattern = /(http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
	if (pattern.test(str)) {
		return true;
	} else {
		return false;
	}
}

// 공배 + 영문 + 숫자 제거 리턴
function returnStrWithout(str, type) {
	if ( isEmpty(str) ) return;

	if (type == "space") {
		str = str.replace(/ /g, "");
	} else if (type == "numEng") {
		str = str.replace(/[^a-zA-Z0-9]/gi, '');
	}
	
	return str;
}


/*
* 쿠키 관련
*/ 

//쿠키값 추출
function getCookie(cookieName) { // 쿠키명
	var cookie = document.cookie;
	
	// 현재 쿠키가 존재할 경우
	if (cookie.length > 0) {
		// 해당 쿠키명이 존재하는지 검색한 후 존재하면 위치를 리턴.
		startIndex = cookie.indexOf(cookieName);
	
		// 만약 존재한다면
	  	if (startIndex != -1) {
			// 값을 얻어내기 위해 시작 인덱스 조절
		 	startIndex += cookieName.length;
	
		 	// 값을 얻어내기 위해 종료 인덱스 추출
		 	endIndex = cookie.indexOf(";", startIndex);
	
		 	// 만약 종료 인덱스를 못찾게 되면 쿠키 전체길이로 설정
		 	if(endIndex == -1) endIndex = cookie.length;
	
		 	// 쿠키값을 추출하여 리턴
		 	return unescape(cookie.substring(startIndex + 1, endIndex));
	  	}
	  	else {
	  		// 쿠키 내에 해당 쿠키가 존재하지 않을 경우
			return false;
		}
	}
	else {
		// 쿠키 자체가 없을 경우
	 	return false;
	}
}

// 쿠키 설정
function setCookie(cookieName, cookieValue, expireDate) { // 설정할 쿠키명, 쿠키 값, 쿠키 유효날짜
	 var today = new Date();
	 today.setDate( today.getDate() + parseInt(expireDate) );
	 document.cookie = cookieName + "=" + escape( cookieValue ) + "; path=/; expires=" + today.toGMTString() + ";";
}

// 쿠키 삭제
function deleteCookie(cookieName) { // 삭제할 쿠키명
	var expireDate = new Date();
 
	// 어제 날짜를 쿠키 소멸 날짜로 설정
	expireDate.setDate( expireDate.getDate() - 1 );
	document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString() + "; path=/";
}

// 전체 쿠키 출력
function viewCookie() {
	if( document.cookie.length > 0 )
		console.log("viewCookie : " + document.cookie);
}