// I/O using scanner objects (Oracle Java Tutorials)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class ScannerDemo {
	public static void main(String[] args) throws IOException {
		// Scanner objects offer convenience methods for functions similar
		// to C-style scanf()
		
		// NOTE: Scanner objects are most useful when wrapping streams
		
		// below code requires xanadu.txt, to be found here:
		// https://docs.oracle.com/javase/tutorial/essential/io/streams.html
		try(Scanner s 
			= new Scanner(new BufferedReader(new FileReader("xanadu.txt")));) {
			// scan file token by token relying on whitespace
			// (or different!) delimiters
			while (s.hasNext())
				System.out.println(s.next());
			
		} catch (IOException aExc) {
			System.out.println("An exception has occurred: " + aExc);
			aExc.printStackTrace();
		}
		// NOTE2: Scanner objects normally require closing
		// (in the 'finally' block), but the 'new-style' try-catch handles that
	}
}
