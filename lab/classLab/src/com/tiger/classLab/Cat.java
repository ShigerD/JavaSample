package com.tiger.classLab;

public class Cat {
	
	public Cat()
	{
		System.out.println("Cat's building way");
		//speakMiao();
	}
	public  void speak()
	{
		System.out.println(" cat speak Miao");
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	private String color;
}
