// 4/25/2019 Java Class Lecture Notes - 

// gonna add a drawing panel to our jpanel for our users
// PaintComponent function is the one that gets called when it's time to actually draw on the screen

// Minimizing, Maximizing, changing size of screen = increments i. Why? bc it redraws paintComponent?
// Not being drawn centered, drawString draws to the right

import java.util.ArrayList;
import java.awt.*;
import Java.awt.event.*;
import javax.swing.*;

public class CS3913Spring2019Graphics {

	static ArrayList<Point> al;

	public static void main (String[] args) {
		JFrame jf = new JFrame("My Program");
		al = new ArrayList<Point>();
		jf.setSize(400, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawingPanel p = new DrawingPanel();
		p.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				al.add(new Point(m.getX(), m.getY()));
			}
		})
		jf.add(p);
		jf.setVisible(true);
	}
}

class DrawingPanel extends JPanel {
	int i;
	DrawingPanel() {
		super();
		i = 0;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int height = this.getSize().height;
		int width = this.getSize().width;
		Font f = g.getFont().deriveFont((float)45);
		g.setFont(f);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.RED);

		g.setColor(Color.BLACK);

		//g.drawString(""+i, width/2, height/2);

		g.drawLine(0, 0, width, height);
		g.drawLine(0, height, width, 0);


		g.setColor(Color.RED);
		int size = 6;
		// g.fillOval(width/2, height/2, size, size);
		for (Point p : CS3913Spring2019Graphics.al) {
			g.fillOval(p.x-size/2, p.y-size/2, size, size);
		}

		i++;
	}
}

class Point {
	int x;
	int y;
	Point(int newx, int newy) { x = newx; y = newy; }
	Point() {this(0, 0);}
}