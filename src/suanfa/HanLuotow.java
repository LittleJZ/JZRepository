package suanfa;

public class HanLuotow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanLowTow(2, 'A', 'B', 'C');

	}
	public static void hanLowTow(int num,char a,char b,char c){
		if(num==1){
			System.out.println("第" +1+"个盘从" +a+"->"+c);
		}else{
			hanLowTow(num-1, a, c, b);
			System.out.println("第" +num+"个盘从" +a+"->"+c);
			
			hanLowTow(num-1, b, a, c);
		}
	}

}
