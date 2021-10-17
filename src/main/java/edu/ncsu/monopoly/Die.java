package edu.ncsu.monopoly;

import java.util.Random;

public class Die {
	private Random r = new Random();
	public int getRoll() 
	{
		var rand = r.nextInt();
		return (rand* 6) + 1;
	}
}