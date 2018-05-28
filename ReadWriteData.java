// demonstrate I/O binary operations on files
import java.io.*;

class ReadWriteData {
    public static void main(String[] args) {
        int i = 10;
        double d = 1023.56;
        boolean b = true;

        // try to write some binary data
        try (DataOutputStream aFileOut =
                     new DataOutputStream(new FileOutputStream("test_binary_data")))
        {
            System.out.printf("Writing %d to file.\n", i);
            aFileOut.writeInt(i);

            System.out.printf("Writing %.2f to file.\n", d);
            aFileOut.writeDouble(d);

            System.out.println("Writing " + b + " to file.");
            aFileOut.writeBoolean(b);
        } catch (IOException aExc) {
            System.out.println("Cannot write file due to exception: " + aExc);
            return;
        }

        // try to read some binary data
        try (DataInputStream aFileIn =
                     new DataInputStream(new FileInputStream("test_binary_data")))
        {
            System.out.println("Reading i from file: " + aFileIn.readInt());
            System.out.println("Reading d from file: " + aFileIn.readDouble());
            System.out.println("Reading b from file: " + aFileIn.readBoolean());
        } catch (IOException aExc) {
            System.out.println("Cannot read file due to exception: " + aExc);
        }

        // TODO: figure out how DataInputStream recognizes binary data in sequence
    }
}