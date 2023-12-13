import java.util.Scanner;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        int adjacencyMatrix[][] = new int[10][10];
        int i, j, minimumCost = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("********* PRIM'S ALGORITHM *********");
        System.out.println("Enter the number of nodes");
        int numberOfNodes = input.nextInt();

        System.out.println("Enter the cost matrix");
        for (i = 1; i <= numberOfNodes; i++) {
            for (j = 1; j <= numberOfNodes; j++) {
                adjacencyMatrix[i][j] = input.nextInt();
            }
        }

        System.out.println("The entered cost matrix is");
        for (i = 1; i <= numberOfNodes; i++) {
            for (j = 1; j <= numberOfNodes; j++) {
                System.out.print(adjacencyMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Minimum Spanning Tree Edges and costs are");
        minimumCost = prims(adjacencyMatrix, numberOfNodes, minimumCost);

        System.out.print("The minimum spanning tree cost is: ");
        System.out.print(minimumCost);
    }

    static int prims(int adjacencyMatrix[][], int numberOfNodes, int minimumCost) {
        int nearVertex[] = new int[10], minimumSpanningTree[][] = new int[10][3], selectedVertex = 0, i, j, k;

        for (i = 2; i <= numberOfNodes; i++)
            nearVertex[i] = 1;

        nearVertex[1] = 0;

        for (i = 1; i < numberOfNodes; i++) {
            int min = 999;

            for (j = 1; j <= numberOfNodes; j++) {
                if (nearVertex[j] != 0 && adjacencyMatrix[j][nearVertex[j]] < min) {
                    min = adjacencyMatrix[j][nearVertex[j]];
                    selectedVertex = j;
                }
            }

            minimumSpanningTree[i][1] = selectedVertex;
            minimumSpanningTree[i][2] = nearVertex[selectedVertex];
            minimumCost += min;
            nearVertex[selectedVertex] = 0;

            for (k = 1; k <= numberOfNodes; k++) {
                if (nearVertex[k] != 0 && adjacencyMatrix[k][nearVertex[k]] > adjacencyMatrix[k][selectedVertex])
                    nearVertex[k] = selectedVertex;
            }

            System.out.print(i + ") Minimum edge is (" + minimumSpanningTree[i][1]);
            System.out.println("," + minimumSpanningTree[i][2] + ") and its cost is: " + min);
        }
        return minimumCost;
    }
}
