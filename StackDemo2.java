// stack demo with type derivation based on the article from http://www.25hoursaday.com/CsharpVsJava.html#same
import java.util.Stack;

interface Mammal {
    // default speak() implementation
    default void speak() {
        System.out.println("*Generic mammal sound*");
    }
}

class Dog implements Mammal {
    // Dog provides its own speak() implementation
    public void speak() {
        System.out.println("Woof! Woof!");
    }
}

class Cat implements Mammal {
    // Cat provides its own speak() implementation
    public void speak() {
        System.out.println("Meow! Meow!");
    }
}

class MuteKoala implements Mammal {
    // mute koala is mute is no speak() implementation :(
}

class StackDemo2 {
    // wildcard with upper bound to capture all Mammal-derived stacks
    // (keyword 'extends' used for classes and interfaces!)
    public static void annoyNeighbors(Stack<? extends Mammal> pets) {
        while (!pets.empty()) {
            Mammal animal = pets.pop();
            animal.speak();
        }
    }

    public static void main(String[] args) {
        // stack of different mammals
        Stack<Mammal> pets = new Stack<Mammal>();
        // add some animals to the stack (both push() and add() allowed)
        pets.add(new Dog());
        pets.add(new Cat());
        pets.add(new MuteKoala());
        // make some animal noise!
        System.out.println("Your pets are annoying the neighbors:");
        annoyNeighbors(pets);
        System.out.println("Your neighbors are furious...");
    }
}