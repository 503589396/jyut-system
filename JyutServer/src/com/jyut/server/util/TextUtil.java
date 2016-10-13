/**
 * 
 */
package com.jyut.server.util;

/**
 * �����ı������ַ����Ĺ���
 * @date Sep 24, 2016
 * @author wztscau
 * @project ���˹���ϵͳ������
 * 
 */
public class TextUtil {

	/**
	 * Ѱ���ַ���ĳ���ַ����ֵ�x�ε�λ��
	 * @param str Դ�ַ���
	 * @param ch Ҫ��Ѱ��ĳ���ַ�
	 * @param count ���ֵĵ�X��
	 * @return
	 */
	public static int searchCharIndex(String str,char ch,int count) {
		int number = 0;
		char arr[] = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == ch) {
				number++;
			}
			if (number == count) {
				return i; 
			}
		}
		return -1;
	}
	
	/**
	 * ���ַ����г��ֵ�X�ε��ַ��滻����һ���ַ���
	 * @param str Դ�ַ���
	 * @param oldCh ���滻���ַ�
	 * @param newStr �ַ��滻����ַ���
	 * @param count ���滻�ַ����ֵĵ�X��
	 * @return �������ַ���
	 */
	public static String replaceCharIndex(String str,char oldCh,String newStr,int count){
		int index = searchCharIndex(str, oldCh, count);
		if(index>-1){
			StringBuffer sb = new StringBuffer(str);
			StringBuffer replace = sb.replace(index, index+1, newStr);
			return replace.toString(); 
		}
		return str;
	}
}
