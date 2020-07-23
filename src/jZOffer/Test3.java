package jZOffer;

import java.util.Scanner;

public class Test3 {

	/**
	 * @param args
	 * @return 
	 */
	public static int main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true){
			String s=sc.nextLine();
			String[] arr=s.split(" ");
			int n1=arr[0].length();
			  int n2=arr[1].length();
		        int[][] dp=new int[n1+1][n2+1];
		        int[][] dp2=new int[n1+1][n2+1];
		        for(int i=1;i<n1+1;i++){
		            for(int j=1;j<n2+1;j++){
		                if(arr[0].charAt(i-1)==arr[1].charAt(j-1)){
		                    dp[i][j]=dp[i-1][j-1]+1;
		                }else{
		                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
		                }
		            }
		        }
		       String newstr=funzhuan(arr[1],0,arr[1].length()-1);
		       for(int i=1;i<n1+1;i++){
		            for(int j=1;j<n2+1;j++){
		                if(arr[0].charAt(i-1)==newstr.charAt(j-1)){
		                    dp2[i][j]=dp2[i-1][j-1]+1;
		                }else{
		                    dp2[i][j]=Math.max(dp2[i-1][j],dp2[i][j-1]);
		                }
		            }
		        }
		      if(dp[n1][n2]==arr[1].length()||dp2[n1][n2]==arr[1].length()){
		    	  System.out.println(true);
		      }else{
		    	  System.out.println(false);
		      }
		}
		
	       
	        
	}
	public static String funzhuan(String s,int i,int j){
		char temp;
		char[] arr=s.toCharArray();
		while(i<j){
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		return new String(arr);
	}
	


}
