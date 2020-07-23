package jZOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class orangesRotting {

	/**
	 * @param args
	 * leetcode994
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int orangesRotting(int[][] grid) {
		int m=grid.length;
		int n=grid[0].length;
		int count =0;
		Deque<int[]> queue=new LinkedList<>();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]==1){
					count++;
				}
				if(grid[i][j]==2){
					queue.add(new int[]{i,j});
				}
			}
		}
		int round=0;
		while(count>0&& !queue.isEmpty()){
			round++;
			int size=queue.size();
			for(int i=0;i<size;i++){
				int[] o=queue.poll();
				int j=o[0];
				int k=o[1];
				if(j-1>=0 && grid[j-1][k]==1){
					grid[j-1][k]=2;
					count--;
					queue.add(new int[]{j-1,k});
				}
				if(j+1<m && grid[j+1][k]==1){
					grid[j+1][k]=2;
					count--;
					queue.add(new int[]{j+1,k});
				}
				if(k-1>=0 && grid[j][k-1]==1){
					grid[j][k-1]=2;
					count--;
					queue.add(new int[]{j,k-1});
				}
				if(k+1<n && grid[j][k+1]==1){
					grid[j][k+1]=2;
					count--;
					queue.add(new int[]{j,k+1});
				}
			}
		}
		if(count==0){
			return  round;
		}else{
			return -1;
		}

	}

}
