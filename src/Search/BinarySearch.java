package Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BinarySearch {

	/**二分查找，数组必须有序
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,8,10,67,89,1000,1313};
		ArrayList<Integer> list=binarySearch3(arr, 0, arr.length-1, 1000);
		System.out.println(list);
	}
	public static int binarySearch(int[] arr,int left, int right,int findValue){
		if(left>right){
			return -1;
		}
		int mid=(left+right)/2;
		int midValue=arr[mid];
		if(findValue>midValue){
			return binarySearch(arr, mid+1, right, findValue);
		}else if(findValue<midValue){
			return binarySearch(arr, left, mid-1, findValue);
		}else{
			return mid;
		}
	}
	
	public static ArrayList<Integer> binarySearch2(int[] arr,int left, int right,int findValue){
		if(left>right){
			return new ArrayList<Integer>();
		}
		int mid=(left+right)/2;
		int midValue=arr[mid];
		if(findValue>midValue){
			return binarySearch2(arr, mid+1, right, findValue);
		}else if(findValue<midValue){
			return binarySearch2(arr, left, mid-1, findValue);
		}else{
			ArrayList<Integer> resultList =new ArrayList<>();
			int temp=mid-1;
			while(true){
				if(temp<0 || arr[temp]!=findValue){
					break;
				}
				resultList.add(temp);
				temp-=1;
			}
			resultList.add(mid);
			temp=mid+1;
			while(true){
				if(temp>arr.length-1 || arr[temp]!=findValue){
					break;
				}
				resultList.add(temp);
				temp+=1;
			}
			return resultList;
		}
	}
	
	public static ArrayList<Integer> binarySearch3(int[] arr,int left, int right,int findValue){
		if(left>right){
			return new ArrayList<Integer>();
		}
		int mid=(left+right)/2;
		int midValue=arr[mid];
		if(findValue>midValue){
			return binarySearch2(arr, mid+1, right, findValue);
		}else if(findValue<midValue){
			return binarySearch2(arr, left, mid-1, findValue);
		}else{
			ArrayList<Integer> resultList =new ArrayList<>();
			int temp=mid-1;
			while(true){
				if(temp<0 || arr[temp]!=findValue){
					break;
				}
				temp-=1;
			}
			if(temp<0){
				resultList.add(0);
			}else{
				resultList.add(temp+1);
			}
			temp=mid+1;
			while(true){
				if(temp>arr.length-1 || arr[temp]!=findValue){
					break;
				}
				temp+=1;
			}
			if(temp>arr.length-1){
				resultList.add(arr.length-1);
			}else{
				resultList.add(temp-1);
			}
			return resultList;
		}
	}

}
