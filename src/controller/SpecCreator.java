package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class SpecCreator {
	public void fileCreator(String text, String fileName) throws IOException{
        BufferedWriter output = null;
        Writer out = null;
        
        try {
            File file = new File(fileName);
            out = new BufferedWriter(new OutputStreamWriter(
        			new FileOutputStream(file), "UTF8"));
            
            out.append(text);
            
            out.flush();
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            output.close();
          }
        }
    }
}
