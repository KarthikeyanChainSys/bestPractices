package com.chainsys.bestPractices.coupled;
// Objects of this class can work only with petrol engine and steel wheel
// The car class is tightly coupled with PetrolEngine class and SteelWheel class
public class Car {
	private PetrolEngine engine;
	private SteelWheel[] wheels;

	public Car() {
		engine = new PetrolEngine();
		wheels = new SteelWheel[4];
		wheels[0] = new SteelWheel();
		wheels[0].location = "front left";
		wheels[1] = new SteelWheel();
		wheels[1].location = "front right";
		wheels[2] = new SteelWheel();
		wheels[2].location = "back left";
		wheels[3] = new SteelWheel();
		wheels[3].location = "back right";
	}
	public Car(PetrolEngine engine, SteelWheel[] wheel) {
		this.engine = engine;
		this.wheels = wheel;
		wheels[0].location = "front left";
		wheels[1].location = "front right";
		wheels[2].location = "back left";
		wheels[3].location = "back right";
	}
	public void StarCar() {
		engine.start();
		wheels[0].rotate();
		wheels[1].rotate();
		wheels[2].rotate();
		wheels[3].rotate();	
	}
	public SteelWheel[] getWheels() {
		return this.wheels;
	}
}
