package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={13,7,8,3,29,6,1};
		Node node=createHuffmanTree(arr);
		preOrder(node);
		
	}
	public static Node createHuffmanTree(int[] arr){
		List<Node> list =new ArrayList<Node>();
		for(int value:arr){
			list.add(new Node(value));
		}
		while(list.size()>1){
			Collections.sort(list);
			Node left=list.get(0);
			Node right =list.get(1);
			Node parent =new Node(left.value + right.value);
			parent.left=left;
			parent.right=right;
			list.remove(left);
			list.remove(right);
			list.add(parent);
		}
		return list.get(0);
	}
	
	public static void preOrder(Node root){
		if(root != null){
			root.preOrder();
		}else{
			System.out.println("kong");
		}
	}
	

}

class Node implements Comparable<Node>{
	 int value;
	 Node left;
	 Node right;
	
	public Node(int value) {
		super();
		this.value = value;
	}
	public void preOrder(){
		System.out.println(this);
		if(this.left != null){
			this.left.preOrder();
		}
		if(this.right != null){
			this.right.preOrder();
		}
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.value-o.value;
	}
	
}
