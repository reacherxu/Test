package org.xzt.weka;

import java.io.File;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class TestWeka1 {
	public static void main(String[] args) {
	       try {
	          
	           Classifier classifier1;
	           Classifier classifier2;
	           Classifier classifier3;
//	           Classifier classifier4;
	 
	          
	           File inputFile = new File(
	        		   "D:\\百度云同步盘\\wordbench\\imbalanced data\\experiment\\test\\diabetes_copy.arff");// 训练语料文件
	           ArffLoader atf = new ArffLoader();
	           atf.setFile(inputFile);
	           Instances instancesTrain = atf.getDataSet(); // 读入训练文件
	          
	           //"D:\\百度云同步盘\\wordbench\\imbalanced data\\experiment\\test\\diabetesTrain0.arff"
	           //"D:\\百度云同步盘\\wordbench\\imbalanced data\\experiment\\test\\diabetesTest0.arff"
	           inputFile = new File(
	        		   "D:\\百度云同步盘\\wordbench\\imbalanced data\\experiment\\test\\diabetes_copy.arff" );// 测试语料文件
	           atf.setFile(inputFile);
	           Instances instancesTest = atf.getDataSet(); // 读入测试文件
	 
	           //设置类标签类
	           instancesTest.setClassIndex(8);
	           instancesTrain.setClassIndex(8);
	 
	          
	           // 朴素贝叶斯算法
	           classifier1 = (Classifier) Class.forName(
	                  "weka.classifiers.bayes.NaiveBayes").newInstance();
	           // 决策树
	           classifier2 = (Classifier) Class.forName(
	                  "weka.classifiers.trees.J48").newInstance();
	           // Zero
	           classifier3 = (Classifier) Class.forName(
	                  "weka.classifiers.rules.ZeroR").newInstance();
	           //LibSVM
//	           classifier4 = (Classifier) Class.forName(
//	                  "weka.classifiers.functions.LibSVM").newInstance();
	 
	          
//	           classifier4.buildClassifier(instancesTrain);
	           classifier1.buildClassifier(instancesTrain);
	           classifier2.buildClassifier(instancesTrain);
	           classifier3.buildClassifier(instancesTrain);
	          
	          
	          
	           Evaluation eval = new Evaluation(instancesTrain);
	          
//	           eval.evaluateModel(classifier4, instancesTest);
//	           System.out.println(eval.errorRate());
	           eval.evaluateModel(classifier1, instancesTest);
	           System.out.println(1-eval.errorRate());
	           eval.evaluateModel(classifier2, instancesTest);
	           System.out.println(1-eval.errorRate());
	           eval.evaluateModel(classifier3, instancesTest);
	           System.out.println(1-eval.errorRate());
	          
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	    }
}
