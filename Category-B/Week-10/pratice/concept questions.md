1. Explain method overloading and method overriding.
Answer:
Method overloading occurs when a class contains multiple methods with the same name but different parameter lists. The methods may differ in the number of parameters, their data types, or their order. Overloading allows related operations to use one meaningful method name while accepting different kinds of input. The compiler determines which overloaded method to call by examining the arguments and the available method signatures. Therefore, overloading is resolved at compile time.
Example:
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

Here, add is overloaded because the methods have different parameter types.Method overriding occurs when a subclass provides its own implementation of an inherited instance method with the same signature, subject to Java's overriding rules. Overriding allows a subclass to specialize the behaviour inherited from its parent class. When an overridden method is called through a reference, Java selects the implementation according to the actual object's runtime class. This is known as dynamic method dispatch, and it supports runtime polymorphism.
Example:
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}

If an Animal reference points to a Dog object, calling sound() executes the Dog implementation.Conclusion: Overloading uses the same method name with different parameter lists and is resolved at compile time. Overriding provides a subclass-specific implementation of an inherited method and supports runtime polymorphism.

2. Explain the sequence of constructor invocation when a derived-class object is created.
Answer:
A constructor is a special member of a class that executes when an object is created. It initializes the object's state. When a subclass object is constructed, Java ensures that its superclass portion is initialized before the subclass constructor body completes.
For example, suppose Manager extends Employee, and Employee extends Person. When a Manager object is created, constructor execution proceeds from the top of the inheritance hierarchy toward the most derived class:
1. Person constructor executes.
2. Employee constructor executes.
3. Manager constructor executes.
This order ensures that inherited fields and superclass state are initialized before subclass-specific initialization relies on them.
In Java, a subclass constructor can pass arguments to its superclass constructor by using super(arguments). The super(...) constructor invocation must appear first in the constructor body. If a constructor does not explicitly invoke another constructor in the same class or a superclass constructor, Java inserts an implicit no-argument superclass constructor invocation when permitted.
Example:
class Person {
    Person(String name) {
        System.out.println("Person: " + name);
    }
}

class Employee extends Person {
    Employee(String name) {
        super(name);
        System.out.println("Employee constructor");
    }
}

class Manager extends Employee {
    Manager(String name) {
        super(name);
        System.out.println("Manager constructor");
    }
}

public class ConstructorOrderDemo {
    public static void main(String[] args) {
        new Manager("Ravi");
    }
}


Output:
Person: Ravi
Employee constructor
Manager constructor


Conclusion: Superclass construction happens before subclass constructor execution. The super(...) call passes the necessary values to the superclass constructor.

3. Compare concrete classes, abstract classes and interfaces.
Answer:
A concrete class is a class that can be instantiated directly. It may contain instance variables, constructors, concrete methods and inherited behaviour. A concrete class is suitable when the system needs actual objects with defined state and behaviour. For example, a Car class can store a vehicle's model and speed and provide methods to accelerate or brake.
An abstract class is declared using the abstract keyword and cannot be instantiated directly. It may contain instance variables, constructors, concrete methods and abstract methods. An abstract method declares required behaviour without providing its implementation. Subclasses must implement inherited abstract methods unless they are also declared abstract. Abstract classes are useful when related classes share common state and behaviour but require specialized implementations. For example, an abstract Shape class may define a common color field and an abstract area() method.
An interface defines a contract that implementing classes agree to fulfil. A class can implement multiple interfaces, even though Java classes can extend only one class. Interfaces commonly specify method signatures and constants. Modern Java interfaces can also contain default and static methods, but they do not provide ordinary per-instance fields. Interfaces are useful for describing capabilities that may be shared by otherwise unrelated classes, such as Chargeable, Runnable or Comparable.
Comparison:
- Concrete class: can be instantiated; represents a usable implementation.
- Abstract class: cannot be instantiated directly; combines shared implementation with required subclass behaviour.
- Interface: defines a contract or capability that classes implement; supports multiple interface implementation.
Conclusion: Use a concrete class for directly usable objects, an abstract class for a shared base with common state or implementation, and an interface for a contract that different classes can implement.

4. How should a class handle the same abstract method declared in two interfaces?
Answer:
A Java class can implement more than one interface. If two interfaces declare an abstract method with the same signature and compatible return types, a single implementation in the class can satisfy both interface contracts.
For example:
interface Printable {
    void print();
}

interface Showable {
    void print();
}

class Report implements Printable, Showable {
    @Override
    public void print() {
        System.out.println("Printing report");
    }
}


The Report class implements both interfaces and provides one public implementation of print(). That implementation fulfils the method requirement of both Printable and Showable.
This illustrates multiple interface implementation: one class can promise to support several capabilities without extending several classes. The return types must be compatible, and any conflicting default methods require explicit resolution by the implementing class.
Conclusion: One compatible public implementation can satisfy identical abstract method declarations from multiple interfaces.

5. Why must equals() and hashCode() be overridden consistently?
Answer:
In Java, equals() and hashCode() are methods inherited from Object. By default, equals() compares object identity, meaning it generally treats two separate object instances as unequal even if their fields contain the same values. If a class needs content equality, it can override equals() to compare the relevant fields.
The hashCode() method returns an integer used by hash-based collections such as HashSet and HashMap to organize objects into hash buckets. Java requires that if two objects are equal according to equals(), they must return the same hash code. The reverse is not required: unequal objects may have the same hash code.
If a programmer overrides equals() but leaves the default hashCode(), two logically equal objects may produce different hash codes. A hash-based collection may then place them in different buckets and fail to recognize a duplicate or find an object that logically matches an existing entry.
Example: two Student objects with the same roll number should be treated as equal if roll number defines uniqueness. Both equals() and hashCode() should therefore be based on that roll number.
Conclusion: Override equals() and hashCode() consistently whenever defining content equality. This allows hash-based collections to behave correctly.

