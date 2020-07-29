package mytest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test5 {


	//多线程顺序打印ABC
	public static void main(String[] args) {

		final PrintABC ad = new PrintABC();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					ad.loopA();
				}
			}
		}, "A").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					ad.loopB();
				}
			}
		}, "B").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					ad.loopC();
					System.out.println("-----------------------------------");
				}
			}
		}, "C").start();

	}

}

