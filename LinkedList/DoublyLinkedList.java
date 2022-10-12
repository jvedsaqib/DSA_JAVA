package com.practice.saqib;



public class DoublyLinkedList {
	private static ListNode head;
	
	private static class ListNode{
		private int data;
		private ListNode next;
		private ListNode prev;
		
		ListNode(int data, ListNode prev){
			this.data = data;
			this.prev = prev;
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
	
	public int getHead(ListNode head) {
		int headNode = 0;
		ListNode temp = head;
		headNode = temp.data;
		return headNode;
	}
	
	public int getLast(ListNode head) {
		int lastNode = 0;
		ListNode temp = head;
		while(temp.next != null)
			temp = temp.next;
		lastNode = temp.data;
		return lastNode;
	}
	
	public ListNode addNodeAtFront(ListNode head, int data) {
		ListNode temp = new ListNode(data, null);
		temp.next = head;	
		head = temp;
		return head;
	}
	
	
	public ListNode addNodeAtLast(ListNode head, int data) {
		ListNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
			if(temp.next == null) {
				ListNode addNode = new ListNode(data, temp);
				temp.next = addNode;
				break;
			}
		}
		
		
		 return head;
	}
	
	public ListNode deleteNodeAtFront(ListNode head) {
		ListNode temp = head;
		temp = head.next;
		temp.prev = null;
		
		return temp;
	}
	public ListNode deleteNodeAtLast(ListNode head) {
		ListNode temp = head;
		ListNode prev = null;
		
		while(temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
		
		return head;
	}
	
	
	
	
	
	
	
	// <---MAIN--->
	public static void main(String[] args) {
		
		DoublyLinkedList dll = new DoublyLinkedList();
		
		ListNode head = new ListNode(5, null);
		ListNode second = new ListNode(10, head);
		ListNode third = new ListNode(15, second);
		
		head.next = second;
		second.next = third;
		
		dll.display(head);
		System.out.println(dll.getHead(head));
		System.out.println(dll.getLast(head));
		head = dll.addNodeAtFront(head, 4);
		dll.display(head);
		
		head = dll.addNodeAtLast(head, 17);
		dll.display(head);
		
		head = dll.deleteNodeAtFront(head);
		dll.display(head);
		
		head = dll.deleteNodeAtLast(head);
		dll.display(head);
		
	}

}
