package org.xzt.dp.filter;

public class HtmlFilter implements Filter {
	String msg;
	@Override
	//process html tag
	public String doFilter(String str) {
		msg = str.replace("<", "[")
				.replace(">", "]");
		return msg;
	}

}
