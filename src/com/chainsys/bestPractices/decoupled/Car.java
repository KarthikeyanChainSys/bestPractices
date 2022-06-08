package com.chainsys.bestPractices.decoupled;
// Objects of this class can work with any engine, and with any wheel
// The car class is decoupled from PetrolEngine class, and SteelWheel class
public class Car {
	private Iengine engine; // early bound with engine interface
	private Iwheel[] wheels; // early bound with wheel interface
	// The type of engine, and the type of wheel will be injected to the car class
	// At runtime using the constructors. This is called as constructor based
	// dependency injection
	public Car(Iengine engine, Iwheel[] wheel) {
		this.engine = engine;
		this.wheels = wheel;
	}
	public void StarCar() {
		engine.start();
		wheels[0].rotate();
		wheels[1].rotate();
		wheels[2].rotate();
		wheels[3].rotate();	
	}
	public Iwheel[] getWheels() {
		return this.wheels;
	}
}
