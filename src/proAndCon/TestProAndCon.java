package proAndCon;

public class TestProAndCon {

	/**
	 * @param args
	 */
	public Object o =new Object();
	private int count =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestProAndCon t=new TestProAndCon();
		new Thread(t.new provide()).start();
		new Thread(t.new counsumer()).start();
		new Thread(t.new provide()).start();
		new Thread(t.new counsumer()).start();
		new Thread(t.new provide()).start();
		new Thread(t.new counsumer()).start();
		

	}
	class provide implements Runnable{

		@Override
		public void run() {
			for(int i=0;i<10;i++){
			// TODO Auto-generated method stub
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (o) {
				while(count==10){
					try {
						o.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				count++;
				System.out.println("生产者生产"+count);
				o.notifyAll();
			}
			}
			
		}
		
	}
	class counsumer implements Runnable{

		@Override
		public void run() {
			for(int i=0;i<10;i++){
			// TODO Auto-generated method stub
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (o) {
				while(count==0){
					try {
						o.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				count--;
				System.out.println("消费者消费，还剩"+count);
				o.notifyAll();
			}
			}
		}
		
	}

}

