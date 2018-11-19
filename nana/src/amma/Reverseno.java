package amma;

public class Reverseno 
{
	long x;
	long y=0;
	public long reverseno(long temp)
	{
	x=temp;
	while(x>y)
	{
		long d=x%10;
        y=y*10+d;
        x=(long)x/10;
        
    }
	return y;

	}
	
}