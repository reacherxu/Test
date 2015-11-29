package org.dp.creative.prototype;

public class Prototype implements Cloneable {
	public Object clone() throws CloneNotSupportedException {
		Prototype o = (Prototype)super.clone();
		return o;
	}
}
