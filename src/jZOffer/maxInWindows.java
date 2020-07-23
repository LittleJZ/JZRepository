package jZOffer;

import java.util.ArrayList;

public class maxInWindows {

	/**
	 * 滑动窗口的最大值
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
		ArrayList<Integer> list= new ArrayList<>();
        if(num.length<size || size==0) return list;
        for(int i=0;i<num.length-size+1;i++){
        	int temp=num[i];
        	for(int j=i;j<i+size;j++){
        		if(num[j]>temp){
        			temp=num[j];
        		}
        	}
        	list.add(temp);
        }
        return list;
    }

}
