package amma;

public class Test13 {

	public static void main(String[] args) 
	{
		Abstract obj=new Mysubconcrete();
		int z=obj.divide(13, 13);
		System.out.println(z);
		Mysubconcrete obj1=new Mysubconcrete();
		int a=obj1.multiply(23, 34, 4);
		System.out.println(a);
	}

}
