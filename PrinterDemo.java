// demonstrate writing to console using a character writer
import java.io.*;

class PrinterDemo {
	public static void main(String[] args)
	throws IOException {
		// create some variables
		int i = 10;
		double d = 1.65;
		// create writer (flushOnNewline = true)
		PrintWriter aWriter = new PrintWriter(System.out, true);
		aWriter.println("Using PrintWriter.");
		aWriter.println("i = " + i + "\nd = " + d);
		aWriter.println("i + d = " + (i + d));
	}
}
