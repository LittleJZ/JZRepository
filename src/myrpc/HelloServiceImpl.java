package myrpc;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHi(String name) {
		// TODO Auto-generated method stub
		return "Hi,"+name;
	}

}
