package org.xzt.test;

//产品系列,对应一家4s店
interface ISet {
	//发布商品
	public void issue();
	
	//编辑商品
	public void edit();
	
	//交易下单
	public void pay();
}

class SetA implements ISet {//其余商品BCD...均是如此

	@Override
	public void issue() {
		System.out.println("发布商品....");
	}

	@Override
	public void edit() {
		System.out.println("编辑商品....");
	}

	@Override
	public void pay() {
		System.out.println("交易下单....");
	} 
	
}

interface Factory {
	public ISet produce();
}
public class FactoryA implements Factory{

	@Override
	public ISet produce() {
		return new SetA();
	}  
	
	public static void main(String[] args) {
		Factory factory = new FactoryA();
		ISet set = factory.produce();
		set.issue();
		set.edit();
		set.pay();
	}
	
}

