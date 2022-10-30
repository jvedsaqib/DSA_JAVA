package sort_search;

public class InsertionSort {
	int arr[];
	
	public static int[] sort(int[] arr) {
		
		for(int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			
			while(j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = temp;	
		}
		return arr;
	}
	
	
	public static void display(int[] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {5, 2, 7, 1, 9};
		display(arr);
		System.out.println();
		display(sort(arr));

	}

}
