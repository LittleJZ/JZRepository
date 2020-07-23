package tree;

import javax.swing.text.Position.Bias;

public class BinaryTreeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		BinaryTree binaryTree =new BinaryTree();
		HeroNode root =new HeroNode(1, "宋江");
		HeroNode node1 =new HeroNode(2, "卢俊义");
		HeroNode node2 =new HeroNode(3, "吴用");
		HeroNode node3 =new HeroNode(4, "公孙胜");
		HeroNode node4 =new HeroNode(5, "关胜");
		root.setLeft(node1);
		root.setRight(node2);
		node2.setRight(node3);
		node2.setLeft(node4);
		binaryTree.setRoot(root);
		binaryTree.preOrder();
		binaryTree.delNode(3);
		binaryTree.preOrder();
//		binaryTree.midOrder();
//		binaryTree.postOrder();
//		HeroNode resNode=null;
//		resNode= binaryTree.preOrderSearch(15);
//		if(resNode!=null){
//			System.out.println(resNode.getNo()+resNode.getName());
//		}else{
//			System.out.println("未找到");
//		}
//		
//		resNode= binaryTree.midOrderSearch(5);
//		if(resNode!=null){
//			System.out.println(resNode.getNo()+resNode.getName());
//		}else{
//			System.out.println("未找到");
//		}
//
//		resNode= binaryTree.postOrderSearch(5);
//		if(resNode!=null){
//			System.out.println(resNode.getNo()+resNode.getName());
//		}else{
//			System.out.println("未找到");
//		}
		
	}

}
class BinaryTree{
	private HeroNode root;

	
	

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	public void delNode(int no){
		if(this.root != null){
			if(this.root.getNo() == no){
				this.root =null;
			}else{
				this.root.delNode(no);
			}
		}else{
			System.out.println("树为空");
		}
	}
	
	public void preOrder(){
		if(this.root != null){
			this.root.preOrder();
		}else{
			System.out.println("为空");
		}
	}
	
	public void midOrder(){
		if(this.root != null){
			this.root.midOrder();
		}else{
			System.out.println("为空");
		}
	}
	
	public void postOrder(){
		if(this.root != null){
			this.root.postOrder();
		}else{
			System.out.println("为空");
		}
	}
	
	public HeroNode preOrderSearch(int no){
		if(this.root != null){
			return this.root.preOrderSearch(no);
		}else{
			return null;
		}
	}
	public HeroNode midOrderSearch(int no){
		if(this.root !=null){
			return this.root.midOrderSearch(no);
		}
		else{
			return null;
		}
	}
	
	public HeroNode postOrderSearch(int no){
		if(this.root != null){
			return this.root.postOrderSearch(no);
		}
		else{
			return null;
		}
	}
	
	
}

class HeroNode{
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	
	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HeroNode getLeft() {
		return left;
	}
	public void setLeft(HeroNode left) {
		this.left = left;
	}
	public HeroNode getRight() {
		return right;
	}
	public void setRight(HeroNode right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
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
	public void midOrder(){
		if(this.left != null){
			this.left.midOrder();
		}
		System.out.println(this);
		if(this.right != null){
			this.right.midOrder();
		}
	}
	
	public void postOrder(){
		if(this.left != null){
			this.left.postOrder();
		}
		if(this.right != null){
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
	public HeroNode preOrderSearch(int no){
		HeroNode resNode=null;
		System.out.println("前序查找");
		if(this.no==no){
			return this;
		}
		if(this.left != null){
			resNode = this.left.preOrderSearch(no);
		}
		if(resNode != null){
			return resNode;
		}
		
		if(this.right != null){
			resNode =this.right.preOrderSearch(no);
		}
		return resNode;
	}
	
	public HeroNode midOrderSearch(int no){
		HeroNode resNode= null;
		if(this.left != null){
			resNode = this.left.midOrderSearch(no);
		}
		if(resNode != null){
			return resNode;
		}
		System.out.println("中序查找");
		if(this.no == no){
			return this;
		}
		
		if(this.right!= null){
			resNode = this.right.midOrderSearch(no);
		}
		return resNode;
	}
	
	public HeroNode postOrderSearch(int no){
		HeroNode resNode= null;
		if(this.left != null){
			resNode = this.left.postOrderSearch(no);
		}
		if(resNode != null){
			return resNode;
		}
		if(this.right != null){
			resNode = this.right.postOrderSearch(no);
		}
		if(resNode != null){
			return resNode;
		}
		System.out.println("后续查找");
		if(this.no==no){
			return this;
		}
		return resNode;
		
	}
	
	public void delNode(int no){
		if(this.left != null && this.left.no== no){
			this.left =null;
			return;
		}
		if(this.right != null && this.right.no == no){
			this.right = null;
			return;
		}
		if(this.left != null){
			this.left.delNode(no);
		}
		if(this.right != null){
			this.right.delNode(no);
		}
	}
	
}
