package org.dp.behavior.visit;

public class MySubject implements Subject {
	private String s = "subject";
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String getSubject() {
		return this.s;
	}

	public static void main(String[] args) {
		Subject s = new MySubject();
		s.accept(new MyVisitor());
	}
}
