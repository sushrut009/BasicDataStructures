package com.linked_list.pack;

public class UserClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyLinkedList List1 = new SinglyLinkedList();
		List1.insertAtHead(20);
		List1.insertAtHead(30);
		System.out.println(List1.getnElements());
     	List1.insertAtHead(40);
//		List1.insertAtHead(50);
//		List1.displayList();
//		
		List1.insertAtEnd(100);
		List1.insertAtEnd(120);
		List1.insertAtEnd(140);
		List1.insertAtEnd(160);
		
		List1.displayList();
//		
//		List1.insertAtPosition(133, 3);
//		List1.insertAtPosition(217, 7);
//		List1.insertAtPosition(222, 10);
//		List1.insertAtPosition(322, 0);
//		List1.displayList();
//		List1.insertAtPosition(4423, 24);
//		List1.removeAtHead();
//		List1.removeAtHead();
//		List1.removeAtHead();
//		List1.removeAtEnd();
//		List1.displayList();
//		List1.removeAtEnd();
//		List1.displayList();
//		List1.removeAtEnd();
//		List1.displayList();
     	List1.removeAtPosition(0);
     	List1.displayList();
     	List1.removeAtPosition(1);
     	List1.displayList();
     	List1.removeAtPosition(2);
     	List1.displayList();
     	List1.removeAtPosition(0);
     	List1.displayList();
     	List1.removeAtPosition(2);
     	List1.displayList();
     	
		
		
		
	}

}
