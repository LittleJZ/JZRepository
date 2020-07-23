package jZOffer;

//字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
public class leftRotateString {

	public String LeftRotateString(String str, int n) {
		int len =str.length();
		if(len==0) return "";
		n= n%len;
		str+=str;
		return str.substring(n, len+n);
	}
}
