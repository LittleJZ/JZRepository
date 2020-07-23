package jZOffer;

public class RebuildTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root =reConstructBinaryTree2(pre,0,pre.length-1,in,0,in.length-1);
		return root;
	}
	
	private TreeNode reConstructBinaryTree2(int[] pre,int startpre,int endpre,int[] in,int startin,int endin){
		if(startpre>endpre || startin>endin){
			return null;
		}
		TreeNode root =new TreeNode(pre[startpre]);
		for(int i= startin;i<=endin;i++){
			if(in[i]==pre[startpre]){
				root.left=reConstructBinaryTree2(pre,startpre+1,startpre+i-startin,in ,startin,i-1);
				root.right =reConstructBinaryTree2(pre,startpre+i-startin+1,endpre, in,i+1,endin);
			}
		}
		return root;
	}

}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

