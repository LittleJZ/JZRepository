package graph;

import java.util.Arrays;

public class primDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] data=new char[]{'A','B','C','D','E','F','G'};
		int verxs=data.length;
		int[][] weight=new int[][]{
				{10000,5,7,10000,10000,10000,2},
				{5,10000,10000,9,10000,10000,3},
				{7,10000,10000,10000,8,10000,10000},
				{10000,9,10000,10000,10000,4,10000},
				{10000,10000,8,10000,10000,5,4},
				{10000,10000,10000,4,5,10000,6},
				{2,3,1000,10000,4,6,10000},
		};
		MGraph graph= new MGraph(verxs);
		MinGraph minGraph =new MinGraph();
		minGraph.createGraph(graph, verxs, data, weight);
		minGraph.showGraph(graph);
		minGraph.prim(graph, 1);
	}

}
class MinGraph{
	public void createGraph(MGraph graph,int verxs,char[] data,int[][] weight){
		int i,j;
		for(i=0;i<verxs;i++){
			graph.data[i]=data[i];
			for(j=0;j<verxs;j++){
				graph.weight[i][j]=weight[i][j];
			}
		}
	}
	public void showGraph(MGraph graph){
		for(int[] link:graph.weight){
			System.out.println(Arrays.toString(link));
		}
	}
	
	public void prim(MGraph graph,int v){
		int[] visited =new int[graph.verxs];
	
		visited[v]=1;
		int h1=-1,h2=-1;
		int minWeight =10000;
		for(int k=1;k<graph.verxs;k++){
			for(int i=0;i<graph.verxs;i++){
				for(int j=0;j<graph.verxs;j++){
					if(visited[i]==1 && visited[j]==0 && graph.weight[i][j]<minWeight){
						minWeight=graph.weight[i][j];
						h1=i;
						h2=j;
					}
				}
			}
			System.out.println("±ß<"+graph.data[h1]+","+graph.data[h2]+">È¨Öµ:"+graph.weight[h1][h2]);
			visited[h2]=1;
			minWeight=10000;
		}
	}
}

class MGraph{
	int verxs;
	char[] data;
	int[][] weight;
	public MGraph(int verxs){
		this.verxs=verxs;
		data= new char[verxs];
		weight=new int[verxs][verxs];
	}
}