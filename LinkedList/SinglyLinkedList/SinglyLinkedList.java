package com.linked_list.pack;

public class SinglyLinkedList {
	private ListNode head ; 
	private int nElements ; 
	private ListNode last ;
	
	
	public SinglyLinkedList() {
		head      = null ; 
		last      = null ;
		nElements = 0 ;
	}
	
// Getters and setter functions :--------------------------------------------------------------------
	
	public ListNode getHead() {
		return head;
	}


	public void setHead(ListNode head) {
		this.head = head;
	}


	public int getnElements() {
		return nElements;
	}


	public void setnElements(int nElements) {
		this.nElements = nElements;
	}


	public ListNode getLast() {
		return last;
	}


	public void setLast(ListNode last) {
		this.last = last;
	}

//---------------------------------------------------------------------------------------------------------
	
// INSERT FUNCTIONS :--------------------------------------------------------------------------------------------------------------
	public void insertAtHead(int value) {
		// create a new object to insert 
		ListNode N1 = new ListNode(value);
		//There can be two cases :::::
		// Case 1: List is empty and if it is insert the new elements and that will be the head element
		// We can check if the list is empty by checking the nElements flag 
		// If the list is not empty , we can set the head to be the new element 
		//Not that I do not set N1.next = null explicitly in the case when nElements is 0 . This is because 
		// by default, it points to null . 
		
		if(nElements == 0 ) { //List is empty
			last = N1 ; 
		} else {
			N1.setNext(head) ; 
		}
		head = N1 ; 
		nElements++ ;
	}
	
	
	public void insertAtEnd(int value) {
		// create a new object to insert 
		ListNode N1 = new ListNode(value);
	    if(nElements == 0 ) {
	    	head = N1 ; 
	    } else {
	    	last.setNext(N1);
	    }
	    last = N1 ;
	    nElements++ ;
	}
	
	public void insertAtPosition(int value , int position) {
		// First Node is considered position 0 
		// Last node is considered position nElements -1 
		// If position = nElements , add the node at the end 
		
		//Validate the position 
		if(position < 0  || position > nElements) {
			System.out.println("Cannot insert at specified position");
			return ;
		}
		ListNode N1 = new ListNode(value) ;
		ListNode current = head ; 
		int index = 0 ; // To match the position
		if(position == 0) {
			insertAtHead(value);
			return ; 
		} 
		if(position == nElements) {
			insertAtEnd(value) ;
			return ;
		} 
		while(current != null) {
			if(index == position - 1) {
				N1.setNext(current.getNext());
				current.setNext(N1);
				nElements++ ;
				return ;
			} else {
				index++ ;
				current = current.getNext();
			}
			
		}
		
	}

// Insert END --------------------------------------------------------------------------------------------------------------------------
	
	
// Remove functions ---------------------------------------------------------------------------------------	
	public void removeAtHead() {
		if(nElements == 0) {
			System.out.println("Cannot remove element at head : Empty List");
			return ;
		} else  {
			if(nElements == 1) {
				last = null ;
			}
				
			head = head.getNext(); 
			nElements--;
		}
	}
	
	

	public void removeAtEnd() {
		if(nElements == 0) {
			System.out.println("Cannot remove element at head : Empty List");
			return ;
		} else {
			ListNode current = head ; 
			for(int i = 0 ; i < nElements -2 ; i++) {
				current = current.getNext();
			}
			current.setNext(null);
			last = current ;
			if(nElements == 1) {
				head = null ;
			}
			nElements--;
		}
	}
	
	public void removeAtPosition(int position) {
		if(nElements == 0) {
			System.out.println("Cannot remove element : Empty list");
			return ;
		}
		
		if(position < 0 || position > nElements-1) {
			System.out.println("Position must be in the range from 0 to nElements-1");
			return ; 
		}
		
		if(position == 0 ) {
			removeAtHead();
		} else if(position == nElements-1) {
			removeAtEnd();
		} else {
		    ListNode current = head ;
		    ListNode previous = head ; 
		    for(int i=0 ; i< position ; i++) {
		    	previous = current ;
		    	current = current.getNext();
		    }
		    previous.setNext(current.getNext());
		    nElements-- ;
		}
	}
	
// Remove functions end -------------------------------------------------------------------------------------	
	public boolean isEmpty() {
		return (nElements== 0 ) ;
	}




   public void displayList() {
	   if(nElements == 0) {
		   System.out.println("Empty List: Nothing to display");
		   return ;
	   }
	   ListNode current = head ; 
	   System.out.println("-----------------Displaying List-----------------------------------------------");
	   while(current != null) {
		   current.displayNode();
		   current= current.getNext(); 
	   }
	   
	   System.out.println("-----------------Finished Displaying List -------------------------------------");
   }
   
   
}
