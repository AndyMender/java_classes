// implement a basic context manager similar to the C-lang "cat" binary
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

class ReadFile {
    public static void main(String[] args) {
        int i;  // placeholder for read characters
        FileInputStream aFile = null; // placeholder for the file object

        // file name input as command-line argument
        if (args.length != 1) {
            System.out.println("ERROR: The program takes exactly 1 argument.");
            System.out.println("Usage: ReadFile <filename>");
            return;
        }

        // read file and output to stdout, byte by byte;
        // EOF is marked with -1 (if exceeded, EOFException will be raised);
        // catching FileNotFoundException is not mandatory, because it's a child class
        // of IOException - here it provides extra error reporting
        try {
            aFile = new FileInputStream(args[0]);
            do {
                i = aFile.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (FileNotFoundException aExc) {
            System.out.printf("ERROR: File %s not found.\n", args[0]);
        } catch (IOException aExc) {
            System.out.println("ERROR: Cannot read file.");
        } finally {
            try {
                if (aFile != null) aFile.close();
            } catch (IOException aExc) {
                System.out.println("FATAL ERROR: Cannot close file descriptor.");
            }
        }
        // in Python, the above scenario can be handled using a context manager
        // which implements closing of the file on exit from the context/scope
    }
}