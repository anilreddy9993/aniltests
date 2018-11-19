package amma;
public class Sample3
{
	// Data Members
	public int input1;
	public int input2;
	
	//Constructor Method
	
	public Sample3(int temp1,int temp2)
	{
		input1=temp1;
		input2=temp2;
		int z=input1+input2;
		System.out.println(z);
	}
	
	//operational Methods
	public void add1()   //while using void no need to use retun() type
	{
		int output=input1+input2;
		System.out.println(output);
	}
	public int add2()
	{
		int output=input1+input2;
		return(output);
	}

}
