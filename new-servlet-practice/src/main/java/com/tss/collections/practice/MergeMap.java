package com.tss.collections.practice;

import java.util.HashMap;

public class MergeMap {
	public static void main(String[] args) {
		HashMap<Integer, String> map1 = new HashMap<>();
		map1.put(11, "A");
		map1.put(12, "B");
		map1.put(13, "C");
		map1.put(15, "E");
		HashMap<Integer, String> map2 = new HashMap<>();
		map2.put(1, "G");
		map2.put(2, "B");
		map2.put(3, "C");
		map2.put(4, "D");
		map1.putAll(map2);
		System.out.println(map1);
	}
}