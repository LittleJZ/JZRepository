package mytest;

import java.util.concurrent.atomic.AtomicInteger;

public class Test4 {

	//����ż���̴߳�ӡ
    public static void main(String[] args) {
        AtomicInteger count=new AtomicInteger(1);
        Object o=new Object();
        new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				  try {
		                synchronized (o) {
		                    while (count.get() <= 10) {
		                        if (count.get() % 2 == 1) {
		                        	
		                            o.wait();
		                        } else {
		                        	Thread.sleep(1000);
		                            System.out.println("ż���̴߳�ӡ..." + count.getAndIncrement());
		                            o.notify();
		                        }
		                    }
		                }
		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
			}
		}).start();
        new Thread(new Runnable() {
			
			public void run() {
				 try {
		                synchronized (o) {
		                    while (count.get() <= 10) {
		                        if (count.get() % 2 == 0) {
		                            o.wait();
		                        } else {
		                        	Thread.sleep(1000);
		                            System.out.println("�����̴߳�ӡ..." + count.getAndIncrement());
		                            o.notify();
		                        }
		                    }
		                }
		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
			}
		}).start();
    }
}