package jZOffer;

import java.util.LinkedList;
import java.util.Stack;

public class lastRemaining_Solution {

	/**
	 * 圆圈中剩下的数
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
	}

	public int LastRemaining_Solution(int n, int m) {

		LinkedList<Integer> list=new LinkedList<>();
		for(int i=0;i<n;i++){
			list.add(i);
		}
		int bt=0;
		while(list.size()>1){
			bt=(bt+m-1)%list.size();
			list.remove(bt);
		}
		return list.size()==1?list.get(0):-1;
		
	}
	
	public int Sum_Solution(int n) {
        int sum =n;
        boolean a=(n>0) && ((sum+=Sum_Solution(n-1))>0);
        return sum;
    }

}
