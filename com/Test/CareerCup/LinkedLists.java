package com.Test.CareerCup;


class LLNode{
	int data;
	LLNode next;
}


public class LinkedLists {

	public void addNodeToEndOfList(int data, LLNode head){
		LLNode tempPtr  = head;
		
		while(tempPtr.next != null){
			tempPtr = tempPtr.next;
		}
		
		LLNode newNode = new LLNode();
		newNode.data = data;
		newNode.next = null;
		tempPtr.next = newNode;
	}
	
	public void displayList(LLNode head){
		LLNode tempPtr = head;
		if(tempPtr != null){
			System.out.print(tempPtr.data+",");
			tempPtr = tempPtr.next;
			displayList(tempPtr);
		}
	}
	
}
