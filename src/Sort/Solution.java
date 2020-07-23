package Sort;

public class Solution {

	 public int findKth(int [] input, int k) {
		 	int[] input2=new int[input.length];
		 	//�ҳ������ֵ���������ֵ��������,���Ӷ�0(n)
		 	int start=0;
		 	for(int i=0;i<input.length;i++){
		 		if(input[i]%2==1){
		 			input2[start]=input[i];
		 			start++;
		 		}
		 	}
	        //���������������
	        if(input2==null || input2.length<=0 || input2.length<k){
	            return 0;
	        }
	        //��������,���Ӷ�0��nlogk��
	        for(int len=k/2-1; len>=0; len--){
	            adjustMaxHeapSort(input2,len,k-1);
	        }
	        //�ӵ�k��Ԫ�ؿ�ʼ�ֱ������ѵ����ֵ���Ƚϣ���������ֵС�����滻�������ѡ�
	        //���ն���ľ�����С��K������
	        int tmp;
	        for(int i=k; i<input2.length; i++){
	            if(input2[i]<input2[0]){
	                tmp=input2[0];
	                input2[0]=input2[i];
	                input2[i]=tmp;
	                adjustMaxHeapSort(input2,0,k-1);
	            }
	        }
	        //���ص�K��
	        return input[k];
	    }
	      
	    public void adjustMaxHeapSort(int[] input2, int pos, int length){
	        int temp;
	        int child;
	        for(temp=input2[pos]; 2*pos+1<=length; pos=child){
	            child=2*pos+1;
	            if(child<length && input2[child]<input2[child+1]){
	                child++;
	            }
	            if(input2[child]>temp){
	            	input2[pos]=input2[child];
	            }else{
	                break;
	            }
	        }
	        input2[pos]=temp;
	    }
}
