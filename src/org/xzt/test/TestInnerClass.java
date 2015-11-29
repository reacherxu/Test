package org.xzt.test;

public class TestInnerClass {
	private int num;
	private static int sum = 10;
	public TestInnerClass() {
	}
	public TestInnerClass(int num,int sum) {
		super();
		this.num = num;
		TestInnerClass.setSum(sum);
	}
	
	//private 修饰的内部类 隐藏实现的细节
	private class Inner {
		public TestInnerClass getTestInnerClass() {
			return TestInnerClass.this;
		}
		public TestInnerClass newTestInnerClass() {
			return new TestInnerClass();
		}
	}
	
	private static class StaticInnerClass {
		public int getSum(){  
			return sum;  
		}  
	}
	
	public static void main(String[] args) {
		TestInnerClass test = new TestInnerClass(5,9);  
	    TestInnerClass.Inner inner = test.new Inner();  
	    TestInnerClass TestInnerClass = inner.getTestInnerClass();  
	    TestInnerClass test3 = inner.newTestInnerClass();  
	    System.out.println(TestInnerClass.num);  
	    System.out.println(test3.num);  
	    
		TestInnerClass.StaticInnerClass innerIns = new TestInnerClass.StaticInnerClass();
		System.out.println(innerIns.getSum());
	}
	public static int getSum() {
		return sum;
	}
	public static void setSum(int sum) {
		TestInnerClass.sum = sum;
	}
}
