// Add characters from stdin to an array
import java.io.IOException;

class ReadBytes {
    public static void main (String[] args)
        throws IOException {
        // WARNING: InputStream requires a byte array!
        byte[] array = new byte[10];

        // prompt user for some characters to enter
        System.out.print("Write some characters: ");
        System.in.read(array);
        System.out.print("The array fit: ");
        for (byte b: array)
            // cast to char mandatory - otherwise symbol ordinals are printed!
            System.out.print((char) b);
        System.out.println();
    }
}
