package jZOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestMi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	 public List<List<Character>> permute(String s) {
		 List<List<Character>> res =new ArrayList<>();
	     char[] arr=s.toCharArray();
	     int[] vis=new int[s.length()];
	     helper(res,arr,new ArrayList<Character>(),vis);
	     return res;
	   }
	 
	 public void helper(List<List<Character>> res,char[] arr,ArrayList<Character> list,int[] vis){
		 if(list.size()==arr.length){
			 res.add(new ArrayList<>(list));
		 }
		 for(int i=0;i<arr.length;i++){
			 if(vis[i]==1){
				 continue;
			 }
			 vis[i]=1;
			 list.add(arr[i]);
			 helper(res, arr, list, vis);
			 vis[i]=0;
			 list.remove(list.size()-1);
			 
		 }
	 }
	
	

}
