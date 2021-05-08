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