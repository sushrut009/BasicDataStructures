package com.circ.link;

public class LinkNode {
  private int data ;
  private LinkNode next;
  
  
  public LinkNode(int data) {
	  this.data = data ;
	  next = null ;
  }

// Getter and setter functions -----------------------------------------------------
  public int getData() {
	return data;
  }


  public void setData(int data) {
	this.data = data;
  }


  public LinkNode getNext() {
	return next;
  }


  public void setNext(LinkNode next) {
	this.next = next;
  }

// End : Getter and setter functions------------------------------------------------
  
  public void  displayLink() {
	  System.out.println(this.data);
  }

  
  
}
