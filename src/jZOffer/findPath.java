package jZOffer;

import java.util.ArrayList;

public class findPath {

	/**
	 * @param args
	 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ����
	 * �ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
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
