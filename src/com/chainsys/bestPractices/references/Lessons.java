package com.chainsys.bestPractices.references;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Lessons {
	public static void testA() {
		List<Phone> phoneList = new ArrayList<Phone>();
//		Phone::print; // direct call to static method not worked
		phoneList.add(new Phone());
		phoneList.add(new Phone());
		phoneList.add(new Phone());
		phoneList.add(new Phone());
		phoneList.add(new Phone());
		phoneList.forEach(System.out::println);
	}

	public static void testB() {
		List<Long> phoneNumber = new ArrayList<Long>();
		phoneNumber.add(9465836472L);
		phoneNumber.add(9423145572L);
		phoneNumber.add(9937484472L);
		phoneNumber.add(9469274672L);
		phoneNumber.add(9027478282L);
//		phoneNumber.forEach(Phone::makeCall); // Static method using class to call static method
		Phone iPhone = new Phone();
		phoneNumber.forEach(iPhone::makeCall); // Non-Static method using object reference to call instance method
	}

// Constructor Reference:
	public static void testC() {
		PhoneEmpty mobileA = Phone::new;
		/* Notes (::new)
		 * Call to the constructor
		 * Employee::new (hold reference value)
		 * But here lazy invocation is used
		 * the object is created only when get() is called Every time get() is called a new object is created
		 */
//		constructor reference
		Phone firstPhone = mobileA.get();
		firstPhone.makeCall(8798769087L);
		PhoneWithNumberModel mobileB = Phone::new;
//		parameterized constructor
		Phone secondPhone = mobileB.get(9863938383L, "Honor 8x"); // factory method
		secondPhone.makeCall(secondPhone.getNumber());
		System.out.println(secondPhone.toString());
	}
	
	public static void testD() {
		Map<Long,String> phoneMap = new HashMap<Long,String>();
		phoneMap.put(9465836472L, "Honor 8x");
		phoneMap.put(9423145572L, "Realmi");
		phoneMap.put(9937484472L, "Redmi");
		phoneMap.put(9469274672L, "Oppo");
		phoneMap.put(9027478282L, "nokia");
		/*
		 * map does not have stream because it is not a collection
		 * phoneMap.stream()
		 * so to create stream for Map it should convert to Set<Map.Entry<K,V>>
		 * -K,V are templates. They can be of the same data type, or different data type
		 * template - placeholder for any data type
		 * Set<Map.Entry<Long,String>> entries = phoneMap.entrySet();
		 * Stream<Map.Entry<Long,String>> entryStreams = entries.stream();
		 */
//Get Key
		Set<Long> longSet = phoneMap.keySet();
		Stream<Long> numberStream = longSet.stream();
//		Map has to be convert to a set and stream method 
		Phone[] phoneArray = numberStream.map(Phone::new) // constructor reference of phone
				.toArray(Phone[]::new);  // constructor reference of array
//Get Values
//		Stream<String> stringStream = phoneMap.values().stream();
//		Phone[] phoneArray = stringStream.map(Phone::new).toArray(Phone[]::new);
		
//		int count = phoneArray.length;
//		for(int i=0; i<count; i++) {
//			System.out.println(phoneArray[i]);
//		}
//		Stream<Phone> phoneA = phoneArray.stream(); We can't directly use stream() method on an array. Because array is not a collection type
//		creating a stream from arrays
		Stream<Phone> phoneStream = Arrays.stream(phoneArray);
		phoneStream.forEach(System.out::println);
	}
}

// Functional interface for non-parameterized constructor
interface PhoneEmpty {
	Phone get();
}

//Functional interface for parameterized constructor
interface PhoneWithNumberModel {
	Phone get(long number, String model);
}

class Phone {
	private long number;
	private String model;

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Phone() {
		System.out.println("Default Constructor");
	}
	
	public Phone(Long number) {
		System.out.println("Single Parameterized Constructor");
		this.number = number;
		this.model = "not assigned";
	}
	
//	public Phone(String model) {
//		System.out.println("Single Parameterized Constructor");
//		this.model =model;
//	}

	public Phone(long number, String model) {
		System.out.println("Parameterized Constructor");
		this.number = number;
		this.model = model;
	}

	public void makeCall(long number) {
		System.out.println("Call made to : " + number);
	}

	public static void print(long number) {
		System.out.println("Print Document : " + number);
	}

	@Override
	public String toString() {
		return this.number + " " + this.model;
	}
}