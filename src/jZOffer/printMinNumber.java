package jZOffer;

public class printMinNumber {

	/**
	 * @param args
	 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String PrintMinNumber(int[] numbers) {

		String s=new String("");
		for(int i=0;i<numbers.length;i++){
			for(int j=i+1;j<numbers.length;j++){
				int sum1=Integer.valueOf(numbers[i]+""+numbers[j]);
				int sum2=Integer.valueOf(numbers[j]+""+numbers[i]);
				if(sum1>sum2){
					int temp=numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=temp;
				}
			}
		}
		for(int i=0;i<numbers.length;i++){
			s+=String.valueOf(numbers[i]);
		}
		return s;
	}
	

}
