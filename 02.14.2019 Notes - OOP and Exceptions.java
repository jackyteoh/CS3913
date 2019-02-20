// 02/14/2019 Java Class 3 Lecture Notes - OOP and Exceptions

// Class - outline for an object. the framework for the object
// Object - single instance of a class

// writing definition of a class inside a text file inside the source code. Classes exist as frameworks/ideas in the source code

// Java has a class called the Math class

// Java has Public classes and Default classes
// Public classes: one per file. File is named same as the class.
// Default classes: 

// Public: accessible anywhere. can be created in any place. Anywhere in the program.
// Private: only functions of "thing" class can access
// Protected: Only derived classes can access
// Default class cannot be created in any place. CAN ONLY BE CREATED IN THE SAME PACKAGE
// Default (Package Private): the classes that are inside this package have access to it. Classes in another package do not

package cs3913spring2019classes; // Does the package have to be the same name as the file?
// classes exist inside of a package. NOT MANDATORY
// Packages: a collection of similar classes
// Each .java file can only have 1 package. first line in the file.
import newpackage.NewClass; // in a newClass.java/newpackage.java file with that package

public class CS3913Spring2019Class {
	int x;

	public static void main(String[] args){
		// CS3913Spring2019Class ne = new CS3913Spring2019Classes();
		// ne.x = 10;
		x = 10; 
		// Math m = new Math(); NOT CORRECT
		// System is a class
		// No need to instantiate a Math object. Can simply call Math.sqrt();
		// System.out.println(sqrt(25)); // Doesn't work
		System.out.println(Math.sqrt(25));
		// EVERY JAVA PROGRAM HAS A CLASS THAT NEVER GETS INSTANTIATED
		Thing one = new Thing();
		Thing two = new Thing();
		one.test();
		// newpackage.NewClass n = new newpackage.NewClass(); // How to access another package's class' function?
		// if I say NewClass, I mean newpackage.NewClass
		NewClass n = new NewClass();
		one.insideVar = 100;
		two.insideVar = 200;
		Thing.staticVar = 30;
		System.out.println("one.insideVar" + one.insideVar + "one.staticVar" + one.staticVar);


		Thing three = new OtherThing();
		OtherThing four = (OtherThing) three;

		// pointer to a base class object, if i know the base class type its pointing to, i can point that to the derived class reference
		Counter[] cArr = new Counter[100];
		for (int i = 0; i < 100; i++){
			cArr[i] = new Counter();
		}
		for (Counter c: cArr){
			c.increment();
		}
		System.out.println(Counter.count);

		// Error throwing and catching
		try{
			pitcher();
		}
		catch (Exception e){
			System.out.println("Exception caught:"+e.toString());
		}
		finally {
			System.out.println("You will ALWAYS see this!!");
		}
	}// end of main

	static void pitcher() throws Exception{
		throw new Exception("Yikes... bad bad bad");
	}
}


class Counter{
	static int count;
	void increment() {
		count++;
	}
}

class Thing{ // no operators, no operator overloading. functions can't have default parameters. CANT HAVE DEFAULT PARAMETERS.
	int insideVar; // Instance variable. PACKAGE PRIVATE SO IT CAN WORK

	static int staticVar; // ONLY ONE STATIC VAR. VARIABLE GETS SHARED WITH EVERY INSTANTIATION OF THE THING CLASS
	// gets created AS SOON AS THE CLASS IS CREATED
	Thing(){
		this(42);
	}
	Thing(char c){
		this(42);
		System.out.println(c);
	}
	Thing(int newval){
		insideVar = newval;
	}

	static void staticTest(){
		System.out.println("Hello World!");
		// insideVar = 20; METHOD IS STATIC. NO GUARANTEE THAT AN OBJECT WAS EVER CREATED. THEREFORE, NO GUARANTEE INSIDEVAR WAS EVER CREATED
		// static methods can only access static variables.
		// Instance methods can access both static and instance variable.
	}

	void test(){ // No declaration = package private. Accessible by any class in that package.
		System.out.println("Hello World");
	}
	void test(int i){
		System.out.println(i);
	}
	void test(int i, char c){
		System.out.println(c+' '+i);
	}
	void test(Object... oArr){ // Variable-arity method?
		for(Object o: oArr){ // Creates an Object reference, which is actually a class, with the objects in oArr and prints them out as strings.
			System.out.println(o.toString()); 
		}
		for (int i = 0; i < oArr.length; i++){
			System.out.println(oArr[i].toString());
		}
	}
}

// static: methods can be called without instantiating an object of the other class
// static variables DEFINED INSIDE THE CLASS.
// static variables are stored inside the class.
// Exists only one variable for the class.
// For instance variables, exists one variable for each object.
// Static, one variable for each class.

// Cannot store data inside code
// When you create an object of your class, you're creating an object of your class not an object of the class Class
// Static variables will be stored inside the object for your class object. Not inside the object you instantiate.
// So Thing one's staticVar gets stored in Thing object not one?
// Datatype = Class.