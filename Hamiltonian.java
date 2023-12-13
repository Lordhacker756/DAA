import java.io.*;

public class HamiltonianCycle {
    static boolean isSolutionFound = false;

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\t\t\t\tHamiltonian Cycle");

        System.out.print("\nEnter the number of the vertices: ");
        int numberOfVertices = Integer.parseInt(reader.readLine());

        int graph[][] = new int[numberOfVertices + 1][numberOfVertices + 1];
        int path[] = new int[numberOfVertices + 1];

        System.out.print("\nIf edge between the following vertices enter 1 else 0:\n");
        for (int i = 1; i <= numberOfVertices; i++)
            for (int j = 1; j <= numberOfVertices; j++) {
                if ((i != j) && (i < j)) {
                    System.out.print(i + " and " + j + ": ");
                    graph[j][i] = graph[i][j] = Integer.parseInt(reader.readLine());
                }
                if (i == j)
                    graph[i][j] = 0;
            }

        for (int i = 1; i <= numberOfVertices; i++)
            path[i] = 0;

        path[1] = 1;
        System.out.println("\nSolution:");
        findHamiltonianCycle(2, graph, path, numberOfVertices);

        if (!isSolutionFound)
            System.out.println("No Solution possible!");
    }

    static void findHamiltonianCycle(int position, int graph[][], int path[], int numberOfVertices) {
        while (true) {
            getNextValue(position, graph, path, numberOfVertices);
            if (path[position] == 0)
                return;
            if (position == numberOfVertices) {
                for (int i = 1; i <= position; i++)
                    System.out.print(path[i] + " ");
                System.out.println();
                isSolutionFound = true;
                return;
            } else
                findHamiltonianCycle(position + 1, graph, path, numberOfVertices);
        }
    }

    static void getNextValue(int position, int graph[][], int path[], int numberOfVertices) {
        while (true) {
            path[position] = (path[position] + 1) % (numberOfVertices + 1);
            if (path[position] == 0)
                return;
            if (graph[path[position - 1]][path[position]] != 0) {
                int j;
                for (j = 1; j < position; j++)
                    if (path[position] == path[j])
                        break;
                if (j == position)
                    if ((position < numberOfVertices) || ((position == numberOfVertices) && graph[path[numberOfVertices]][path[1]] != 0))
                        return;
            }
        }
    }
}