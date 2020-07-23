package jZOffer;

public class ChouNum {

	/**
	 * @param args
	 * ��ֻ����������2��3��5��������������Ugly Number��������6��8���ǳ�����
	 * ��14���ǣ���Ϊ������������7�� ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int GetUglyNumber_Solution(int index) {
        if(index<7) return index;
        
        int[] arr =new int[index];
        arr[0]=1;
        int t2=0,t3=0,t4=0;
        for(int i=1;i<index;i++){
        	arr[i]=Math.min(arr[t2]*2, Math.min(arr[t3]*3,arr[t4]*5));
        	if(arr[i]==arr[t2]*2) t2++;
        	if(arr[i]==arr[t3]*2) t3++;
        	if(arr[i]==arr[t4]*2) t4++;
        }
        return arr[index-1];
    }

}
