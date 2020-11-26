package week7;

import java.io.*;
import java.util.Stack;


public class Input {
	
	public static void main(String[] args) {
		
		Stack<String> data = new Stack<>();
		String temp = new String("");
		
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\CHO_LAB\\javatest\\input.txt");
			
			int t = fis.read();
			
			
			while (t != -1) {
				
				data.push("");
				temp = data.peek(); data.pop();
				
				while ( t != 10 && t != -1 ) {
					temp += (char)t;
					t = fis.read();
					
				}
				
				data.push(temp);
				t = fis.read();
			}
			fis.close();
		}
		catch (FileNotFoundException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
		
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\CHO_LAB\\javatest\\output.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String str;
			
			while (!data.isEmpty()) {					
				str = data.peek(); data.pop();		
				bw.write(str);	
				bw.newLine();
			}
			
			bw.flush();
			bw.close(); fos.close(); osw.close();
		} catch (IOException e) { e.printStackTrace(); }

	}
	
}
