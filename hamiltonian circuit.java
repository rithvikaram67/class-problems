public class Main {
	public static void main(String[] args) {
	    int[][] graph = {
	        {0, 1, 1},
	        {1, 0, 1},
	        {1, 1, 0}
	    };
	    if(isHamiltonian(graph)) {
	        System.out.println("Hamiltonian Circuit exists");
	    } else {
		System.out.println("Hamiltonian Circuit does no exists");
	    }
    }
    static boolean isHamiltonian(int[][] graph) {
        if(graph[0][2] == 1 &&
           graph[1][2] == 1 &&
           graph[2][0] == 1) {
               return true;
           }
           return false;
    }
}
