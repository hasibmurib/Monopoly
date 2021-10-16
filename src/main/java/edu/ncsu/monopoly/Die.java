package edu.ncsu.monopoly;

public class Die {
	private static final int SEIS = 6;

	public int getRoll() {
		return (int)(Math.random() * Die.SEIS) + 1;
	}
}
