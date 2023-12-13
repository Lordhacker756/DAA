import java.util.Scanner;

public class Subset {
    static int solutionCount = 0;

    public static void main(String[] args) {
        int[] elements = new int[10];
        int numberOfElements, targetSum, index, totalSum = 0;
        int[] subsetIndicator = new int[10];
        Scanner in = new Scanner(System.in);
        System.out.println("********** SUBSET PROBLEM ************");
        System.out.println("Enter the number of elements: ");
        numberOfElements = in.nextInt();
        System.out.println("Enter the elements in increasing order");
        for (index = 0; index < numberOfElements; index++)
            elements[index] = in.nextInt();
        System.out.println("Enter the value of target sum: ");
        targetSum = in.nextInt();
        for (index = 0; index < numberOfElements; index++)
            totalSum = totalSum + elements[index];
        System.out.println("SUM =" + totalSum);
        if (totalSum < targetSum || elements[0] > targetSum) {
            System.out.println("Subset is not possible ! ");
            System.exit(0);
        }
        findSubsets(0, 0, totalSum, subsetIndicator, elements, targetSum);
        if (solutionCount == 0)
            System.out.println("Subset is not possible ! ");
        System.out.println("\n********** ********* *************");
    }

    static void findSubsets(int currentSum, int currentIndex, int remainingSum, int[] subsetIndicator, int[] elements, int targetSum) {
        subsetIndicator[currentIndex] = 1;
        if (currentSum + elements[currentIndex] == targetSum) {
            solutionCount++;
            System.out.print("\nSolution " + solutionCount + " is {");
            for (int i = 0; i <= currentIndex; i++)
                if (subsetIndicator[i] == 1) {
                    System.out.print(elements[i] + " ");
                }
            System.out.print("}");
        } else if (currentIndex + 1 < elements.length && (currentSum + elements[currentIndex] + elements[currentIndex + 1]) <= targetSum)
            findSubsets(currentSum + elements[currentIndex], currentIndex + 1, remainingSum - elements[currentIndex], subsetIndicator, elements, targetSum);
        if (currentIndex + 1 < elements.length && (currentSum + remainingSum - elements[currentIndex]) >= targetSum && (currentSum + elements[currentIndex + 1]) <= targetSum) {
            subsetIndicator[currentIndex] = 0;
            findSubsets(currentSum, currentIndex + 1, remainingSum - elements[currentIndex], subsetIndicator, elements, targetSum);
        }
    }
}