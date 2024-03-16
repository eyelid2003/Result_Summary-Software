//package sheet;
import java.io.File; 
 
import java.io.FileInputStream;  
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Fifth  
{  
	Fifth(String filename,String pdfname,String sem)
	{
		
		int totaladd=0;
		int addggirl=0;
		int addgboy=0;
	 
		int addscgirl=0;
		int addscboy=0;
	 
		int addstgirl=0;
		int addstboy=0;
		
		int addobcgirl=0;
		int addobcboy=0;
	 
	 
		int passstu=0;
		int pass1aggirl=0;
		int pass1agboy=0;
		int pass1ascgirl=0;
		int pass1ascboy=0;
		int pass1astgirl=0;
		int pass1astboy=0;
		int pass1aobcgirl=0;
		int pass1aobcboy=0;
		
		int genboy1=0;
		int gengirl1=0;
	
		int scboy1=0;
		int scgirl1=0;
	
		int stboy1=0;
		int stgirl1=0;
		
		int obcboy1=0;
		int obcgirl1=0;
	 
		int genboy2=0;
		int gengirl2=0;
	
		int scboy2=0;
		int scgirl2=0;
	
		int stboy2=0;
		int stgirl2=0;
		
		int obcboy2=0;
		int obcgirl2=0;
	 
	 
		int genboy3=0;
		int gengirl3=0;
		
		int scboy3=0;
		int scgirl3=0;
	
		int stboy3=0;
		int stgirl3=0;
		
		int obcboy3=0;
		int obcgirl3=0;
		String strp="(\\d+\\.\\d+)";
		Pattern pattern;
		Matcher matcher;
		FileInputStream fis;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		try  
		{ 
		
			String roll="";
	        fis = new FileInputStream(filename);
	        workbook = new XSSFWorkbook(fis);
	        sheet = workbook.getSheetAt(0);
	        for(Row row:sheet)
	        {
	        	StringBuilder rowData = new StringBuilder();
				String word="";
	            for(Cell cell:row)
	            {
	            	rowData.append(cell.toString()).append("\t");
	            }
	            	word=rowData.toString();
	                String strpr="(\\d+\\w+\\d+)";
					pattern=Pattern.compile(strpr);
					matcher=pattern.matcher(word);
					
					if(matcher.find())
					{
						
						roll=matcher.group();
						totaladd=totaladd+1;
						PDDocument document = PDDocument.load(new File(pdfname));
						document.getClass();
						if (!document.isEncrypted())
						{
							PDFTextStripperByArea stripper = new PDFTextStripperByArea();
							stripper.setSortByPosition(true);
							PDFTextStripper Tstripper = new PDFTextStripper();
							String str = Tstripper.getText(document);
							Scanner scn = null;     
							scn = new Scanner(str);
							String line="";
							while (scn.hasNextLine()) 
							{  
								line = scn.nextLine();
				     
								if(line.contains(roll))
								{ 
									
									if(word.contains("FEMALE") && word.contains("GENERAL"))
									{
										addggirl=addggirl+1;
										if(line.contains(roll))
										{  
											int k=0;
									   
											while(k!=20)
											{
												if(line.contains("Total"))
												{
													String data=line.trim();
													
													int o=0;
													while(o!=5)
													{
														if(line.contains("PASS"))
														{
															System.out.print(roll +"--");
															
															pattern=Pattern.compile(strp);
															matcher=pattern.matcher(data);
															double sgpa=0;
															if(matcher.find())
															{
																sgpa=Double.parseDouble(matcher.group());
															}
															
															System.out.println(sgpa);
															passstu=passstu+1;
															if(sgpa>=7.5)
															{
																pass1aggirl=pass1aggirl+1;
																gengirl1=gengirl1+1;
															}
															if(sgpa>=6.5 && sgpa<7.5)
															{
																pass1aggirl=pass1aggirl+1;
																gengirl2=gengirl2+1;
															}
															if(sgpa>=5 && sgpa<6.5)
															{
																pass1aggirl=pass1aggirl+1;
																gengirl3=gengirl3+1;
															}
															break;
														}
														if(line.contains("FAIL"))
														{
															System.out.println(roll +"-- Fail");
															break;
														}
														line = scn.nextLine();
														o++;
													}
													
														
												break;
												
												}
												line = scn.nextLine();
												k++;
													
											}
										}
										
									}
									
									
									
									
									
									
									if(word.contains("FEMALE") && word.contains("SCHEDULE_CASTE"))
									{
										addscgirl=addscgirl+1;
										if(line.contains(roll))
										{  
											int k=0;
									   
											while(k!=20)
											{
												if(line.contains("Total"))
												{
													String data=line.trim();
													int o=0;
													while(o!=5)
													{
														if(line.contains("PASS"))
														{
															System.out.print(roll +"--");
															pattern=Pattern.compile(strp);
															matcher=pattern.matcher(data);
															double sgpa=0;
															if(matcher.find())
															{
																sgpa=Double.parseDouble(matcher.group());
															}
															System.out.println(sgpa);
															passstu=passstu+1;
															if(sgpa>=7.5)
															{
																pass1ascgirl=pass1ascgirl+1;
																scgirl1=scgirl1+1;
															}
															if(sgpa>=6.5 && sgpa<7.5)
															{
																pass1ascgirl=pass1ascgirl+1;
																scgirl2=scgirl2+1;
															}
															if(sgpa>=5 && sgpa<6.5)
															{
																pass1ascgirl=pass1ascgirl+1;
																scgirl3=scgirl3+1;
															}
															break;
														}
														if(line.contains("FAIL"))
														{
															System.out.println(roll +"-- Fail");
															break;
														}
														line = scn.nextLine();
														o++;
													}
													
														
												break;
												
												}
												line = scn.nextLine();
												k++;
													
											}
										}
										
									}
									
									
									
									if(word.contains("FEMALE") && word.contains("SCHEDULE_TRIVES"))
									{
										addstgirl=addstgirl+1;
										if(line.contains(roll))
										{  
											int k=0;
									   
											while(k!=20)
											{
												if(line.contains("Total"))
												{
													String data=line.trim();
													int o=0;
													while(o!=5)
													{
														if(line.contains("PASS"))
														{
															System.out.print(roll +"--");
															double sgpa=Double.parseDouble(data.substring(23,27));
															System.out.println(sgpa);
															passstu=passstu+1;
															if(sgpa>=7.5)
															{
																pass1astgirl=pass1astgirl+1;
																stgirl1=stgirl1+1;
															}
															if(sgpa>=6.5 && sgpa<7.5)
															{
																pass1astgirl=pass1astgirl+1;
																stgirl2=stgirl2+1;
															}
															if(sgpa>=5 && sgpa<6.5)
															{
																pass1astgirl=pass1astgirl+1;
																stgirl3=stgirl3+1;
															}
															break;
														}
														if(line.contains("FAIL"))
														{
															System.out.println(roll +"-- Fail");
															break;
														}
														line = scn.nextLine();
														o++;
													}
													
														
												break;
												
												}
												line = scn.nextLine();
												k++;
													
											}
										}
										
									}
									
									
									
									
									if(word.contains("FEMALE") && word.contains("OTHER_BACKWARD_CLASS"))
									{
										addobcgirl=addobcgirl+1;
										if(line.contains(roll))
										{  
											int k=0;
									   
											while(k!=20)
											{
												if(line.contains("Total"))
												{
													String data=line.trim();
													int o=0;
													while(o!=5)
													{
														if(line.contains("PASS"))
														{
															System.out.print(roll +"--");
															pattern=Pattern.compile(strp);
															matcher=pattern.matcher(data);
															double sgpa=0;
															if(matcher.find())
															{
																sgpa=Double.parseDouble(matcher.group());
															}
															System.out.println(sgpa);
															passstu=passstu+1;
															if(sgpa>=7.5)
															{
																pass1aobcgirl=pass1aobcgirl+1;
																obcgirl1=obcgirl1+1;
															}
															if(sgpa>=6.5 && sgpa<7.5)
															{
																pass1aobcgirl=pass1aobcgirl+1;
																obcgirl2=obcgirl2+1;
															}
															if(sgpa>=5 && sgpa<6.5)
															{
																pass1aobcgirl=pass1aobcgirl+1;
																obcgirl3=obcgirl3+1;
															}
															break;
														}
														if(line.contains("FAIL"))
														{
															System.out.println(roll +"-- Fail");
															break;
														}
														line = scn.nextLine();
														o++;
													}
													
														
												break;
												
												}
												line = scn.nextLine();
												k++;
													
											}
										}
										
									}
									
									
									if(word.contains("MALEMALE") && word.contains("GENERAL"))
									{
										addgboy=addgboy+1;
										if(line.contains(roll))
										{  
											int k=0;
										   
											while(k!=20)
											{
											   
												if(line.contains("Total"))
												{
													String data=line.trim();
													int o=0;
													while(o!=5)
													{
														if(line.contains("PASS"))
														{
															System.out.print(roll +"--");
															pattern=Pattern.compile(strp);
															matcher=pattern.matcher(data);
															double sgpa=0;
															if(matcher.find())
															{
																sgpa=Double.parseDouble(matcher.group());
															}
															System.out.println(sgpa);
															passstu=passstu+1;
															if(sgpa>=7.5)
															{
																pass1agboy=pass1agboy+1;
																genboy1=genboy1+1;
															}
															if(sgpa>=6.5 && sgpa<7.5)
															{
																pass1agboy=pass1agboy+1;
																genboy2=genboy2+1;
															}
															if(sgpa>=5 && sgpa<6.5)
															{
																pass1agboy=pass1agboy+1;
																genboy3=genboy3+1;
															}
															break;
														}
														if(line.contains("FAIL"))
														{
															System.out.println(roll +"-- Fail");
															break;
														}
														line = scn.nextLine();
														o++;
													}
													
														
												break;
												
												}
												line = scn.nextLine();
												k++;
													
											}
										}
										
									}
									
									
									
									if(word.contains("MALEMALE") && word.contains("SCHEDULE_CASTE"))
									{
										addscboy=addscboy+1;
										if(line.contains(roll))
										{  
											int k=0;
										   
											while(k!=20)
											{
											   
												if(line.contains("Total"))
												{
													String data=line.trim();
													int o=0;
													while(o!=5)
													{
														if(line.contains("PASS"))
														{
															System.out.print(roll +"--");
															pattern=Pattern.compile(strp);
															matcher=pattern.matcher(data);
															double sgpa=0;
															if(matcher.find())
															{
																sgpa=Double.parseDouble(matcher.group());
															}
															System.out.println(sgpa);
															passstu=passstu+1;
															if(sgpa>=7.5)
															{
																pass1ascboy=pass1ascboy+1;
																scboy1=scboy1+1;
															}
															if(sgpa>=6.5 && sgpa<7.5)
															{
																pass1ascboy=pass1ascboy+1;
																scboy2=scboy2+1;
															}
															if(sgpa>=5 && sgpa<6.5)
															{
																pass1ascboy=pass1ascboy+1;
																scboy3=scboy3+1;
															}
															break;
														}
														if(line.contains("FAIL"))
														{
															System.out.println(roll +"-- Fail");
															break;
														}
														line = scn.nextLine();
														o++;
													}
													
														
												break;
												
												}
												line = scn.nextLine();
												k++;
													
											}
										}
										
									}
									
									
									if(word.contains("MALEMALE") && word.contains("SCHEDULE_TRIVES"))
									{
										addstboy=addstboy+1;
										if(line.contains(roll))
										{  
											int k=0;
										   
											while(k!=20)
											{
												if(line.contains("Total"))
												{
													String data=line.trim();
													int o=0;
													while(o!=5)
													{
														if(line.contains("PASS"))
														{
															System.out.print(roll +"--");
															pattern=Pattern.compile(strp);
															matcher=pattern.matcher(data);
															double sgpa=0;
															if(matcher.find())
															{
																sgpa=Double.parseDouble(matcher.group());
															}
															System.out.println(sgpa);
															passstu=passstu+1;
															if(sgpa>=7.5)
															{
																pass1astboy=pass1astboy+1;
																stboy1=stboy1+1;
															}
															if(sgpa>=6.5 && sgpa<7.5)
															{
																pass1astboy=pass1astboy+1;
																stboy2=stboy2+1;
															}
															if(sgpa>=5 && sgpa<6.5)
															{
																pass1astboy=pass1astboy+1;
																stboy3=stboy3+1;
															}
															break;
														}
														if(line.contains("FAIL"))
														{
															System.out.println(roll +"-- Fail");
															break;
														}
														line = scn.nextLine();
														o++;
													}
													
														
												break;
												
												}
												line = scn.nextLine();
												k++;
													
											}
										}
										
									}
									
									if(word.contains("MALEMALE") && word.contains("OTHER_BACKWARD_CLASS"))
									{
										addobcboy=addobcboy+1;
										if(line.contains(roll))
										{  
											int k=0;
										   
											while(k!=20)
											{
											   
												if(line.contains("Total"))
												{
													String data=line.trim();
													int o=0;
													while(o!=5)
													{
														if(line.contains("PASS"))
														{
															System.out.print(roll +"--");
															pattern=Pattern.compile(strp);
															matcher=pattern.matcher(data);
															double sgpa=0;
															if(matcher.find())
															{
																sgpa=Double.parseDouble(matcher.group());
															}
															System.out.println(sgpa);
															passstu=passstu+1;
															if(sgpa>=7.5)
															{
																pass1aobcboy=pass1aobcboy+1;
																obcboy1=obcboy1+1;
															}
															if(sgpa>=6.5 && sgpa<7.5)
															{
																pass1aobcboy=pass1aobcboy+1;
																obcboy2=obcboy2+1;
															}
															if(sgpa>=5 && sgpa<6.5)
															{
																pass1aobcboy=pass1aobcboy+1;
																obcboy3=obcboy3+1;
															}
															break;
														}
														if(line.contains("FAIL"))
														{
															System.out.println(roll +"-- Fail");
															break;
														}
														line = scn.nextLine();
														o++;
													}
													
														
												break;
												
												}
												line = scn.nextLine();
												k++;
													
											}
										}
										
									}
								}
							}
						}
						document.close();
					}
					
	            
	  
	        }
	        workbook.close();
	        fis.close();
		}  
		catch(Exception e)  
		{  
			e.printStackTrace();  
		}
		finally
		{
			
			System.out.println("toatl add student--"+totaladd);
			System.out.println(" ");
		   
			System.out.println("add ggirls student--"+addggirl);
		   System.out.println("add gboy student--"+addgboy);
		   System.out.println(" ");
		   
		   System.out.println("add scgirls student--"+addscgirl);
		   System.out.println("add scboy student--"+addscboy);
		   System.out.println(" ");
		   
		   System.out.println("add stgirls student--"+addstgirl);
		   System.out.println("add stboy student--"+addstboy);
		   System.out.println(" ");
		   
		   System.out.println("add obcgirls student--"+addobcgirl);
		   System.out.println("add obcboy student--"+addobcboy);
		   System.out.println(" ");
		   
		   System.out.println("Total pass student--"+passstu);
		   System.out.println(" ");
		  
		   System.out.println("genaral girls 1stAttempt pass student--"+pass1aggirl);
		   System.out.println("genaral boy 1stAttempt pass student--"+pass1agboy);
		   System.out.println(" ");
		   
		   System.out.println("sc girls 1stAttempt pass student--"+pass1ascgirl);
		   System.out.println("sc boy 1stAttempt pass student--"+pass1ascboy);
		   System.out.println(" ");
		   
		   System.out.println("st girls 1stAttempt pass student--"+pass1astgirl);
		   System.out.println("st boy 1stAttempt pass student--"+pass1astboy);
		   System.out.println(" ");
		   
		   System.out.println("obc girls 1stAttempt pass student--"+pass1aobcgirl);
		   System.out.println("obc boy 1stAttempt pass student--"+pass1aobcboy);
		   System.out.println(" ");
		   
		   System.out.println("genaral girls 1st pass student--"+gengirl1);
		   System.out.println("genaral boy 1st pass student--"+genboy1);
		   System.out.println(" ");
		
		  
		   
		   System.out.println("sc girls 1st pass student--"+scgirl1);
		   System.out.println("sc boy  1st pass student--"+scboy1);
		   System.out.println(" ");
		   
		   System.out.println("st girls 1st pass student--"+stgirl1);
		   System.out.println("st boy  1st pass student--"+stboy1);
		   System.out.println(" ");
		   
		   System.out.println("obc girls 1st pass student--"+obcgirl1);
		   System.out.println("obc boy 1st pass student--"+obcboy1);
		   System.out.println(" ");
		   
		   
		   System.out.println("genaral girls 2dn pass student--"+gengirl2);
		   System.out.println("genaral boy 2dn pass student--"+genboy2);
		   System.out.println(" ");
		
		   
		   System.out.println("sc girls 2dn pass student--"+scgirl2);
		   System.out.println("sc boy  2dn pass student--"+scboy2);
		   System.out.println(" ");
		   
		   System.out.println("st girls 2dn pass student--"+stgirl2);
		   System.out.println("st boy  2dn pass student--"+stboy2);
		   System.out.println(" ");
		  
		   System.out.println("obc girls 2dn pass student--"+obcgirl2);
		   System.out.println("obc boy 2dn pass student--"+obcboy2);
		   System.out.println(" ");
		   
		   
		   System.out.println("genaral girls 3rd pass student--"+gengirl3);
		   System.out.println("genaral boy 3rd pass student--"+genboy3);
		   System.out.println(" ");
		
		   System.out.println("sc girls 3rd pass student--"+scgirl3);
		   System.out.println("sc boy  3rd pass student--"+scboy3);
		   System.out.println(" ");
		   
		   System.out.println("st girls 3rd pass student--"+stgirl3);
		   System.out.println("st boy  3rd pass student--"+stboy3);
		   System.out.println(" ");
		   
		   System.out.println("obc girls 3rd pass student--"+obcgirl3);
		   System.out.println("obc boy 3rd pass student--"+obcboy3);
		   
		   
		   
		   try
			{
				ConFile conn=new ConFile();
				String query1=" insert into general (sem,stuaddgirl,stuaddboy,pass1agirl,pass1aboy,passdisgirl,passdisboy,pass1divgirl,pass1divboy,pass2divgirl,pass2divboy) values ('"+sem+"','"+addggirl+"','"+addgboy+"','"+pass1aggirl+"','"+pass1agboy+"','"+gengirl1+"','"+genboy1+"','"+gengirl2+"','"+genboy2+"','"+gengirl3+"','"+genboy3+"') ";
				int i1=conn.s.executeUpdate(query1);
				
				
				
				String query2=" insert into sc (sem,stuaddgirl,stuaddboy,pass1agirl,pass1aboy,passdisgirl,passdisboy,pass1divgirl,pass1divboy,pass2divgirl,pass2divboy) values ('"+sem+"','"+addscgirl+"','"+addscboy+"','"+pass1ascgirl+"','"+pass1ascboy+"','"+scgirl1+"','"+scboy1+"','"+scgirl2+"','"+scboy2+"','"+scgirl3+"','"+scboy3+"') ";
				int i2=conn.s.executeUpdate(query2);
				
				
				String query3=" insert into st (sem,stuaddgirl,stuaddboy,pass1agirl,pass1aboy,passdisgirl,passdisboy,pass1divgirl,pass1divboy,pass2divgirl,pass2divboy) values ('"+sem+"','"+addstgirl+"','"+addstboy+"','"+pass1astgirl+"','"+pass1astboy+"','"+stgirl1+"','"+stboy1+"','"+stgirl2+"','"+stboy2+"','"+stgirl3+"','"+stboy3+"') ";
				int i3=conn.s.executeUpdate(query3);
				
				
				String query4=" insert into obc (sem,stuaddgirl,stuaddboy,pass1agirl,pass1aboy,passdisgirl,passdisboy,pass1divgirl,pass1divboy,pass2divgirl,pass2divboy) values ('"+sem+"','"+addobcgirl+"','"+addobcboy+"','"+pass1aobcgirl+"','"+pass1aobcboy+"','"+obcgirl1+"','"+obcboy1+"','"+obcgirl2+"','"+obcboy2+"','"+obcgirl3+"','"+obcboy3+"') ";
				int i4=conn.s.executeUpdate(query4);
				if(i4==1 && i1==1 && i2==1 && i3==1)
				{
					
					new Process();
					JOptionPane.showMessageDialog(null,"All student inserted");
					
				}
				else
				{
					new Process();
					JOptionPane.showMessageDialog(null,"something is wrong");
					
				}
				
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		   
		   
		   
		}
			
	}
	
	public static void main(String[] args)   
	{  
	
		
	}  
}  