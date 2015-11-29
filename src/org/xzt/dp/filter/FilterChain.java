package org.xzt.dp.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{
	List<Filter> filters = new ArrayList<Filter>();
	String msg ;
	
	public FilterChain addFilter(Filter f) {
		this.filters.add(f);
		return this; //这样子可以反复的利用add方法
	}
	
	//是一个filter，所以要实现doFilter()
	public String doFilter(String str) {
		msg = str;
		for(Filter f : filters) {
			msg = f.doFilter(msg);
		}
		return msg;
	}
}
