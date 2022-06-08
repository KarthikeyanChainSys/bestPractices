package com.chainsys.bestPractices.defaultmethod;

public class TestVehicle {

	public static void main(String[] args) {
		Car firstCar = new Car();
		firstCar.start();
		firstCar.move();
		
		Bike firstBike = new Bike();
		firstBike.start();
		firstBike.move();
	}

}
