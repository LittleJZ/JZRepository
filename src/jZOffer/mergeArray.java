package jZOffer;

public class mergeArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergeArray ma =new mergeArray();
		int[] num1={2,0};
		int m=1;
		int[] num2={1};
		int n=1;
		ma.merge(num1, m, num2, n);

	}
	 public void merge(int[] nums1, int m, int[] nums2, int n) {
	        
	        int l=nums1.length-1;
	        if(m==0) {
	            while(n>0&&l>=0){
	                nums1[l]=nums2[n-1];
	                l--;
	                n--;
	            }
	        }
	        while(m>0&&n>0){
	            if(nums1[m-1]>nums2[n-1]){
	                nums1[l]=nums1[m-1];
	                m--;
	                l--;
	            }else{
	                nums1[l]=nums2[n-1];
	                n--;
	                l--;
	            }
	        }
	        while(m>0&&l>=0){
	            nums1[l]=nums1[m-1];
	            m--;
	            l--;
	        }
	         while(n>0&&l>=0){
	            nums1[l]=nums2[n-1];
	            n--;
	            l--;
	        }
	    }

}
