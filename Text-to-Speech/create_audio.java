package GOOGLE_SPEECH;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

class create_audio extends Thread
{
	private int index = 0;
	private String s;
	File output;
	private static String USER_AGENT =  
            "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:11.0) ";

	create_audio(int i,String ext)
	{
		index = i;
		s = ext;
		output = new File("output" + i + ".mp3");
		start();
	}
	public void run()
	{
		try {
			go(Language.valueOf("EN"),URLEncoder.encode(s, "utf-8"),index);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void go(Language language, String text,int index) throws Exception {
        // Create url based on input params
        
		String strUrl = "http://translate.google.com/translate_tts?" + 
                "tl=" + language + "&q=" + text;
        URL url = new URL(strUrl);

        // Etablish connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Get method
        //because data is going through url.
        connection.setRequestMethod("GET");
        // Set User-Agent to "mimic" the behavior of a web browser. In this 
        // example, I used my browser's info
        connection.addRequestProperty("User-Agent", USER_AGENT);
        connection.connect();

        // Get content
        BufferedInputStream bufIn = 
                new BufferedInputStream(connection.getInputStream());
        byte[] buffer = new byte[1024];
        int n;
        ByteArrayOutputStream bufOut = new ByteArrayOutputStream();
        while ((n = bufIn.read(buffer)) > 0) {
            bufOut.write(buffer, 0, n);
        }
        BufferedOutputStream out = 
                new BufferedOutputStream(new FileOutputStream(output));
        // Done, save data
        out.write(bufOut.toByteArray());
        out.flush();
        out.close();
        System.out.println("Done");
    }
	public enum Language {
        FR("french"),
        EN("english");

        private final String language;
        private Language(String language) {
            this.language = language;
        }

        public String getFullName() {
            return language;
        }
    }
}

