import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.io.Writer;
import java.util.*;


public class FileScanner {
	static String[] meget = {"hella","huita","über","extremo","mega"};
	static String[] rap = {"Bing", "Bong", "Skrrrt","skippity","pop pop","boom"};
	
	
	public static String findAndReplace (String a, String s, String[] k) {
		if(a.toLowerCase().contains(s)) {
			String[] b = a.split(" ");
			a="";
			String start = "";
			String slut = "";
			int sluttal = 1;
			int starttal = 0;
			for (int j = 0; j < b.length; j++) {
				start="";
				slut="";
				sluttal=1;
				starttal=0;
					if(b[j].toLowerCase().contains(s)) {
						while (!(b[j].toLowerCase().charAt(starttal)==s.charAt(0))) {
							
							start=b[j].substring(0,starttal+1);
							starttal++;
						}
						while (!(b[j].toLowerCase().charAt(b[j].length()-sluttal)==s.charAt(s.length()-1))) {
							
							slut=b[j].substring((b[j].length()-sluttal));
							sluttal++;
						}
								
							
						
						for (int i = 0; i < b[j].length(); i++) {
							if(b[j].toLowerCase().charAt(i)==s.charAt(0)) {
								b[j]=b[j].substring(i,s.length()+i);
							}
						}
						
						if(b[j].toLowerCase().equals(s)) {
							b[j] = start+k[(int) (Math.random() * k.length)]+slut;
						}
					}
				a+=b[j]+" ";
			}
		}
		return a;
	}
	public static String format(String s) {
		String[] a = s.split("(?<=\\.)");
		String output="";
		for (int i = 0; i < a.length-1; i++) {
			 if(a[i].charAt(0)==' ') {
				a[i]=a[i].substring(1)+"\n";
			}
			a[i]=findAndReplace(a[i],"meget", meget);
			a[i]=findAndReplace(a[i],"rap",rap);
				
			
			
			output += a[i] + "\n";
			 

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
	
	public static void zipf (String s) {
		String[] sArr = s.split(" ");
		ArrayList<ordTæller> aList = new ArrayList<ordTæller>();
	
			for (int i = 0; i < sArr.length; i++) {
				sArr[i]=sArr[i].toLowerCase();
		if (i==0) {
			aList.add(new ordTæller(("\\b[sArr[i]]\\b"),1));
			System.out.println(aList.get(0).getWord());
		} else {
			for (int j = 0; j < aList.size(); j++) {
				if(aList.get(j).getWord().matches("(\\b)"+sArr[i]+"(\\b)")) {
					aList.get(j).setValues(aList.get(j).getWord(), aList.get(j).getOccurence()+1);
				}
				else {
					aList.add(new ordTæller(sArr[i],1));
					
				}
			
			}
		}
			}
			for (ordTæller ordTæller : aList) {
				System.out.println(ordTæller.getWord() + "Er set i teksten: " + ordTæller.getOccurence() + " gange");
				
			}
	}
	public static void writeToFile(String s, String a) {

		try {
			Writer writer = new OutputStreamWriter(new FileOutputStream("TheEnhanced" + a + ".rtf"), "UTF-8");
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
		writeToFile(format(input),"UglyDuckling");
		zipf(input);

	}
}