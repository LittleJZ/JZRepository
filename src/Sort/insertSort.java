package Sort;

import java.util.Arrays;

public class insertSort {

	public static void main(String[] args) {
		//简单插入排序当较小的数在后面时，后移次数增多，效率变低
		int[] arr ={101,34,119,1,-1,89};
		System.out.println(Arrays.toString(arr));
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void insertSort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int insertValue=arr[i];
			int insertIndex=i-1;
			while(insertIndex>=0 && arr[insertIndex]>insertValue){
				arr[insertIndex+1]=arr[insertIndex];
				insertIndex--;
			}
			if(insertIndex+1 !=i){
				arr[insertIndex+1]=insertValue;
			}
		}
	}
	
}
