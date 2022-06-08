package com.chainsys.bestPractices.clone;

public class Student // implements Cloneable
{
	public String name;
	public int age;
	// @Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
