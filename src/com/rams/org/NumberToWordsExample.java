package com.rams.org;

public class NumberToWordsExample {
	private static final String[] digitWords = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine" };

	public static void main(String[] args) {

		int number = 12345; // onetwothreefourfive
		String result = covnertNumberToWord(number);
		System.out.println(result);
	}

	
	private static String covnertNumberToWord(int number) {
		String numberDigit = Integer.toString(number);
		StringBuilder response = new StringBuilder();
		for (char digit : numberDigit.toCharArray()) {
			int digitValue = digit - '0';
			response.append(digitWords[digitValue]);
		}
		return response.toString();
	}

}
