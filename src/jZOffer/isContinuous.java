package jZOffer;

public class isContinuous {

	/**
	 * ÆË¿ËÅÆË³×Ó
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isContinuous(int [] numbers) {

		if(numbers.length==0) return false;
		int[] arr=new int[14];
		int max=-1;
		int min=14;
		for(int i=0;i<numbers.length;i++){
			arr[numbers[i]]++;
			if(numbers[i]==0) continue;
			if(arr[numbers[i]]>1){
				return false;
			}
			if(numbers[i]>max){
				max=numbers[i];
			}
			if(numbers[i]<min){
				min=numbers[i];
			}
		}
		if(max-min>=5){
			return false;
		}else{
			return true;
		}
    }

}
