package jZOffer;

import java.util.Stack;

public class getNext {

	/**二叉树的下一个节点
	 * @param args
	 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums={3,5,1};
		getNext g= new getNext();
		int c=g.search(nums, 3);
		System.out.println(c);
	}
	
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if(pNode == null) return null;
		
		
		
		if(pNode.right!=null){
			pNode= pNode.right;
			while(pNode.left!= null){
				pNode=pNode.left;
			}
			return pNode;
		}
		
		while(pNode.next!= null){
			
			if(pNode.next.left ==pNode) return pNode.next;
			pNode=pNode.next;
		}
		return null;

	}
	
	public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int low =0;
        int hei= nums.length-1;
   
        while(low<=hei){
           int mid =low + (hei -low)/2;
            if(target==nums[mid]){
                return mid;
            }
            if(nums[mid]<	nums[hei]){
            	if(nums[mid]<target && target<=nums[hei]){
            		low =mid+1;
            	}else{
            		hei =mid-1;
            	}
            }else{
            	if(nums[mid]>target && target>=nums[low]){
            		hei =mid-1;
            	}else{
            		low=mid+1;
            	}
            }
        }
     
     return -1;

    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
