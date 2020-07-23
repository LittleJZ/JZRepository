package jZOffer;

public class deleteDuplication {

	/**
	 * @param args
	 * 删除链表中重复节点
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode deleteDuplication(ListNode pHead) {

		ListNode head=new ListNode(0);
		head.next=pHead;
		ListNode pre =head;
		ListNode last=head.next;
		while(last!= null){
			if(last.next!=null &&last.val ==last.next.val){
				while(last.next!=null && last.val ==last.next.val){
					last=last.next;
				}
				pre.next=last.next;
				last=last.next;
			}
			else{
				pre=pre.next;
				last=last.next;
			}
		}
		return head.next;
	}

}
