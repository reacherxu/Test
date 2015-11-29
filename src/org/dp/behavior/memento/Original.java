package org.dp.behavior.memento;

public class Original {
	private String value;

	public Original(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Memento createMemento() {
		return new Memento(value);
	}
	
	public void restoreMemento(Memento memento) {
		this.value = memento.getValue();
	}
	
	public static void main(String[] args) {
		Original original = new Original("egg"); 
		Memento memento = original.createMemento();
		System.out.println(original.getValue());
		original.setValue("hatched");
		System.out.println(original.getValue());
		original.restoreMemento(memento);
		System.out.println(original.getValue());
	}
}
