// File I/O using standard byte streams (Oracle Java Tutorials)
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class ByteIO {
	public static void main(String[] args) {
		// NOTE: all byte stream classes are derived from InputStream
		// or OutStream
		int c;
		
		// this requires xanadu.txt to be found here:
		// https://docs.oracle.com/javase/tutorial/essential/io/streams.html
		try(FileInputStream inFile = new FileInputStream("xanadu.txt");
			FileOutputStream outFile = new FileOutputStream("outfile.txt");) {
			// read file byte by byte and write to another file
			while ((c = inFile.read()) != -1)
				outFile.write(c);
			
		} catch (IOException aExc) {
			System.out.println("An exception has occurred: " + aExc);
			aExc.printStackTrace();
		}	
	}
}
