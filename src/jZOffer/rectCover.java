package jZOffer;

public class rectCover {

	/**
	 * @param args
	 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int RectCover(int target) {
		if (target <= 1) {
			return 1;
		}
		if(2*target ==2){
			return 1;
		}else if(target*2==4){
			return 2;
		}else{
			return RectCover(target-1)+RectCover(target-2);
		}
	}

}
