package com;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		// 1st Way
		Stream<Integer> stream = Stream.of(12, 1, 2, 4, 5, 89, 10, 23);
		stream.forEach(n -> System.out.println(n));

		// 2nd Way
		Stream<String> stream1 = Stream.of(new String[] { "A", "P", "C", "D" });
		stream1.forEach(n -> System.out.println(n));

		// 3rd Way
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(6);
		l1.add(3);
		l1.add(7);
		l1.add(10);
		l1.add(11);
		l1.add(14);
		l1.add(9);
		l1.add(12);
		l1.add(2);
		l1.add(4);
		l1.add(10);

		Stream<Integer> si = l1.stream();
		si.forEach(n -> System.out.println(n));

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");

		Stream<Entry<Integer, String>> m = map.entrySet().stream();
		System.out.println(Arrays.toString(m.toArray()));

		// find list of Even Number using java 8
		List<Integer> l2 = l1.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(l2);

		// find list of square Even Number using java 8
		List<Integer> l3 = l1.stream().filter(x -> x % 2 == 0).map(x -> x * x).collect(Collectors.toList());
		System.out.println(l3);

		// Remove Duplicate Integer From list by using java 8
		List<Integer> l4 = l1.stream().distinct().collect(Collectors.toList());
		System.out.println(l4);

		// Remove Duplicate Integer From list also sort ascending order by using java 8
		List<Integer> l5 = l1.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(l5);

		// Remove Duplicate Integer From list also sort descending order by using java 8
		List<Integer> l6 = l1.stream().sorted(Collections.reverseOrder()).distinct().collect(Collectors.toList());
		System.out.println(l6);

		OptionalInt op = l1.stream().mapToInt(Integer::intValue).min();
		System.out.println(op.getAsInt());

		Optional<Integer> i = l1.stream().max(Comparator.naturalOrder());
		System.out.println(i.get());
	}

}
