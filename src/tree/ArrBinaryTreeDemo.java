package tree;

public class ArrBinaryTreeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={1,2,3,4,5,6,7};
		ArrBinaryTree tree=new ArrBinaryTree(arr);
		tree.preOrder();

	}

}

class ArrBinaryTree{
	private int[] arr;

	public ArrBinaryTree(int[] arr) {
		super();
		this.arr = arr;
	}
	public void preOrder(){
		this.preOrder(0);
	}
	
	
	public void preOrder(int index){
		if(arr==null || arr.length==0){
			System.out.println("Êý×éÎª¿Õ");
		}else{
			System.out.println(arr[index]);
			if(2*index+1<arr.length){
				preOrder(2*index+1);
			}
			if(2*index+2<arr.length){
				preOrder(2*index+2);
			}
		}
	}
	
}
