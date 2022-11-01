package sort_search;

public class SelectionSort {

	public static int[] sort(int[] arr) {
		int n = arr.length;
		
		for(int i = 0; i < n - 1; i++) {
			int min = i;
			for(int j = i + 1; j < n; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {5, 1, 10, 2, 9};
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr = sort(arr);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
	}

}
