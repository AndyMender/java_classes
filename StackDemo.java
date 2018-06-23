// Stack demo based on the article from http://www.25hoursaday.com/CsharpVsJava.html#same
import java.util.Stack;

class StackDemo {
    // universal method using generics and wildcards
    public static void printStack(Stack<?> stack) {
        System.out.println("Printing stack:");
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // create an int stack
        Stack<Integer> intStack = new Stack<Integer>();
        // add some items to the stack
        intStack.add(50);
        intStack.add(2);
        intStack.add(10);
        intStack.add(12);
        // print the stack content
        printStack(intStack);
        // create a String stack
        Stack<String> sStack = new Stack<String>();
        // add some items again
        sStack.add("piggy");
        sStack.add("sofa");
        sStack.add("peas");
        sStack.add("umbrella");
        // print the stack content
        printStack(sStack);
    }
}