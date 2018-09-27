
public class ordTæller {
	private String word;
	private int occurence;
	
	public ordTæller(String w, int o) {
		word = w;
		occurence = o;
	}
	
	public void setValues(String w, int o) {
		word = w;
		occurence = o;
	}
	
	public String getWord() {
		return word;
	}
	public int getOccurence() {
		return occurence;
	}
}
