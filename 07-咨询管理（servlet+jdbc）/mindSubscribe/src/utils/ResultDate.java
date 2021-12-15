package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @instruction
 * 响应结果
 */
public class ResultDate {
	
	/**
	 * 是否成功
	 */
	private boolean isSuccess;
	
	/**
	 * 返回消息
	 */
	private String msg;
	
	/**
	 * 响应数据
	 * @return
	 */
	private List<Object> dataList = new ArrayList<>();
	
	

	public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public boolean getIsSuccess() {
		return isSuccess;
	}
	
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
