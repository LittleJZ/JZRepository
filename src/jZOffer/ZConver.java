package jZOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZConver {

	/**
	 * @param args
	 * Z×ÖÐÎ±ä»»
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="PAYPALISHIRING";
		ZConver z=new ZConver();
		z.convert(s, 3);
	}

	public String convert(String s, int numRows) {
	        if(numRows<2) return s;
	        List<StringBuilder> rows =new ArrayList<StringBuilder>();
	        for(int i=0;i<Math.min(s.length(), numRows);i++){
	        	rows.add(new StringBuilder());
	        }
	        int cur =0;
	        int flag=-1;
	        for(char c:s.toCharArray()){
	        	rows.get(cur).append(c);
	        	if(cur==0 || cur==numRows-1) flag=-flag;
	        	cur+=flag;
	        }
	        StringBuilder ans =new StringBuilder();
	        for(StringBuilder row :rows){
	        	ans.append(row);
	        }
	        return ans.toString();
	    }
}
