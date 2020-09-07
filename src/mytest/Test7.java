package mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class Test7 {

	public static void main(String[] args) {
		HashMap map=new HashMap<>();
		// TODO Auto-generated method stub
		Student s1= new Student("zhangsan", 17);
		Student s2=new Student("zhangsan", 17);
		Set set =new HashSet<>();
		map.put(s1, "1");
		map.put(s2, "2");
		set.add(s1);
		set.add(s2);
		System.out.println(map.get(s1));
		System.out.println(map.get(s2));
		System.out.println(set.size());
		//不重写hashcode equals 输出 1，2
		//重写hashcode equals输出  2 ，2 
		//set不重写hashcode size为2
		//set重写hashcode size为1
		
		List<String> list=new ArrayList<>();
		list.add("靳卓1");
		list.add("靳卓2");
		list.add("大帅逼");
		System.out.println(list);
	/*	for(String s:list){
			if("靳卓1".equals(s)){
				list.remove(s);
			}
		}*/
		//java.util.ConcurrentModificationException
		Iterator it =list.iterator();
		while(it.hasNext()){
			String str=(String) it.next();
			if("靳卓1".equals(str)){
				it.remove();
				//list.remove("靳卓1");//此种同增强for循环
			}
		}
		System.out.println(list);
		ThreadLocal<String> s=new ThreadLocal<>();
		s.set("zhangsan");
		System.out.println(s.get());
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<5;i++){
					System.out.println(s.get());
				}
			}
		}).start();
		ExecutorService s7=Executors.newFixedThreadPool(2);
		//FutureTask<V>
		s7.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		Future<?> submit = s7.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	
	}

}
