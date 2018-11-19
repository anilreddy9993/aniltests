package amma;

public class Test9 {

	public static void main(String[] args) 
	{
		// length of the string
		String x="my name is";
		int y=x.length();
		System.out.println(y);
		
		// strings are equal or not
		String x1="hello how do u do";
		
		String y1="hello how do u do";
		if(x1.equals(y1))
		{
			System.out.println("given strings are same");
		}
		else
		{
			System.out.println("given strings are not equal");
		}
		
		// Character at
		char y2=x1.charAt(10);
		System.out.println(y2);

	}

}
