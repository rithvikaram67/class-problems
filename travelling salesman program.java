public class Main {
	static int n = 2;
	static int[][] graph = {
		{0, 10},
		{10, 0}
	};
	static boolean[] visited = new boolean[n];
	static int minCost = Integer.MAX_VALUE;
	public static void main(String[] args) {
		visited[0] = true;
		tsp(0, 1, 0);
		System.out.println("Minimum travelling cost: " + minCost);
	}
	static void tsp(int city, int count, int cost) {
		if (count == n && graph[city][0] > 0) {
			minCost = Math.min(minCost, cost + graph[city][0]);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i] && graph[city][i] > 0) {
				visited[i] = true;
				tsp(i, count + 1, cost + graph[city][i]);
				visited[i] = false;
			}
		}
	}
}
