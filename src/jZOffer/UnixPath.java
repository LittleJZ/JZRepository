package jZOffer;

import java.util.Stack;

public class UnixPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path="/a/./b/../../c/";
		UnixPath u =new UnixPath();
		u.simplifyPath(path);
	}
	
	public String simplifyPath(String path) {
		String[] s =path.split("/");
		Stack<String> stack =new Stack<>();
		for(int i=0;i<s.length;i++){
			if(!stack.empty() && s[i].equals("..")){
				stack.pop();
			}else if(!s[i].equals("") && !s[i].equals(".") && !s[i].equals("..")){
				stack.push(s[i]);
			}
		}
		if(stack.empty()){
			return "/";
		}
		StringBuffer res = new StringBuffer();
		for(int i=0;i<stack.size();i++){
			res.append("/"+stack.get(i));
		}
		return res.toString();
		

	}

}
