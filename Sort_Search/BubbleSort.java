package com.saqib;
import java.util.*;

class Bubble{
	
	int[] sort(int arr[], int size){
		for(int i=0; i<size; i++) {
			for(int j=0; j<size-1; j++) {
				if(arr[j] < arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
}

public class BubbleSort {
	
	public static void main(String[] args) {
		int size;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Array Size -> ");
		size = sc.nextInt();
		int arr[] = new int[size];
		int ans[] = new int[size];
		
		System.out.println("Enter Array Elements -> ");
		for(int i=0; i<size; i++) 
			arr[i] = sc.nextInt();
		
		for(int i=0; i<size; i++) 
			System.out.println("A["+i+"] = "+arr[i]);
		
		Bubble obj = new Bubble();
		
		ans = obj.sort(arr, size);
		
		
		System.out.println("::SORTED::");
		for(int i=0; i<size; i++) 
			System.out.println("A["+i+"] = "+ans[i]);
		
	}
}
