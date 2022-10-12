package com.practice.saqib;

class Array{
	
	/*public int secondLargest(int[] arr) {
		int max = 0;
		int secondMax = 0;
		
		for(int j = 0; j<arr.length; j++) {
			for(int i=0; i<arr.length; i++) {
				if(arr[i] > max) {
					max = arr[i];
				}
				else if(arr[i] > secondMax && arr[i] != max ) {
					secondMax = arr[i];
				}
			}
		}
		return secondMax;
	}*/
	
	public int secondLargest(int[] arr) {
		int max = 0;
		int secondMax = 0;
		
		
			for(int i=0; i<arr.length; i++) {
				if(arr[i] > max) {
					secondMax = max;
					max = arr[i];
				}
				else if(arr[i] > secondMax && arr[i] != max ) {
					secondMax = arr[i];
				}
			}
		
		return secondMax;
	}
	
	public int[] moveZero(int[] arr) {
		
		for(int j = 0; j<arr.length; j++) {
			for(int i = 0; i<arr.length; i++) {
				if(i < arr.length-1) {
					if(arr[i] == 0 & arr[i+1] != 0) {
						int temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
					}
				}
			}
		}
		return arr;
	}
	
	public int[] resizeArr(int[] arr, int capacity) {
		int temp[] = new int[capacity];
		if(capacity > arr.length) {
			for(int i = 0; i<arr.length; i++) {
				temp[i] = arr[i];
			}
		}
		else if(capacity < arr.length) {
			for(int i = 0; i<capacity; i++) {
				temp[i] = arr[i];
			}
		}
		arr = temp;
		return arr;
	}
	
	
	public int missingNum(int[] arr) {
		int n = arr.length + 1;
		int sum = n * (n+1) / 2;
		
		for(int i = 0; i<arr.length; i++) {
			sum = sum - arr[i];
		}
		return sum;
	}
	
	public char[] reverse(char[] arr) {
		char temp[] = new char[arr.length];
		int j = 0;
		for(int i = arr.length-1; i>=0; i--) {
			temp[j] = arr[i];
			j++;
		}
		
		return temp;
	}
	
	
	
	
	
}




public class OneDArray {

	public static void main(String[] args) {
		int arr[] = {1, 2, 0, 5, 6};
		int arr2[] = {1, 2, 3, 5, 6};
		
		Array obj = new Array();
		System.out.println("Second Highest -> "+obj.secondLargest(arr));
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			}
		System.out.println();
		obj.moveZero(arr);
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			}
		System.out.println();
		arr = obj.resizeArr(arr, arr.length*2);
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			}
		System.out.println();
		System.out.println("::Arr2::");
		for(int i = 0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" ");
			}
		System.out.println();
		System.out.println("Missing is -> "+obj.missingNum(arr2));
		
		String cat = "madam";
		char str[] = cat.toCharArray();
		System.out.println(cat);
		for(int i = 0; i<str.length; i++) {
			System.out.print(str[i]+" ");
			}
		System.out.println();
		str = obj.reverse(str);
		String revCat = new String(str);
		System.out.println(revCat);
		if(cat.equals(revCat))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
		
	}

}
