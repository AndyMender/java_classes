// File I/O using line streams (Oracle Java Tutorials)
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

class CharIO2 {
	public static void main(String[] args) {
		// BufferedReader and PrintWriter can be used to operate on
		// entire lines instead of single characters 
		// NOTE: above classes are used to wrap character stream objects
		
		// below code requires xanadu.txt, to be found here:
		// https://docs.oracle.com/javase/tutorial/essential/io/streams.html
		try(BufferedReader inStream = new BufferedReader(new FileReader("xanadu.txt"));
			PrintWriter outStream = new PrintWriter(new FileWriter("outfile.txt"));) {
				String line;
				// character buffer is represented as a String object
				while ((line = inStream.readLine()) != null)
					outStream.println(line);
		} catch (IOException aExc) {
			System.out.println("An exception has occurred: " + aExc);
			aExc.printStackTrace();
		}	
	}
}
