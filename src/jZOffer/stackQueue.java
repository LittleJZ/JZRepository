package jZOffer;

import java.util.Stack;

public class stackQueue {

	/**
	 * @param args
	 * 使用两个栈实现一个队列
	 */
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void push(int node) {

		stack1.push(node);
	}
		

	public int pop() {
		if(stack1.empty() && stack2.empty()){
			System.out.println("没有数据");
		}
		if(stack2.empty()){
			while(!stack1.empty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

}
