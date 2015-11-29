package org.dp.behavior.observer;

public class MySubject extends AbstractSubject implements Subject {

	@Override
	public void operation() {
		System.out.println("update self!");  
		notifyObservers();
	}
	public static void main(String[] args) {
		MySubject subject = new MySubject();
		subject.add(new Observer1());
		subject.add(new Observer2());
		subject.operation();
	}
}
