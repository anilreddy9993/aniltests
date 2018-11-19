package amma;

import java.util.Scanner;

public class Strstatarray 
{
	public static void main(String[] args) 
	{
		// fixed array
		String[] x=new String[5];
		
		//take input from key board
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<5;i++)
		{
			switch(i+1)
			{
			case 1:
				System.out.println("enter 1st word");
				break;
			case 2:
				System.out.println("enter 2nd word");
				break;
			case 3:
				System.out.println("enter 3rd word");
				break;
			default:
				System.out.println("enter"+(i+1)+"th word");
				break;
			}
			x[i]=sc.nextLine();
		}
		// sorting
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(x[j].compareTo(x[j+1])>0)
				{
					String temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
				}
			}
		}
		for(int i=0;i<5;i++)
		{
			System.out.print(x[i]+" ");
		}
	}

}
