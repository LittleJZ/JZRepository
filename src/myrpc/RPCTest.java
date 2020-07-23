package myrpc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;

public class RPCTest {

		 
	    public static void main(String[] args) throws IOException {
	        new Thread(new Runnable() {
	            public void run() {
	                try {
	                    Server serviceServer = new ServerCenter(8088);
	                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
	                    serviceServer.start();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }).start();
	        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
	        System.out.println( service.sayHi("test"));
	    }

}
