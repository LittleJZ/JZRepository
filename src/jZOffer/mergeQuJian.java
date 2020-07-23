package jZOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class mergeQuJian {

	/**
	 * @param args
	 *合并区间
	 *输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 private class MyComparator implements Comparator<int[]> {
	        public int compare(int[] a, int[] b) {
	            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
	        }
	    }
	public int[][] merge(int[][] intervals){
		List<int[]> list=new ArrayList<>();
		for(int[] o:intervals){
			list.add(o);
		}
		Collections.sort(list, new MyComparator());
		LinkedList<int[]> merge=new LinkedList<>();
		for(int[] o:list){
			if(merge.isEmpty()){
				merge.add(o);
				continue;
			}
			int[] arr=merge.getLast();
			if(o[0]>arr.length-1){
				merge.add(o);
			}else{
				arr[arr.length-1]=Math.max(o[o.length-1], arr[arr.length-1]);
			}
		}
		int rsize=merge.size()-1;
		int[][] res=new int[rsize][];
		int index=0;
		for(int[] o:merge){
			res[index]=o;
			index++;
		}
		return res;
		
		
	}

}
