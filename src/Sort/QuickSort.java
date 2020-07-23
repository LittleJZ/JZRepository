package Sort;

import java.util.Arrays;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={-9,78,22,0,23,-567,70,-1}; 
		QuickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void QuickSort(int[] arr,int left,int right){
		int l=left;
		int r=right;
		int pivot=arr[(left+right)/2];
		int temp=0;
		while(l<r){
			//
			while(arr[l]<pivot){
				l+=1;
			}
			//
			while(arr[r]>pivot){
				r-=1;
			}
			if(l>=r){
				break;
			}
			temp=arr[l];
			arr[l]=arr[r];
			arr[r]=temp;
			/*if(arr[l]==pivot){
				r--;
			}
			if(arr[r]==pivot){
				l++;
			}*/
			QuickSort(arr, left, r);
			QuickSort(arr, l, right);
			
		}
	}

}
