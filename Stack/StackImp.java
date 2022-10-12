


public class StackImp {	
	private ListNode top;
	private int length;
	
	private static class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data){
			this.data = data;
		}	
	}
	
	
	public ListNode push(int data) {
		ListNode temp = new ListNode(data);
		temp.next = top;
		top = temp;
		length++;
		return temp;
	}
	
	public ListNode pop(ListNode stack) {
		if(top == null) {
			System.err.println("Stack Underflow");
			return stack;
		}
		System.out.println("Popped -> "+top.data);
		top = top.next;
		length--;
		return stack;
	}
	
	public void display(ListNode stack) {
		if(top == null) {
			System.err.println("No element");
		}
		else {
			System.out.println("::Stack::");
			System.out.println("::Length:: "+length);
			while(stack.next != null) {
				System.out.println(stack.data);
				stack = stack.next;
			}
			System.out.println(stack.data);
		}
	}
	
	public void peek(ListNode stack) {
		System.out.println("Top of stack -> "+ top.data);
	}
	public void getLength(ListNode stack) {
		System.out.println("Length of stack -> "+ length);
	}
	
	
	
	public static void main(String[] args) {
		StackImp obj = new StackImp();
		ListNode stack = obj.push(6);
		stack = obj.push(5);
		stack = obj.push(7);
		obj.display(stack);
		obj.peek(stack);
		stack = obj.pop(stack);
		stack = obj.pop(stack);
		stack = obj.pop(stack);
		stack = obj.pop(stack);
		obj.display(stack);
		stack = obj.push(7);
		stack = obj.push(14);
		obj.display(stack);
		obj.peek(stack);
		obj.getLength(stack);
		System.out.println("-----------");
	}

}
