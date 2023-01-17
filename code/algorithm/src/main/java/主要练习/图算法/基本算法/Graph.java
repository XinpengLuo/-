package 主要练习.图算法.基本算法;
import java.util.*;

public class Graph {

    private List<String> vertexList; //存储顶点集合
    private int[][] edges; //存储图的邻接矩阵
    private int numOfEdges; //边的数目
    private boolean[] isVisited;
    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }
    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //插入边 v1和v2都表示是点的下标
    public void insertEdges(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //返回边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回节点i 对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1 v2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }


    //得到第一个邻接点的下标
    public int getFirstNeighbor(int index){
        for(int j = 0; j < vertexList.size(); j++)
            if(edges[index][j] > 0)
                return j;
        return -1;
    }


    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int index, int j){
        for(int i = j + 1; i < vertexList.size(); i++)
            if(edges[index][i] > 0)
                return i;
        return -1;
    }
    public void dfs(int i){
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int firstNeighbor = getFirstNeighbor(i);
        while (firstNeighbor != -1){
            if(!isVisited[firstNeighbor])
                dfs(firstNeighbor);
            firstNeighbor = getNextNeighbor(i,firstNeighbor);
        }
    }

    //对dfs进行一个重载 遍历所有节点进行dfs
    public void dfs(){
        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i])
                dfs(i);
        }
    }


    //对一个结点进行广度优先遍历的方法
    public void bfs(int i){
        int u; //队列的头节点下标
        int w; //邻接结点的下标
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        queue.add(i);
        while (!queue.isEmpty()){
            //取出队列的头节点下标
            u = queue.removeFirst();
            //得到第一个邻接点的下标
            w = getFirstNeighbor(u);
            while (w != -1){
                if(!isVisited[w])
                {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.add(w);
                }
                w = getNextNeighbor(u,w);
            }
        }
    }



    public static void main(String[] args) {
        int n = 5;
        String VertexValue[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        //添加顶点
        for (String s : VertexValue) {
            graph.insertVertex(s);
        }
        //添加边
        /*
        A --> B A --> C B --> C B--> D B -> E
         */
        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);
        //graph.showGraph();
        graph.dfs();
    }
}
