package mytest;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.DriverManager;
import java.util.ServiceLoader;


public class Test8 {

	public static void main(String[] args) {
	    String s = new String("1");
	    s.intern();
	    String s2 = "1";
	    System.out.println(s == s2);
	    
	    
	    String s3=new String("1")+new String("1");
	    s3.intern();
	    String s4="11";
	    System.out.println(s3==s4);
	    
	    String s5=new String("1")+new String("1");
	    
	    String s6="11";
	    s5.intern();
	    System.out.println(s5==s6);
		// TODO Auto-generated method stub
	/*	for(Method m:User.class.getMethods()){
			System.out.println("-------------");
			System.out.println("method:"+m.getName());
			System.out.println("return:"+m.getReturnType().getName());
			for(java.lang.reflect.Parameter p:m.getParameters()){
				System.out.println("parameter"+p.getType().getName()+":"+p.getName());
			}
		}*/
	}
	//java8��parameters���ԣ���������·����Ĳ���������arg0,arg1��ʽ���򿪺����ʾname,age
	

}
class User{
	public void createUser(String name,int age){
		
	}
}
