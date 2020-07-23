package hash;

public class HashTabDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emp emp =new Emp(1, "张三");
		HashTab hashTab =new HashTab(7);
		hashTab.add(emp);
		hashTab.list();
		hashTab.findById(2);
	}
	

}
class Emp{
	 int id;
	 String name;
	 Emp next;
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
class HashTab{
	private EmpLinkedList[] empLinkedList;
	private int size;
	public HashTab(int size) {
		super();
		this.size =size;
		this.empLinkedList =new EmpLinkedList[size];
		for(int i=0;i<size;i++){
			empLinkedList[i]= new EmpLinkedList();
		}
	}
	
	public void add(Emp emp){
		int empNumNo= hashValue(emp.id);
		empLinkedList[empNumNo].add(emp);
	}
	
	public void list(){
		for(int i=0;i<empLinkedList.length;i++){
			empLinkedList[i].list();
		}
	}
	private int hashValue(int id){
		return id% size;
	}
	
	public void findById(int id){
		int empNumNo= hashValue(id);
		Emp emp=empLinkedList[empNumNo].findById(id);
		
		if(emp!=null){
			System.out.println(emp.id+emp.name);
		}else{
			System.out.println("未找到");
		}
	}
}

class EmpLinkedList{
	private Emp head;
	
	public void add(Emp emp){
		if(head==null){
			head=emp;
			return;
		}
		Emp curEmp =head;
		while(true){
			if(curEmp.next ==null){
				break;
			}
			curEmp= curEmp.next;
		}
		curEmp.next = emp;
	}
	
	public void list(){
		if(head==null){
			System.out.println("没有雇员信息");
			return;
		}
		System.out.println("链表的信息为");
		Emp curEmp =head;
		while(true){
			System.out.printf(curEmp.id+curEmp.name);
			if(curEmp.next== null){
				break;
			}
			curEmp=curEmp.next;
		}
		System.out.println();
	}
	
	public Emp findById(int id){
		if(head== null){
			return null;
		}
		Emp curEmp =head;
		while(true){
			if(curEmp.id ==id ){
				break;
			}
			if(curEmp.next == null){
				curEmp=null;
				break;
			}
			curEmp=curEmp.next;
		}
		return curEmp;
	}
}
