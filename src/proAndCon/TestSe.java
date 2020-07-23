package proAndCon;

import java.util.concurrent.Semaphore;

public class TestSe {

	/**
	 * @param args
	 */
	private Semaphore notFull =new Semaphore(10);
	private Semaphore notEmpty= new Semaphore(0);
	private Semaphore muatx =new Semaphore(1);
	private int count =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSe s= new TestSe();
		new Thread(s.new produce()).start();
		new Thread(s.new consumer()).start();
		
		new Thread(s.new produce()).start();
		new Thread(s.new consumer()).start();

	}
	class produce implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<10;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try{
					notFull.acquire();
					muatx.acquire();
					count++;
					System.out.println("生产者生产第"+count);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					muatx.release();
					notEmpty.release();
				}
			}
			
		}
		
	}
	
	class consumer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<10;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try{
					notEmpty.acquire();
					muatx.acquire();
					count-- ;
					System.out.println("消费者消费后还有"+count);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					muatx.release();
					notFull.release();
				}
			}
			
		}
		
	}

}
