package com.chainsys.bestPractices.decoupled;

public class WaterEngine implements Iengine{

	@Override
	public void start() {
		System.out.println("Water engine started");
	}

	@Override
	public void stop() {
		System.out.println("Water engine stooped");
	}

}
