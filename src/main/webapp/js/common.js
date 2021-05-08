function isEmpty(str) {
	var chkVal = true;
	if (str != "" && str != null) {
		chkVal = false;
	}
	return chkVal;
}

function isTrimEmpty(str) {
	var strVal = $.trim(str);
	var chkVal = true;
	if (strVal != "" && strVal != null) {
		chkVal = false;
	}
	return chkVal;
}