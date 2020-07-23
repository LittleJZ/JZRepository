package recursion;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Queue8 {

	/**
	 * @param args
	 */
	int max=8;
	int[] array =new int[max];
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue8 queue=new Queue8();
		queue.check(0);
		System.out.println(count);
		
		
	}
	
	//������
	private void print(){
		count++;
		for(int i=0;i<max;i++){
			System.out.print(array[i]+ " ");
		}
		System.out.println();
	}
	
	//�ж��Ƿ��Ƿ��ͻ
	private boolean judge(int n){
		for(int i=0;i<n;i++){
			if(array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
				return false;
			}
		}
		return true;
	}
	//���÷���
	private void check(int n){
		if(n==max){
			print();
			return;
		}
		for(int i=0;i<max;i++){
			array[n]=i;
			if(judge(n)){
				check(n+1);
			}
			
		}
	}

}
