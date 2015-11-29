/**
 * 
 */
package org.dp.behavior.template;

/**
 * @author Reacher
 *
 */
public abstract class AbstractCalculator {
	//模版类的主方法
	public final int calculate(String exp,String opt) {
		int array[] = split(exp,opt);
		return calculate(array[0],array[1]);
	}
	
	public abstract int calculate(int a,int b);
	
	public int[] split(String exp,String opt){  
        String array[] = exp.split(opt);  
        int arrayInt[] = new int[2];  
        arrayInt[0] = Integer.parseInt(array[0]);  
        arrayInt[1] = Integer.parseInt(array[1]);  
        return arrayInt;  
    }  
}
