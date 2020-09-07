package mytest;

public class Tets1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1=new Thread(new c1());
		Thread t2=new Thread(new c2());
		t1.run();
		t2.run();
	}

}

class c1 implements Runnable{

	@Override
	public void run() { 
		// TODO Auto-generated method stub
			try {
				for(int i=0;i<5;i++){
					System.out.println(i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
}

class c2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
			try {
				for(int j=0;j>-5;j--){
					System.out.println(j);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
}
