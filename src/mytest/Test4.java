package mytest;

import java.util.concurrent.atomic.AtomicInteger;

public class Test4 {
	  static int count=1;
	//����ż���̴߳�ӡ
    public static void main(String[] args) {
      
        Object o=new Object();
        new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				  try {
		                synchronized (o) {
		                    while (count <= 10) {
		                        if (count % 2 == 1) {
		                        	
		                            o.wait();
		                        } else {
		                        	Thread.sleep(1000);
		                            System.out.println("ż���̴߳�ӡ..." + count);
		                            count++;
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
		                    while (count <= 10) {
		                        if (count % 2 == 0) {
		                            o.wait();
		                        } else {
		                        	Thread.sleep(1000);
		                            System.out.println("�����̴߳�ӡ..." + count);
		                            count=count+1;
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