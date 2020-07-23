package mytest;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
		for(int i=0;i<cyclicBarrier.getParties();i++){
			new Thread(new Barrier(cyclicBarrier),"运动员"+i).start();
		}
		System.out.println("游戏开始");

	}

}
class Barrier implements Runnable{

	private CyclicBarrier cyclicBarrier;
	public Barrier(CyclicBarrier cyclicBarrier){
		this.cyclicBarrier =cyclicBarrier;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++){
			try {
				 Random rand = new Random();
                 int randomNum = rand.nextInt((3000 - 1000) + 1) + 1000;//产生1000到3000之间的随机整数
                 Thread.sleep(randomNum);
                 System.out.println(Thread.currentThread().getName()+",通过了第"+i+"个障碍");
                 cyclicBarrier.await();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
}
