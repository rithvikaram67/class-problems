public class Main
{
	static int n = 2;
	static int[][] cost =
	{
		{3, 1},
		{2, 4}
	};
	static boolean[] assigned = new boolean[n];
	static int minCost = Integer.MAX_VALUE;
	public static void main(String[] args)
	{
		findMinCost(0, 0);
		System.out.println("Minimum Assignment Cost = " + minCost);
	}
	static void findMinCost(int worker, int currentCost)
	{
		if(worker == n)
		{
			minCost = Math.min(minCost, currentCost);
			return;
		}
		for(int job = 0; job < n; job++)
		{
			if(!assigned[job])
			{
				assigned[job] = true;
				findMinCost(worker + 1, currentCost + cost[worker][job]);
				assigned[job] = false;
			}
		}
	}
}
