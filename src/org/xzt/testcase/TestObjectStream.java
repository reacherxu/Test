package org.xzt.testcase;

import java.io.*;

public class TestObjectStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		T t = new T();
		t.k = 4;
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("e:/w.txt"));
			oos.writeObject(t);
			oos.flush();
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream("e:/w.txt"));
			T tRead = (T)ois.readObject();
			System.out.println(tRead.i+","+tRead.j+","+tRead.k);
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
class T implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i = 10;
	Boolean j = false;
	double d = 2.2;
	transient float k = 3;
}
