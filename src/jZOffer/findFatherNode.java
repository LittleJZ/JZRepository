package jZOffer;

public class findFatherNode {

	/**
	 * @param args
	 * leetcode 236寻找二叉树最近公共父节点
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public TreeNode ans=null;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		helper(root, p, q);
		return ans;
	}

	public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return false;
		}
		int left = helper(root.left, p, q) ? 1 : 0;
		int right = helper(root.right, p, q) ? 1 : 0;
		int mid = (root == p || root == q) ? 1 : 0;
		if (mid + left + right >= 2) {
			ans = root;
		}
		return (mid + left + right > 0);
	}

}
