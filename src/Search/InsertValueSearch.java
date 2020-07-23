package Search;

public class InsertValueSearch {

	/**
	 * @param args
	 * 插值查找；要求数组有序
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr =new int[100];
//		for(int i=0;i<100;i++){
//			arr[i]=i+1;
//		}
		int[] arr={1,8,10,67,89,1000,1313};
		System.out.println(InsertValueSearch(arr, 0, arr.length-1, 1313));
	}
	public static int InsertValueSearch(int[] arr,int left,int right,int findValue){
		if(left>right || findValue<arr[0] || findValue > arr[arr.length-1]){
			return -1;
		}
		int mid =left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
		int midValue= arr[mid];
		if(findValue<midValue){
			return InsertValueSearch(arr, left, mid-1, findValue);
		}else if(findValue>midValue){
			return InsertValueSearch(arr, mid+1, right, findValue);
		}else{
			return mid;
		}
	}

}
