package jZOffer;

//�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
public class leftRotateString {

	public String LeftRotateString(String str, int n) {
		int len =str.length();
		if(len==0) return "";
		n= n%len;
		str+=str;
		return str.substring(n, len+n);
	}
}
