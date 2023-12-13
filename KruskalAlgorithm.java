import java.util.Scanner;

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int[][] costMatrix = new int[10][10];
        int nodeCount, minimumCost = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("********* KRUSKAL'S ALGORITHM *******");
        System.out.println("Enter the number of nodes: ");
        nodeCount = in.nextInt();
        System.out.println("Enter the cost matrix");
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                costMatrix[i][j] = in.nextInt();
            }
        }
        System.out.println("The entered cost matrix is");
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                System.out.print(costMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        minimumCost = calculateMinimumCost(nodeCount, minimumCost, costMatrix);
        System.out.println("The minimum spanning tree cost is:");
        System.out.println(minimumCost);
    }

    static int calculateMinimumCost(int nodeCount, int minimumCost, int[][] costMatrix) {
        int edgeCount = 1, min, startNode = 0, endNode = 0, tempStartNode = 0, tempEndNode = 0;
        int[] parent = new int[10];
        while (edgeCount < nodeCount) {
            min = 999;
            for (int i = 1; i <= nodeCount; i++) {
                for (int j = 1; j <= nodeCount; j++) {
                    if (costMatrix[i][j] < min) {
                        min = costMatrix[i][j];
                        startNode = tempStartNode = i;
                        endNode = tempEndNode = j;
                    }
                }
            }
            while (parent[tempStartNode] > 0) {
                tempStartNode = parent[tempStartNode];
            }
            while (parent[tempEndNode] > 0) {
                tempEndNode = parent[tempEndNode];
            }
            if (tempStartNode != tempEndNode) {
                System.out.println((edgeCount++) + ">minimum edge is : (" + startNode + "," + endNode + ") and its cost is:" + min);
                minimumCost += min;
                parent[tempEndNode] = tempStartNode;
            }
            costMatrix[startNode][endNode] = costMatrix[endNode][startNode] = 999;
        }
        return minimumCost;
    }
}