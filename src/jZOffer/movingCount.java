package jZOffer;

import java.util.LinkedList;

public class movingCount {

	/**
	 *  例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=5,rows=10,cols=10;
		
		movingCount m=new movingCount();
		m.MovingCount(5, 10, 10);

	}
	public int sum=0;

	int[] dx={0,1,0,-1};
	int[] dy={1,0,-1,0};
	
	public int MovingCount(int threshold, int rows, int cols) {
		if(threshold<0) return 0;
		int[][] vis=new int[rows][cols];
		sum=1;
		helper(0, 0, threshold, rows, cols,vis);
		return sum;
	}
	public void helper(int x,int y,int threshold,int rows,int cols,int[][] vis){
		vis[x][y]=1;
		for(int i=0;i<=3;i++){
			int newx=x+dx[i],newy=y+dy[i];
			if(newx>=0&&newy>=0&&newx<rows&&newy<cols&&canreach(threshold, newx, newy)&&vis[newx][newy]==0){
				sum++;
				helper(newx, newy, threshold, rows, cols, vis);
			}
		}
	}
	
	
	boolean canreach(int threshold, int x, int y) {
		int sum = 0;
		while (x > 0) {
			sum += x % 10;
			x /= 10;
		}
		while (y > 0) {
			sum += y % 10;
			y /= 10;
		}
		return sum <= threshold;
	}

}
