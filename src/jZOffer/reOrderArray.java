package jZOffer;

public class reOrderArray {

	/**
	 * @param args
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
	 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void ReOrderArray(int[] array) {
	
		int length=array.length;
		int k=0;
		for(int i=0;i<length;i++){
			if(array[i]%2==1){
				int j=i;
				int temp=array[j];
				while(j>k){
					
					array[j]=array[j-1];
					
					j--;
				}
				array[j]=temp;
				k++;
			}
		}
	}

}
