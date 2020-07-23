package threadedBinaryTree;




public class ThreadedBinaryTreeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HeroNode root =new HeroNode(1, "jack");
		HeroNode herNode1 =new HeroNode(3, "aa");
		HeroNode herNode2 =new HeroNode(6, "bb");
		HeroNode herNode3 =new HeroNode(8, "cc");
		HeroNode herNode4 =new HeroNode(10, "dd");
		HeroNode herNode5 =new HeroNode(14, "ee");
		root.setLeft(herNode1);
		root.setRight(herNode2);
		herNode1.setLeft(herNode3);
		herNode1.setRight(herNode4);
		herNode2.setLeft(herNode5); 
		BinaryTree b =new BinaryTree();
		b.setRoot(root);
		b.MidThreaded(root);
		HeroNode left=herNode4.getLeft();
		HeroNode right= herNode4.getRight();
		System.out.println(left);
		System.out.println(right);
		System.out.println("便利中序线索化二叉树");
		b.MidThreadedList();
	}

}
//线索化二叉树
class BinaryTree{
	private HeroNode root;

	private HeroNode pre =null;
	

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	public void MidThreadedList(){
		HeroNode node =root;
		while(node!=null){
			while(node.getLeftType() ==0){
				node=node.getLeft();
			}
			System.out.println(node);
			while(node.getRightType() ==1){
				node =node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
	}
	//中序线索化二叉树方法
	public void MidThreaded(HeroNode node){
		
		if(node==null){
			return;
		}
		//中序线索化，先处理左子树
			MidThreaded(node.getLeft());
		//处理自身
		if(node.getLeft() == null){
			node.setLeft(pre);
			node.setLeftType(1);
		}
		if(pre!= null && pre.getRight() == null){
			pre.setRight(node);
			pre.setRightType(1);
		}
		pre=node;
		//处理右子树
			MidThreaded(node.getRight());
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
	private int leftType;
	private int rightType;
	
	public int getLeftType() {
		return leftType;
	}
	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}
	public int getRightType() {
		return rightType;
	}
	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
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
