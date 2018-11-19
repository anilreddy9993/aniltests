package amma;
public class Primemethod 
{
public int x;
public int prime(int temp)
{
	x=temp;
	int flag=0;
	for(int i=2;i<x;i++)
	{
		if(x%i==0)
		{
			flag=1;
		}
	}
		if(flag==0)
		{
			System.out.println(x+" is prime number");
		}
		else
		{
			System.out.println(x+" is not prime number");
		}
		return (x);

}
	

}
