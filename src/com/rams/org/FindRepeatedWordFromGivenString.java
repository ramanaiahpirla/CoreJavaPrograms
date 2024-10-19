package com.rams.org;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindRepeatedWordFromGivenString {
	public static void main(String[] args) {
		String str = "Opentext is a good company, Opentext is located at Hyderbad";

		// Task : to count how many times the Opentext has occured.

		List<String> listOfText = Arrays.asList(str.split("[^a-zA-Z0-9]+"));

		Map<String, Long> frequencyOfOpentext = listOfText.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getKey().equalsIgnoreCase("openText"))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(frequencyOfOpentext);

		// Task : Find the each word, how many times its repeated

		Map<String, Long> frequencyOfEachWord = listOfText.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(frequencyOfEachWord);
	}

}
