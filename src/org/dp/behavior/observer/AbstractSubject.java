package org.dp.behavior.observer;

import java.util.Vector;

public abstract class AbstractSubject implements Subject {
	Vector<Observer> vectors = new Vector<Observer>();

	public void add(Observer observer) {
		vectors.add(observer);
	}

	public void del(Observer observer) {
		vectors.remove(observer);
	}

	public void notifyObservers() {
		for (int i = 0; i < vectors.size(); i++) {
			vectors.get(i).update();
		}
	}
}
