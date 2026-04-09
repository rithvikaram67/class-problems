import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        double[] weight = new double[n];
        double[] value = new double[n];
        double[] ratio = new double[n];
        System.out.println("Enter weight and value for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Weight: ");
            weight[i] = scanner.nextDouble();
            System.out.print("Item " + (i + 1) + " - Value: ");
            value[i] = scanner.nextDouble();
            ratio[i] = value[i] / weight[i]; 
        }
        System.out.print("Enter knapsack capacity: ");
        double capacity = scanner.nextDouble();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ratio[j] < ratio[j + 1]) {
                    double tempRatio = ratio[j];
                    ratio[j] = ratio[j + 1];
                    ratio[j + 1] = tempRatio;
                    double tempWeight = weight[j];
                    weight[j] = weight[j + 1];
                    weight[j + 1] = tempWeight;
                    double tempValue = value[j];
                    value[j] = value[j + 1];
                    value[j + 1] = tempValue;
                }
            }
        }
        double totalValue = 0.0;
        double remainingCapacity = capacity;//6
        
        System.out.println("\nItems selected:");
        for (int i = 0; i < n; i++) {//2<2
            if (remainingCapacity == 0) {
                break;
            }
            
            if (weight[i] <= remainingCapacity) {
                totalValue += value[i];
                remainingCapacity -= weight[i];
                System.out.printf("Item with weight %.2f and value %.2f - Taken fully (%.2f%%)\n", 
                                weight[i], value[i], 100.0);
            } 
            else {
                double fraction = remainingCapacity / weight[i];
                totalValue += value[i] * fraction;
                System.out.printf("Item with weight %.2f and value %.2f - Taken partially (%.2f%%)\n", 
                                weight[i], value[i], fraction * 100);
                remainingCapacity = 0;
            }
        }
        
        System.out.printf("\nMaximum value in knapsack: %.2f\n", totalValue);
    }
}
