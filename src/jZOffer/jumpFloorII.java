package jZOffer;

public class jumpFloorII {

	/**
	 * @param args
	 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public int JumpFloorII(int target) {
		if(target<=0){
			return 1;
		}
		if(target==1){
			return 1;
		}else{
			return 2*JumpFloorII(target-1);
		}
	}

}
