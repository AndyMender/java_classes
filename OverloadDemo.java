// method overloading demo based on an article from http://www.25hoursaday.com/CsharpVsJava.html#same


// parent class implementing a print method
class Parent {
    // printing with a String param
    public void printStuff(String str) {
        System.out.println("In parent class: " + str);
    }
}

// child class inheriting from parent
class Child extends Parent {
    // overloaded parent method
    public void printStuff(String str) {
        System.out.println("In child class: " + str);
    }

    // print method with different signature
    public void printStuff(int n) {
        System.out.println("In child class: " + n);
    }
}

class OverloadDemo {
    public static void main(String[] args) {
        // create some variables
        String str = "Hello there!";
        int i = 100;
        // create a parent and a child object
        Parent p = new Parent();
        Child c = new Child();
        Parent pc = new Child();    // allowed - Child-declared method will be inaccessible

        // printing items
        p.printStuff(str);          // allowed - Parent object calls Parent method

        c.printStuff(str);          // allowed - Child calls overloaded method
        c.printStuff(i);            // allowed - Child calls Child-specific method

        pc.printStuff(str);     // allowed - Parent object calls Child method
        //pc.printStuff(i);     // not allowed - parent does not have this method
    }
}