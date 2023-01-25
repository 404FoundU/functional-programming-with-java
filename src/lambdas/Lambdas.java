package lambdas;

//https://www.youtube.com/watch?v=tj5sLSFjVj4&t=13s
public class Lambdas {
    public static void main(String[] args) {

        Cat myCat = new Cat();
        myCat.print();

        printThing(myCat);
// Instead of sending object which contains an action -> we pass action itself
        // use lambda to pass in our implementation of print method as an object
        // lambdas give you the ability to make method implementations into objects
        //Lambdas can only be used in context of functional interface
        // Instead of creating a class that implements FI and then adding imp of SAM  and then create object of that class
        printThing(
                () -> {
                    System.out.println("Meow");
                }
        );
    }

    static void printThing(Printable thing) {
        thing.print();
    }
}
