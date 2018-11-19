package amma;
public interface Myinterface 
{
	public int add(int x,int y);
	public int substract(int x,int y);
	public int multiply(int x,int y);
	public static int divide(int x,int y) 
	{
		int z=x/y;
		System.out.println(z);
		return z;
	}

}
