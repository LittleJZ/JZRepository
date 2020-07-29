package mytest;

public class Subsequence {

	   //s = "abc", t = "ahbgdc" true
	   //s = "axc", t = "ahbgdc" false
	public boolean isSubsequence(String s, String t) {
		if (s.length()==0) return true;
		if(t.length()==0) return false;
		int p = 0,q=0;
		while(q<s.length() && p<t.length()){
			if(s.charAt(q)==t.charAt(p)){
				q++;
				p++;
			}else{
				p++;
			}
		}
		return (q==s.length());
		
	}
	public boolean isSubsequence2(String s, String t) {
		int i=0;
		for(char c:s.toCharArray()){
			while(i<t.length() && t.charAt(i)!=c){
				i++;
			}
			i++;
		}
		return i<=t.length();
	}
}
