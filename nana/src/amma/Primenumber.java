package amma;

import java.util.Scanner;

public class Primenumber 
{
	public static void main(String[] args) 
	{
     Scanner sc=new Scanner(System.in);
     System.out.println("enter a number");
     int x=sc.nextInt();
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
    	 System.out.println(x+ " is not prime number");
     }


	}

}
