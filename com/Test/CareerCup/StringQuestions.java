package com.Test.CareerCup;

import java.util.ArrayList;

public class StringQuestions {

	public void ConvertStringToInt(String intStr) throws Exception{
		int length = intStr.length();
		int convertedString = 0;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int highestMultiplier = (int) Math.pow(10, length - 1);
		boolean negative = intStr.charAt(0) == 45;
		if(negative){
			intStr = intStr.substring(1);
			highestMultiplier  = ((int) Math.pow(10, intStr.length()- 1));
		}
		for(int i = 0; i < intStr.length(); i++){
			char test = intStr.charAt(i);
			if((!((test >= 48) && (test <= 57)))||intStr.isEmpty()){
				throw new Exception("String contains invalid characters");
			}else{
				numbers.add(new Integer(test - 48));
			}
		}
		for(int i: numbers){
			convertedString = convertedString + (i * highestMultiplier);
			highestMultiplier /= 10;
		}
		if(!negative)
			System.out.println("The string "+intStr+", was converted to the int:"+ convertedString);
		else
			System.out.println("The string "+intStr+", was converted to the int:"+ (convertedString*-1));

		
	}
	
}
