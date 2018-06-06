// Reading strings from the console
import java.io.*;

class ReadLines {
	public static void main(String[] args)
	throws IOException {
		// String placeholder
		String aStr;
		// reader object
		BufferedReader aReader 
			= new BufferedReader(new InputStreamReader(System.in));

		// Read some strings from the console via readline
		System.out.println("Write something nice and it will be copied.");
       		System.out.println("Say 'stop' and it will be over:");
		do {
			aStr = aReader.readLine();
			System.out.println(aStr);
		} while (! aStr.equals("stop"));
	}
}
