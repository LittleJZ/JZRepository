package Sort;

import java.util.Arrays;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array ={3,9,-1,10,-2};
		int temp;
		boolean flag=false;
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<array.length-1-i;j++){
				
				if(array[j]>array[j+1]){
					flag=true;
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			
			}
			if(!flag){
				break;
			}else{
				flag=false;
			}
		}
		System.out.println(Arrays.toString(array));

	}

}
