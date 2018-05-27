// implement the C-lang binary 'cp' in Java
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

class CopyFile {
    public static void main(String[] args) {
        // character placeholder
        int i;

        // file placeholders
        FileInputStream aFileIn = null;
        FileOutputStream aFileOut = null;

        // check command-line argument number
        if (args.length != 2) {
            System.out.println("Wrong number of arguments.");
            System.out.println("Usage: CopyFile <file_in> <file_out>");
            return;
        }

        // sanity-check for input file
        try {
            aFileIn = new FileInputStream(args[0]);
        } catch (FileNotFoundException aExc) {
            System.out.println("Input file not found. Aborting operation.");
            return;
        }

        // sanity-check for output file
        try {
            aFileOut = new FileOutputStream(args[1]);
        } catch (FileNotFoundException aExc) {
            System.out.println("Target file not created. Aborting operation.");
            return;
        }
        // buffer the input file and write to output file
        try {
            do {
                // possible to do in a single line without buffering
                // but that removes the extra -1 sanity check
                i = aFileIn.read();
                if (i != -1) aFileOut.write(i);
            } while (i != -1);
        } catch (IOException aExc) {
            System.out.println("While copying content a problem has occurred and the program will close.");
            return;
        } finally {
            // can be split to address input and output file individually
            try {
                if (aFileIn != null) aFileIn.close();
                if (aFileOut != null) aFileOut.close();
            } catch (IOException aExc) {
                System.out.println("FATAL ERROR: input or output file not closed.");
            }
        }
    }
}