package jZOffer;

public class partitionListNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(4);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(2);
		ListNode l5=new ListNode(5);
		ListNode l6=new ListNode(2);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		System.out.println(l1.next.val);
		partitionListNode p1=new partitionListNode();
		p1.partition(l1, 3);


	}
	
	public ListNode partition(ListNode head, int x) {
		ListNode minNode = new ListNode(0);
		ListNode min = minNode;
		ListNode maxNode = new ListNode(0);
		ListNode max = maxNode;
		while (head != null) {
			if (head.val < x) {
				min.next = head;
				min = head;
			} else {
				max.next = head;
				max = head;
			}
			head = head.next;
		}
		max.next = null;
		min.next = maxNode.next;
		return minNode.next;
	}

}
