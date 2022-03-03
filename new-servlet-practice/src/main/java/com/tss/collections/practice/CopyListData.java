package com.tss.collections.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CopyListData {

	public static void main(String[] args) {
		List<Integer> source = Arrays.asList(1, 2, 3);
		List<Integer> dest = Arrays.asList(4, 5, 6);
		Collections.copy(dest, source);
		System.out.println(dest);
		System.out.println(source);
	}
}