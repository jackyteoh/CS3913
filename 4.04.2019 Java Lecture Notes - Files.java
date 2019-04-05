// 04.04.2019 Java Lecture Notes - Files

// Erase the first character in the directory, data still there, but
// When "Delete", doesn't actually delete the data
// Just says the sector is free, data is still there
// SSD is read only, EEPROM? electrical eraseable programmable 
// SSD is eraseable, erase one sector, then rewrite
// Screening Disk drive? Change one bit/byte
// Deleting on SSD, undeleting is impossible. Erase = trim = array of physical storage, also has mapping of logical sector number to actual physical sector number
// LS 0 --> PS 0, etc. extra space at end. Trim sector 0, stores sector 0 at 182903021830, and then erases sector 0 when it gets to it.
// Spreads the ssd wear
// SSD is like writing and erasing on paper

public static void main (string[] args) {
	File f = new File(".");
	File[] arr = f.listfiles();
	for (File thing : arr) {
		if (thing.isDirectory()) {
			System.out.println(thing.getName()+" <DIR>");
		}
		else {
			// System.out.println(thing.getName());
			Scanner sin = new Scanner(thing);
			while (sin.hasNext()) {
				System.out.print(sin.next() + " ");
			}
		}
	}

	// Dataoutputstream
	Printstream ps = new PrintStream("PSOut.txt");
	Printstream ps = new PrintStream(new FileOutputStream(new File("PSOut.txt"))); //UTF-16
	int x = 512;
	ps.print(x);
	ps.println("Hello World");
	Dataoutputstream dos = new Dataoutputstream(new FileOutputStream(new File("DOSOut.txt"))); // doesn't write the file correctly, blank
	dos.writeInt(x); // Writes in ASCII?
	dos.writeInt(1024); // no indication of differentiation between integers. You have to know what's where in the file. 
	dos.close();
	ps.close();
	Scanner sin = new Scanner("PSOut.txt");
	System.out.println("Processing PSOut.txt");
	while (sin.hasNextInt()) {
		System.out.println(sin.nextInt());
	}
	System.out.println("Done processing PSOut.txt");

	DataInputStream ds = new DataInputStream(new FileInputStream(new File("DSOut.txt")));
	Scanner sin = new Scanner("PSOut.txt");
	System.out.println("Processing PSOut.txt");
	while (sin.hasNextInt()) {
		System.out.println(sin.nextInt());
	}
	System.out.println("Done processing PSOut.txt");
	//stx = 2
	// null null stx null

	// printstream takes file name, scanner doesnt take just file name. Scans a string, not a file.
}