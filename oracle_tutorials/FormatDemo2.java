// I/O formatting demo based on official tutorials from Oracle

class FormatDemo2 {
    public static void main(String[] args) {
        int i = 2;
        double r = Math.sqrt(i);

        // print the square root of a number
        System.out.format("The square root of %d is %f.%n", i, r);
    }
}