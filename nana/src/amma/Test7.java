package amma;

public class Test7 
{
	int l;
	public int fabonoic(int temp)
	{
		l=temp;
		int x=0;
		int y=1;
		System.out.print(x+" "+y+" ");
		int z=x+y;
		while(z<=l)
		{
			System.out.print(z+" ");
			x=y;
			y=z;
			z=x+y;
			
		}
		return z;
	}

}
