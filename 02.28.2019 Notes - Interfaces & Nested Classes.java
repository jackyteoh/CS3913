// 02.28.2019 Java Lecture Notes - Interfaces & Nested Classes

// public class: globally accessive
// non-public class: globally accessive, package creation
// Member class: a nested class ccreation from within the outer class
// Static class: A nested class similar to member class, but exists in static context
// inner class: created inside a function across the context (static/instance) of the function
// Anonymous class: An inner class with no name

// member class exists in the instance. can't create a member object within a static context
// static class only has access to the static items in the outer class. is a nested class
// dont have access to everything in the outer class.

// instance items = member class.
// no need of instance, = choose between static or member class

// global class - nested class
/* Class A {
	class Member{
	}
	static class SClass{
	}
}

*/
package CS3913Spring2019NestedClasses;

import java.util.Scanner; // allows you to shorten the name

public class CS3913Spring2019NestedClasses{
	int i;
	public static void main(String[] args){
		Sclass s = new Sclass();
		s.y = 100;
		CS3913Spring2019NestedClasses c2 = new CS3913Spring2019NestedClasses();
		c2.i = 100;
		CS3913Spring2019NestedClasses.Sclass.x = 10;
	}
	void func(){
		// c++ has manifest const, must be known during compile time.
		// java is not manifest. can declare const but assign it a value later?
		// final can be changed once and only once. Once it's set, it cannot be changed.
		Scanner sin = new Scanner(System.in);
		final int z; // final similar to const in c++
		System.out.println("Give me a number: ");
		z = sin.nextInt();
		class Inner{
			void innerFunc(){
				System.out.println(z);
				i = z;
			}
		}
	}
	void func2(){
		new AnotherClass{
			double d;
			void anotherFunc(int newval){
				super.anotherFunc(newval);
				d = 100;
			}
		}.anotherFunc(20);
	}
	static Sclass{
		static int x;
		int y;
	}
}

class AnotherClass{ // Anonymous class?
	int x;
	void anotherFunc(int newval){
		x = newval;
	}
}


// Interface
// Implement 

// Abstract is like pure virtual
/* abstract class Vehicle{
	abstract void putGasIn(double amount);
	abstract boolean isFull();
}
*/

class Vehicle {
	void loadUpTheFamily(){}
}
interface CanPutGasIn{ // Interface = abstract class, and all functions are pure virtual
	void putGasIn(double amount);
	boolean isFull();
}

class Car extends Vehicle implements CanPutGasIn{ //EXTENDS 1, implements many.
	double gasTank;
	double gasTankCapacity;
	void putGasIn(double amount){
		gasTank += amount;
	}
	boolean isFull(){
		return (gasTank == gasTankCapacity);
	}

}

class GasStation{
	double pumpGas(CanPutGasIn c){ // pumpGas can call isFull
		double putIn = 0;
		while (!(c.isFull())){
			c.putGasIn(1);
			putIn++;
		}
		return putIn;
	}
}



/*
Threads:
Process has a number of things assigned to it: Memory, Files, Network Connections. These exist as part of the process
Assigned to the process.

Multithreading
Possible Issues:
Creating too many threads
Concurrency Control
Shared Resources => Concurrency Control becomes the most important
Semaphore: Flag that says that a thread is still using the shared resource.
Capital letter data type for semaphore???
Capital = class. lower case = primitive. PRIMITIVE DONT HAVE SEMAPHORES
Must give up your semaphore before another thread can use it.
wait(), notify()
wait() is called when you need to get into your critical section
notify() is called when you're done with your critical section
wait();
.
.
.
notify();
Protects code from 
Threads get interrupted constantly


*/