//此oj需要手动引入工具类，直接用会报“编译或运行失败”，如需要用ArrayList，需要手动引入，
//如：import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;


public class DirectedGraph {
    private int Vertexnum;
    private int Edgenum;
    private int[][] Edge;

    public DirectedGraph() {
    }
    /**
     * @param Vertexnum  表示顶点的数目，顶点编号为0，Vertexnum-1
     * @param Edge 二维数组，表示边，第一维是边的个数，第二维长度为2，表示一条有向边，分别为出度和入度。
     * @param Edgenum  表示有几条边
     */
    DirectedGraph(int Vertexnum, int[][] Edge, int Edgenum) {
        this.Vertexnum = Vertexnum;
        this.Edge = Edge;
        this.Edgenum = Edgenum;
    }
    /**
     * 如果包括环 返回一个包含环的字符串格式如下“”
     *
     * @param graph  输入的图对象
     * @return  若有环，按升序返回环所在的边的字符串，eg"(1,2)(2,3)(3,1)"，如果不包括则返回空字符串
     */
    public static StringBuilder FindCycle(DirectedGraph graph) {
        // please enter your code here...
        //查看所有边
        /*
        for (int i = 0; i < graph.Edgenum; i++) {
            System.out.println(Arrays.toString(graph.Edge[i]));
        }*/
        int[][] edgeList = new int[graph.Vertexnum][graph.Vertexnum];
        for(int i = 0; i < graph.Edgenum; ++i) {
            edgeList[graph.Edge[i][0]][graph.Edge[i][1]] = 1;
        }
        HashSet<String> ring = new HashSet<>();
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[graph.Vertexnum];
        for(int i = 0; i < graph.Vertexnum; i++) {
            if(!visited[i]) {
                graph.FindCycle(i, edgeList, ring, path, visited);
            }
        }
        ArrayList<String> ringList = new ArrayList<>(ring);
        ringList.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for(String i : ringList) {
            sb.append(i);
        }
        return sb;
    }
    private void FindCycle(int v, int[][] edgeList, HashSet<String> ring, ArrayList<Integer> path, boolean[] visited) {
        if(!path.contains(v) && visited[v]) visited[v] = false;
        if(visited[v]) {
            int j = path.indexOf(v);
            while (j < path.size() - 1) {
                ring.add("(" + path.get(j) + "," + path.get(j + 1) + ")");
                j++;
            }
            ring.add("(" + path.get(j) + "," + v + ")");
            return;
        }
        path.add(v);
        visited[v] = true;
        for(int i = 0; i < visited.length; i++) {
            if(edgeList[v][i] == 1) {
                FindCycle(i, edgeList, ring, path, visited);
            }
        }
        path.remove(path.size()-1);
    }
}