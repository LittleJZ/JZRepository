package jZOffer;

public class offer1 {

	/**
	 * @param args
	 * 统计一个数字在排序数组中出现的次数。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int GetNumberOfK(int [] array , int k) {
		   int count =1;
	       int index =findCount(array,k,0,array.length-1);
	       if(index ==-1) return 0;
	       for(int i=index-1;i>=0;i--){
	    	   if(array[i]==k){
	    		   count++;
	    	   }
	       }
	       for(int j=index+1;j<array.length;j++){
	    	   if(array[j]==k){
	    		   count++;
	    	   }
	       }
	       return count;
	 }
	 public int findCount(int [] array , int k,int l,int r){
		 int left=l;
		 int rg=r;
		
		 while(left<=rg){
			 int mid=(rg-left)/2+left;
			 if(array[mid]<k){
				 left=mid+1;
			 }else if(array[mid]>k){
				 rg=mid-1;
			 }else{
				 return mid;
			 }
		 }
		 return -1;
	 }

}
