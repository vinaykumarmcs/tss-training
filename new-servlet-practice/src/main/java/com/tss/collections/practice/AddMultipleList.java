package com.tss.collections.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddMultipleList {
	public static void main(String[] args) {
		List<Integer> hundreads = Arrays.asList(101, 102, 103);
		List<Integer> thousands = Arrays.asList(1001, 1002, 1003);
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		finalList.add(thousands);
		finalList.add(hundreads);
		System.out.println(finalList);
	}
}