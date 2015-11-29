package xzt.gbk;

import kevin.zhang.NLPIR;

public class TestWordSeperation {

	public static void main(String[] args) {
		try {
			testUTF8();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void testUTF8() throws Exception {
		// �����ӿ�ʵ��
		NLPIR nlpir = new NLPIR();
		// NLPIR_Init�����ڶ�����������0��ʾ����ΪGBK, 1��ʾUTF8����(�˴����۲���Ȩ��)
		if (!NLPIR.NLPIR_Init("./file/".getBytes("utf-8"), 1)) {
			System.out.println("NLPIR��ʼ��ʧ��...");
			return;
		}
		String temp = "ÿ����ձ����ǵ�Ҫ����, ����Ͼ���������Ŀ�Ľ������.";
		// Ҫͳһ����, ����ִʽ�����������
		byte [] resBytes = nlpir.NLPIR_ParagraphProcess(temp.getBytes("UTF-8"), 1);
		System.out.println("�ִʽ��: " + new String(resBytes, "UTF-8"));
		
		String utf8File = "./test/test-utf8.TXT";
		String utf8FileResult = "./test/test-utf8_result.TXT";
		nlpir.NLPIR_FileProcess(utf8File.getBytes("utf-8"), utf8FileResult.getBytes("utf-8"), 1);
		
		// �˳�, �ͷ���Դ
		NLPIR.NLPIR_Exit();
	}
}

