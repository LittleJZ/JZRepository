package jZOffer;

import java.util.Stack;

public class convert {

	/**
	 * @param args
	 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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

