// 02.21.2019 Notes - Windowing & Extending Classes

package cs3913spring2019; 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
class CS3913SpringNotes{
	public static void main(String[] args){

	}
}
*/

class A{
	int x;
	A(){
		this(0);
	}
	A(int newx){
		x = newx;
	}
	int getx() {
		return x;
	}
}

class B extends A{
	double d;
	B(){
		// super(0); // First line of the constructor MUST be super. Only place you can call super.
		this(0); // Call to sibling constructor B(int newx);
		// this call is calling the sibling constructor
	}
	B(int newx){
		super(newx);
		d = 100;
	}
	@Override // What does this do? Documentation?
	int getx() {
		return super.getx()+1;
	}
}

public class CS3913Spring2019Window1{
	static Jframe jf;
	static Jpanel jp;
	static JButton jb;

	public static void main(String[] args){
		// Event driven programming. Different than procedural programming.
		// Procedural: programmer knows all the steps
		// Event driven: set up handlers for code. Wait for events to happen. Order of execution not defined.
		// Just set up responses and wait for events to happen. 
		// Define classes and functions so that each one will handle a situation that's occurring. 
		// 


		// nested class
		class ButtonPress implements ActionListener{ // implements == extends. ActionListener is an interface.
			public static actionPerformed(ActionEvent ae){
				JButton theButton = (JButton)ae.getSource();
				theButton.setText("Yeah, you pressed me!");
				theButton.setEnabled(false);
			}
		}
		jf = new JFrame("Hello World!");
		jf.setSize(400, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jb = new JButton("Press Me!");
		// jb is not a button, jb is a reference to the button. 
		// once the object has been added to the panel, i don't need to reference it anymore
		// how to access it?
		// jb.addActionListener(new ButonPress());
		jb.addActionListener(new ActionListener()){ // actionListener = abstract class. no object 
			public void actionPerformed(ActionEvent ae){ // ANONYMOUS CLASS. CLASS THAT IS CREATED. 
				// OBJECT OF THAT CLASS IS CREATED. AND PASSED TO ACTIONLISTENER ALL IN ONE SHOT.
				// CAN CREATE AS MANY ANONYMOUS CLASSES AS NEEDED.
				JButton theButton = (JButton)ae.getSource();
				theButton.setText("I'm a little teapot!");
				theButton.setEnabled(false);
			}
		}
		JButton jb2 = new JButton("No Press Me!");
		jb2.addActionListener(new ButtonPress());
		jp = new JPanel();
		// jf.add(jb);
		// jf.add(jb2);
		// once jp.add(jb), you can reassign jb to another new button and then jp.add(jb) again.
		// Then you'll have 2 buttons
		jp.add(jb);
		jp.add(jb2);

		jf.add(jp);
		jf.setVisible(true)
	}


	class A{
		int x;
		A(int newx){
			x = newx;
		}
		int getx() {
			return x;
		}
	}

	void func(){
		A a = new A(100);
		A b = new A(100){

			@Override
			int getx(){
				return super.getx()+1;
			}
		};
		System.out.println(a.getx()); // prints 100
		System.out.println(b.getx()); // prints 101?
	}

}


// interfaces get implemented, classes get extended
class ButtonPress implements ActionListener{ // implements == extends. ActionListener is an interface.
	public static actionPerformed(ActionEvent ae){
		JButton theButton = (JButton)ae.getSource();
		theButton.setText("Yeah, you pressed me!");
		theButton.setEnabled(false);
	}
}

// Sequential Layout [] [] [] once runs out of space, next line. don't control the layout
// simply put things on in the order that you want, Java will arrange them for you
// Sequential is the default layout. Each is a class. Assign layout by creating new object of the class
// and call set layout function. BORING. PROB NOT GONNA USE

// Grid Layout. Has a constructor that requires a min of 2 things. (rows, columns) or (rows, col, hgap, vgap)
// Things will be organized according to the input

// Border layout. Defines a border in which you can place things. Place them in any order.
// Also defines constants for BorderLayout.North, West, South, East, Center, etc.
// When putting, must also specify WHERE its going ^

// You can place a panel on a panel.


public class CS3913Spring2019Window2 {
	static PressCounter count;
	static JLabel iLabel;
	static JLabel upLabel;
	static JLabel downLabel;
	static JLabel pressLabel;
	static JButton upButton;
	static JButton downButton;

	public static void main(String[] args){
		count = new PressCounter();
		JFrame jf = new JFrame("Welcome to my program!");
		jf.setSize(800, 800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel inner = new JPanel();
		Jpanel top = new JPanel();
		JPanel bottom = new JPanel();
		inner.setLayout(new BorderLayout());
		top.setLayout(new GridLayout(6, 3));
		bottom.setLayout(new GridLayout(3, 5));
		inner.add(top, BorderLayout.NORTH);
		inner.add(bottom, BorderLayout.SOUTH);

		jf.add(inner);
		jf.setVisible(true);
	}

	void uglyTopFunc(JPanel jp){
		jp.add(new Jlabel());
		jp.add(new Jlabel());
		jp.add(new Jlabel());
		jp.add(new Jlabel());
		jp.add(iLabel);
		jp.add(new JLabel());
		jp.add(new JLabel());
		jp.add(upLabel);
		jp.add(new JLabel());
		jp.add(new JLabel());
		jp.add()
	}


	static class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e){
			JButton action = (JButton)e.getSource();
			if (action == upButton){
				count.i++;
				count.ups++;
			}
			else{
				count.i++;
				count.downs++;
			}
			iLabel.setText("i="+count.i);
			upLabel.setText("Up="+count.ups);
			downLabel.setText("Down="+count.downs);
			pressLabel.setText("Presses="+(count.ups+count.downs));
		}
	}

	static class PressCounter{
		int i;
		int ups;
		int downs;
		PressCounter(){
			i = 0;
			ups = 0;
			downs = 0;
		}
	}
}


