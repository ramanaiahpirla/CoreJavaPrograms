package com.rams.org;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfEachCharInGivenString {
	public static void main(String[] args) {
		
		String line = "Ram is employee of ABC company, ram is from Blore, RAM! is good in algorithms.";
		Map<Character, Long> eachCharFrequency =  line.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("Frequency of each char : " + eachCharFrequency);
		
		
	}

}
