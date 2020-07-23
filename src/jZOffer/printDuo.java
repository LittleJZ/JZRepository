package jZOffer;

import java.util.ArrayList;

public class printDuo {

	/**
	 * @param args
	 * 把二叉树打印成多行
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
	    
		ArrayList<ArrayList<Integer>> result =new ArrayList<ArrayList<Integer>>();
		ArrayList<TreeNode> nodeList= new ArrayList<>();
		ArrayList<Integer> list =new ArrayList<>();
		if(pRoot== null) return result;
		nodeList.add(pRoot);
		int start=0,end=1;
		while(!nodeList.isEmpty()){
			TreeNode node =nodeList.remove(0);
			list.add(node.val);
			start++;
			if(node.left!=null){
				nodeList.add(node.left);
				
			}
			if(node.right!= null){
				nodeList.add(node.right);
			}
			if(start==end){
				result.add(new ArrayList<>(list));
				end=nodeList.size();
				start=0;
				list=new ArrayList<>();
			}
		}
		return result;
    }

}
