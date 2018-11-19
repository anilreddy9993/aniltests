package amma;

public class Test12 {

	public static void main(String[] args) 
	{
	Myinterface obj=new Concreteclass();	
            int l=obj.add(34, 67);
            System.out.println(l);
            // using static in that interface we can write the body
            Myinterface.divide(40, 8);
	}

}
