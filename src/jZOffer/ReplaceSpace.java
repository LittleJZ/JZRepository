package jZOffer;

public class ReplaceSpace {

	/**
	 * @param args
	 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer str=new StringBuffer("hello world");
		String result=replaceSpace(str);
		System.out.println(result);
	}

	public static String replaceSpace(StringBuffer str) {
		int count=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' '){
				count++;
			}
		}
		int oldlength=str.length()-1;
		int nowLength= str.length() + 2*count;
		str.setLength(nowLength);
		for(int i=oldlength;i>=0;i--){
			if(str.charAt(i)!=' '){
				str.setCharAt(i+2*count, str.charAt(i));
			}else{
				count--;
				str.setCharAt(i+2*count, '%');
				str.setCharAt(i+2*count+1, '2');
				str.setCharAt(i+2*count+2, '0');
			}
		}
		return str.toString();
	}

}
