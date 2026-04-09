
public class Main {
    
    static boolean isSafe(int v, int[][] graph, int[] color, int c) {
        for (int i = 0; i < graph.length; i++) {//0<2
            if (graph[v][i] == 1 && color[i] == c) {//
                return false; 
            }
        }
        return true;
    }

    
    static boolean graphColoringUtil(int[][] graph, int m, int[] color, 
    int v) {
        
        int V = graph.length;//2
        
        
        if (v == V) {//2==2
            return true;
        }

       
        for (int c = 1; c <= m; c++) 
        {//1<=2
        
            if (isSafe(v, graph, color, c))//
            {
                color[v] = c;
                if (graphColoringUtil(graph, m, color, v + 1)) //t
                {
                    return true;
                }
                color[v] = 0;
            }
        }
        return false;
    }
    static void graphColoring(int[][] graph, int m) {
        int V = graph.length;//2
        int[] color = new int[V]; 
        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("No solution exists");
            return;
        }

        for (int i = 0; i < V; i++) {//1<2
            System.out.println("Vertex " + i + " ---> Color " + color[i]);
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0, 1}, 
            {0, 0}  
        };
        int m = 2; 
        graphColoring(graph, m);
    }
}
