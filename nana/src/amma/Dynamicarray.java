package amma;

import java.util.ArrayList;
import java.util.Scanner;

public class Dynamicarray 
{
	public static void main(String[] args) 
	{
		ArrayList<String> x=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size");
		int n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
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
			x.add(sc.nextLine());
		}
		//sorting
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(x.get(j).compareTo(x.get(j+1))>0)
				{
					String temp=x.get(j);
					x.set(j, x.get(j+1));
					x.set(j+1, temp);
				}
			}
		}
		//Display array string after sorting
		for(int i=0;i<n;i++)
		{
			System.out.println(x.get(i)+" ");
		}
	}

}
