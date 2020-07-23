package Sort;

import java.util.Arrays;

public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={4,6,8,5,9};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	public static void heapSort(int[] arr){
		int temp=0;
		for(int i=arr.length/2-1;i>=0;i--){
			adjustHeap(arr, i, arr.length);
		}
		for(int j=arr.length-1;j>0;j--){
			temp=arr[j];
			arr[j]=arr[0];
			arr[0]=temp;
			adjustHeap(arr, 0, j);
		}
	}
	
	public static void adjustHeap(int[] arr,int i,int length){
		int temp=arr[i];
		for(int k=2*i+1;k<length;k=k*2+1){
			if(k+1<length && arr[k]<arr[k+1]){
				k++;
			}
			if(temp<arr[k]){
				arr[i]=arr[k];
				i=k;
			}else{
				break;
			}
			
		}
		arr[i]=temp;
	}

}
