package com.chainsys.bestPractices.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

// Stream is a sequence of elements computed on demand
// Stream supports sequential and parallel aggregation operations
// Stream is not a data structure
// Streams cannot be iterated directly
// Streams cannot be accessed using index value
// Stream represents single use sequence of data
// Stream should be operated on only once
public class StreamLessons {
	public static void demoA() {
		Stream s1 = Stream.empty();
		Stream<Integer> intstream = Stream.of(11, 12, 13, 14, 15);
//		long count = intstream.count(); // count number of count
//		System.out.println("Number of count is : " + count);

//		// Stream has already been operated upon or closed	

//		int value = intstream.findFirst().get();  // find first element
//		// findFirst() returns object of type Optional
//		// get() of Optional returns the first value
//		System.out.println("Value is : " + value);

//		System.out.println(intstream.toList()); // print the list
//		System.out.println(intstream[0]); // ERROR : it not work like as index value type 
	}

	public static void demoB() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		// List<Integer> list2 = Arrays.asList(10,20,30,40,50);
		Stream<Integer> intstream = list.stream();
		List<Integer> evenNumbers = intstream.filter(i -> i % 2 == 0).collect(Collectors.toList()); // collect() returns
																									// a collection
		System.out.println(evenNumbers);
	}

	public static void demoC() {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = integers.stream().reduce(0, (a, b) -> a + b);
		// Reduction of objects / elements - Returning a single value
		// by performing an operation on elements of a collection
		System.out.println(sum);
	}

	public static void demoD() {
		IntStream intstream = IntStream.of(1, 2, 3, 4, 5);
		System.out.println(intstream.sum());
//		System.out.println(intstream.count());
		LongStream longstream = LongStream.of(1, 2, 3, 4, 5);
		System.out.println(longstream.sum());
		DoubleStream doublestream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
		System.out.println(doublestream.sum());
	}

	public static void demoE() {
		Supplier<Stream<Integer>> intstream = () -> Stream.of(10, 2, 3, 4, 5);
		System.out.println("Count: " + intstream.get().count());
		System.out.println("First: " + intstream.get().findFirst().get());
		System.out.println("List: " + intstream.get().toList());
		// get() on the supplier creates a new stream every time
	}

	public static void demoF() {
		// Converting primitive type to object type stream = boxing
		Stream<Integer> intstream = IntStream.of(1, 2, 3, 4, 5).boxed();
		System.out.println(intstream.findFirst().get());
	}

	public static void demoG() {
		Stream<Integer> streamOne = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		streamOne.forEach(p -> System.out.println(p));
		Stream<Integer> streamTwo = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		streamTwo.forEach(p -> System.out.println(p));
	}

	public static void demoH() {
		Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));

		randomNumbers.limit(5).forEach(System.out::println);
	}

	public static void demoI() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Vijay");
		memberNames.add("Karthikeyan");
		memberNames.add("Arjun");
		memberNames.add("Rajini");
		memberNames.add("Ajith");
		memberNames.add("Suriya");
		memberNames.add("Anjali");
		memberNames.add("Kamal");
		memberNames.stream().filter((s) -> s.startsWith("A")).forEach(System.out::println);
		System.out.print("\n");
		// filter returns a stream - Intermediate operations
		memberNames.stream().filter((s) -> s.startsWith("K")).map(String::toUpperCase).forEach(System.out::println);
		System.out.print("\n");
		// The map() intermediate operation converts each element in the stream into
		// another object
		// via the given function.
		memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);
	}

	public static void demoJ() {
		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Vijay");
		memberNames.add("Karthikeyan");
		memberNames.add("Arjun");
		memberNames.add("Rajini");
		memberNames.add("Ajith");
		memberNames.add("Suriya");
		memberNames.add("Anjali");
		memberNames.add("Kamal");
		memberNames.add("Shiva");
		memberNames.add("Raguvaran");
		// Terminal Operations return a result of a certain type after processing all
		// the stream elements.
		List<String> memNamesInUppercase = memberNames.stream().sorted().map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.print(memNamesInUppercase);
		boolean matchedResult = memberNames.stream().anyMatch((s) -> s.startsWith("A"));
		System.out.print("\n");
		System.out.println(matchedResult); // true

		matchedResult = memberNames.stream().allMatch((s) -> s.startsWith("A"));

		System.out.println(matchedResult); // false

		matchedResult = memberNames.stream().noneMatch((s) -> s.startsWith("E"));

		System.out.println(matchedResult); // true
		long totalMatched = memberNames.stream().filter((s) -> s.startsWith("A")).count();

		System.out.println(totalMatched);
		Optional<String> reduced = memberNames.stream().reduce((s1, s2) -> s1 + "," + s2);

		reduced.ifPresent(System.out::println);
	}

	public static void demoK() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 250; i++) {
			list.add(i);
		}
		System.out.println(list.parallelStream().findFirst().get());
		System.out.println(list.parallelStream().findAny().get());
	}

	public static void demoL() {
		// distinct() - print unique value and remove duplicate value with the given
		// order
		List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);
//		List<Integer> list1 = Arrays.asList(1,1,2,2,3,3,4,3,1,2,6,4,5,5);
		System.out.println("The distinct elements are : ");
		list.stream().distinct().forEach(System.out::println);
	}

	public static void demoM() {
		// skip() - discards the first n elements of a stream
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(i -> i % 2 == 0).skip(2)
				.forEach(i -> System.out.print(i + " "));
	}

	public static void demoN() {
		// peek() is an intermediate operation and we didn't apply a terminal operation
		// to the pipeline.
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> newList = list.stream().peek(System.out::println) // Method Reference
				.collect(Collectors.toList());
//		System.out.println(newList);
	}

	public static void demoO() {
		Stream.of("one", "two", "three", "four")
			.peek(e -> System.out.println("value: " + e))
//		  	.peek(System.out::println) - line no. 191 and 192 same, its give same output (Method Reference)
				.collect(Collectors.toList());
	}

	public static void demoP() {
//		 Stream.of("one", "two", "three", "four").peek(e->e.toUpperCase())
//		 // peek() does not manipulate the element 
//		  .forEach(System.out::println);
		Stream.of("one", "two", "three", "four").map(e -> e.toUpperCase())
				// map() well manipulate the element
				.forEach(System.out::println);
	}

	// peek() can be useful in altering the inner state of an element
	// without replacing the element
	public static void demoQ() {
		Stream<Emp> empStream = Stream.of(new Emp(100, "Alice"), new Emp(101, "Bob"), new Emp(102, "Chuck"));
		empStream.peek(e -> e.setName(e.getName().toUpperCase())).forEach(System.out::println);
	}
}

class Emp {
	private int id;
	private String name;

	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
