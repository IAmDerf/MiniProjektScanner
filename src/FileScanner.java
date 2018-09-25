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
	static String[] meget = {"hella","huita","über","extremo","mega"};
	
	public static String findAndReplace (String s, String a, String[] k) {
		if(s.contains(a)) {
			String[] b = s.split(" ");
			s="";
			for (int j = 0; j < b.length; j++) {
				if(b[j].length()>=a.length())
					if(b[j].substring(0,a.length()).equals(a)) {
						b[j] = k[(int) (Math.random() * k.length)];
					}
				s=s+b[j]+" ";
				}
		}
		return s;
	}
	public static String format(String s) {
		String[] a = s.split("(?<=\\.)");
		String output="";
		for (int i = 0; i < a.length-1; i++) {
			 if(a[i].charAt(0)==' ') {
				a[i]=a[i].substring(1)+"\n";
			}
			findAndReplace(a[i],"meget", meget);
				
			
			
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
			Writer writer = new OutputStreamWriter(new FileOutputStream("TheEnhanced" + a + ".rtf"), "UTF-16");
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
		//writeToFile(format(input),"UglyDuckling");
		

	}
}