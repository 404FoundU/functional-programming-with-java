package lambdas;


import java.time.LocalDateTime;
import java.time.ZoneOffset;

// Method inside an interface is called abstract method
// When only one abstract method inside interface- functional interface
// SAM interface - Single abstract method
// Can contain static methods or default methods
@FunctionalInterface
public interface Printable {
    void print();

    default long parseTimeStringValue(String timeString) {
        return 1L;
    }

    static String testStatic(){
        return "Static method";
    }

}
