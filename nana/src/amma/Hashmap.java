package amma;

import java.util.HashMap;
import java.util.Map;

public class Hashmap 
{
	public static void main(String[] args)
	{
	

	
	//create HASHMAP
	HashMap<Integer,String> x=new HashMap<Integer,String>();
	// insert data as a pairs
	x.put(100, "hello");
	
	x.put(23, "hi");
	x.put(100, "dude");
	for(Map.Entry<Integer, String> e:x.entrySet())
	{
		System.out.println(e.getKey()+" "+e.getValue());
	}
	}

}
