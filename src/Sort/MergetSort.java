package Sort;

import jZOffer.ListNode;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class MergetSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ssc=new Scanner(System.in);
		String s=ssc.next();
		
		
		System.out.println(s);
				
	}
	
	public static void mergeSort(int[] arr,int left,int right,int[] temp){
		if(left<right){
			int mid =(left+right)/2;
			//左递归分
			mergeSort(arr, left, mid, temp);
			//右递归分
			mergeSort(arr, mid+1, right, temp);
			merge(arr, left, mid, right, temp);
			
		}
		
	}
	
	public static void merge(int[] arr,int left,int mid ,int right,int[] temp){
		int i=left;
		int j=mid+1;
		int t=0;
		//按顺序放入temp数组中
		while(i<= mid && j<=right){
			if(arr[i]<=arr[j]){
				temp[t]=arr[i];
				i+=1;
				t+=1;
			}else{
				temp[t]=arr[j];
				j+=1;
				t+=1;
			}
		}
		//当有一方完结式，另一方没有完结，遍历放入temp中
		while(i<=mid){
			temp[t]=arr[i];
			i+=1;
			t+=1;
		}
		while(j<=right){
			temp[t]= arr[j];
			j+=1;
			t+=1;
		}
		//把temp数组赋值给原始数组
		t=0;
		int tempLeft=left;
		while(tempLeft<=right){
			arr[tempLeft]=temp[t];
			tempLeft+=1;
			t+=1;
		}
	}

}
