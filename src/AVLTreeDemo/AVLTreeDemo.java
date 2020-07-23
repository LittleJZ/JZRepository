package AVLTreeDemo;





public class AVLTreeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={10,11,7,6,8,9};
		AVLTree tree= new AVLTree();
		
		for(int i=0;i<arr.length;i++){
			tree.add(new Node(arr[i]));
		}
		tree.midOrder();
		System.out.println(tree.getRoot().height());
		System.out.println(tree.getRoot().leftHeight());
		System.out.println(tree.getRoot().rightHeight());
		System.out.println(tree.getRoot().right);
	}

}

class AVLTree{
	Node root;
	
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
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
	public int leftHeight(){
		if(left== null){
			return 0;
		}
		return left.height();
	}
	public int rightHeight(){
		if(right==null){
			return 0;
		}
		return right.height();
	}
	
	public int height(){
		return Math.max(left ==null?0:left.height(),right== null? 0:right.height())+1;
	}
	
	private void leftRotate(){
		Node newNode = new Node(value);
		//把新节点的左子树设置为当前节点的左子树
		newNode.left = left;
		newNode.right =right.left;
		value =right.value;
		right=right.right;
		left =newNode;
	}
	
	private void rightRotate(){
		Node newNode = new Node(value);
		newNode.right =right;
		newNode.left =left.right;
		value= left.value;
		left = left.left;
		right =newNode;
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
		//左旋转
		if(rightHeight()-leftHeight()>1){
			if(right!= null && right.leftHeight() > right.leftHeight()){
				right.rightRotate();
				leftRotate();
			}else{
			this.leftRotate();
			}
			return;
		}
		if(leftHeight() -rightHeight() >1){
			if(left!= null && left.rightHeight() > left.leftHeight()){
				left.leftRotate();
				this.rightRotate();
			}else{
			this.rightRotate();
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
