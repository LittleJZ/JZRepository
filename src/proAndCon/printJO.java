package proAndCon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class printJO {

	/**
	 * @param args
	 */

	private Lock lock =new ReentrantLock();
	private Condition c1= lock.newCondition();
	private Condition c2 =lock.newCondition();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printJO p= new printJO();
		
		new Thread(p.new printj()).start();
		new Thread(p.new printO()).start();
	}
	
	class printj implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=1;i<=100;i=i+2){
				
				try{
					lock.lock();
					System.out.println(Thread.currentThread().getName()+i);
					c1.await();
					c2.signal();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
			
		}
		
	}
	
	class printO implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=2;i<=100;i=i+2){
				
				try{
					lock.lock();
					System.out.println(Thread.currentThread().getName()+i);
					c1.signal();
					c2.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			}
			
		}
		
	}

}
