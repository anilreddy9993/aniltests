package test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Runnertest1 {

	public static void main(String[] args) throws Exception 
	{
		// connect excel sheet
				File f=new File("E:\\project\\excel sheets\\sent.xls");
				//open excel sheet for reading
				Workbook rwb=Workbook.getWorkbook(f);
				//0 is for sheet1
				Sheet rsh1=rwb.getSheet(0);
				//get count of rows in sheet1
				int nour1=rsh1.getRows();
				//get count of columns in sheet1
				int nouc1=rsh1.getColumns();
				//1 is for sheet2
				Sheet rsh2=rwb.getSheet(1);
				//get count of rows in sheet 2
				int nour2=rsh2.getRows();
				//get count of columns in sheet 2
				int nouc2=rsh2.getColumns();
				
				//open excel sheet for writing
				WritableWorkbook wwb=Workbook.createWorkbook(f, rwb);
				// write able sheet1
				WritableSheet wsh1=wwb.getSheet(0);
				//write able sheet2
				WritableSheet wsh2=wwb.getSheet(1);
				
				// format that to be written
				WritableCellFormat cf=new WritableCellFormat();
				cf.getBackgroundColour();
				cf.setAlignment(Alignment.JUSTIFY);
				cf.setWrap(true);
				
				//set column name for results
				Date dt=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
				String cname=sdf.format(dt);
				
				//label is useful to send results in the excel sheet1
				Label l1=new Label(nouc1,0,cname,cf);
				wsh1.addCell(l1);
				
				//label is useful to send results in the excel sheet3
				Label l2=new Label(nouc2,0,cname,cf);
				wsh2.addCell(l2);
				
				//create object to the methods class
				Gmailloginmethods mco1=new Gmailloginmethods();
				
				//collect all the methods from methods class
				Method m[]=mco1.getClass().getMethods();
				System.out.println("hello");
				
				// keyword driven
				try
				{
					//calling methods one after other
					//1st row index is zero have names of the columns
					for(int i=1;i<nour1;i++)
					{
						int flag=0;
						//get tid and mode from sheet1
						String tid=rsh1.getCell(0,i).getContents();
						//get the mode yes or no 
						String mode=rsh1.getCell(2, i).getContents();
						if(mode.equalsIgnoreCase("Yes"))
						{
							//1st row(index 0)have names of columns in sheet2
							for(int j=1;j<nour2;j++)//rows in sheet2
							{
								String sid=rsh2.getCell(0, j).getContents();
								if(tid.equals(sid))
								{
									//take step details from sheet3
									String mn=rsh2.getCell(2,j).getContents();
									String e=rsh2.getCell(3, j).getContents();
									String d=rsh2.getCell(4, j).getContents();
									String c=rsh2.getCell(5, j).getContents();
									System.out.println(mn+" "+e+" "+d+" "+c);
									for(int k=0;k<m.length;k++)
									{
										if(m[k].getName().equals(mn))
										{
											//to reuse the methods in class
											String r=(String) m[k].invoke(mco1, e,d,c);
											Label lb=new Label(nouc2,j,r,cf);
											//step results
											wsh2.addCell(lb);
											if(r.equalsIgnoreCase("unkown browser"))
											{
												wwb.write();
												wwb.close();
												rwb.close();
												//stop run and exit
												System.exit(0);
												System.out.println("hello");
											}
											if(r.contains("failed")||r.contains("interrupted"))
											{
											   flag=1;
											}
											
										}
									}//k closing
									
								}
							}//j closing
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
				}
					
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
				wwb.write();
				wwb.close();
				rwb.close();
				mco1.close();
		

	}

}
