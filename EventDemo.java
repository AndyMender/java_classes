// publisher-subscriber demo based on an article from http://www.25hoursaday.com/CsharpVsJava.html
import java.util.EventObject;
import java.util.Random;
import java.util.Stack;


// example event object
class EvenNumberEvent extends EventObject {
    private int number;

    public EvenNumberEvent(Object source, int number) {
        // pass the trigger to parent constructor
        super(source);
        // store number
        this.number = number;
    }

    public int getNumber() { return this.number; }
}


// subscriber/listener interface to handle ALL listeners
// alternative - base class with a ready implementation
// or interface with a 'default' method
interface EvenNumberListener {
    void evenNumberFound(EvenNumberEvent ene);
}


class Publisher {
    // collection for tracking subscribers/listeners
    Stack<EvenNumberListener> subscribers = new Stack<EvenNumberListener>();

    // event trigger
    private void OnEvenNumberFound(int num) {
        // loop through subscribers/listeners and trigger callback
        for (int i = 0; i < subscribers.size(); i++) {
            EvenNumberListener listener = (EvenNumberListener) subscribers.get(i);
            listener.evenNumberFound(new EvenNumberEvent(this, num));
        }
    }

    // subscriber/listener adder
    public void addEvenNumberEventListener(EvenNumberListener enl) {
        subscribers.add(enl);
    }

    // subscriber/listener remover
    public void removeEvenNumberEventListener(EvenNumberListener enl) {
        subscribers.remove(enl);
    }

    // test runner
    public void runNumbers() {
        // create randomizer with seed
        Random rand = new Random(System.currentTimeMillis());

        // generate 20 numbers in the range 1-20
        // and trigger event if the number is even
        for (int i = 0; i < 20; i++) {
            int current = (int) rand.nextInt() % 20;
            System.out.println("Current number is: " + current);

            if ((current % 2) == 0 && current != 0) {
                OnEvenNumberFound(current);
            }
        }
    }
}


public class EventDemo implements EvenNumberListener {
    // callback function called when even number is found
    public void evenNumberFound(EvenNumberEvent ene) {
        System.out.println("Even number found: " + ene.getNumber());
    }

    public static void main(String[] args) {
        EventDemo ed = new EventDemo();
        Publisher pub = new Publisher();

        // add subscriber/listener
        pub.addEvenNumberEventListener(ed);

        // run test
        pub.runNumbers();

        // remove subscriber/listener
        pub.removeEvenNumberEventListener(ed);
    }
}