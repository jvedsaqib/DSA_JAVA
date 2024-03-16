package linkedList;
import java.util.*;

public class SLL {

	private ListNode head;

	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void display() {
		ListNode temp = head;

		try {
			while (temp.next != null) {
				System.out.print(temp.data + " -> ");
				temp = temp.next;
			}
			System.out.println(temp.data);
		} catch (Exception e) {
			System.err.println("No Data");
		}

	}

	public void display(ListNode head) {
		ListNode temp = head;

		try {
			while (temp.next != null) {
				System.out.print(temp.data + " -> ");
				temp = temp.next;
			}
			System.out.println(temp.data);
		} catch (Exception e) {
			System.err.println("No Data");
		}

	}

	public int getSize() {
		int count = 0;
		ListNode temp = head;

		try {
			while (temp.next != null) {
				count++;
				temp = temp.next;
			}
		} catch (NullPointerException e) {
			System.err.println("No data");
		}
		return count + 1;
	}

	public int getHead() {
		int headNode = 0;
		ListNode temp = head;
		headNode = temp.data;
		return headNode;
	}

	public int getLast() {
		int lastNode = 0;
		ListNode temp = head;
		while (temp.next != null)
			temp = temp.next;
		lastNode = temp.data;
		return lastNode;
	}

	public void addNodeAtFront(int data) {
		ListNode temp = new ListNode(data);
		temp.next = head;
		head = temp;
		System.out.println("Data inserted at front!");
	}

	public void addNodeAtLast(int data) {
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
			if (temp.next == null) {
				ListNode lastNode = new ListNode(data);
				temp.next = lastNode;
				System.out.println("Data inserted at last!");
				break;
			}
		}
	}

	public void deleteNodeAtFront() {
		head = head.next;
	}

	public void deleteNodeAtLast() {
		ListNode temp = head;
		ListNode prev = null;

		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
	}

	public void addNodeAtSpecificPosition(int data, int pos) {
		int count = 0;
		ListNode temp = head;
		ListNode prev = null;

		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
			count++;
			if (count == pos) {
				ListNode addNode = new ListNode(data);
				prev.next = addNode;
				addNode.next = temp;
			}
		}

	}

	public void deleteNodeAtSpecificPosition(int pos) {
		int count = 0;
		ListNode temp = head;
		ListNode prev = null;

		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
			count++;
			if (count == pos) {
				prev.next = temp.next;
			}
		}
	}

	public boolean searchNode(int key) {
		ListNode temp = head;
		boolean flag = false;

		 do {
			if (temp.data == key)
				flag = true;
			temp = temp.next;
		}while (temp.next != null);

		return flag;
	}

	public ListNode reverseList(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;

		while (curr.next != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	// <-----MAIN----->

	public static void main(String args[]) {
		SLL sll = new SLL();
		Scanner sc = new Scanner(System.in);
		int data;

		int choice;
		int sub_choice;
		boolean flag = true;
		
		while(flag) {
			System.out.println("0) Exit \n1) Display \n2) Insert \n3) Delete \n4) Search");
			System.out.println("Choose - ");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 0:
				flag = false;
				break;
			case 1:
				sll.display(sll.head);
				break;
			case 2:
				System.out.println("0) Back \n1) Insert at front \n2) Insert at last \n3) Insert at specific position");
				System.out.println("Choose - ");
				sub_choice = sc.nextInt();
				switch(sub_choice) {
				
				case 0:
					break;
				case 1:
					System.out.println("Enter Data - ");
					data = sc.nextInt();
					sll.addNodeAtFront(data);
					System.out.println();
					sll.display(sll.head);
					break;
				case 2:
					System.out.println("Enter Data - ");
					data = sc.nextInt();
					sll.addNodeAtLast(data);
					System.out.println();
					sll.display(sll.head);
					break;
				case 3:
					System.out.println("Enter Data - ");
					data = sc.nextInt();
					System.out.println("Enter Position - ");
					int add_pos = sc.nextInt();
					sll.addNodeAtSpecificPosition(data, add_pos);
					System.out.println();
					sll.display(sll.head);
					break;
				
				}
				break;
				
			case 3:
				System.out.println("0) Back \n1) Delete front \n2) Delete last \n3) Delete specific position");
				System.out.println("Choose - ");
				sub_choice = sc.nextInt();
				switch(sub_choice) {
				
				case 0:
					break;
				case 1:
					sll.deleteNodeAtFront();
					System.out.println();
					sll.display(sll.head);
					break;
				case 2:
					sll.deleteNodeAtLast();
					System.out.println();
					sll.display(sll.head);
					break;
				case 3:
					System.out.println("Enter Position - ");
					int del_pos = sc.nextInt();
					sll.deleteNodeAtSpecificPosition(del_pos);
					System.out.println();
					sll.display(sll.head);
					break;
				}
				break;
			
			case 4:
				System.out.println("Enter Element - ");
				int key = sc.nextInt();
				System.out.println(sll.searchNode(key));
				break;
			
			}
			
			
		}
		
		

	}

}
