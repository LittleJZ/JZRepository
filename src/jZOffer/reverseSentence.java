package jZOffer;

public class reverseSentence {

	/**student. a am I to I am a student
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String ReverseSentence(String str) {
		char[] arr =str.toCharArray();
		fanzhuan(arr, 0, arr.length-1);
		int black =-1;
		for(int i=0;i<str.length();i++){
			
			if(arr[i]== ' '){
				int next=i;
				fanzhuan(arr, black+1, next-1);
				black=next;
			}
			
			
		}
		fanzhuan(arr, black+1, arr.length-1);
		return new String(arr);
		
	}
	public void fanzhuan(char [] arr,int start,int end){
		while(start<end){
			char temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}

}
