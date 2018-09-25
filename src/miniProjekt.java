
public class miniProjekt {
	
	public static String format(String s) {
		String[] a = s.split(" ");
		String output="";
		output=output+a[1].toString();
		System.out.println(output);
		return output;
	}	
	public static void main(String[] args) {
		System.out.println(format("Manden sagde til dem \"Det skete I de dage\""));
		
		
	}
}

/*if(checkI==(StrArr[i+1].charAt(0))) {
StrArr[i]=StrArr[i]+StrArr[i+1];
if(checkcitat==(StrArr[i].charAt(StrArr[i].length()-1))) {
StrArr[i+1]=StrArr[i]+StrArr[i+1];
StrArr[i]="";
}

}*/
/*for (int i = 0; i < StrArr.length; i++) {
output= output + StrArr[i] + "\n";

} */