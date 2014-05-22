package com.Test.CareerCup;

public class ArrayDemo {
	
	public void CountMaxCharacters(String str){
		if( null == str || str.length() == 0){
			System.out.println("Gimme a better string this one sucks.");
			return;
		}
		int MaxCount = 0, tempCount = 0;
		char MaxOccurring = str.charAt(0), temp = str.charAt(0);
		tempCount++;
	
		for(int i = 1; i < str.length(); i++){
			if(temp == str.charAt(i)){
				tempCount++;
				if(MaxCount < tempCount){
					MaxCount = tempCount;
					MaxOccurring = str.charAt(i);
				}
			}else{
				temp = str.charAt(i);
				tempCount = 1;
			}
		}
		System.out.println("The max occurring character is: "+ MaxOccurring + "\n The number of time it occurs is: "+ MaxCount);
	}

/*
 * Given and array and Index i in the array, group the elements such that elements at index positions less than
 * i are lesser than the element at position i and next they are equal to and then the last group has elements greater than 
 * the element at i
 * */
	
	public void PrintArrrangedArray(int[] arr, int i){

		if(i < 0){
			return;
		}
		int pivot = arr[3];
		int smaller = 0, equal = 0, larger = arr.length - 1;
		
		while(equal <= larger){
			if(arr[smaller] < pivot){
				//swap(arr, smaller++, equal++);
				int temp = arr[smaller];
				arr[equal] = arr[smaller];
				arr[smaller] = temp;
				smaller++;
				equal++;
			}
			else if(arr[smaller]==pivot){
				++equal;
			}
			else{
				//swap(arr, equal, larger--);
				int temp = arr[equal];
				arr[larger] = arr[equal];
				arr[equal] = temp;
				larger--;
			}
			for(int i1 = 0; i1 < arr.length; i1++){
				System.out.print(arr[i1] + ",");
			}
			System.out.println();
		}
	}
	
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	//		int[] arr = {123,12,134,14,145,16,56,17,68};
	public int partition(int[] arr, int startIndex, int endIndex){

		int pivot = arr[(startIndex + endIndex)/2];
		System.out.println("Pivot: " + pivot);
		while(startIndex <= endIndex){
			while(arr[startIndex] < pivot){
				startIndex++;
			}
			while(arr[endIndex] > pivot){
				endIndex--;
			}
			if(startIndex <= endIndex){
				swap(arr, startIndex, endIndex);
				startIndex++;
				endIndex--;
			}
		}
		return startIndex;
	}
	
	public void quickSort(int[] arr, int startIndex, int endIndex){

		int index = partition(arr, startIndex, endIndex);
		if(startIndex < index -1){
			quickSort(arr, startIndex, index -1);
		}
		if(index < endIndex){
			quickSort(arr, index, endIndex);
		}
		for(int i1 = 0; i1 < arr.length; i1++){
			System.out.print(arr[i1] + ",");
		}
		System.out.println();
	}

	
}
