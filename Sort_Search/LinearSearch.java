package sort_search;

public class LinearSearch {
	
	public static boolean search(int[] arr, int key) {
		for(int i : arr) {
			if (i == key)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = {5, 1, 3, 4, 7};
		
		System.out.println(search(arr, 5));
		System.out.println();
		System.out.println(search(arr, 15));

	}

}
