package com.eunjy.stockid.domain.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommonResultVo {
	public CommonResultVo() {
	}
	
	public CommonResultVo(ResultStatus result) {
		setResult(result);
	}
	
	protected ResultStatus result;
	protected String resultMsg;
	protected boolean isSuccess;
	
	public ResultStatus getResult() {
		return result;
	}
	public void setResult(ResultStatus result) {
		this.result = result;
		isSuccess = (ResultStatus.SUCCESS == this.result);
	}
	public String getresultMsg() {
		return resultMsg;
	}
	public void setresultMsg(String resultMsg) {
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