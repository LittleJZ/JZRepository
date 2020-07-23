package jZOffer;

import java.util.ArrayList;

public class findPath {

	/**
	 * @param args
	 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树
	 * 的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private ArrayList<ArrayList<Integer>> listAll =new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> list =new ArrayList<>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

		if(root == null) return listAll;
		list.add(root.val);
		target-=root.val;
		if(target==0 && root.left ==null && root.right == null)
			listAll.add(new ArrayList<>(list));
		FindPath(root.left, target);
		FindPath(root.right, target);
		list.remove(list.size()-1);
		return listAll;
	}

}
