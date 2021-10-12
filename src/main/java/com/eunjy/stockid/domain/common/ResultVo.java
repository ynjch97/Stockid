package com.eunjy.stockid.domain.common;

import java.util.Map;

import lombok.Data;

@Data
public class ResultVo {

	protected ResultStatus result;
	protected String resultMsg;
	protected Map<String, String> resultMap;
	protected boolean isSuccess;
	
	public ResultVo() {
	}
	
	public ResultVo(ResultStatus result) {
		setResult(result);
	}
	
	public ResultVo(ResultStatus result, String resultMsg) {
		setResult(result);
		setResultMsg(resultMsg);
	}
	
	public ResultVo(ResultStatus result, String resultMsg, Map<String, String> resultMap) {
		setResult(result);
		setResultMsg(resultMsg);
		setResultMap(resultMap);
	}
	
	public ResultStatus getResult() {
		return result;
	}
	public void setResult(ResultStatus result) {
		this.result = result;
		isSuccess = (ResultStatus.SUCCESS == this.result);
	}
	public boolean getIsSuccess() {
		return isSuccess;
	}
	
	public enum ResultStatus {
		SUCCESS,
		FAIL
	}
	
}