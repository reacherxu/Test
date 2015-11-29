package org.xzt.dp.filter;

public class Main {

	

	public static void main(String[] args) {
		//Filter[] filters = {new HtmlFilter(),new SensitiveFilter()};
		String str = "<html>,kjflksd<body>,fuck U and fuck me !";
		
		FilterChain fc = new FilterChain();
		fc.addFilter(new HtmlFilter());
		
		FilterChain fc2 = new FilterChain();
		fc2.addFilter(new SensitiveFilter());
		
		fc.addFilter(fc2);
		
		MsgFilter mf = new MsgFilter();
		mf.setMsg(str);
		mf.setFc(fc);
		
		System.out.println(mf.filter());
		
		
		
	}

}
