package amma;

import java.util.Scanner;

public class Test11 {

	public static void main(String[] args) {
		


			//declare 5 numbers static array
			int x[]=new int[5];

			//store 5 number into array
			Scanner sc=new Scanner(System.in);
			for(int i=0;i<5;i++)
			{
				System.out .println("Enter a number");
				x[i]=sc.nextInt();
			}
			//sorting
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<4;j++)
				{
					if(x[j]>x[j+1])
					{
						int temp=x[j];
						x[j]=x[j+1];
						x[j+1]=temp;
					}
				}
			}
			//Display array number after sorting
			for (int i=0;i<5;i++)
			{
				System.out.print(x[i]+" ");
				
			}
		

	}

}
