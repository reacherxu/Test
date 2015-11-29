package org.xzt.decisiontree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Iterator;

//调试过程中发现4个错误 ，感谢宇宙无敌的调试工具——print
//1、selectAtrribute中的一个数组下标出错 2、两个字符串相等的判断
//3、输入的数据有一个错误 4、selectAtrribute中最后一个循环忘记了i++

//决策树的树结点类
class TreeNode {
	String element;  //该值为数据的属性名称
	String value;    //上一个分裂属性在此结点的值
	LinkedHashSet<TreeNode> childs;  //结点的子结点，以有顺序的链式哈希集存储

	public TreeNode() {
		this.element = null;
		this.value = null;
		this.childs = null;
	}
	
	public TreeNode(String value) {
		this.element = null;
		this.value = value;
		this.childs = null;
	}
	
	public String getElement() {
		return this.element;
	}
	
	public void setElement(String e) {
		this.element = e;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String v) {
		this.value = v;
	}
	
	public LinkedHashSet<TreeNode> getChilds() {
		return this.childs;
	}
	
	public void setChilds(LinkedHashSet<TreeNode> childs) {
		this.childs = childs;
	}
}

//决策树类
class DecisionTree {
	TreeNode root;  //决策树的树根结点
	
	public DecisionTree() {
		root = new TreeNode();
	}
	
