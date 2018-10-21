package com.Doubly.list;

public class DoublyLinkedList {
  LinkNode first ;
  LinkNode last ;
	
  // Constructor 
  public DoublyLinkedList() {
    first = null ;
	last = null ;
  }
	
  // Return if the LinkedList is empty or not 
  public boolean isEmpty() {
    if(first == null) 
	  return true ;
	else 
	  return false ;
    }

  public void insertFirst(int value) {
  //Create a new Object 
    LinkNode Obj = new LinkNode(value); //  Obj is the refrence to the new object	  
  //Two cases :
  //  1) List is empty 
  //  2) List is not empty 
	  
  // Scenerio Diagram ::::::
  // -----------------------------------------------------	  
	 
  //  --------                                     -----------
  //  | First |---------> Null                     |  Next   |----> Null
  //  |       |                                    |         |
  //  | Last  |---------> Null             Null<---|  Prev   |
  //  |-------|                                    |---------|
	  
  if(isEmpty()) {
	  //Attach first of the list to "next reference" of the newly created object
	  last  = Obj ;
	  // After this , the first element is inserted and we have---> 
	  //  --------                                     -----------
	  //  | First |----------------------------------->|  Next   |----> Null
	  //  |       |                                    |         |
	  //  | Last  |----------------------      Null<---|  Prev   |
	  //  |-------|                      |             |----^----|
	  //                                 |------------------| 
	  
  } else {
	  //Scenerio :
	  //-------                 --------       ---------
	  // |First|--------------->| Next |------>|  Next |----> NULL
	  // |     |                |      |       |       |
	  // |     |                |      |       |       |
	  // |Last |---|    NULL<---| Prev |<------|  Prev |
	  // -------   |            --------       -----^--|
	  //           |--------------------------------|
	  // Start by connecting the prev of the old first to the new object 
	  first.prev = Obj ; // note prev of obj is by default set to NULL 
	  Obj.next = first ; // Make the next reference of the new obj to point to old first 
    
  }
  
  first = Obj ; // This step is common to both 
  }
  
  public  void insertLast(int value) {
	  LinkNode Obj = new LinkNode(value);
	  if(isEmpty()) {
		  first = Obj ;
		  last =  Obj ;  
	  } else {
		  last.next = Obj ;
		  last.next.prev = last ;
		  last = Obj ;
	  }
  }
  
  
  public void deleteFirst() {
	  if(isEmpty()) {
		  System.out.println("Cannot delete an element from an empty list");
		  return ;  // Cannot delete 
	  }
	  
	  if(first.next == null) {
		  last = null ;
	  } else {
	  first.next.prev = null;
	  }
	  first = first.next;
	  
  }
  
  public void deleteLast() {
	  if(isEmpty()) {
		  System.out.println("Cannot delete element from an empty list");
		  return ;
	  }
	  
	  if(first.next == null) {
		  first = null ; 
	  } else {
		  last.prev.next = null ; 
	  }
	  last = last.prev ;
  }
  
  
  // Insert value after the node with matching key  
  public void insertAfter(int key, int value ) {
	  if(isEmpty()) {
		  return ;
	  }
	  LinkNode Obj = new LinkNode(value); // Create a node to be inserted 
	  LinkNode current = first ;
	  while(current != null ) {
		  if(current == last) {
			  insertLast(value);
			  return ;
		  }
		  if(current.data == key ) {
			  current.next.prev = Obj ;
			  Obj.next = current.next ;
			  current.next = Obj ;
			  Obj.prev = current;
			  return;
		  } else {
			  current = current.next;
		  }  
	  }
	  
  }
  
  public void deleteKey(int key) {
	  if(isEmpty()) {
		  return ;
	  }
	  LinkNode current = first ;
	  
	  while(current != null) {
	    if(current.data == key) {
		  if(current == first) {
		    deleteFirst() ;
		    return ;
	      } else if (current == last ) {
	    	  deleteLast() ;
	    	  return ;
	      } else {
	    	  current.next.prev = current.prev ;
	    	  current.prev.next = current.next;
	    	  return ;
	      }
	    }
		else {
			current = current .next;
		}
      }
  
  }
  
  public void displayForward() {
	  LinkNode current = first ;
	  System.out.println("First -----> Last");
	  while(current != null) {
		  current.displayLink();
		  current = current.next ;
	  }  
  }
  
  public void displayBackward() {
	  LinkNode current = last ;
	  System.out.println("Last -----> First");
	  while(current != null) {
		  current.displayLink();
		  current = current.prev;
		  
	  }
	  System.out.println("NULL");
  }
  
  
}
