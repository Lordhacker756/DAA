import java.util.Scanner;

public class Dijkstras {
    public static void main(String[] args) {
        int i, j;
        int distance[] = new int[10], visited[] = new int[10];
        int cost[][] = new int[10][10], path[] = new int[10];
        Scanner input = new Scanner(System.in);

        System.out.println("**** DIJKSTRA'S ALGORITHM ******");
        System.out.println("Enter the number of nodes: ");
        int numberOfNodes = input.nextInt();

        System.out.println("Enter the cost matrix");
        for (i = 1; i <= numberOfNodes; i++)
            for (j = 1; j <= numberOfNodes; j++)
                cost[i][j] = input.nextInt();

        System.out.println("The entered cost matrix is");
        for (i = 1; i <= numberOfNodes; i++) {
            for (j = 1; j <= numberOfNodes; j++) {
                System.out.print(cost[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Enter the source vertex: ");
        int sourceVertex = input.nextInt();
        dijkstra(cost, distance, sourceVertex, numberOfNodes, path, visited);
        printPath(sourceVertex, numberOfNodes, distance, path, visited);
        System.out.println("\n********* *************** *********");
    }

    static void dijkstra(int cost[][], int distance[], int sourceVertex, int numberOfNodes, int path[], int visited[]) {
        int count = 2, min, currentVertex = 0;

        for (int i = 1; i <= numberOfNodes; i++) {
            visited[i] = 0;
            distance[i] = cost[sourceVertex][i];
            if (cost[sourceVertex][i] == 999)
                path[i] = 0;
            else
                path[i] = sourceVertex;
        }

        visited[sourceVertex] = 1;

        while (count <= numberOfNodes) {
            min = 999;

            for (int w = 1; w <= numberOfNodes; w++)
                if ((distance[w] < min) && (visited[w] == 0)) {
                    min = distance[w];
                    currentVertex = w;
                }

            visited[currentVertex] = 1;
            count++;

            for (int w = 1; w <= numberOfNodes; w++) {
                if ((distance[w]) > (distance[currentVertex] + cost[currentVertex][w])) {
                    distance[w] = distance[currentVertex] + cost[currentVertex][w];
                    path[w] = currentVertex;
                }
            }
        }
    }

    static void printPath(int sourceVertex, int numberOfNodes, int distance[], int path[], int visited[]) {
        for (int w = 1; w <= numberOfNodes; w++) {
            if (visited[w] == 1 && w != sourceVertex) {
                System.out.println("The shortest distance between ");
                System.out.println(sourceVertex + " -> " + w + " is: " + distance[w]);

                int t = path[w];
                System.out.println("The path is:");
                System.out.print(" " + w);

                while (t != sourceVertex) {
                    System.out.print("<--> " + t);
                    t = path[t];
                }

                System.out.print("<--> " + sourceVertex);
            }
        }
    }
}
