package utils;

import java.util.Random;

import model.generic.InterfaceRandom;

/**
 * classe wrapper pour le random, remplacera la classe mock des tests en
 * environement de production
 * 
 * @author p.pitiot
 *
 */
public class TrueRandom implements InterfaceRandom {

	private static Random generator = new Random();

	@Override
	public int nextInt(int i) {
		return generator.nextInt(i);
	}

	@Override
	public double nextDouble() {
		return generator.nextDouble();
	}

}
