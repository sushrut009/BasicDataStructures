package com.circ.link;

public class CircularLinkedList {
  LinkNode head ;
  LinkNode last ; 
  
  //Constructor 
  public CircularLinkedList() {
	  head = null ; // This node is the head node
	  last = null ;
  }
  
  public boolean isEmpty() {
	  return (head == null) ;
  }
   
  
  //-----------------------------------------------------------------------------------------------
  //     |---------------------------------------|
  // -------      --------       ---------       |
  // |      |     |      |       |       |       |
  // | NODE |---->|NODE  |------>| NODE  |--------
  // |      |     |      |       |       |
  // --------     --------       ---------
  public void insertAtHead(int value) {
	  LinkNode L1 = new LinkNode(value) ;
	  if(isEmpty()) {
		  head = L1 ;
		  last = L1 ;
		  L1.setNext(head);;
	  } else {
		  last.setNext(L1);
		  L1.setNext(head);
		  head = L1 ;
	  }
  }
  
  public void insertAtEnd(int value) {
	  LinkNode L1 = new LinkNode(value) ;
	  if(isEmpty()) {
		  head = L1 ;
		  last = L1 ;
		  L1.setNext(head);
	  } else {
		  last.setNext(L1);
		  L1.setNext(head);
		  last = L1 ;
	  }
  }
  
  
  public void DeleteAtLast() {
	  if(isEmpty()) {
		  System.out.println("Invalid operation for empty list : LIST EMPTY");
		  return ;
	  }
	  
	  if(this.ListLength() == 1) {
		  head = null ;
		  last = null ;
		  System.out.println("List is EMPTY now ");
		  return ;
	  }
	  
	  LinkNode current = head ; 
	  LinkNode previous = head ;
	  
	  while(current != last) {
		  previous = current ;
		  current = current.getNext();
	  }
	  
	  previous.setNext(head);
	  
  }
  
  
  public void DeleteAtHead() {
	  if(isEmpty()) {
		  System.out.println("Invalid operation for empty list : LIST EMPTY");
		  return ;
	  }
	  
	  if(this.ListLength() == 1) {
		  head = null ;
		  last = null ;
		  System.out.println("List is EMPTY now ");
		  return ;
	  }
	  
	  head = head.getNext();
	  
  }
  
  public void displayList() {
	  LinkNode current = head ;
	  System.out.println("------------------------ Begin Display List ------------------------------");
	  while(current.getNext() != head) {
		  current.displayLink();
		  current = current.getNext();
	  }
	  current.displayLink();
	  System.out.println("------------------------ End Display List --------------------------------");
  }
  public int ListLength() {
	  if(isEmpty()) return 0 ;
	  int length = 1 ;
	  LinkNode current  = head ; 
	  
	  while(current.getNext() != head) {
		  length++ ;
          current = current.getNext();		  
	  }
	  
	  return length ;
  }
  
  
   
	
}
