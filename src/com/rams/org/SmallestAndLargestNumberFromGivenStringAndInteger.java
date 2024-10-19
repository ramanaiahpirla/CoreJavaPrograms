package com.rams.org;
//123456789 find the largest number 
public class SmallestAndLargestNumberFromGivenStringAndInteger {
	
	public static void main(String[] args) {
		String givenNumberString = "0123456789";
		
		// Find the largest Number
		int largestNumer = givenNumberString.chars().max().getAsInt();
		System.out.println("Maximum Digit from the given String : " + Character.getNumericValue((char) largestNumer));
		
		// Find the smallest Number
		
		int smallestNumber = givenNumberString.chars().min().getAsInt();
		System.out.println("Minimum Digit from the given String : " + Character.getNumericValue((char) smallestNumber));
		
		// If the given String is integer, then find the largest and smallest number in it.
		
		Integer number = 123456789;
		int maxDigit = String.valueOf(number).chars().max().getAsInt();
		System.out.println("Maximum Digit from the given Integer Number : " + Character.getNumericValue(maxDigit));
		
		int maximumDigit = String.valueOf(number).chars().map(Character::getNumericValue).max().getAsInt();
		System.out.println("Maximum Digit from the given Integer Number in another approach : " + maximumDigit);
		
		int minDigit = String.valueOf(number).chars().min().getAsInt();
		System.out.println("Minimum Digit from the given Integer Number : " + Character.getNumericValue(minDigit));
		
		int minimumDigit = String.valueOf(number).chars().map(Character::getNumericValue).min().getAsInt();
		System.out.println("Minimum Digit from the given Integer Number in another approach : " + minimumDigit);
		
		
	}

}
