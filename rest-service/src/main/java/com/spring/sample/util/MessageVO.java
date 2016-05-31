package com.spring.sample.util;

import java.io.Serializable;

public class MessageVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	public MessageVO(String msg) {
		super();
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
