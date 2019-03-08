// 03.07.2019 Java Lecture Notes - Threads

/*
Thread Methods:
Start - 
Run - 
Sleep - causes the thread to move to blocked. Stores for a certain amount of time
Yield - causes the thread to move from the running state to the ready state
currentThread() - returns a reference to the currently running thread

sema = static. MyThread class is instantiated 5 times. 5 different semaphores == bad 
synchronized(sema) // Equivalent to wait and notify 
need to synchronize on a common object

Synchronizing on the instance, no other synchronized functions in the instance are running at the same time
Synchronizing on the class, no other synchronized functions in the class are running at the same time

Introduction to Java, Data types, loops, branches, array, OOP and exceptions, Windowing(JFrame, JButton, JLabel, layouts), extended classes, 
Nested classes, inheritance, member classes, static classes, anonymous classes, inner classes, THREADS

*/

public class CS3913Spring2019Threads1 {

	public static void main(String[] args){
		for (int i = 0; i < 5; i++){
			new MyThread(i).start();
		}
		Thread mine = Thread.currentThread();
		for(int i = 0; i < 100; i++){
			System.out.println("Main");
			mine.yield();
		}
	}
}

class MyThread extends Thread{
	int i;
	MyThread(int val){
		i = val;
	}
	public void run(){
		for (int i = 0; i < 100; i++){
			System.out.println("Thread");
			yield();
		}
	}	
}

