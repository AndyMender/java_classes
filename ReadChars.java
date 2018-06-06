// Demonstrate reading characters from the console
import java.io.*;

class ReadChars {
	public static void main(String[] args) 
	throws IOException {
		// catch the exception outside main() (meaning, never)
		char c;
		// wrap the byte stream to convert int to chars
		// (completely redundant here...)
		BufferedReader aCReader 
			= new BufferedReader(new InputStreamReader(System.in));
		// get characters from stdin
		System.out.println("Enter some characters. Fullstop ends the input. Begin:");
		do {
			c = (char) aCReader.read();
			System.out.print(c);
		} while (c != '.');
		
		System.out.println();
	}
}
		
