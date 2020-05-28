package test.model.algorithms.tabou;

import model.generic.InterfaceRandom;

public class MockRandom implements InterfaceRandom {

	static int iNbCall = -1;
	static int[] iListInt = { 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 1, 3, 1 };

	@Override
	public int nextInt(int i) {
		iNbCall++;
		return iListInt[iNbCall % iListInt.length];
	}

}
