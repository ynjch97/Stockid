package com.eunjy.stockid.domain.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommonResultVo {

	protected ResultStatus result;
	protected String resultMsg;
	protected boolean isSuccess;
	
	public CommonResultVo() {
	}
	
	public CommonResultVo(ResultStatus result) {
		setResult(result);
	}
	
	public CommonResultVo(ResultStatus result, String resultMsg) {
		setResult(result);
		setResultMsg(resultMsg);
	}
	
	public ResultStatus getResult() {
		return result;
	}
	public void setResult(ResultStatus result) {
		this.result = result;
		isSuccess = (ResultStatus.SUCCESS == this.result);
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public boolean getIsSuccess() {
		return isSuccess;
	}
	
	public enum ResultStatus {
		SUCCESS,
		FAIL
	}
	
}