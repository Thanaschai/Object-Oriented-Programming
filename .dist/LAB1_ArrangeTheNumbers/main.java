import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Amount of Number : ");
        String N = s.nextLine();
        int n = Integer.parseInt(N); //String to integer
        if(n < 0){ //Check if amount of number are less than 0
            System.out.println("You number should be a natural number and 0");
            return;
        }
        int [] arr = new int [n];

        for(int i = 0 ; i < n ; i++){
            String number = s.nextLine();
            int num = Integer.parseInt(number);
            arr[i] = num;
        }
        System.out.println("---------------------------");
        if(n>= 1){
            QuickSort(arr , 0 , n-1);
        }
        for(int i = 0 ; i < n ; i++){
            System.out.println(arr[i]);
        }
    }

    //    Reference Quick Sort by https://www.youtube.com/watch?v=h8eyY7dIiN4

    private static  void swap(int [] arr , int index1 , int index2){
        int temp = arr[index1]; //Given the temporary value
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    private static void QuickSort(int [] arr , int low_index , int high_index){
        if(low_index >= high_index){
            return;
        }
        int pivot = arr[high_index]; //Assume pivot value is Last value in array
        int left_pointer = low_index;
        int right_pointer = high_index;
        while(left_pointer < right_pointer){

            while(arr[left_pointer] <= pivot && left_pointer < right_pointer){ //Find index of value greater than pivot in array
                left_pointer++;
            }

            while(arr[right_pointer] >= pivot && left_pointer < right_pointer){ //Find index of value lower than pivot in array
                right_pointer--;
            }
            swap(arr , left_pointer , right_pointer); //Swap value between arr[left_pointer] and arr[right_pointer]
        }
        swap(arr , left_pointer , high_index); //Swap value between arr[left_pointer] and pivot

        QuickSort(arr , low_index , left_pointer-1); //Recursive in left part partition

        QuickSort(arr , right_pointer+1 , high_index); //Recursive in right part partition
    }
}