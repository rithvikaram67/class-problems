public class Main {
    static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {

        int[][] points = {
            {2, 3},
            {7, 8},
            {1, 1},
        };

        int n = points.length;

        double minDist = Double.MAX_VALUE;//1.7976931348623157E308
        int p1x = 0, p1y = 0, p2x = 0, p2y = 0;
        for (int i = 0; i < n; i++) {//1<3
            for (int j = i + 1; j < n; j++) {
                double dist = distance(
                    points[i][0], points[i][1],//2,3
                    points[j][0], points[j][1]//1,1
                );//2.23606797749979
                if (dist < minDist) {//2.23606797749979<7.07
                    minDist = dist;//2.23606797749979
                    p1x = points[i][0];//2
                    p1y = points[i][1];//3
                    p2x = points[j][0];//1
                    p2y = points[j][1];//1
                }
            }
        }
        System.out.println("Closest Pair: (" + p1x + ", " + p1y + 
                           ") and (" + p2x + ", " + p2y + ")");
        System.out.println("Minimum Distance: " + minDist);
    }
}
