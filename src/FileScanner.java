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
		
	public static String findAndReplaceWord (String a, String s, String[] k) {
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
						//Denne del finder starten og slutningen af ordet, så vi kan proppe det på det endelige ord.
						while (!(b[j].toLowerCase().charAt(starttal)==s.charAt(0))) {
							
							start=b[j].substring(0,starttal+1);
							starttal++;
						}
						while (!(b[j].toLowerCase().charAt(b[j].length()-sluttal)==s.charAt(s.length()-1))) {
							
							slut=b[j].substring((b[j].length()-sluttal));
							sluttal++;
						}
								
							
						//Denne del cutter alt unødvendigt af vores ord, og efterlader kun et stykke der er lige langt som det ord vi leder efter, ved et bogstav der ens ved startbogstavet af det ord vi leder efter
						for (int i = 0; i < b[j].length(); i++) {
							if(b[j].toLowerCase().charAt(i)==s.charAt(0)) {
								b[j]=b[j].substring(i,s.length()+i);
							}
						}
						// Her byttes vores oprindelige ord, ud med et tilfældigt ord fra vores array, og tilføjes dens oprindelige start og slut.
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
		String[] meget = {"hella","huita","über","extremo","mega"};
		String[] rap = {"bing", "bong", "skrrrt","skippity","pop pop","boom"};
		String[] vand = {"pengene", "bunkevis af heroin","bajer"};
		String[] bedrøvet = {"suicidal","depressed","meget meget trist"};

		
		String[] a = s.split("(?<=\\.)");
		String output="";
		for (int i = 0; i < a.length-1; i++) {
			 if(a[i].charAt(0)==' ') {
				a[i]=a[i].substring(1)+"\n";
			}
			a[i]=findAndReplaceWord(a[i],"meget", meget);
			a[i]=findAndReplaceWord(a[i],"rap",rap);
			a[i]=findAndReplaceWord(a[i],"vand",vand);
			a[i]=findAndReplaceWord(a[i],"bedrøvet",bedrøvet);
			
			
			
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
		String[] sArr = s.split("\\b");
		ArrayList<ordTæller> aList = new ArrayList<ordTæller>();
			for (int i = 0; i < sArr.length; i++) {
				//Her gøres alle ord i sætningen til kun ordet, uden ekstra symboler
					sArr[i]=sArr[i].toLowerCase();
					if(sArr[i].matches("\\pL+")){	
						//Her laves de første ordTællere
						if(aList.size()==0) {
							aList.add(new ordTæller(sArr[i],1));
						}
						else if (aList.size()==1) {
							if(sArr[i].equals(aList.get(0).getWord())) {
								aList.get(0).setValues(aList.get(0).getWord(), aList.get(0).getOccurence()+1);
							}
							else {
								aList.add(new ordTæller(sArr[i],1));
							}
						}
						else {
						//Her sammenlignes ordet med ord, der allerede har været nævnt tidligere, hvis ordet ikke findes skabes et nyt object
						for (int j = 0; j < aList.size(); j++) {
							if(aList.get(j).getWord().matches(sArr[i])) {
								aList.get(j).setValues(aList.get(j).getWord(), aList.get(j).getOccurence()+1);
								j=aList.size();
							}
						
							else if(j==aList.size()-1) {
								aList.add(new ordTæller(sArr[i],1));
								j=aList.size();
				
							}
						}
							}
				
			
						}
					} 
				// Her sorteres ordnene efter occurence, ved hjælp af sorterings metoden "bubblesort"
			     ordTæller temp = new ordTæller("temp",0);  
			     for(int i=0; i < aList.size(); i++){  
			    	 for(int j=1; j < (aList.size()-i); j++){  
			    		 if(aList.get(j-1).getOccurence() < aList.get(j).getOccurence()){    
			    			 temp.setValues(aList.get(j-1).getWord(), aList.get(j-1).getOccurence());   
			    			 aList.get(j-1).setValues(aList.get(j).getWord(),aList.get(j).getOccurence());  
			    			 aList.get(j).setValues(temp.getWord(), temp.getOccurence());
			    		 }
			    		 
			}
	}
			     //Her udprintes 
			     float første = aList.get(0).getOccurence();
			     float anden = aList.get(1).getOccurence();
			     float tredje = aList.get(2).getOccurence();
			     float fjerde = aList.get(3).getOccurence();
			    		 
					System.out.println("\"" + aList.get(0).getWord() + "\"" + " er det mest skrevne ord i teksten, og er blevet skrevet " + aList.get(0).getOccurence() + " gange");
					System.out.println("\"" + aList.get(1).getWord() + "\"" + " er det næst mest skrevne ord, med " + aList.get(1).getOccurence() + " gange set i teksten, dette er " + anden/første + " gange af " + "\"" + aList.get(0).getWord()+ "\"");
					System.out.println("\"" + aList.get(2).getWord() + "\"" + " er det tredje mest skrevne ord, med " + aList.get(2).getOccurence() + " gange set i teksten, dette er " + tredje/første + " gange af " +"\"" + aList.get(0).getWord()+ "\"");
					System.out.println("\"" + aList.get(3).getWord() + "\"" + " er det fjerde mest skrevne ord, med " + aList.get(3).getOccurence() + " gange set i teksten, dette er " + fjerde/første + " gange af " + "\"" + aList.get(0).getWord()+ "\"");
			     
	}
	public static void writeToFile(String s, String a) {

		try {
			Writer writer = new OutputStreamWriter(new FileOutputStream("TheEnhanced" + a + ".rtf"), "ISO-8859-1");
			BufferedWriter fout = new BufferedWriter(writer);
			fout.write(s);
			fout.newLine();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String fil = "UglyDuckling";
		String input = readFromFile(fil);
		System.out.println(format(input));
		writeToFile(format(input),fil);
		zipf(input);
		//System.out.println(findAndReplaceSentence(input,"String", test));

	}
}