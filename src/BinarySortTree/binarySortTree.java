package BinarySortTree;

import java.lang.annotation.Target;

public class binarySortTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={7,3,10,12,5,1,9,0};
		BinarySortTree22 tree =new BinarySortTree22();
		for(int i=0;i<arr.length;i++){
			tree.add(new Node(arr[i]));
		}
		tree.midOrder();
		//测试删除叶子节点
		tree.delete(0);
		tree.delete(5);
		tree.delete(9);
		tree.delete(12);
		tree.delete(7);
		tree.delete(3);
		tree.delete(10);
		tree.delete(1);
		System.out.println("----------------");
		tree.midOrder();
	}

}

class BinarySortTree22{
	Node root;
	public Node search(int value){
		if(root == null ){
			return null;
		}else{
			return root.search(value);
		}
	}
	public int delRigthTreeMin(Node node){
		Node temp=node;
		while(temp.left!= null){
			temp=temp.left;
		}
		delete(temp.value);
		return temp.value;
	}
	public Node parentSearch(int value){
		if(root== null){
			return null;
		}else{
			return  root.parentSearch(value);
		}
	}
	
	public void delete(int value){
		if(root == null){
			return;
		}else{
			Node targetNode =root.search(value);
			if(targetNode == null){
				return;
			}
			if(root.left == null && root.right == null){
				root= null;
				return;
			}
			Node parent =root.parentSearch(value);
			if(targetNode.left == null && targetNode.right ==null){
				if(parent.left!= null && parent.left== targetNode){
					parent.left=null;
				}else if(parent.right != null && parent.right ==targetNode){
					parent.right =null;
				}
			}else if(targetNode.left != null && targetNode.right != null){
				int temp=delRigthTreeMin(targetNode.right);
				targetNode.value=temp;
			}else{
				if(targetNode.left!= null){
					if(parent!=null){
					if(parent.left.value == value){
						parent.left =targetNode.left;
					}else{
						parent.right =targetNode.left;
					}
					}else{
						root=targetNode.left;
					}
				}else{
					if(parent!= null){
					if(parent.left.value ==value){
						parent.left =targetNode.right;
					}else{
						parent.right =targetNode.right;
					}
					}else{
						root=targetNode.right;
					}
				}
			}
			
		}
	}
	public void add(Node node){
		if (root == null){
			root=node;
		}else{
			root.add(node);
		}
	}
	public void midOrder(){
		if(root == null){
			System.err.println("为空");
		}else{
			root.midOrder();
		}
	}
}
class Node{
	int value;
	Node left;
	Node right;
	public Node(int value) {
		super();
		this.value = value;
	}
	

	/**
	 * 查找到要删除的节点
	 * @param value 要删除节点的值
	 */
	public Node search(int value){
		if(this.value == value){
			return this;
		}else if(value < this.value){
			if(this.left != null){
				return this.left.search(value);
			}
		}else{
			if(value>this.value){
				if(this.right != null){
					return this.right.search(value);
				}
			}
		}
		return null ;
	}
	/**
	 * 查找要删除节点的父节点
	 * @param value
	 * @return
	 */
	public Node parentSearch(int value) {
		if ((this.left != null && this.left.value == value)
				|| (this.right != null && this.right.value == value)) {
			return this;
		} else {
			if (this.left != null && value < this.value) {
				return this.left.parentSearch(value);
			} else if (this.right != null && value > this.value) {
				return this.right.parentSearch(value);
			} else {
				return null;
			}
		}

	}
	
	public void add(Node node){
		if(node==null){
			return ;
		}
		if(node.value<this.value){
			if(this.left == null){
				this.left = node;
			}else{
				this.left.add(node);
			}
		}else{
			if(this.right == null){
				this.right =node;
			}else{
				this.right.add(node);
			}
		}
	}
	public void midOrder(){
		if(this.left!= null){
			this.left.midOrder();
		}
		System.out.println(this);
		if(this.right!=null){
			this.right.midOrder();
		}
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
}
