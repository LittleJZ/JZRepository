package jZOffer;

import java.util.Scanner;

public class Test2{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String n=sc.nextLine();
		String m=sc.nextLine();
		int num=Integer.parseInt(n);
		int height=Integer.parseInt(m);
		int[] w=new int[num];
		int[] val=new int[num];
		String wlength=sc.nextLine();
		String vlength=sc.nextLine();
		String[] w1=wlength.split(" ");
		String[] val1=vlength.split(" ");
		for(int i=0;i<num;i++){
			w[i]=Integer.parseInt(w1[i]);
		}
		for(int i=0;i<num;i++){
			val[i]=Integer.parseInt(val1[i]);
		}
		int[][] v= new int[num+1][height+1];
		for(int i=0;i<v.length;i++){
			v[i][0]=0;
		}
		for(int i=0;i<v[0].length;i++){
			v[0][i]=0;
		}
		for(int i=1;i<v.length;i++){
			for(int j=1;j<v[0].length;j++){
				if(w[i-1]>j){
					v[i][j]=v[i-1][j];
				}else{
					v[i][j]=Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);
				}
			}
		}
		System.out.println(v[num][height]);
		
	}


}

