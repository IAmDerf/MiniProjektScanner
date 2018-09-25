import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.io.Writer;

public class FileScanner {
	public static String format(String s) {
		String[] a = s.split("(?<=\\.)");
		String output="";
		for (int i = 0; i < a.length-1; i++) {
			/*if(a[i+1].charAt(0)=='\"') {
				a[i]=a[i]+" "+a[i+1];
				a[i+1]="";
			}
			else*/ if(a[i].charAt(0)==' ') {
				a[i]=a[i].substring(1)+"\n";
			}
			a[i].split("[a-z][A-Z]");
				
			
			
			/*if((check==a[i].charAt(a[i].length()-1))) {
				a[i]=a[i]+a[i+1];
				a[i+1]="";
			}*/
			
			
			output= output + a[i] + "\n";
			 

		}
		return output;
	}
	
	public static String readFromFile(String s) {
		String file = "";
		try {
			InputStream is = new FileInputStream("src/" + s + ".txt");
			int BUFFER_SIZE = 10000;
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"),BUFFER_SIZE);
			String str;
			while ((str = br.readLine()) != null) {
				file += str;
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
		
	}

	public static void writeToFile(String s, String a) {

		try {
			Writer writer = new OutputStreamWriter(new FileOutputStream("TheEnhanced" + a + ".txt"), "UTF-16");
			BufferedWriter fout = new BufferedWriter(writer);
			fout.write(s);
			fout.newLine();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String input = readFromFile("UglyDuckling");
		System.out.println(format(input));
		

	}
}