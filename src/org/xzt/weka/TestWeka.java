package org.xzt.weka;

import java.io.File;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class TestWeka {
	
	 //"D:\\百度云同步盘\\wordbench\\imbalanced data\\experiment\\test\\diabetesTrain0.arff"
    //"D:\\百度云同步盘\\wordbench\\imbalanced data\\experiment\\test\\diabetesTest0.arff"
	//"E:\\Program Files\\Weka-3-6\\data\\cpu.with.vendor.arff"
	public static void main(String[] args) throws Exception {
        Classifier m_classifier = new J48();
        // 训练语料文件，官方自带的 demo 里有
        File inputFile = new File("D:\\百度云同步盘\\wordbench\\imbalanced data\\experiment\\test\\diabetes_copy.arff");
        ArffLoader atf = new ArffLoader();
        atf.setFile(inputFile);
        Instances instancesTrain = atf.getDataSet(); // 读入训练文件
        
        // 测试语料文件：随便 copy 一段训练文件出来，做分类的预测准确性校验
        inputFile = new File("D:\\百度云同步盘\\wordbench\\imbalanced data\\experiment\\test\\diabetes_copy.arff");
        atf.setFile(inputFile);
        Instances instancesTest = atf.getDataSet(); // 读入测试文件
        
       /* double sum = instancesTest.numInstances(), // 测试语料实例数
        right = 0.0f;*/
        
        //TODO  notice
        instancesTrain.setClassIndex(instancesTrain.numAttributes()-1);// 分类属性：第一个字段
        instancesTest.setClassIndex(instancesTest.numAttributes()-1); // 设置分类属性所在行号（第一行为0号），instancesTest.numAttributes()可以取得属性总数
        
        m_classifier.buildClassifier(instancesTrain);
		
		Evaluation eval = new Evaluation(instancesTrain);
		//TODO  第一个为一个训练过的分类器，第二个参数是在某个数据集上评价的数据集
		eval.evaluateModel(m_classifier, instancesTest);
		
		System.out.println(eval.toClassDetailsString());  
        System.out.println(eval.toSummaryString());  
        System.out.println(eval.toMatrixString());  
        
       /* m_classifier.buildClassifier(instancesTrain); // 训练
        for (int i = 0; i < sum; i++)// 测试分类结果
        {
            double predicted = m_classifier.classifyInstance(instancesTest.instance(i));
            System.out.println("预测某条记录的分类id：" + predicted + ", 分类值："
                    + instancesTest.classAttribute().value((int) predicted));
            System.out.println("测试文件的分类值： " + instancesTest.instance(i).classValue() + ", 记录："
                    + instancesTest.instance(i));
            System.out.println("--------------------------------------------------------------");
 
            // 如果预测值和答案值相等（测试语料中的分类列提供的须为正确答案，结果才有意义）
            if (m_classifier.classifyInstance(instancesTest.instance(i)) == instancesTest.instance(i)
                    .classValue()) {
                right++;// 正确值加1
            }
        }
        // 请将文件内容的第一列 ? 换成正确答案，才能评判分类预测的结果，本例中只是单纯的预测，下面的输出没有意义。
        System.out.println("J48 classification precision:" + (right / sum));*/
    }
}
