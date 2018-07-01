// object serialization demo based on the article from http://www.25hoursaday.com/CsharpVsJava.html#same

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;

// class whose objects can be serialized
class SerializeTest implements Serializable {
    transient int x;        // will not be serialized due to 'transient' keyword
    private int y;          // will be serialized despite being 'private'

    // standard constructor to initialize x and y
    public SerializeTest(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // toString override with a serialization format
    @Override
    public String toString() {
        return String.format("{x=%d, y=%d}", x, y);
    }

    // getters to print 'x' and 'y'
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

class SerializeDemo {
    public static void main(String[] args) {
        SerializeTest st = new SerializeTest(61, 52);
        SerializeTest st_copy = null;

        // test toString() override and field contents
        System.out.println("Object before write: " + st);
        System.out.format("x=%d, y=%d\n", st.getX(), st.getY());

        // write the object to disk
        System.out.println("Writing object to disk...");
        try (ObjectOutputStream out
                     = new ObjectOutputStream(new FileOutputStream("out.txt"));) {
            out.writeObject(st);
            out.flush();
        } catch (IOException ioe) {
            System.out.println("Couldn't write object to file. Aborting.");
            ioe.printStackTrace();
            return;
        }

        // read object from disk
        System.out.println("Reading object from disk...");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("out.txt"));) {
            // mandatory cast to target object
            st_copy = (SerializeTest) in.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("Couldn't read object from file. Aborting.");
            ioe.printStackTrace();
            return;
        }

        // check if object I/O worked
        if (st_copy == null) {
            System.out.println("Object reading from file failed :(.");
        } else {
            System.out.println("Object after write and read: " + st_copy);
            System.out.format("x=%d, y=%d\n", st.getX(), st.getY());
        }
    }
}