package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

	/**
	 * @param args
	 */
	private ArrayList<String> vertexList;
	private int[][] edges;
	private int numsOfEdge;
	private boolean[] isVisted;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=8;
		String VertexValue[] ={"1","2","3","4","5","6","7","8"};
		Graph graph= new Graph(n);
		for(String value :VertexValue){
			graph.insertVertex(value);
		}
		graph.add(0, 1, 1);
		graph.add(0,2,1);
		graph.add(1,3,1);
		graph.add(1,4,1);
		graph.add(3,7,1);
		graph.add(4,7,1);
		graph.add(2,5,1);
		graph.add(2,6,1);
		graph.add(5,6,1);
		graph.showGraph();
		//graph.dfs();
		graph.bfs();
	}
	public Graph(int n) {
		super();
		this.vertexList = new ArrayList<String>(n);
		this.edges = new int[n][n];
		this.numsOfEdge = 0;
		isVisted=new boolean[n];
	}
	public int getNeigboor(int index){
		for(int j =0;j<getNumofVertex();j++){
			if(edges[index][j]>0){
				return j;
			}
		}
		return -1;
	}
	
	public int getNextNeigboor(int v1,int v2){
		for(int j =v2+1;j<getNumofVertex();j++){
			if(edges[v1][j]>0){
				return j;
			}
		}
		return -1;
	}
	//深度优先
	private void dfs(boolean[] isVisted,int i){
		System.out.println(getValueByIndex(i));
		isVisted[i]=true;
		int w=getNeigboor(i);
		while(w != -1){
			if(!isVisted[w]){
				dfs(isVisted, w);
			}
			w=getNextNeigboor(i, w);
		}
	}
	
	public void dfs(){
		isVisted=new boolean[8];
		for(int i=0;i<getNumofVertex();i++){
			if(!isVisted[i]){
				dfs(isVisted, i);
			}
			
		}
	}
	//广度优先
	private void bfs(boolean[] isVisted,int index){
		int u;
		int w;
		LinkedList queue =new LinkedList<>();
		System.out.println(getValueByIndex(index));
		isVisted[index]=true;
		queue.addLast(index);
		while (!queue.isEmpty()){
			u=(Integer)queue.removeFirst();
			w= getNeigboor(u);
			while(w != -1){
				if(!isVisted[w]){
					System.out.println(getValueByIndex(w));
					isVisted[w]=true;
					queue.addLast(w);
				}
				w=getNextNeigboor(u, w);
			}
		}
	}
	
	public void bfs(){
		for(int j=0;j<getNumofVertex();j++){
			if(!isVisted[j]){
				bfs(isVisted, j);
			}
		}
	}
	public int getNumofVertex(){
		return vertexList.size();
	}
	
	public int getNumOfEdges(){
		return numsOfEdge;
	}
	
	public String getValueByIndex(int i){
		return vertexList.get(i);
	}
	public void showGraph(){
		for(int[] link:edges){
			System.out.println(Arrays.toString(link));
		}
	}
	
	public int getWeight(int v1,int v2){
		return edges[v1][v2];
	}
	public void insertVertex(String n){
		vertexList.add(n);
	}
	public void add(int v1,int v2,int weight){
		edges[v1][v2]=weight;
		edges[v2][v1]=weight;
		numsOfEdge++;
	}

	
}
