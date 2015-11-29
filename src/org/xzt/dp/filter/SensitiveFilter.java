package org.xzt.dp.filter;

public class SensitiveFilter implements Filter {
	String msg;
	@Override
	public String doFilter(String str) {
		msg = str.replace("fuck", "****");
		return msg;
	}

}
