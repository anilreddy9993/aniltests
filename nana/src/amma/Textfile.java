package amma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Textfile 
{
	public static void main(String[] args) throws IOException 
	{
     File f1=new File("E:\\sample.txt");
     FileReader fr=new FileReader(f1);
     BufferedReader br=new BufferedReader(fr);
     
     //open another file to write
     
     File f2=new File("E:\\sample2.txt");
     FileWriter fw=new FileWriter(f2);
     BufferedWriter bw=new BufferedWriter(fw);
     
     //Data driven
     int nol=0;
     int now=0;
     int non=0;
     String l;
	while((l=br.readLine())!=null)
     {
    	 nol=nol+1;
    	 String[] p=l.split(" ");
    	 now =now+p.length;
    	 Pattern m=Pattern.compile("[a-z]+ [0-9]+");
    	 Matcher mm=m.matcher(l);
    	 while(mm.find())
    	 {
    		 non=non+1;
    	 }
     }
	//send output file
	bw.write("no. of lines is"+nol);
	bw.newLine();
	bw.write("no. of words is"+now);
	bw.newLine();
	bw.write("no. of numeric values is"+non);
	//close file
	br.close();
	fr.close();
	bw.close();
	fw.close();
    		 

	}

}