	public DecisionTree(TreeNode root) {
		this.root = root;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public String selectAtrribute(TreeNode node,String[][] deData, boolean flags[],
			LinkedHashSet<String> atrributes, HashMap<String,Integer> attrIndexMap) {
		//Gain数组存放当前结点未分类属性的Gain值
		double Gain[] = new double[atrributes.size()];
		//每条数据中归类的下标，为每条数据的最后一个值
		int class_index = deData[0].length - 1;
		//属性名，该结点在该属性上进行分类
		String return_atrribute = null;
		
		//计算每个未分类属性的 Gain值
		int count = 0; //计算到第几个属性
		for(String atrribute:atrributes) {
			//该属性有多少个值，该属性有多少个分类
			int values_count, class_count;
			//属性值对应的下标
			int index = attrIndexMap.get(atrribute);
			//存放属性的各个值和分类值
			LinkedHashSet<String> values = new LinkedHashSet<String>();
			LinkedHashSet<String> classes = new LinkedHashSet<String>();
			
			for(int i = 0; i < deData.length; i++) {
				if(flags[i] == true) {
					values.add(deData[i][index]);
					classes.add(deData[i][class_index]);
				}
			}
			values_count = values.size();
			class_count = classes.size();
			
			int values_vector[] = new int[values_count * class_count];
			int class_vector[] = new int[class_count];
			
			for(int i = 0; i < deData.length; i++) {
				if(flags[i] == true) {
					int j = 0;
					for(String v:values) {
						if(deData[i][index].equals(v)) {
							break;
						} else {
							j++;
						}
					}
										
					int k = 0;
					for(String c:classes) {
						if(deData[i][class_index].equals(c)) {
							break;
						} else {
							k++;
						}
					}
					
					values_vector[j*class_count+k]++;
					class_vector[k]++;
				}
			}
			
			/*  //输出各项统计值
			for(int i = 0; i < values_count * class_count; i++) {
				System.out.print(values_vector[i] + " ");
			}
			System.out.println();
			for(int i = 0; i < class_count; i++) {
				System.out.print(class_vector[i] + " ");
			}
			System.out.println();
			*/		
			
			//计算InforD
			double InfoD = 0.0;
			double class_total = 0.0;
			for(int i = 0; i < class_vector.length; i++){
				class_total += class_vector[i];
			}
			for(int i = 0; i < class_vector.length; i++){
				if(class_vector[i] == 0) {
					continue;
				} else {
					double d = Math.log(class_vector[i]/class_total) / Math.log(2.0) * class_vector[i] / class_total;
					InfoD = InfoD - d;
				}
			}
			
			//计算InfoA
			double InfoA = 0.0;
			for(int i = 0; i < values_count; i++) {
				double middle = 0.0;
				double attr_count = 0.0;
				
				for(int j = 0; j < class_count; j++) {
					attr_count +=  values_vector[i*class_count+j];
				}
				
				for(int j = 0; j < class_count; j++) {
					if(values_vector[i*class_count+j] != 0) {
						double k = values_vector[i*class_count+j];
						middle = middle - Math.log(k/attr_count) / Math.log(2.0) * k / attr_count;
					}
				}
				
				InfoA += middle * attr_count / class_total;
			}

			Gain[count] = InfoD - InfoA;
			count++;
		}
		
		double max = 0.0;
		int i = 0;
		for(String atrribute:atrributes) {
			if(Gain[i] > max) {
				max = Gain[i];
				return_atrribute = atrribute;
			}
			i++;
		}
		
		return return_atrribute;
	}
	
	//node：在当前结点构造决策树
	//deData：数据集
	//flags：指示在当前结点构造决策树时哪些数据是需要的
	//attributes：未分类的属性集
	//attrIndexMap：属性与对应数据下标
	public void buildDecisionTree(TreeNode node, String[][] deData, boolean flags[],
			LinkedHashSet<String> attributes, HashMap<String,Integer> attrIndexMap) {
		//如果待分类属性已空
		if(attributes.isEmpty() == true) {
			//从数据集中选择多数类，遍历符合条件的所有数据
			HashMap<String,Integer> classMap = new HashMap<String,Integer>();
			int classIndex = deData[0].length - 1;
			for(int i = 0; i < deData.length; i++) {
				if(flags[i] == true) {
					if(classMap.containsKey(deData[i][classIndex])) {
						int count = classMap.get(deData[i][classIndex]);
						classMap.put(deData[i][classIndex], count+1);
					} else {
						classMap.put(deData[i][classIndex], 1);
					}
				}
			}
			//选择多数类
			String mostClass = null;
			int mostCount = 0;
			Iterator<String> it = classMap.keySet().iterator();
			while(it.hasNext()) {
				String strClass = (String)it.next();
				if(classMap.get(strClass) > mostCount) {
					mostClass = strClass;
					mostCount = classMap.get(strClass);
				}
			}
			//对结点进行赋值，该结点为叶结点
			node.setElement(mostClass);
			node.setChilds(null);
			System.out.println("yezhi:" + node.getElement() + ":" + node.getValue());
			return;
		}
		
		//如果待分类数据全都属于一个类
		int class_index = deData[0].length - 1;
		String class_name = null;
		HashSet<String> classSet = new HashSet<String>();
		for(int i = 0; i < deData.length; i++) {
			if(flags[i] == true) {
				class_name = deData[i][class_index];
				classSet.add(class_name);
			}
		}
		//则该结点为叶结点，设置有关值，然后返回
		if(classSet.size() == 1) {
			node.setElement(class_name);
			node.setChilds(null);
			System.out.println("leaf:" + node.getElement() + ":" + node.getValue());
			return;
		}
		
		//给定的分枝没有元组，是不是有这种情况？
						
		//选择一个分类属性
		String attribute = selectAtrribute(node, deData, flags, attributes, attrIndexMap);
		//设置分裂结点的值
		node.setElement(attribute);
		//System.out.println(attribute);
		if(node == root) {
			System.out.println("root:" + node.getElement() + ":" + node.getValue());
		} else {
			System.out.println("branch:" + node.getElement() + ":" + node.getValue());
		}
		
		//生成和设置各个子结点
		int attrIndex = attrIndexMap.get(attribute);
		LinkedHashSet<String> attrValues = new LinkedHashSet<String>();
		for(int i = 0; i < deData.length; i++) {
			if(flags[i] == true) {
				attrValues.add(deData[i][attrIndex]);
			}
		}
		LinkedHashSet<TreeNode> childs = new LinkedHashSet<TreeNode>();
		for(String attrValue:attrValues) {
			TreeNode tn = new TreeNode(attrValue);
			childs.add(tn);
		}
		node.setChilds(childs);
		
		//在候选分类属性中删除当前属性
		attributes.remove(attribute);
		
		//在各个子结点上递归调用本函数
		if(childs.isEmpty() != true) {
			for(TreeNode child:childs) {
				//设置子结点待分类的数据集
				boolean newFlags[] = new boolean[deData.length] ;
				for(int i = 0; i < deData.length; i++) {
					newFlags[i] = flags[i];
					if(deData[i][attrIndex] != child.getValue()) {
						newFlags[i] = false;
					}
				}
				//设置子结点待分类的属性集
				LinkedHashSet<String> newAttributes = new LinkedHashSet<String>();
				for(String attr:attributes) {
					newAttributes.add(attr);
				}
				//在子结点上递归生成决策树
				buildDecisionTree(child, deData, newFlags, newAttributes, attrIndexMap);
			}
		}
	}
	
	//输出决策树
	public void printDecisionTree() {
	
	}
}

public class DeTree {

