// I/O using scanner objects with locale handling (Oracle Java Tutorials)
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

class ScannerDemo2 {
	public static void main(String[] args) throws IOException {
		double sum = 0;
		
		// Scanner objects handle also numerical tokens!
		
		// below code requires "usnumbers.txt", to be found here:
		// https://docs.oracle.com/javase/tutorial/essential/io/scanning.html
		try(Scanner s 
			= new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));) {
			// set the US locale to handle the thousands comma notation
			s.useLocale(Locale.US);
			// by default Scanner uses whitespace as defined in java.lang.Character.isWhitespace()
            // however, a different delimiter can be used:
            // s.useDelimiter(",")  would use a comma as the separator

			// each of the primitive types has an individual nextType() method
			// NOTE: overloading wouldn't work due to the underlying
			// char-based byte I/O approach
			while (s.hasNext()) {
				// read in ONLY tokens of type double
				if (s.hasNextDouble()) {
					sum += s.nextDouble();
				} else {
					s.next();
				}
			}
		} catch (IOException aExc) {
			System.out.println("An exception has occurred: " + aExc);
			aExc.printStackTrace();
		}
		System.out.println("The sum is: " + sum);
	}
}
