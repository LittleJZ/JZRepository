package myrpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerCenter implements Server {
	private static ExecutorService executor=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	private static final HashMap<String, Class> REGISTER_MAP=new HashMap<>();
	private static boolean isRunning=false;
	private static int port;

	public ServerCenter(int port){
		this.port=port;
	}
	@Override
	public void stop() {
		isRunning=false;
		executor.shutdown();
	}

	@Override
	public void start() throws IOException {
		ServerSocket socket=new ServerSocket();
		socket.bind(new InetSocketAddress(port));
		System.out.println("server start");
		try {
			while(true){
				executor.execute(new ServiceTask(socket.accept()));
			}
		} finally {
			socket.close();
		}
	}

	@Override
	public void register(Class serviceInterface, Class impl) {
		REGISTER_MAP.put(serviceInterface.getName(), impl);
	}

	@Override
	public boolean isRunning() {
		return isRunning;
	}

	@Override
	public int getPort() {
		return port;
	}
	
	private static class ServiceTask implements Runnable{

		Socket client=null;
		public ServiceTask(Socket client){
			this.client=client;
		}
		public void run() {
			ObjectInputStream input=null;
			ObjectOutputStream output=null;
			try {
				input=new ObjectInputStream(client.getInputStream());
				String serviceName=input.readUTF();
				String methodName=input.readUTF();
				Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
				Object[] arguments =(Object[]) input.readObject();
				Class serviceClass=REGISTER_MAP.get(serviceName);
				if(serviceClass==null){
					throw new ClassNotFoundException(serviceName+ " not found");
				}
				Method method=serviceClass.getMethod(methodName, parameterTypes);
				Object result=method.invoke(serviceClass.newInstance(), arguments);
				output=new ObjectOutputStream(client.getOutputStream());
				output.writeObject(result);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				  if (output != null) {
	                    try {
	                        output.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	                if (input != null) {
	                    try {
	                        input.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	                if (client != null) {
	                    try {
	                        client.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
			}
		}
		
	}

}
