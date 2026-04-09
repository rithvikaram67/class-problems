
import java.util.*;

public class ClosestPairUserInput {

    // Function to calculate distance
    static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of points
        System.out.print("Enter number of points: ");
        int n = sc.nextInt();

        int[][] points = new int[n][2];

        // Input points
        System.out.println("Enter the points (x y):");
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        double minDist = Double.MAX_VALUE;
        List<String> pairs = new ArrayList<>();

        // Find closest pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                double dist = distance(
                    points[i][0], points[i][1],
                    points[j][0], points[j][1]
                );

                if (dist < minDist) {
                    minDist = dist;
                    pairs.clear();
                    pairs.add("(" + points[i][0] + "," + points[i][1] + 
                              ") and (" + points[j][0] + "," + points[j][1] + ")");
                }
                else if (Math.abs(dist - minDist) < 1e-9) {
                    pairs.add("(" + points[i][0] + "," + points[i][1] + 
                              ") and (" + points[j][0] + "," + points[j][1] + ")");
                }
            }
        }

        // Output
        System.out.println("\nMinimum Distance: " + minDist);
        System.out.println("Closest Pairs:");
        for (String pair : pairs) {
            System.out.println(pair);
        }

        sc.close();
    }
}
