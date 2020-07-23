package Sort;

import java.util.Arrays;

public class RadixSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={53,3,542,748,14,214};
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void radixSort(int[] arr){
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			if(max<arr[i]){
				max=arr[i];
			}
		}
		int maxLength= (max+"").length();
		int[][] bucket =new int[10][arr.length];
		int[] bucketCounts=new int[10];
		for(int i=0,n=1;i<maxLength;i++,n*=10){
			for(int j=0;j<arr.length;j++){
				int count=arr[j] /n %10;
				bucket[count][bucketCounts[count]] =arr[j];
				bucketCounts[count]++;
			}
			int index=0;
			for(int k=0;k<bucketCounts.length;k++){
				if(bucketCounts[k]!=0){
				for(int j=0;j<bucketCounts[k];j++){
					arr[index]=bucket[k][j];
					index++;
				}
				bucketCounts[k]=0;
				}
			}
		}
	}

}
