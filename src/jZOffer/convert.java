package jZOffer;

import java.util.Stack;

public class convert {

	/**
	 * @param args
	 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

	/*public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree == null) return null;
		Stack<TreeNode> s= new Stack<TreeNode>();
		TreeNode pre = null;
		boolean isFirst =true;
		
		TreeNode root= pRootOfTree;
		while(root!= null || !s.isEmpty()){
			while(root!= null){
				s.push(root);
				root=root.left;
			}
			
			root =s.pop();
			if(isFirst){
				pRootOfTree =root;
				pre =pRootOfTree;
				isFirst=false;
			}else{
				pre.right =root;
				root.left=pre;
				pre=root;
			}
			root =root.right;
			
			
		}
		return pRootOfTree;
	}*/

}

