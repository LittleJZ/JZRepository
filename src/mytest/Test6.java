package mytest;

public class Test6 {

	//����sleep�᲻���ͷ�cpu
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("��ʼ");
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
		System.out.println("����");
		//����֪��sleep�ͷ�cpu
	}

}
