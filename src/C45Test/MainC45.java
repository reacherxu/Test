package C45Test;

import java.util.ArrayList;
import java.util.List;

public class MainC45 {

    
    
    
    public static void main(String args[]){
        
    	List<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
        List<String> attributeList = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        attributeList.add("age");
        attributeList.add("income");
        attributeList.add("student");
        attributeList.add("credit_rating");
       // attributeList.add("TARGET_VALUE");
          
        List<String> l1 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l1.add("youth");l1.add("high");l1.add("no");l1.add("fair");l1.add("no");
        
        List<String> l2 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l2.add("youth");l2.add("high");l2.add("no");l2.add("excellent");l2.add("no");
        
        List<String> l3 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l3.add("middle_aged");l3.add("high");l3.add("no");l3.add("fair");l3.add("yes");
        
        List<String> l4 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l4.add("senior");l4.add("medium");l4.add("no");l4.add("fair");l4.add("yes");
        
        List<String> l5 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l5.add("senior");l5.add("low");l5.add("yes");l5.add("fair");l5.add("yes");
        
        List<String> l6 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l6.add("senior");l6.add("low");l6.add("yes");l6.add("excellent");l6.add("no");
        
        List<String> l7 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l7.add("middle_aged");l7.add("low");l7.add("yes");l7.add("excellent");l7.add("yes");
        
        List<String> l8 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l8.add("youth");l8.add("medium");l8.add("no");l8.add("fair");l8.add("no");
        
        List<String> l9 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l9.add("youth");l9.add("low");l9.add("yes");l9.add("fair");l9.add("yes");
        
        List<String> l10 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l10.add("senior");l10.add("medium");l10.add("yes");l10.add("fair");l10.add("yes");
        
        List<String> l11 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l11.add("youth");l11.add("medium");l11.add("yes");l11.add("excellent");l11.add("yes");
        
        List<String> l12 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l12.add("middle_aged");l12.add("medium");l12.add("no");l12.add("excellent");l12.add("yes");
        
        List<String> l13 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l13.add("middle_aged");l13.add("high");l13.add("yes");l13.add("fair");l13.add("yes");
        
        List<String> l14 = new ArrayList<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;};
        l14.add("senior");l14.add("medium");l14.add("no");l14.add("excellent");l14.add("no");
        
        dataList.add((ArrayList<String>) l1);
        dataList.add((ArrayList<String>) l2);
        dataList.add((ArrayList<String>) l3);
        dataList.add((ArrayList<String>) l4);
        dataList.add((ArrayList<String>) l5);
        dataList.add((ArrayList<String>) l6);
        dataList.add((ArrayList<String>) l7);
        dataList.add((ArrayList<String>) l8);
        dataList.add((ArrayList<String>) l9);
        dataList.add((ArrayList<String>) l10);
        dataList.add((ArrayList<String>) l11);
        dataList.add((ArrayList<String>) l12);
        dataList.add((ArrayList<String>) l13);
        dataList.add((ArrayList<String>) l14);
        
      //  DecisionTree dt = new DecisionTree();
     //   TreeNode node = dt.createDT(dataList,attributeList);
        System.out.println();
    }
}