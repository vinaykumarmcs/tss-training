package com.tss.collections.practice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GetMapKeys {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("db", "oracle");
		map.put("username", "user1");
		map.put("password", "pass1");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String k = entry.getKey();
			String v = entry.getValue();
			System.out.println("Key: " + k + ", Value: " + v);
		}
		Set<String> keys = map.keySet();
		for (String k : keys) {
			System.out.println("Key: " + k);
		}
		Collection<String> values = map.values();
		for (String v : values) {
			System.out.println("Value: " + v);
		}
	}
}