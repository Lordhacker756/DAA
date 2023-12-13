public class QuickSort {
    public static void main(String args[]) {
        //Numbers which need to be sorted
        int[] numbers = {23,5,23,1,7,12,3,34,0,-2,4,2,1222,2,0};
        
        //Displaying the numbers before sorting 
        System.out.print("Before sorting, numbers are ");
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
        
        //Sorting in ascending order using bubble sort 
        quickSortInAscendingOrder(numbers,0,numbers.length-1);
        
        //Displaying the numbers after sorting 
        System.out.print("After sorting, numbers are ");
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
    }
    
    //This method sorts the input array in ascending order using quick sort 
    static void quickSortInAscendingOrder (int[] numbers, int low, int high) {
        int i = low;
        int j = high;
        int temp;
        int middle = numbers[(low + high) / 2];
        
        while (i < j) {
            while (numbers[i] < middle) {
                i++;
            }
            while (numbers[j] > middle) {
                j--;
            }
            if (i <= j) {
                temp = numbers[i]; 
                numbers[i] = numbers[j]; 
                numbers[j] = temp;
                i++;
                j--; 
            }
        }
        if (low < j) {
            quickSortInAscendingOrder(numbers, low, j); 
        }
        if (i < high) {
            quickSortInAscendingOrder(numbers, i, high); 
        }
    } 
}