6. Differentiate shallow copying and deep copying.
Answer:
A shallow copy creates a new outer object but copies references to nested mutable objects rather than creating independent copies of those nested objects. As a result, the original object and the copy may refer to the same internal list, array or other mutable object. If one object modifies that shared nested object, the change may be visible through the other object.
A deep copy creates a new outer object and also copies the relevant nested objects so that the copy has independent mutable state. Changes to copied nested data do not affect the original, provided the deep-copy implementation correctly duplicates all mutable objects that need independence.
For example, suppose a Student object contains a reference to a mutable ArrayList of marks. A shallow copy might share the same list. Adding a mark through the copied student's list would also change what the original student's list shows. A deep copy would create a separate list, preventing that unintended sharing.
Shallow copying can be appropriate when sharing references is intentional or nested objects are immutable. Deep copying is useful when independent object state is required, but it can take more time and memory and requires careful treatment of nested references.
Conclusion: A shallow copy duplicates the outer object but may share nested objects; a deep copy duplicates the necessary nested mutable objects to provide independent state.

7. Explain inner classes and static nested classes.
Answer:
A non-static nested class, commonly called an inner class, is declared inside another class without the static keyword. An inner-class instance is associated with an instance of the enclosing class. It can directly access the enclosing object's instance members, including private members. To create an inner-class object from outside the enclosing class, an enclosing object is normally required.
Example:
class Outer {
    private int value = 10;

    class Inner {
        void display() {
            System.out.println(value);
        }
    }
}


An inner object can access value through its associated Outer instance.
A static nested class is declared with the static keyword. It does not require an enclosing object instance. It can directly access the enclosing class's static members, but it cannot directly access enclosing instance members unless it receives a reference to an enclosing object.
Example:
class Outer {
    static int count = 5;
    int value = 10;

    static class Nested {
        void display() {
            System.out.println(count);
        }
    }
}


A static nested class can be useful for a helper type that belongs conceptually to the outer class but does not need access to a particular outer object. An inner class is useful when the nested object must interact closely with the state of one enclosing object.
Conclusion: Inner classes are associated with an enclosing instance; static nested classes are not.

8. Explain the time complexity of array access, insertion and deletion.
Answer:
An array stores elements in indexed positions. Because the array's indexing scheme allows direct calculation of an element's location, accessing an element at a known index takes \(O(1)\) constant time. The number of other elements does not affect the number of steps needed to access that position.Insertion or deletion in the middle of a fixed-size array is different. To insert an element while preserving order, the elements after the insertion position must be shifted to create space. To delete an element, the elements after that position must be shifted left to fill the gap. In the worst case, a large portion of the array must be moved.Therefore, insertion or deletion in the middle takes \(O(n)\) time in the worst case. A fixed-size array also has limited capacity; if no empty position exists, insertion may require creating another array and copying elements.Conclusion: Access by index is \(O(1)\). Middle insertion and deletion are \(O(n)\) because elements may need to be shifted.

9. How does dynamic method dispatch allow different object types to be processed uniformly?
Answer:
Dynamic method dispatch is the Java mechanism that chooses an overridden instance method implementation at runtime according to the actual class of the object. It is a key feature of runtime polymorphism.A base-class reference can point to an object of a derived class. The reference provides access to members allowed by its declared type, but when an overridden instance method is called, Java executes the implementation belonging to the object's runtime class.For example, an array of Animal references may hold Dog, Cat and Bird objects. If each subclass overrides sound(), a loop can call sound() on every reference. Each object produces its own behaviour without requiring the loop to explicitly check whether the object is a dog, cat or bird.This approach reduces repetitive conditional logic and makes software easier to extend. A new subclass can supply its own implementation without requiring changes to the code that processes the base type, provided the shared contract remains suitable.Conclusion: A common base-type reference allows uniform processing, while dynamic method dispatch selects the correct overridden implementation for each actual object.

10. When should inheritance or an interface be used?
Answer:
Inheritance models an IS-A relationship. A subclass is a specialized kind of its superclass and inherits its accessible state and behaviour. For example, a Dog is an Animal, so Dog extends Animal can be appropriate when the class genuinely represents a specialized animal.An interface models a CAN-DO capability or contract. It specifies behaviour that a class promises to provide without requiring that class to inherit from a particular implementation class. For example, a Phone, an ElectricCar and a Laptop may all be Chargeable, even though they are not the same kind of object and should not necessarily share one superclass.java supports single class inheritance but allows a class to implement multiple interfaces. This makes interfaces particularly useful when a capability crosses otherwise unrelated class hierarchies.The choice should reflect the conceptual relationship, not simply a desire to reuse code. Inheritance is suitable when the subclass is genuinely a specialized form of the parent and can honour the parent's behavioural expectations. An interface is more appropriate when the requirement is a shared capability that multiple different classes can implement.Conclusion: Use inheritance for a genuine IS-A relationship and interfaces for a shared CAN-DO contract.