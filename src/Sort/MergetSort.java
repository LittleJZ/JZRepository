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
			//��ݹ��
			mergeSort(arr, left, mid, temp);
			//�ҵݹ��
			mergeSort(arr, mid+1, right, temp);
			merge(arr, left, mid, right, temp);
			
		}
		
	}
	
	public static void merge(int[] arr,int left,int mid ,int right,int[] temp){
		int i=left;
		int j=mid+1;
		int t=0;
		//��˳�����temp������
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
		//����һ�����ʽ����һ��û����ᣬ��������temp��
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
		//��temp���鸳ֵ��ԭʼ����
		t=0;
		int tempLeft=left;
		while(tempLeft<=right){
			arr[tempLeft]=temp[t];
			tempLeft+=1;
			t+=1;
		}
	}

}
