package com.practice.saqib;

public class String_subsequence {

	public static boolean isSubsequence(String str, String sub) {
		int i = 0;
		int j = 0;
		
		while(i < str.length() && j < sub.length()) {
			if(str.charAt(i) == sub.charAt(j)) {
				j++;
			}
			i++;
		}
		
		return j == sub.length();
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(isSubsequence("Saqib", "aqi"));
		
		System.out.println(isSubsequence("Saqib", "aiq"));
		

	}

}
