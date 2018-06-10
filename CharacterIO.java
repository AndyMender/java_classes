// File I/O using character streams (Oracle Java Tutorials)
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class CharacterIO {
	public static void main(String[] args) {
		// NOTE: all character streams rely on character encoding
		// (characters saved as integers and decoded using a character set);
		// in C, the charset is standard ASCII; the JVM uses the system's
		// encoding accessible via java.nio.charset.Charset.defaultCharset()
		// NOTE2: all character stream classes are derived from Reader or Writer
		
		// below code requires xanadu.txt, to be found here:
		// https://docs.oracle.com/javase/tutorial/essential/io/streams.html
		try(FileReader inFile = new FileReader("xanadu.txt");
			FileWriter outFile = new FileWriter("outfile.txt");) {
			int c;
			// WARNING: FileReader/Writer use only the default encoding!
			while ((c = inFile.read()) != -1)
				outFile.write(c);
		} catch (IOException aExc) {
			System.out.println("An exception has occurred: " + aExc);
			aExc.printStackTrace();
		}	
	}
}
