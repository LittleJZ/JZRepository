package jZOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res =new ArrayList();
	        if(root==null) return res;
	        Deque<TreeNode> list =new LinkedList<>();
	        list.add(root);
	        while(!list.isEmpty()){
	            List<Integer> ans =new ArrayList<>();
	            int cnt =list.size();
	            while(cnt>0){
	            	TreeNode temp =list.removeFirst();
	            	ans.add(temp.val);
	
	            	if(temp.left!= null) list.add(temp.left);
	            	if(temp.right!=null) list.add(temp.right);
	            	cnt--;
	            }
	            res.add(ans);
	            
	        }
	        return res;
	    }

}
