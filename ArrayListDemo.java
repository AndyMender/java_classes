// ArrayList demo with String objects
import java.util.ArrayList;

class ArrayListDemo {
    public static void main(String[] args) {
        // create an empty array list
        ArrayList<String> sList = new ArrayList<String>();
        // create a String array with some items
        String[] sArray = { "A1", "A2", "B1", "B2",
                            "C1", "C2", "native" };

        System.out.println("An ArrayList was created. The initial size is: " + sList.size());
        System.out.println("The list was initialized without a specified capacity.");

        // add elements to the ArrayList
        System.out.println("Adding some String elements to the ArrayList:");
        for (String s: sArray) {
            System.out.println("Adding: " + s);
            sList.add(s);
        }
        System.out.println("The new size of the ArrayList is: " + sList.size());
    }
}