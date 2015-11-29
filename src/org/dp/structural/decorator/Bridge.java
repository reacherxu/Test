package org.dp.structural.decorator;

public abstract class Bridge {
	Sourceable source;

	public Bridge(Sourceable source) {
		super();
		this.source = source;
	}
	
	public void method() {
		source.method();
	}

	public Sourceable getSource() {
		return source;
	}

	public void setSource(Sourceable source) {
		this.source = source;
	}
	
}
