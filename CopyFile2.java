// implement the C-lang binary 'cp' in Java
// (slightly different version, based on the documentation from Oracle)
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

class CopyFile2 {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Wrong number of arguments.");
            System.out.println("Usage: CopyFile <file_in> <file_out>");
            return;
        }

        // character placeholder
        int c;
        try(FileInputStream aFileIn = new FileInputStream(args[0]);
            FileOutputStream aFileOut = new FileOutputStream(args[1])) {

            // not 'do...while'!
            while ((c = aFileIn.read()) != -1)
                aFileOut.write(c);
        } catch (IOException aExc) {
            System.out.println("I/O Error: " + aExc);
            aExc.printStackTrace();
        }
    }
}