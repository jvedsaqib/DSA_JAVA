// This progam uses stack to reverse a string

import java.util.Stack;

public class StringReverse {
	
	public static String reverse(String str) {
		Stack<Character> stack = new Stack<>();
		
		char chararr[] = str.toCharArray();
		
		for(char c : chararr) {
			stack.push(c);
		}
		
		for(int i = 0; i<chararr.length; i++) {
			chararr[i] = stack.pop();
		}
		return new String(chararr);
	}

	public static void main(String[] args) {
		
		StringReverse str = new StringReverse();
		
		String s1 = str.reverse("SAQIB");
		System.out.println(s1);

	}

}
