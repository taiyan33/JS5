import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.URLDecoder;

//http://www.cnblogs.com/shitou/archive/2011/07/04/2097427.html
public class hw4 {
 
  public static void main(String[] args) {
	  
	  BufferedReader br = null;
	  BufferedWriter bw = null;
		String file = "D:/01 新人專區/workspace/hw/src/encode_text.txt";
		String fileout = "D:/01 新人專區/workspace/hw/src/decode_file.txt";
		String name="";
	try {

		//br = new BufferedReader(new FileReader(FILENAME));
		FileReader fr = new FileReader( new File(file) );
		br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter( new File(fileout) );
		bw = new BufferedWriter(fw);

		String sCurrentLine;
		  
		while ((sCurrentLine = br.readLine()) != null) {
			System.out.println(sCurrentLine);
			name = java.net.URLDecoder.decode(sCurrentLine, "UTF-8");
			System.out.println(name);
			bw.append(name);
			bw.newLine();
		}
		bw.close();
		

	} catch (IOException e) {

		e.printStackTrace();

	}
	  
//	
//	try {
//		name = java.net.URLEncoder.encode("測試", "UTF-8");
//	} catch (UnsupportedEncodingException e) {
//		// TODO 自動產生 catch 區塊
//		e.printStackTrace();
//	}
//      System.out.println(name);
//      
//  	try {
//		name = java.net.URLDecoder.decode(name, "UTF-8");
//	} catch (UnsupportedEncodingException e) {
//		// TODO 自動產生 catch 區塊
//		e.printStackTrace();
//	}
//      System.out.println(name);
  }
 
}