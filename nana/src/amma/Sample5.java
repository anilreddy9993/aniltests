package amma;

public class Sample5 
{
	public int x;
	//constructer method
	private Sample5()
	{
		x=10;
	}
	// operational method
	public static Sample5 create()
	{
		Sample5 obj=new Sample5();
		return(obj);
	}
	public void display()
	{
		System.out.println(x);
	}

}
