// console I/O with formatting strings
import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.nio.charset.Charset;

class FormatDemo {
    public static void main(String[] args)
        throws IOException {
        // buffering container for read lines
        String[] string_array = new String[5];

        // charset object
        Charset charset = Charset.defaultCharset();
        // reader object
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in, charset));
        // printer object
        PrintWriter printer
                = new PrintWriter(new OutputStreamWriter(System.out, charset), true);

        // capture text
        printer.println("Write some text [max 5 lines]:");
        for (int i = 0; i < string_array.length; i++) {
            string_array[i] = reader.readLine();
        }

        // print text
        printer.println("Here is your text:");
        for (String s: string_array) {
            // legacy C-style printf() could also be used here
            // %n defines a platform-specific terminator (recommended!)
            printer.format("This is your line: %s%n", s);

            // String has a format() method as well for building formatted strings
            // a la C-style sprintf
        }
    }
}