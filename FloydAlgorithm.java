import java.util.Scanner;

class FloydAlgorithm {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = new int[10][10];
        int vertexCount;
        Scanner in = new Scanner(System.in);
        System.out.println("***********FLOYD'S ALGORITHM**********");
        System.out.println("Enter the number of vertices: ");
        vertexCount = in.nextInt();
        System.out.println("Enter the adjacency matrix");
        for (int i = 1; i <= vertexCount; i++) {
            for (int j = 1; j <= vertexCount; j++) {
                adjacencyMatrix[i][j] = in.nextInt();
            }
        }
        System.out.println("Entered adjacency matrix is: ");
        for (int i = 1; i <= vertexCount; i++) {
            for (int j = 1; j <= vertexCount; j++) {
                System.out.print(adjacencyMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        calculateShortestPaths(adjacencyMatrix, vertexCount);
        System.out.println("All pair shortest path matrix:");
        for (int i = 1; i <= vertexCount; i++) {
            for (int j = 1; j <= vertexCount; j++) {
                System.out.print(adjacencyMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void calculateShortestPaths(int[][] adjacencyMatrix, int vertexCount) {
        for (int k = 1; k <= vertexCount; k++) {
            for (int i = 1; i <= vertexCount; i++) {
                for (int j = 1; j <= vertexCount; j++) {
                    adjacencyMatrix[i][j] = min(adjacencyMatrix[i][j], adjacencyMatrix[i][k] + adjacencyMatrix[k][j]);
                }
            }
        }
    }

    static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }
}