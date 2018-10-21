package com.linked_list.pack;

public class ListNode {
	private int data ; // Data held by the node 
	private ListNode next ;
	
	
	public ListNode(int data) { // Constructor of the type ListNode 
		this.data = data ; 
		next      = null ;
	}
	
	
	public void displayNode() {
		System.out.println(data);
	}


	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public ListNode getNext() {
		return next;
	}


	public void setNext(ListNode next) {
		this.next = next;
	}

}
