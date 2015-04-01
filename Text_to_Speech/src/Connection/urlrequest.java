package Connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.omg.PortableInterceptor.USER_EXCEPTION;

public class urlrequest {
	private static final String USER_AGENT =  
            "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:11.0) ";

	public static void main(String argsp[])
	{
		try{
			String url_add = "http://www.tutorialspoint.com/java/java_url_processing.htm";
			 URL url = new URL(url_add);
			 System.out.println("URL is " + url.toString());
	         System.out.println("protocol is "
	                                    + url.getProtocol());
	         System.out.println("authority is "
	                                    + url.getAuthority());
	         System.out.println("file name is " + url.getFile());
	         System.out.println("host is " + url.getHost());
	         System.out.println("path is " + url.getPath());
	         System.out.println("port is " + url.getPort());
	         System.out.println("default port is "
	                                   + url.getDefaultPort());
	         System.out.println("query is " + url.getQuery());
	         System.out.println("ref is " + url.getRef());
	         HttpURLConnection connect = (HttpURLConnection)url.openConnection();
	         connect.addRequestProperty("USER AGENT", USER_AGENT);
	         InputStreamReader in = new InputStreamReader(connect.getInputStream());
	         int current;
	         while((current = in.read()) != -1){
	        	System.out.print((char)current); 
	         }
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
	}
}
