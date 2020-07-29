package mytest;

public class Test6 {

	//测试sleep会不会释放cpu
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("开始");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					try {
						Thread.sleep(2000);
						System.out.println(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		Thread.sleep(3000);
		System.out.println("结束");
		//运行知道sleep释放cpu
	}

}
