// File I/O using buffered streams (Oracle Java Tutorials)
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

class BufferedIO {
	public static void main(String[] args) {
		// BufferedReader and BufferedWriter provide buffering capabilities
		// to existing character streams
		// NOTE: BufferedInputStream and BufferedOutputStream are applicable
		// to byte streams
		
		// NOTE2: BufferedWriter provides no line writing method
		// (for that wrapping with PrintWriter is needed)
		
		// below code requires xanadu.txt, to be found here:
		// https://docs.oracle.com/javase/tutorial/essential/io/streams.html
		try(BufferedReader inStream = new BufferedReader(new FileReader("xanadu.txt"));
			PrintWriter outStream
				= new PrintWriter(new BufferedWriter(new FileWriter("outfile.txt")));) {
			String line;
			while ((line = inStream.readLine()) != null)
				outStream.println(line);
		} catch (IOException aExc) {
			System.out.println("An exception has occurred: " + aExc);
			aExc.printStackTrace();
		}
	}
}
