package AVLTreeDemo;

import java.util.Vector;

public class MaxArray {

	int res=Integer.MIN_VALUE;
	int sum=0;
	private static Vector<String> vector=new Vector<>();
	public static void main(String[] args) {
		vector.add("v1");
		vector.add("v2");
		for(int i=0;i<vector.size();i++){
			System.out.println(vector.get(i));
		}
	}
    public int maxSubArray(int[] nums) {
    	for(int i=0;i<nums.length;i++){
    		if(sum<=0){
    			sum=nums[i];
    		}else{
    			sum+=nums[i];
    		}
    		if(sum>res){
    			res=sum;
    		}
    	}
    	return res;
    }
    
    public int maxSubArray2(int[] nums) {
    	int res=nums[0];
    	for(int i=1;i<nums.length;i++){
    		nums[i]+=Math.max(nums[i-1], 0);
    		res=Math.max(res, nums[i]);
    	}
    	return res;
    }
    
}
