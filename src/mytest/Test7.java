package mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


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
		//����дhashcode equals ��� 1��2
		//��дhashcode equals���  2 ��2 
		//set����дhashcode sizeΪ2
		//set��дhashcode sizeΪ1
		
		List<String> list=new ArrayList<>();
		list.add("��׿1");
		list.add("��׿2");
		list.add("��˧��");
		System.out.println(list);
	/*	for(String s:list){
			if("��׿1".equals(s)){
				list.remove(s);
			}
		}*/
		//java.util.ConcurrentModificationException
		Iterator it =list.iterator();
		while(it.hasNext()){
			String str=(String) it.next();
			if("��׿1".equals(str)){
				it.remove();
				//list.remove("��׿1");����ͬ��ǿforѭ��
			}
		}
		System.out.println(list);
	}

}