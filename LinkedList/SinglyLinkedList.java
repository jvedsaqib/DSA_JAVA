package com.practice.saqib;

public class SinglyLinkedList {

	private ListNode head;
	
	private static class ListNode{
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
			while(temp.next != null) {
				System.out.print(temp.data+" -> ");
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
			while(temp.next != null) {
				System.out.print(temp.data+" -> ");
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
			while(temp.next != null) {
				count++;
				temp = temp.next;
			}
		}
		catch(NullPointerException e){
			System.err.println("No data");
		}
		return count+1;
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
		while(temp.next != null)
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
		while(temp.next != null) {
			temp = temp.next; 
			if(temp.next == null) {
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
		
		while(temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
	}
	
	public void addNodeAtSpecificPosition(int data, int pos) {
		int count = 0;
		ListNode temp = head;
		ListNode prev = null;
		
		while(temp.next != null) {
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
		
		while(temp.next != null) {
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
		
		while(temp.next != null) {
			if(temp.data == key)
				flag = true;
			temp = temp.next;
		}
		
		return flag;
	}
	
	
	
	public ListNode reverseList(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		
		while(curr.next != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	
	
	
	
	
	// <-----MAIN----->
	
	public static void main(String args[]) {
		SinglyLinkedList sll = new SinglyLinkedList();
		
		sll.head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(4);
		
//			<-------------->
		
		sll.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = null;
		
		sll.display();
		System.out.println(sll.getSize());
		sll.addNodeAtFront(12);
		sll.display();
		System.out.println(sll.getSize());
		sll.addNodeAtLast(17);
		sll.addNodeAtFront(5);
		sll.display();
		System.out.println("Head Node -> "+sll.getHead());
		System.out.println("Last Node -> "+sll.getLast());
		sll.deleteNodeAtFront();
		sll.display();
		sll.deleteNodeAtLast();
		sll.display();
		sll.addNodeAtSpecificPosition(24, 1);
		sll.display();
		sll.deleteNodeAtSpecificPosition(2);
		sll.display();
		System.out.println(sll.searchNode(82));
		ListNode reverse = sll.reverseList(sll.head);
		sll.display(reverse);
		
	}
	
}
