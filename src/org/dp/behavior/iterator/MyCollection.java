package org.dp.behavior.iterator;

public class MyCollection implements Collection {

	private String string[] = {"A","B","C","D","E"};
	@Override
	public Iterator iterator() {
		return new MyIterator(this);
	}

	@Override
	public Object get(int i) {
		return string[i];
	}

	@Override
	public int size() {
		return string.length;
	}
	
	public static void main(String[] args) {
		Collection collection = new MyCollection();
		Iterator it = collection.iterator();
		while( it.hasNext() ) {
			System.out.print(it.next()+"\t");
		}
	}

}
