package Search;

public class SeqSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={1,4,6,8,-1};
		System.out.println(seqSearch(arr, 4));
	}
	//œﬂ–‘≤È’“
	public static int seqSearch(int[] arr,int value){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==value){
				return i;
			}
		}
		return -1;
	}
	
}
