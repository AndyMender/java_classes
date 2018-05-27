// implement a basic context manager similar to the C-lang "cat" binary
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

class ReadFile {
    public static void main(String[] args) {
        int i;  // placeholder for read characters

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
        //
        // this version uses a context manager mimic implemented in JDK 7
        // which relies on the close() method defined in AutoCloseable and Closeable interfaces
        // and simplifies the 'catch' clause
        try(FileInputStream aFile = new FileInputStream(args[0])) {
            do {
                i = aFile.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        } catch (IOException aExc) {
            System.out.println("I/O error: " + aExc);
        }
    }
}