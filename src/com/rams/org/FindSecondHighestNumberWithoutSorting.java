package com.rams.org;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

public class FindSecondHighestNumberWithoutSorting {
	public static void main(String[] args) {
		int[] numbers = { 3, 9, 5, 7, 6, 1, 4, 6, 8 };

		OptionalInt highest = Arrays.stream(numbers).max();
		OptionalInt secondHighest = Arrays.stream(numbers).filter(n -> n != highest.orElse(Integer.MIN_VALUE)).max();
		if (secondHighest.isPresent()) {
			System.out.println("Second Highest : " + secondHighest.getAsInt());
		}

		// Using Java8
		Integer[] nums = { 200, 87, 55, 66, 99, 1, 5, 8, 666 };
		Integer secondHighestValue = Arrays.stream(nums).sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.orElse(0);
		System.out.println(secondHighestValue);

	}

}
