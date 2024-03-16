//package sheet;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.io.*;
import java.io.File;
import java.io.IOException;
public class ThirdFile 
{
	ThirdFile(String filename,String pdfname,String sem)
	{
		
		int girlA=0;
		int girlB=0;
		int girlC=0;
		int girlD=0;
		
		int obcgirlA=0;
		int obcgirlB=0;
		int obcgirlC=0;
		int obcgirlD=0;
		
		int scgirlA=0;
		int scgirlB=0;
		int scgirlC=0;
		int scgirlD=0;
		
		int boyA=0;
		int boyB=0;
		int boyC=0;
		int boyD=0;
		int stuF=0;
		
		int scboyA=0;
		int scboyB=0;
		int scboyC=0;
		int scboyD=0;
		int scstuF=0;
		
		int obcboyA=0;
		int obcboyB=0;
		int obcboyC=0;
		int obcboyD=0;
		int obcstuF=0;
		
		
		Pattern pattern;
		Matcher matcher;
		try
		{
			ConFile conn=new ConFile();
			File file=new File(filename);
			Scanner sc=new Scanner(file);
			String word="";
			String roll="";
			String name="";
			while (sc.hasNext())
			{
				word=sc.nextLine();
				String strpr="(\\d{5}\\w{1}\\d{5})";
				pattern=Pattern.compile(strpr);
				matcher=pattern.matcher(word);
				int counr=0;
				
				if(matcher.find())
				{
					roll=matcher.group();
				
					
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
								String fatchname="[A-Za-a]+";
								pattern=Pattern.compile(fatchname);
								matcher=pattern.matcher(line);
								while(matcher.find())
								{
									name=name+ " "+matcher.group();
									
								}
								
								int k=0;
								String result="";
								while(k!=20)
								{
									line = scn.nextLine();
									k++;
									if(line.contains(sem))
									{
										if(line.contains("+"))
										{
											pattern=Pattern.compile("[A-Z]{1}|[+,#]{1}");
											matcher=pattern.matcher(line);
											if(matcher.find())
											{
												result=matcher.group() + "+";
												//System.out.println(result+"---");	
											}
										}
										//System.out.print(roll+"---");
										//System.out.print(line+"---");									
										else
										{
											pattern=Pattern.compile("[A-Z]{1}|[+,#]{1}");
											matcher=pattern.matcher(line);
											if(matcher.find())
											{
												result=matcher.group();
												//System.out.println(result+"---");	
											}
										}
										
										if(word.contains("FEMALE") && word.contains("GENERAL"))
										{
											System.out.print(roll +"--");
											System.out.println(result);
											String query1=" insert into sub (subcode,roll,name,cast,gen,grade) values ('"+sem+"','"+roll+"','"+name.substring(3)+"','General','Female','"+result+"') ";
											int i1=conn.s.executeUpdate(query1);
											if(i1==1)
											{
												name="";
												//JOptionPane.showMessageDialog(null,"All student inserted");
												
											}
											else
											{
												JOptionPane.showMessageDialog(null,"something is wrong");
												
											}
										}
						
										
										
										
										
										if(word.contains("FEMALE") && word.contains("SCHEDULE_CASTE"))
										{
											System.out.print(roll +"--");
											System.out.println(result);
											String query1=" insert into sub (subcode,roll,name,cast,gen,grade) values ('"+sem+"','"+roll+"','"+name.substring(3)+"','SC','Female','"+result+"') ";
											int i1=conn.s.executeUpdate(query1);
											if(i1==1)
											{
												name="";
												//JOptionPane.showMessageDialog(null,"All student inserted");
												
											}
											else
											{
												JOptionPane.showMessageDialog(null,"something is wrong");
												
											}
										}
										
										
										
										
										if(word.contains("FEMALE") && word.contains("OTHER_BACKWARD_CLASS"))
										{
											System.out.print(roll +"--");
											System.out.println(result);
											String query1=" insert into sub (subcode,roll,name,cast,gen,grade) values ('"+sem+"','"+roll+"','"+name.substring(3)+"','OBC','Female','"+result+"') ";
											int i1=conn.s.executeUpdate(query1);
											if(i1==1)
											{
												name="";
												//JOptionPane.showMessageDialog(null,"All student inserted");
												
											}
											else
											{
												JOptionPane.showMessageDialog(null,"something is wrong");
												
											}
										}
										
										
										if(word.contains("MALEMALE") && word.contains("SCHEDULE_CASTE") )
										{
											System.out.print(roll +"--");
											System.out.println(result);
											String query1=" insert into sub (subcode,roll,name,cast,gen,grade) values ('"+sem+"','"+roll+"','"+name.substring(3)+"','SC','Male','"+result+"') ";
											int i1=conn.s.executeUpdate(query1);
											if(i1==1)
											{
												name="";
												//JOptionPane.showMessageDialog(null,"All student inserted");
												
											}
											else
											{
												JOptionPane.showMessageDialog(null,"something is wrong");
												
											}
										}
										
										
										if(word.contains("MALEMALE") && word.contains("GENERAL"))
										{
											System.out.print(roll +"--");
											System.out.println(result);
											String query1=" insert into sub (subcode,roll,name,cast,gen,grade) values ('"+sem+"','"+roll+"','"+name.substring(3)+"','General','Male','"+result+"') ";
											int i1=conn.s.executeUpdate(query1);
											if(i1==1)
											{
												name="";
												//JOptionPane.showMessageDialog(null,"All student inserted");
												
											}
											else
											{
												JOptionPane.showMessageDialog(null,"something is wrong");
												
											}
										}
								
										
										
										
										
										
									
										
										
										if(word.contains("MALEMALE") && word.contains("OTHER_BACKWARD_CLASS") )
										{
											System.out.print(roll +"--");
											System.out.println(result);
											String query1=" insert into sub (subcode,roll,name,cast,gen,grade) values ('"+sem+"','"+roll+"','"+name.substring(3)+"','OBC','Male','"+result+"') ";
											int i1=conn.s.executeUpdate(query1);
											if(i1==1)
											{
												name="";
												//JOptionPane.showMessageDialog(null,"All student inserted");
												
											}
											else
											{
												JOptionPane.showMessageDialog(null,"something is wrong");
												
											}
										}
					
										break;
									}
									
									
								}
							}
						}
						
					}
					document.close();
				}
			   
			   
			} 
		}
  
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	finally
	{
		new SubProcess();
		JOptionPane.showMessageDialog(null,"Process done");
	}
	}
	public static void main(String args[]) throws IOException 
	{
		
	}
}