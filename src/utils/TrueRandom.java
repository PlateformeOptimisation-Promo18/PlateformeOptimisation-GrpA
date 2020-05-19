package utils;

import java.util.Random;

import model.generic.InterfaceRandom;

public class TrueRandom implements InterfaceRandom{
	
	private static Random generator = new Random(); 

	@Override
	public int nextInt(int i) {
		return generator.nextInt(i);
	}
	
	

}
