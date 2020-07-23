package mytest;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
		for(int i=0;i<cyclicBarrier.getParties();i++){
			new Thread(new Barrier(cyclicBarrier),"�˶�Ա"+i).start();
		}
		System.out.println("��Ϸ��ʼ");

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
                 int randomNum = rand.nextInt((3000 - 1000) + 1) + 1000;//����1000��3000֮����������
                 Thread.sleep(randomNum);
                 System.out.println(Thread.currentThread().getName()+",ͨ���˵�"+i+"���ϰ�");
                 cyclicBarrier.await();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
}
