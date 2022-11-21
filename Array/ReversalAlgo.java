package arrayDemo;

public class ReversalAlgo {
	
	public static int[] reverse(int arr[], int start, int end) {
		
		for(int i = start; i < end; i++) {
			int temp = arr[i];
			arr[i] = arr[i+1];
			arr[i + 1] = temp;
		}
		return arr;
	}
	

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		int d = 2;
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr = reverse(arr, 0, d);
		arr = reverse(arr, d, arr.length - 1);
		arr = reverse(arr, 0, arr.length - 1);
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
