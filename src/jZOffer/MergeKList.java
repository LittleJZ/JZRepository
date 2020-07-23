package jZOffer;

public class MergeKList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public ListNode mergeK(ListNode[] lists) {
	        if (lists == null || lists.length == 0) return null;
	        return merge(lists, 0, lists.length - 1);
	   }
	  private ListNode merge(ListNode[] lists,int left,int right){
		  if(left<right){
			  int mid=left+(right-left)/2;
			  ListNode l1=merge(lists, left, mid);
			  ListNode l2=merge(lists, mid+1, right);
			  return mergeList(l1,l2);
		  }
		  return lists[left];
	  }
	  private ListNode mergeList(ListNode l1,ListNode l2){
		  if(l1==null) return l2;
		  if(l2==null) return l1;
		  if(l1.val<l2.val){
			  l1.next=mergeList(l1.next, l2);
			  return l1;
		  }else{
			  l2.next=mergeList(l1, l2.next);
			  return l2;
		  }
	  }

}
