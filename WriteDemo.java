// demonstrate the low-level stdout method from PrintStream
class WriteDemo {
    public static void main(String[] args) {
        // variable to print out (char recorded as int by its ASCII ordinal)
        int b = 'X';
        // byte or int is cast to char and emitted to stdout
        System.out.write(b);
        // mandatory endline symbol to close the buffer and flush to stdout
        System.out.write('\n');
    }
}