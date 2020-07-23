package proAndCon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

	/**
	 * @param args
	 */
	private Lock lock =new ReentrantLock();
	private Condition notFull =lock.newCondition();
	private Condition notEmpty =lock.newCondition();
	private int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestLock t2 =new TestLock();
		new Thread(t2.new produce()).start();
		new Thread(t2.new consumer()).start();
		new Thread(t2.new produce()).start();
		new Thread(t2.new consumer()).start();

	}
	class produce implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<10 ;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try{
				lock.lock();
				while(count==10){
					try {
						notFull.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				count++;
				System.out.println("生产者生产第"+count);
				notEmpty.signalAll();
				}finally{
					lock.unlock();
				}
			}
			
			
		}
		
	}
	
	class consumer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<10 ;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try{
				lock.lock();
				while(count==0){
					try {
						notEmpty.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				count--;
				System.out.println("消费者消费后还有"+count);
				notFull.signalAll();
				}finally{
					lock.unlock();
				}
			}
			
			
		}
		
	}

}
