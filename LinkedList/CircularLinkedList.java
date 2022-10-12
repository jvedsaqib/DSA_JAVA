package com.practice.saqib;


public class CircularLinkedList {
	// private static ListNode head;
	
	
	private static class ListNode{
		private int data;
		private ListNode next;
		private ListNode prev;
		
		public ListNode(int data){
			this.data = data;
		}
	}
	
	
	// <---Methods--->
	
	
	public void display(ListNode head) {
		ListNode temp = head;
		
		do {
			System.out.print(temp.data+"-> ");
			temp = temp.next;
		}while(temp.next != head);
		System.out.print(temp.data);
		
	}
	
	public ListNode addNodeAtFront(int data, ListNode head) {
		ListNode prevNode = new ListNode(data);
		
		head.prev = prevNode;
		prevNode.next = head;
		ListNode temp = head;
		do {
			temp = temp.next;
		}while(temp.next != head);
		prevNode.prev = temp;
		temp.next = prevNode;
		
		return head;
	}
	
	
	public ListNode addNodeAtLast(int data, ListNode head) {
		ListNode temp = head;
		ListNode prevNode = new ListNode(data);
		
		prevNode.next = head;
		do {
			temp = temp.next;
		}while(temp.next != head);
		temp.next = prevNode;
		prevNode.prev = temp;
		
		return head;
	}
	
	
	
	// ---MAIN---
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		
		ListNode head = new ListNode(5);
		ListNode second = new ListNode(7);
		ListNode third = new ListNode(9);
		ListNode fourth = new ListNode(3);
		
		head.next = fourth;
		head.prev = fourth;
		fourth.next = head;
		fourth.prev = head;
		
		head = cll.addNodeAtLast(14, head);
		head = cll.addNodeAtFront(20, head);
		head = cll.addNodeAtFront(11, head);
		head = cll.addNodeAtLast(17, head);
		
		cll.display(head);
		

	}

}
