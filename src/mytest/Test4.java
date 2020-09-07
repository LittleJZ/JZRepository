package mytest;

import java.util.concurrent.atomic.AtomicInteger;

public class Test4 {
	  static int count=1;
	//奇数偶数线程打印
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
		                            System.out.println("偶数线程打印..." + count);
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
		                            System.out.println("奇数线程打印..." + count);
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