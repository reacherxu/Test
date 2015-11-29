package org.xzt.test.socket_thread;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

import weka.clusterers.EM;
import weka.clusterers.FarthestFirst;
import weka.clusterers.HierarchicalClusterer;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class ClusterArithmeticAction {
	Instances insdata = null;
	Instances insdataClusterer  = null;
	String path="";
	int NumCluster=0;
	public ClusterArithmeticAction(String filename){
		try{
			//��ȡ���·��--------------------------------------
//			File directory = new File(".");
//			path = directory.getCanonicalPath();	    		    	
			//(1)��������----------------------------------------
			DataSource source = new DataSource("D:\\temp\\diabetes.arff");
			insdata = source.getDataSet();
			if (insdata.classIndex() == -1)
				insdata.setClassIndex(insdata.numAttributes() - 1);
			//generate data for clusterer (w/o class)
			Remove filter = new Remove();
			filter.setAttributeIndices("" + (insdata.classIndex() + 1));
			filter.setInputFormat(insdata);
			insdataClusterer = Filter.useFilter(insdata, filter);
			NumCluster = 3;
//			NumCluster = Integer.parseInt(filename.substring(filename.indexOf("_")+1));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	//����SimpleKMeans�����㷨===========================================
	public String SimpleKMeansCluster(String filename){
		filename = "06"+filename.substring(0,filename.indexOf("_"))+"SC"+filename.substring(filename.indexOf("_"))+".txt";  
		try{
			//(1)�����д����±�
			PrintStream ps;        
			FileOutputStream fos = new FileOutputStream(path+"\\AnswerData\\"+filename);
			BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
			ps = new PrintStream(bos, true);
			System.setOut(ps);
			SimpleKMeans KM = new SimpleKMeans();
			//(2)���þ���Ҫ�õ���������� 
			KM.setNumClusters(NumCluster);
			//(3)ʹ�þ����㷨���������о��� 
			KM.buildClusterer(insdataClusterer); 
			//(4)��ӡ������
			for(int i=0;i<insdataClusterer.numInstances();i++)
				System.out.println(KM.clusterInstance(insdataClusterer.instance(i)));
			//���������-----
			bos.close();
			fos.close();
			ps.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return filename;
	}

	//����EM�����㷨===========================================
	public String EMCluster(String filename){
		filename = "06"+filename.substring(0,filename.indexOf("_"))+"EM"+filename.substring(filename.indexOf("_"))+".txt";  
		try{
			//(1)�����д����±�
			PrintStream ps;        
			FileOutputStream fos = new FileOutputStream(path+"\\AnswerData\\"+filename);
			BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
			ps = new PrintStream(bos, true);
			System.setOut(ps);
			//(2)��������----------------------------------------	    	
			String[] options = weka.core.Utils.splitOptions("-I 100 -N "+ NumCluster+" -M 1.0E-6 -S 100");
			//ѧϰһ��EMcluster������EM
			EM EMcluster = new EM();           // new instance of EMcluster
			EMcluster.setOptions(options);     // set the options
			EMcluster.buildClusterer(insdataClusterer);    // build the EMcluster	    	
			//������۽��	    	
			for(int i=0;i<insdataClusterer.numInstances();i++)
				System.out.println(EMcluster.clusterInstance(insdataClusterer.instance(i)));
			//���������-----
			bos.close();
			fos.close();
			ps.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return filename;
	}

	//����FarthestFirst�����㷨===========================================
	public String FarthestFirstCluster(String filename){
//		filename = "06"+filename.substring(0,filename.indexOf("_"))+"FF"+filename.substring(filename.indexOf("_"))+".txt";  
		try{
			//(1)�����д����±�
			PrintStream ps;        
			FileOutputStream fos = new FileOutputStream("D:\\temp\\diabetes.arff");
			BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
			ps = new PrintStream(bos, true);
			System.setOut(ps);
			//(2)��������----------------------------------------	    	
			String[] options = new String[2];
			options[0] = "-S";                 // max. iterations
			options[1] = "100";
			//ѧϰһ��FarthestFirstCluster������farthestFirstcluster
			FarthestFirst farthestFirstcluster = new FarthestFirst();           // new instance of EMcluster
			farthestFirstcluster.setOptions(options);     // set the options
			farthestFirstcluster.setNumClusters(NumCluster);
			farthestFirstcluster.buildClusterer(insdataClusterer);    // build the EMcluster	    	
			//������۽��	    	
			for(int i=0;i<insdataClusterer.numInstances();i++)
				System.out.println(farthestFirstcluster.clusterInstance(insdataClusterer.instance(i)));
			//���������-----
			bos.close();
			fos.close();
			ps.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return filename;
	}

	//����Hierarchical�����㷨===========================================
	public String HierarchicalCluster(String filename){
		filename = "06"+filename.substring(0,filename.indexOf("_"))+"HC"+filename.substring(filename.indexOf("_"))+".txt";  
		try{
			//(1)�����д����±�
			PrintStream ps;        
			FileOutputStream fos = new FileOutputStream(path+"\\AnswerData\\"+filename);
			BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
			ps = new PrintStream(bos, true);
			System.setOut(ps);
			//(2)��������----------------------------------------	    	
			String[] options = new String[2];
			options[0] = "-L";                 
			options[1] = "WARD";
			//ѧϰһ��HierarchicalCluster
			HierarchicalClusterer Hicluster = new HierarchicalClusterer();// new instance of EMcluster
			Hicluster.setOptions(options);     // set the options
			Hicluster.setNumClusters(NumCluster);
			Hicluster.buildClusterer(insdataClusterer);    // build the EMcluster	    	
			//������۽��	    	
			for(int i=0;i<insdataClusterer.numInstances();i++)
				System.out.println(Hicluster.clusterInstance(insdataClusterer.instance(i)));
			//���������-----
			bos.close();
			fos.close();
			ps.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return filename;
	}

	public static void main(String[] args) {
		String filename = "diabetes";
		ClusterArithmeticAction ins = new ClusterArithmeticAction(filename);
		ins.FarthestFirstCluster(filename);
	}

}
