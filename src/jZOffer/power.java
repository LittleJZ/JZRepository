package jZOffer;

public class power {

	/**
	 * @param args
	 * 
		����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
		
		��֤base��exponent��ͬʱΪ0

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double base =2.00000;
		int y =-2;
		double ans =myPow(base, y);
		System.out.println(ans);
	}

	public static double myPow(double base, int exponent) {
		if(exponent<0){
			exponent=-exponent;
			base=1/base;
		}

		if(base==0){
			return 0;
		}
		if(exponent==0){
			return 1;
		}
		if(exponent==1){
			return base;
		}
		if(exponent %2==0){
			return myPow(base, exponent/2)*myPow(base, exponent/2);
		}else{
			return  base*myPow(base, exponent/2)*myPow(base, exponent/2);
		}
	}

}
