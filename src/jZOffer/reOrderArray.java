package jZOffer;

public class reOrderArray {

	/**
	 * @param args
	 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
	 * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void ReOrderArray(int[] array) {
	
		int length=array.length;
		int k=0;
		for(int i=0;i<length;i++){
			if(array[i]%2==1){
				int j=i;
				int temp=array[j];
				while(j>k){
					
					array[j]=array[j-1];
					
					j--;
				}
				array[j]=temp;
				k++;
			}
		}
	}

}
