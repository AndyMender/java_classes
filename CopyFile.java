// implement the C-lang binary 'cp' in Java
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

class CopyFile {
    public static void main(String[] args) {
        // character placeholder
        int i;

        // check command-line argument number
        if (args.length != 2) {
            System.out.println("Wrong number of arguments.");
            System.out.println("Usage: CopyFile <file_in> <file_out>");
            return;
        }

        // buffer the input file and write to output file
        // use the 'try' context manager
        try(FileInputStream aFileIn = new FileInputStream(args[0]);
            FileOutputStream aFileOut = new FileOutputStream(args[1])) {
            do {
                // possible to do in a single line without buffering
                // but that removes the extra -1 sanity check
                i = aFileIn.read();
                if (i != -1) aFileOut.write(i);
            } while (i != -1);
        } catch (IOException aExc) {
            System.out.println("I/O Error: " + aExc);
        }
    }
}