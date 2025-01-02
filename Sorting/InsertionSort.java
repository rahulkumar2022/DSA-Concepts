package Sorting;


// Take an element and place it in right position
public class InsertionSort {
    
    private void sort(int[] arr,int n){
        for(int i=0;i<n;i++){
            int j = i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1,6,9};
        InsertionSort obj = new InsertionSort();
        obj.sort(arr,arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
