package com.chainsys.bestPractices.decoupled;

public class TestCar {

	public static void main(String[] args) {
		PetrolEngine pe = new PetrolEngine();
		SteelWheel[] sWheels = new SteelWheel[4];
		sWheels[0] = new SteelWheel();
		sWheels[0] .location = "front left";
		sWheels[1] = new SteelWheel();
		sWheels[1] .location = "front right";
		sWheels[2] = new SteelWheel();
		sWheels[2] .location = "back left";
		sWheels[3] = new SteelWheel();
		sWheels[3] .location = "back right";
		Car car = new Car(pe,sWheels);
		car.StarCar();
		SteelWheel[] carWheels = (SteelWheel[])car.getWheels();
		int length = carWheels.length;
		for(int i=0;i<length;i++)
		{
			System.out.println(carWheels[i].location);
		}
		DieselEngine de = new DieselEngine();
		WoodenWheel[] wWheels = new WoodenWheel[4];
		wWheels[0] = new WoodenWheel();
		wWheels[0] .location = "front left";
		wWheels[1] = new WoodenWheel();
		wWheels[1] .location = "front right";
		wWheels[2] = new WoodenWheel();
		wWheels[2] .location = "back left";
		wWheels[3] = new WoodenWheel();
		wWheels[3] .location = "back right";
		Car secondCar = new Car(de,wWheels);
		secondCar.StarCar();
		
		WaterEngine we = new WaterEngine();
		Car thirdCar = new Car(we,wWheels);
		thirdCar.StarCar();
	}
}
