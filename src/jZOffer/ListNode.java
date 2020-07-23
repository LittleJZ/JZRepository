package jZOffer;

public class ListNode {
	public static void main(String[] args) {
		ListNode l1= new ListNode(0);
		ListNode l3 =new ListNode(1);
		l1.next =l3;
		ListNode l2=l1;
		l2=l2.next;
		System.out.println(l1);
		System.out.println(l2);
	}

	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

