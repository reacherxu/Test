package org.xzt.map;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		//记录词频
		String[] array = "xzt,lucien,reacher,xzt,xzt,xzt,lucien,reacher,lucien,reacher,reacher".split(",");
		for(int i=0 ; i<array.length ; i++) {
			if( !map.containsKey(array[i]) ) {
				map.put(array[i], new Integer(1));
			}
			else{
				int count = map.get(array[i]) + 1 ;
				map.put(array[i], new Integer(count));
			}
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		for(Object o : map.keySet()) {
			System.out.println(o);
		}
		for(Object o : map.values()) {
			System.out.println(o);
		}
		
 	}

}
