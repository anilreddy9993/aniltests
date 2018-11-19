package amma;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regularexp
{
	 public String x;
	
	
	public String reg(String args)
	{
		x=args;
		Pattern p=Pattern.compile("[a-z]+");
		Matcher m=p.matcher(x);
		while(m.find())
		{
			System.out.print(m.group());
		}
		return x;
		
	}
	

}