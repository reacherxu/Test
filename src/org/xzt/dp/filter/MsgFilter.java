package org.xzt.dp.filter;

public class MsgFilter {
	FilterChain fc ;
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public FilterChain getFc() {
		return fc;
	}

	public void setFc(FilterChain fc) {
		this.fc = fc;
	}
	
	public String filter() {
		return fc.doFilter(msg);
	}
	
}
