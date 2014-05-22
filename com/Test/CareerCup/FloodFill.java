package com.Test.CareerCup;

public class FloodFill {

	public char[][] arr  = {
			{'P','P','P','P','P'},
			{'O','P','O','P','O'},
			{'O','O','P','P','O'},
			{'P','P','P','O','O'},
			{'P','O','O','O','O'},
			};

	
	public void displayArray(char[][] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("\n\n\n\n");
	}
	
	public void floodFill(char[][] arr, int i, int j){
		
	}
}

