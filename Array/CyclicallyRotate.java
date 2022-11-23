package arrayDemo;

public class CyclicallyRotate {
	
	
	public static int[] rotate(int[] arr) {
		int x = arr[arr.length - 1];	
		// shift
		for(int i = arr.length - 1; i > 0; i--) {	
			arr[i] = arr[i - 1];
		}
		arr[0] = x;
		return arr;
	}
	
	public static void display(int[] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		display(arr);
		System.out.println();
		display(rotate(arr));

	}

}
