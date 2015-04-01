package GOOGLE_SPEECH;
import java.io.BufferedReader;
import java.io.FileReader;

public class GETAUDIO {    
	
    public static void main(String[] args) throws Exception {
  	//entry point for the application
        BufferedReader read1 = new BufferedReader(new FileReader("read.txt"));
        String temp;
        int index = 0;
        while((temp = read1.readLine()) != null)
        {
        	//new thread for the new text
        	new create_audio(index, temp);                               
            index++;
        }
       read1.close();
    }
    
}
