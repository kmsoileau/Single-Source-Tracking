package positronic.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DependencyAnalyzer
{
	public static void analyze(File sourceDirectory, FileWriter fw, ArrayList<ArrayList<String>> comp)
	{
		if(sourceDirectory.isDirectory())
		{
			File[] files=sourceDirectory.listFiles();
			if(files==null)
				return;
			for(File f:files)
				analyze(f,fw,comp);
		}
		if(sourceDirectory.isFile())
		{
			ArrayList<String> x=analyze(sourceDirectory.getAbsolutePath());
			comp.add(x);
		}
	}
	
	public static ArrayList<String> analyze(String sourceFile)
	{
		ArrayList<String> ret=new ArrayList<String>();
		BufferedReader in;
		try 
		{
			in = new BufferedReader(new FileReader(sourceFile));
			String[] s1=sourceFile.split("\\\\");
			String s2=s1[s1.length-1];
			String s3=s2.substring(0,s2.length()-5);
			String inputLine="";
			String total="";
			while ((inputLine = in.readLine()) != null)
			    total+=inputLine;
			in.close();
			StringTokenizer st=new StringTokenizer(total,";/");
			String nextToken=st.nextToken();
			while(!nextToken.startsWith("package"))
				nextToken=st.nextToken();
			int pos=nextToken.indexOf(' ');
			String pkg0=nextToken.substring(pos,nextToken.length());
			
			while(st.hasMoreTokens())
			{
				nextToken=st.nextToken();
				while(nextToken!=null && !nextToken.startsWith("import"))
					if(st.hasMoreTokens())
						nextToken=st.nextToken();
					else
						nextToken=null;
				if(nextToken==null)
					break;
				int pos2=nextToken.indexOf(' ');
				String pkg=nextToken.substring(pos2,nextToken.length());
				ret.add(pkg0+"."+s3+" <-- "+pkg);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch (java.util.NoSuchElementException e) 
		{
			return ret;
		}
		return ret;
	}
	
	public static void main(String[] args) throws Exception 
	{
		FileWriter fw = new FileWriter("stuff.txt");
		ArrayList<ArrayList<String>> comp=new ArrayList<ArrayList<String>>();
		
		analyze(new File(
				"C:\\Users\\Kerry Soileau\\workspace\\positronic\\positronic\\satisfiability"),fw,comp);
		for(ArrayList<String> o : comp)
			for(String s : o)
				fw.write(s+"\n");
		fw.close();
		
	}
}
