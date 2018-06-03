// RandomAccessFile demo
import java.io.*;

class FileSeeker {
    public static void main(String[] args) {
        // some numbers for writing
        double[] aData = { 24.56, 21.45, 80.12, 54.112, 5.01 };

        // RandomAccessFile is NOT a child class of either InputStream
        // or OutputStream; however, it implements methods read() and write(),
        // and seek() to chose the position in the file object;
        // finally, it implements the DataInput and DataOutput interfaces
        // so it has access to the same read* and write* methods for base types
        // as DataInputStream and DataOutputStream classes
        // r - read-only, rw - read/write
        try (RandomAccessFile aFileOut
                     = new RandomAccessFile("random.dat", "rw")) {
            // write some numbers to file
            for (double nDub: aData) {
                aFileOut.writeDouble(nDub);
            }
        } catch (IOException aExc) {
            System.out.println("An exception has occurred while writing to file: " + aExc);
            return;
        }

        // read file at random positions
        try (RandomAccessFile aFileIn
                     = new RandomAccessFile("random.dat", "r")) {
            System.out.println("Reading first element: " + aFileIn.readDouble());

            // 'double' variable size = 8 bytes
            // sets marker 8 bytes ahead - beginning of 2nd variable
            aFileIn.seek(8);
            System.out.println("Reading second element: " + aFileIn.readDouble());

            // moves marker 16 bytes ahead - beginning of 3rd variable
            // the position is always counted from the beginning of the file!
            aFileIn.seek(16);
            System.out.println("Reading third element: " + aFileIn.readDouble());
            System.out.println();

            // read all elements in sequence
            for (int i = 0; i < aData.length; i++) {
                // adjust position and read
                aFileIn.seek(8 * i);
                System.out.println("Reading position " + (i + 1) + ": " + aFileIn.readDouble());
            }
            // a binary file behaves the same way as memory - each segment of bytes contains
            // the encoded information (binary, translated to hexadecimal for viewing)
            // about a number
        } catch (IOException aExc) {
            System.out.println("An exception has occurred while reading file: " + aExc);
        }
    }
}