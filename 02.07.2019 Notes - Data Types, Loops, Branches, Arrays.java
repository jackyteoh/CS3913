// 02.07.2019 Notes - Data Types, Loops, Branches, Arrays

// Primitive data types, need to declare data types
// Only OTHER classes can exist in the global scope. No variables, no objects, no functions. ONLY CLASSES.

// Java char = 16 bits, 2 bytes unicode
// ' ' = char, " " = string

// no pointers
// in creating an object, not actually na object

// IF you create a class you cannot overload any operator that Java does not want you to overload.
// Impossible to have a memory leak in Java. CANNOT have a memory leak
// create items on the heap, don't have to delete them. Delete is not a thing
// Java has a garbage collector. Comes along periodically and clears any objects that cannot be referenced by your program
// Every new = garbage collector (gc) knows where it is. 
// When gc runs, pauses the program to delete stuff. messes up if real time responsiveness is needed

// System is not an object, it's a class. 
// System has an object called out
// println = print line. prints a return character at the end of the line. = endl
// print = just print. NO return character at the end of the line. no endl

// every int can be stored in a double
// cannot take a double and store it in an int
// loss of precision comes up most frequently

// no else if? elif? in java

// System.out.println() == S.out.pln(); SAME THING


public class CS3913Spring2019Intro1{
	public static void main(String[] args){
		S.out.pln(args.length); // length parameter tells you how many the array can hold
		// args.length returns how many strings there are in the args array
		int x = 5;
		int y = 2;
		System.out.println(x/y); // integer/integer = integer. 5/2 = 2 integer division = floor
		System.out.println(x/2.); // 2. 2d 2f makes it a float/double (decimals)
		System.out.println(x/ (double)y); // casting double to y

		String s; // s is NOT an object
		String s = new String("Daniel Katz");
		S.out.pln(s.length());
		s = "Daniel Katz";
		System.out.println(s); // Error: s is not initialized
		System.out.println();

		int a = 5/2;
		int b = (double)(6/2);
		double d = 5/2;

		Integer i = new Integer(15);

		int[] arr = new int(100); // ARRAYS ARE NOT DYNAMIC. need to specify length of array when created
		for (int i = 0; i < arr.length; i++){ // length would return 100
			arr[i] = i*10;
		}

		int[] temp = new int(arr.length * 2);
		for (int i = 0; i < arr.length; i++){
			temp[i] = arr[i];
		}
		arr = temp; // arr references the new array temp


		String[] test = new String(100); // 0 strings, 100 references. 
		// not primitives, but objects. 
		// creation of objects is not creating objects actually, its just creating a reference to it.
		// we're not creating an array of strings, we're creating an array of references to strings
		for (int i = 0; i < 100; i++){
			test[i] = new String("Hello World!");
		}
		// vector == collection

		int c = 0;
		if (c) { // THIS DOES NOT WORK. POSSIBLE LOSS OF PRECISION. INSIDE IF NEEDS TO BE A BOOLEAN. CANT BE CONVERTED

		}
		if (c != 0){

		}

		if(x){

		}
		else if(y){

		}
		else{

		}

		do{ // this code runs no matter what. at least once

		}
		while(condition){

		}
	}
}
