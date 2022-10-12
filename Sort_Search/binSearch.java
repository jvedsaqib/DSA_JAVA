// This program extends a class from BubbleSort.java

package com.saqib;
import java.util.*;

class Search{
	
	void search(int arr[], int key, int high, int low) {
		int mid;
		mid = (high + low) / 2;
		if(low > high)
			System.out.println("Not Found");
		else if(mid == key)
			System.out.println("Found");
		else if(mid > key)
			search(arr, key, mid-1, low);
		else
			search(arr, key, high, mid+1);
	}
}

public class BinSearch extends Bubble {

	public static void main(String[] args) {
		int size,key;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Array size : ");
		size = sc.nextInt();
		Bubble obj = new Bubble();
		int arr[] = new int[size];
		int sort_arr[] = new int[size];
		
		System.out.println("Enter elements : ");
		for(int i=0; i<size; i++)
			arr[i] = sc.nextInt();
		
		sort_arr = obj.sort(arr, size);
		System.out.println("Sorted ARRAY : ");
		for(int i=0; i<size; i++)
			System.out.println("["+i+"] -> "+sort_arr[i]);

		System.out.println("Enter Key : ");
		key = sc.nextInt();
		Search bin = new Search();
		bin.search(sort_arr, key, size, 0);
	}

}
