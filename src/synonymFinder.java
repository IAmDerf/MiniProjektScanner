import java.net.*;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import java.io.*;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;



	
public class synonymFinder {
	/*public static String synonym(String s) {
		try {
		URL url = new URL("https://sproget.dk/lookup?SearchableText="+s);
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null  ? "UTF-8" : encoding;


		return body;
		
		} catch (MalformedURLException e) {
			return("URL is malformed");
			
		} catch (IOException e) {
			return("Input is wrong");
		}
		
		
	}
	*/
	)
	public static void main(String[] args) {
		  String htmlString = "<html><head><title>My title</title></head>"
                  + "<body>Body content</body></html>";

          Document doc = Jsoup.parse(htmlString);
          String title = doc.title();
          String body = doc.body().text();

          System.out.printf("Title: %s%n", title);
          System.out.printf("Body: %s", body);
      }
	
	
}
