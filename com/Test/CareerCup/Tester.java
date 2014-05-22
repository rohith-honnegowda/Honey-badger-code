package com.Test.CareerCup;




public class Tester {

	public static ListNode head = new ListNode();
	public static void main(String[] args) throws Exception {
//		LoadList();
//		LinkedListQuestions qs = new LinkedListQuestions();
//		qs.SortCompleteList(head);
//		qs.DisplayList(head);
//		int[] arr = {11,65,12,45,23};
		int[] arr = {34,12,23,45,56,18,65,90,5};
		ArrayDemo demo = new ArrayDemo();
//		demo.CountMaxCharacters("aaaaaaaabbbbbbbcccefghlmnopqrtuvwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwxyz");
//		demo.CountMaxCharacters("aa");
//		demo.CountMaxCharacters("g");
//		demo.CountMaxCharacters("aaaaaaaabbbbbbbcccefghlmnopqrtuvwwwwwwwww");
//		demo.CountMaxCharacters("");
//		demo.CountMaxCharacters(null);
//		demo.PrintArrrangedArray(arr, 4);
		//demo.partition(arr, 0, arr.length - 1);
		//demo.quickSort(arr, 0, arr.length - 1);
		
		StringQuestions qs = new StringQuestions();
		qs.ConvertStringToInt("12345");
		qs.ConvertStringToInt("-00987");
		
	}

	public static void LoadList(){
		head.setValue(1);
		ListNode tempHead = head;
		int first = 1;
		int second = 1;
		for(int i = 0; i < 20; i++)
		{
			int temp = first + second;
			first = second;
			second = temp;
//			ListNode newOne = new ListNode();
//			newOne.setValue(temp);
//			tempHead.setNext(newOne);
//			tempHead = newOne;
			LinkedListQuestions.AddNodeToList(temp, head);
		}
		
//		for(int i = 20; i < 200; i = i+23)
//		{
////			ListNode newOne = new ListNode();
////			newOne.setValue(i);
////			tempHead.setNext(newOne);
////			tempHead = newOne;
//			LinkedListQuestions.AddNodeToList(i, head);
//		}
	}
	
	
}
