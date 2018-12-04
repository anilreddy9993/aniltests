package test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Gmailrunner 
{
	public static void main(String[] args) throws Exception, IOException 
  {
		
		//connect to excel sheet
	File f=	new File("E:\\project\\excel sheets\\sent.xls");
	
	    // open excel sheet for reading
	Workbook rwb=Workbook.getWorkbook(f);
	Sheet rsh1=rwb.getSheet(0);  //0 is for 1st sheet in excel
	
	// to get used columns and rows
	int nour1=rsh1.getRows();
	int nouc1=rsh1.getColumns();
    
	Sheet rsh2=rwb.getSheet(1); //1 is for 2nd sheet in excell
	
	// to get used columns and rows
	int nour2=rsh2.getRows();
	int nouc2=rsh2.getColumns();
	
	//open same excel file for writing
	WritableWorkbook wwb=Workbook.createWorkbook(f, rwb);
	WritableSheet wsh1=wwb.getSheet(0); //0 is for 1st sheet in excel
	WritableSheet wsh2=wwb.getSheet(1); //1 is for 2nd sheet in excel
	
	// to create  particular format in write able sheet
	WritableCellFormat cf=new WritableCellFormat();
	cf.getBackgroundColour().getDefaultRed();
	cf.setAlignment(Alignment.JUSTIFY);
	cf.setWrap(true);
	
	//set the name to results column in sheet2
	Date d1=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
	String cname=sdf.format(d1);
	
	//set name to results in column in sheet1
	Label l1=new Label(nouc1,0,cname,cf);
	                  //(no.of col in sheet 1,1st row,format of out put,style of output to print in cell) 
	wsh1.addCell(l1);
	
	//set name to results column in sheet2
	Label l2=new Label(nouc2,0,cname,cf);
	                  //col,row,name,format
	wsh2.addCell(l2);
	
	//create object to the methods
	Gmailloginmethods mco=new Gmailloginmethods();
	
	//collecting all the methods using methods class
	Method m[]=mco.getClass().getMethods();
	
	//keyword driven
	try 
	{
		//calling methods one after other
		//1st row(index 0)have names of the column in sheet1
		for (int i=1;i<nour1;i++)
		{
			int flag=0;
		
		//get test id and mode from sheet1
			String tid=rsh1.getCell(0, i).getContents();
			String mode=rsh1.getCell(2, i).getContents();
			if(mode.contentEquals("Yes"));
			{
				//1st row (index is 0)have names if column in sheet2
				for(int j=1;j<nour2;j++)
				{
					String sid=rsh2.getCell(0, j).getContents();
					if(tid.equalsIgnoreCase(sid))
					{
						//take step details from from sheet2
						String mn=rsh2.getCell(2,j).getContents();
						String e=rsh2.getCell(3, j).getContents();
						String d=rsh2.getCell(4, j).getContents();
						String c=rsh2.getCell(5, j).getContents();
						System.out.println(mn+" "+e+" "+d+" "+c);
						for(int k=0;k<m.length;k++)
						{
							// get the methods in a loop
							if(m[k].getName().equals(mn))
							{
								
								//adding results in the empty column
								String r=(String) m[k].invoke(mco,e,d,c);
								Label l3=new Label(nouc2,j,r,cf);
								
								//step result
								wsh2.addCell(l3);
								if(r.equalsIgnoreCase("unkown browser"))
								{
									// save the file and close
									wwb.write();
									wwb.close();
									rwb.close();
									
									// Forcibly close
									System.exit(0);
								}
								if(r.contains("failed")||r.contains("inturrepted"))
								{
									flag=1;
								}
							}
						}//for k closing
					}
				}//for j closing
				if(flag==0)
				{
					
					// to print the test passed or failed
					Label l=new Label(nouc1,i,"passed",cf);
					wsh1.addCell(l);
				}
				else
				{
					Label l=new Label(nouc1,i,"failed",cf);//
					wsh1.addCell(l);
				}
			} 
			
		}// for i closing
		
	}//try block closing
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}
	wwb.write();// to save excel sheet
	wwb.close();//to close excel sheet
	rwb.close();//to close read able sheet
	mco.close();
  }

}
