package com.Doubly.list;

public class LinkNode {
	int data ;
	LinkNode next ;
	LinkNode prev ;
	
	public LinkNode(int value) {
		data = value ;
	}
	
	public void displayLink() {
		System.out.print(data);
		System.out.print("--->");
	}
	
}
