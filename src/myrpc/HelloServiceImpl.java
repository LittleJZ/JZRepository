package myrpc;

import java.io.Serializable;

public class HelloServiceImpl implements HelloService ,Serializable{

	@Override
	public String sayHi(String name) {
		// TODO Auto-generated method stub
		return "Hi,"+name;
	}

}
