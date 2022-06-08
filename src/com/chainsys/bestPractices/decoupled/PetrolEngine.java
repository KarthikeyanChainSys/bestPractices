package com.chainsys.bestPractices.decoupled;

public class PetrolEngine implements Iengine {
	public void start() {
		System.out.println("Petrol engine started");
	}
	public void stop() {
		System.out.println("Petrol engine stopped");
	}
}
