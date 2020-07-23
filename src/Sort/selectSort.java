package Sort;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class selectSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {101,34,119,1,-1,90,123};
		System.out.println(Arrays.toString(arr));
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void selectSort(int[] arr){
		for(int i=0;i<arr.length -1 ;i++){
			int minIndex=i;
			int min=arr[i];
			for(int j=i+1; j<arr.length;j++){
				if(min>arr[j]){
					min=arr[j];
					minIndex=j;
				}
			}
			if(minIndex!=i){
				arr[minIndex]=arr[i];
				arr[i]=min;
			}
			
		}
	}

}
