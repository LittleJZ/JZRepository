package jZOffer;

import java.util.Arrays;

public class minLength {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int m=2;
		int n=2;
		int [][] arr={{1,3},{2,4}};
		// TODO Auto-generated method stub
		int count =Minlength(m, n, arr);
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println(count);

	}
	public static int Minlength(int m,int n,int[][] arr){
		
		int [][] dp=new int[m][n];
		for(int i=1;i<m;i++){
			dp[i][0]=arr[i-1][0]+arr[i][0];
		}
		for(int i=1;i<n;i++){
			dp[0][i]=arr[0][i-1]+arr[0][i];
		}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				dp[i][j]=Math.min(dp[i-1][j]+arr[i][j], dp[i][j-1]+arr[i][j]);
			}
		}
		System.out.println(dp[m-1][n-1]);
		return dp[m-1][n-1];
		
	}

}
