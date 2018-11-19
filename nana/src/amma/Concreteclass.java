package amma;

public class Concreteclass implements Myinterface
 {

	
	public int add(int x, int y) {
		int z=x+y;
		return z;
	}

	
	public int substract(int x, int y) {
          int z=x-y;
		return z;
	}

	
	public int multiply(int x, int y) {
		int z=x*y;
		return z;
	}

	
	public int divide(int x, int y) {
		int z=x/y;
		return z;
	}

}
