// class demo with javadoc-compatible annotations

class Squarer {
    /**
     * Calculates the square of a number
     * @param num the base of the square
     * @return the square of num
     * @exception NumberFormatException if square value doesn't fit into int
     */
    public static int power(int num)
            throws NumberFormatException {
        return num * num;
    }
}

class Cubicer extends Squarer {
    /**
     * Calculates the cubic value of a number
     * @param num the base of the cubic value
     * @return the cubic value of num
     * @exception NumberFormatException if cubic value doesn't fit into int
     */
    public static int power(int num)
            throws NumberFormatException {
        return num * num * num;
    }
}

public class AnnotationDemo2 {
    public static void main(String[] args) {
        // calculate powers and prints them
        System.out.println("2 ^ 2 = " + Squarer.power(2));
        System.out.println("2 ^ 3 = " + Cubicer.power(3));
    }
}