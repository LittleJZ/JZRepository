package jZOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.Executors;

public class jieYuShui {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s={0,1,0,2,1,0,1,3,2,1,2,1};
		jieYuShui ss=new jieYuShui();
		ss.trap(s);
		
	


	}
	
	public int trap(int[] height) {
		int count = 0;
		int max = maxNum(height);
		for (int i = 1; i <= max; i++) {
			int temp = 0;
			boolean flag = false;
			for (int j = 0; j < height.length; j++) {
				
				if (height[j] >= i) {
					flag = true;
					count += temp;
					temp = 0;
				} else if (flag) {
					temp++;
				}
			}
		}
		return count;
	}

	public int maxNum(int[] height) {
		int max = height[0];
		for (int i = 1; i < height.length; i++) {
			if (max < height[i]) {
				max = height[i];
			}
		}
		return max;
	}

}
