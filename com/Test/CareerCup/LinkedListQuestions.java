package com.Test.CareerCup;

import com.Test.CareerCup.ListNode;

public class LinkedListQuestions {
	
	
	public static void AddNodeToList(int value, ListNode head)
	{
		ListNode tempHead = head;
		if(null == tempHead)
		{
			return;
		}
		while(null != tempHead.getNext())
		{
			tempHead = tempHead.getNext();
		}
		ListNode lastNode = new ListNode();
		lastNode.setValue(value);
		lastNode.setNext(null);
		tempHead.setNext(lastNode);
	}

	public void DisplayList(ListNode head)
	{
		if(null == head)
		{
			return;
		}
		int i = 1;
		while(true)
		{
			
			System.out.println("Value at position "+i+": "+head.getValue());
			if(null == head.getNext())
			{
				return;
			}
			head = head.getNext();
			i++;
		}
	}
	
	public void DeleteValueFromList(int value, ListNode head)
	{
		if(null == head)
		{
			return;
		}
		if(head.getValue() == value)
		{
			head = null;
		}
		
		if(head.getNext().getValue() == value)
		{
			head.setNext(null);
		}
		while(head != null){
			ListNode temp = head.getNext();
			if(temp.getValue() == value)
			{
				head.setNext(temp.getNext());
			}
			head = head.getNext();
		}
		
	}
	
	public void SortCompleteList(ListNode head)
	{
		ListNode sortHead = head;
		ListNode tempHead = head;
		ListNode secondSeqHead = head;

		// Start moving, and find the start of the second sequence
		do 
		{
			secondSeqHead = secondSeqHead.getNext();
		}while(secondSeqHead.getValue() < secondSeqHead.getNext().getValue());
		secondSeqHead = secondSeqHead.getNext();
		sortHead = secondSeqHead;
		//System.out.println("Value at the start of the second sequence: "+ secondSeqHead.getValue());
		// start moving from the beginning and comparing with 
		//while((null != secondSeqHead.getNext()))//&&(tempHead != secondSeqHead))
		while(tempHead != secondSeqHead)
		{
			if(tempHead.getValue() < secondSeqHead.getValue())
			{
				tempHead = tempHead.getNext();
			}
			else if(tempHead.getValue() == secondSeqHead.getValue())
			{
				ListNode newOne = new ListNode();
				newOne.setValue(secondSeqHead.getValue());
				ListNode temp2 = tempHead.getNext();
				tempHead.setNext(newOne);
				newOne.setNext(temp2);
			}
			else
			{
				ListNode tempTemp = tempHead.getNext();
				secondSeqHead = secondSeqHead.getNext();
				ListNode newTemp = new ListNode();
				newTemp.setValue(tempHead.getValue());
				tempHead.setValue(secondSeqHead.getValue());
				tempHead.setNext(tempTemp);
				
			}
		}
	}


	public void ReverseList(ListNode head)
	{
		
	}

}
