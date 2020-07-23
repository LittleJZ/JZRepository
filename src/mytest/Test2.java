package mytest;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CountDownLatch countDownLatch=new CountDownLatch(4);
		for(int i=0;i<countDownLatch.getCount();i++){
			new Thread(new Player(countDownLatch),"palyer"+i).start();
		}
		System.out.println("等待所有玩家进入游戏");
		countDownLatch.await();
		System.out.println("所有玩家已进入，游戏开始");
		
	}

}
class Player implements Runnable{
	private CountDownLatch countDownLatch;
	public Player(CountDownLatch countDownLatch){
		this.countDownLatch=countDownLatch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Random r=new Random();
			int numver=r.nextInt((3000 - 1000) + 1) + 1000;
			Thread.sleep(numver);
			System.out.println(Thread.currentThread().getName()+"已经准备好了");
			countDownLatch.countDown();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