	public static void main(String[] args) {
		/*
		//输入数据集1
		String deData[][] = new String[12][];
		deData[0] = new String[]{"Yes","No","No","Yes","Some","high","No","Yes","French","0~10","Yes"};
		deData[1] = new String[]{"Yes","No","No","Yes","Full","low","No","No","Thai","30~60","No"};
		deData[2] = new String[]{"No","Yes","No","No","Some","low","No","No","Burger","0~10","Yes"};
		deData[3] = new String[]{"Yes","No","Yes","Yes","Full","low","Yes","No","Thai","10~30","Yes"};
		deData[4] = new String[]{"Yes","No","Yes","No","Full","high","No","Yes","French",">60","No"};
		deData[5] = new String[]{"No","Yes","No","Yes","Some","middle","Yes","Yes","Italian","0~10","Yes"};
		deData[6] = new String[]{"No","Yes","No","No","None","low","Yes","No","Burger","0~10","No"};
		deData[7] = new String[]{"No","No","No","Yes","Some","middle","Yes","Yes","Thai","0~10","Yes"};
		deData[8] = new String[]{"No","Yes","Yes","No","Full","low","Yes","No","Burger",">60","No"};
		deData[9] = new String[]{"Yes","Yes","Yes","Yes","Full","high","No","Yes","Italian","10~30","No"};
		deData[10]= new String[]{"No","No","No","No","None","low","No","No","Thai","0~10","No"};
		deData[11]= new String[]{"Yes","Yes","Yes","Yes","Full","low","No","No","Burger","30~60","Yes"};
		//待分类的属性集1
		String attr[] = new String[]{"alt", "bar", "fri", "hun", "pat", "price", "rain", "res", "type", "est"};
		*/
		//输入数据集2
		String deData[][] = new String[14][];
		deData[0] = new String[]{"youth","high","no","fair","no"};
		deData[1] = new String[]{"youth","high","no","excellent","no"};
		deData[2] = new String[]{"middle_aged","high","no","fair","yes"};
		deData[3] = new String[]{"senior","medium","no","fair","yes"};
		deData[4] = new String[]{"senior","low","yes","fair","yes"};
		deData[5] = new String[]{"senior","low","yes","excellent","no"};
		deData[6] = new String[]{"middle_aged","low","yes","excellent","yes"};
		deData[7] = new String[]{"youth","medium","no","fair","no"};
		deData[8] = new String[]{"youth","low","yes","fair","yes"};
		deData[9] = new String[]{"senior","medium","yes","fair","yes"};
		deData[10]= new String[]{"youth","medium","yes","excellent","yes"};
		deData[11]= new String[]{"middle_aged","medium","no","excellent","yes"};
		deData[12]= new String[]{"middle_aged","high","yes","fair","yes"};
		deData[13]= new String[]{"senior","medium","no","excellent","no"};
		//待分类的属性集2
		String attr[] = new String[]{"age", "income", "student", "credit_rating"};
		
		LinkedHashSet<String> attributes = new LinkedHashSet<String>();
		for(int i = 0; i < attr.length; i++) {
			attributes.add(attr[i]);
		}
			
		//属性与数据集中对应数据的下标
		HashMap<String,Integer> attrIndexMap = new HashMap<String,Integer>();
		for(int i = 0; i < attr.length; i++) {
			attrIndexMap.put(attr[i], i);
		}
			
		//需要分类的数据，初始为整个数据集
		boolean flags[] = new boolean[deData.length];
		for(int i = 0; i < deData.length; i++) {
			flags[i] = true;
		}
		
		//构造决策树
		TreeNode root = new TreeNode();
		DecisionTree decisionTree = new DecisionTree(root);
		decisionTree.buildDecisionTree(root, deData, flags, attributes, attrIndexMap);	
	}
}
