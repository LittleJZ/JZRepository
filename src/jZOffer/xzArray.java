package jZOffer;

public class xzArray {

	//��ת�������С����
/*	��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
	����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
	��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
	NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��*/
	public int minNumberInRotateArray(int [] array) {
	    
        int low =0;
        int right=array.length-1;
        while(low<right){
            int mid =low+(right-low)/2;
            if(array[mid]>array[right]){
                low =mid+1;
            }else if(array[low]== array[right]){
                right=right-1;
            }else{
                right=mid;
            }
        }
        return array[low];
    }
}
