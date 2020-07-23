package Search;

import java.util.Arrays;

public class FibonacciSearch {

	/**
	 * @param args
	 * 斐波那契查找，也应用于有序数组
	 */
	public static int maxSize=20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,8,10,89,1000,1234};
		System.out.println(fibSearch(arr, 1234));
	}
	public static int[] fib(){
		int[] f=new int[maxSize];
		f[0]=1;
		f[1]=1;
		for(int i=2;i<f.length;i++){
			f[i]=f[i-1]+f[i-2];
		}
		return f;
	}
	public static int fibSearch(int[] arr,int value){
		int low=0;
		int high=arr.length-1;
		int mid=0;
		int k=0;
		int[] f=fib();
		while(high>f[k]-1){
			k++;
		}
		int[] temp=Arrays.copyOf(arr, f[k]);
		for(int i=high+1;i<temp.length;i++){
			temp[i]=arr[high];
		}
		while(low<=high){
			mid=low+f[k-1]-1;
			if(value<temp[mid]){
				high=mid-1;
				k--;
			}else if(value>temp[mid]){
				low=mid+1;
				k-=2;
			}else{
				if(mid<=high){
					return mid;
				}else{
					return high;
				}
			}
		}
		return -1;
	}

}
