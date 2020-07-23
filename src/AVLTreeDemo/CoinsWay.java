package AVLTreeDemo;

public class CoinsWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int res=Integer.MAX_VALUE;
	
	public int coinChange(int[] coins, int amount) {
		if(coins.length==0){
			return -1;
		}
		helper(coins,amount,0);
		if(res==Integer.MAX_VALUE){
			return -1;
		}
		return res;
	}
	public void helper(int[] coins,int amount,int count){
		if(amount<0){
			return;
		}
		if(amount==0){
			res=Math.min(res, count);
		}
		for(int i=0;i<coins.length;i++){
			helper(coins, amount-coins[i], count+1);
		}
	}
	public int coinChange2(int[] coins,int amount){
		if(amount<1) return 0;
		return helper2(coins,amount,new int[amount]);
	}
	public int helper2(int[] coins,int amount,int[] res){
		if(amount<0){
			return -1;
		}
		if(amount==0) return 0;
		if(res[amount-1]!=0){
			return res[amount-1];
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<coins.length;i++){
			int ress=helper2(coins, amount-coins[i], res);
			if(ress>=0&&ress<min){
				min=ress+1;
			}
		}
		res[amount-1]=min==Integer.MAX_VALUE?-1:min;
		return res[amount-1];
	}
	
	public int coinChange3(int[] coins,int amount){
		if(coins.length==0) return -1;
		//res������� �����±�����Ӧ��Ӳ��Ԫ���һ���Ҫ���ٵ�Ӳ���� ��res[9]����9ԪӲ��ʱ�һ�������СӲ����
		int[] res=new int[amount+1];
		//0ԪӲ����Ҫ0��Ӳ�Ҷһ�
		res[0]=0;
		for(int i=0;i<res.length;i++){
			int min=Integer.MAX_VALUE;
			for(int j=0;i<coins.length;j++){
				if(i-coins[j]>=0&&res[i-coins[j]]<min){
					min=res[i-coins[j]]+1;
				}
			}
			res[i]=min;
		}
		return res[amount]==Integer.MAX_VALUE?-1:res[amount];
		
	}

}
