package jZOffer;

import java.util.ArrayList;
import java.util.Stack;

public class PrintZhi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		int floor =1;
		ArrayList<ArrayList<Integer>> list =new ArrayList<ArrayList<Integer>>();
		if(pRoot == null) return list;
		Stack<TreeNode> s1 =new Stack<>();
		Stack<TreeNode> s2 =new Stack<>();
		s1.push(pRoot);
		while(!s1.empty() || !s2.empty()){
			if(floor%2==1){
				ArrayList<Integer> temp =new ArrayList<>();
				while(!s1.empty()){
					TreeNode node =s1.pop();
					if(node != null){
						temp.add(node.val);
						s2.push(node.left);
						s2.push(node.right);
					}
				}
				if(!temp.isEmpty()){
					list.add(temp);
					floor++;
				}
			}else{
				ArrayList<Integer> temp =new ArrayList<>();
				while(!s2.empty()){
					TreeNode node =s2.pop();
					if(node != null){
						temp.add(node.val);
						s1.push(node.right);
						s1.push(node.left);
					}
				}
				if(!temp.isEmpty()){
					list.add(temp);
					floor++;
				}
			}
		}
		return list;

    }

}
