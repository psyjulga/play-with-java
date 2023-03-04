import car.Car;
import car.CarDriveException;
import car.NormalCar;
import car.SuperCar;
import generics.DiaryEntry;
import generics.HideMessage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import userdatabase.FileStudentDatabase;
import userdatabase.StudentDatabase;
import userdatabase.StudentDatabaseException;
import weather.WeatherFetcher;
import weather.WeatherInfo;

class HelloWorld {

	public static void aboutStrings() {
		// String => kein primitiver Datentyp
		// deshalb groß geschrieben
		String greeting;
		greeting = "Hello World";
		greeting.length();
		greeting.concat("!!");
		greeting.toLowerCase();
		greeting.toUpperCase();
		greeting.substring(6, 11);
		// "World"
		greeting.charAt(0);

		System.out.println(greeting);
		// f(x)
		// print(x=>Parameter)
	}

	public static void aboutNumbers() {
		long zahl; // 64 Bit Ganzzahl
		zahl = 32 / 3; // 10
		zahl = 32 % 3; // 2
		System.out.println(zahl);

		// Gleitkommazahlen
		double zahl2; // 64 Bit
		zahl2 = 2; // 2.0
		zahl2 = 5 / 2; // 2.0
		// => Es wird automatisch zur Ganzzahl konvertiert
		// bzw mit diesen gerechnet und erst das Ergebnis
		// als Kommazahl ausgegeben !!
		zahl2 = 5.0 / 2; // 2.5
		System.out.println(zahl2);
	}

	public static void aboutChars() {
		char letter = 'g';
		// 'g' + 'a' => Zahlenwerte der Buchstaben
		// werden zuammengerechnet und dann der
		// Buchstabe des addierten Wertes ausgegeben
		System.out.println(letter);
	}

	public static void aboutScanner() {
		// SCANNER CLASS
		Scanner input = new Scanner(System.in);

		System.out.println("Please insert a number");
		System.out.println(input.nextLong());
		// waits for next input of type long
		System.out.println("Please insert your name");
		System.out.println(input.next());
	}

	public static void aboutMathAndSwitch() {
		// MATH
		// Math.abs .ceil .floor .round .min .max
		// .random 0-1
		// .log logarithmus
		// .pow potenzieren
		int a = 123;
		a += 23;
		a++;
		a--;

		switch (a) {
			case 123:
			case 146:
				System.out.println("123 oder 146!!");
				break;
			default:
				System.out.println("Default!!");
				break;
		}
	}

	public static void playWithStrings() {
		String myStr = "my new cool test sentence";
		String splitted[] = myStr.split(" ", 0);
		System.out.println(myStr);
		System.out.println(Arrays.toString(splitted));
		// Arrays.toString !!!!

		for (String a : splitted)
			System.out.println(a);

		System.out.println(splitted[splitted.length - 1]);
		// print last word of a given sentence

		// ODER:
		int position = myStr.lastIndexOf(" ");
		String lastWord = myStr.substring(position + 1);
		System.out.println(lastWord);
	}

	public static void aboutLoops() {
		int i = 0;

		while (i < 3) {
			System.out.println(i);
			i++;
		}

		for (int j = 0; j <= 10; j++) {
			if (j == 3)
				continue;
			// Diese Iteration wird übersprungen
			if (j == 8)
				break;
			// Die Schleife wird abgebrochen
			System.out.println(j);
		}

		int k = 1024;
		while (k % 2 == 0) {
			System.out.println(k);
			k = k / 2;
		}
		System.out.println(k);
	}

	public static void goethe() throws Exception {
		String file = "C:\\Users\\admin\\OneDrive\\Desktop\\Privat\\coding\\Java Udemy\\goethe.txt";
		Scanner input = new Scanner(Paths.get(file));

		int countIch = 0;
		int countSie = 0;

		while (input.hasNext()) {
			String word = input.next();
			word = word.toLowerCase();

			if (word.equals("ich"))
				countIch++;
			if (word.equals("sie"))
				countSie++;

			System.out.println("Ich: " + countIch);
			System.out.println("Sie: " + countSie);
		}
	}

	public static void aboutArrays() {
		String[] names = new String[10]; // array of ten strings
		names[0] = "Julia";
		names[1] = "Hicham";

		System.out.println(Arrays.toString(names));
		// Arrays.toString !!

		Scanner input = new Scanner(System.in);
		System.out.println("Wie viele Katzen hast du?");
		int numCats = input.nextInt();

		String[] cats = new String[numCats];
		System.out.println("Bitte gebe die Katzennamen ein!");

		for (int i = 0; i < cats.length; i++)
			cats[i] = input.next();

		System.out.println(Arrays.toString(cats));

		// for each
		String os[] = { "Windows", "Linux", "Mac" };

		for (String el : os)
			System.out.println(el);
	}

	public static void moreAboutArrays() {
		// mehrdimensionale arrays
		boolean[][] board = new boolean[8][8];

		board[0][1] = true;
		// zeile spalte

		for (boolean[] row : board) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static void ticTacToe() {
		// Gibt es einen Gewinner? Wen?

		// 0 => nicht belegt
		// 1 => Spieler X
		// 2 => Spieler O
		// int[][] game = new int[3][3];
		int[][] game = { { 2, 2, 1 }, { 2, 1, 2 }, { 1, 2, 1 } };

		int playerWon = 0;

		// Zeile für Zeile
		for (int x = 0; x < 3; x++) {
			if (game[x][0] == game[x][1] && game[x][0] == game[x][2]) {
				playerWon = game[x][0];
			}
		}
		// Spalte für Spalte
		for (int x = 0; x < 3; x++) {
			if (game[0][x] == game[1][x] && game[0][x] == game[2][x]) {
				playerWon = game[0][x];
			}
		}

		if (game[0][0] == game[1][1] && game[0][0] == game[2][2])
			playerWon = game[0][0];
		if (game[2][0] == game[1][1] && game[2][0] == game[0][2])
			playerWon = game[2][0];

		System.out.println(playerWon);
	}

	public static void sumExercise() {
		int[][] arr = { { 4, 2 }, { 9, 5, 2 }, { 1 } };

		int sum = 0;

		// for (int i=0; i<arr.length; i++){
		// for (int j=0; j<arr[i].length;j++){
		// sum += arr[i][j];
		// }
		// }

		for (int[] array : arr) {
			for (int item : array) {
				sum += item;
			}
		}

		System.out.println(sum);
	}

	public static void magicArray() {
		int[][] arr = { { 2, 2, 5, 1 }, { 5, 5 }, { 7, 2, 1 } };

		int[] results = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int sum = 0;

			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
			results[i] = sum;
		}
		// oder man nimmt eine for each und eine
		// Counter Variable die man von 0 hoch zählt
		// um einen Index zu haben

		boolean magic = true;

		// es würde reichen immer nur jeweils
		// den ersten Wert results[0] zu vergleichen
		for (int k = 0; k < results.length - 1; k++) {
			if (results[k] != results[k + 1])
				magic = false;
		}

		System.out.println(Arrays.toString(results));

		if (magic)
			System.out.println("Magic Array");
		else
			System.out.println(
					"Simple Array");
	}

	// Objektorientierung
	public static void player() {
		// Player p1 = new Player();
		// p1.name = "Erik";
		// p1.numberOfCards = 12;
		Player p1 = new Player("Erik", 12);

		// Player p2 = new Player();
		// p2.name = "Monika";
		// p2.numberOfCards = 13;
		Player p2 = new Player("Monika", 13);

		p1.playCard();
		p1.playCard();
		p1.printPlayerInfo();
		p2.printPlayerInfo();
	}

	public static void car() {
		Car c = new Car("BMW", 250);

		try {
			c.drive();
		} catch (CarDriveException e) {
			System.out.println("Error in method car");
			e.printStackTrace();
		}

		Car c2 = new Car("Opel");
		// c2.drive();

		// Statische Variable
		c.numCars++;
		c2.numCars++;
		Car.numCars++;
		System.out.println(Car.numCars); // 3
	}

	// WEATHER PROJECT
	public static void weatherProject()
			throws SAXException, IOException, ParserConfigurationException {
		System.out.println("Für welche Stadt möchtest du das Wetter wissen?");

		Scanner input = new Scanner(System.in);
		String city = input.next();

		WeatherFetcher weather = WeatherFetcher.getInstance();
		WeatherInfo[] infos = weather.fetchWeatherInfo(city);
		// ich bekomme ein komplettes WeatherInfo objekt
		// inklusive methoden etc

		for (int x = 0; x < infos.length; x++) {
			WeatherInfo info = infos[x];
			String time = info.getTimestamp();
			String temp = info.getTemperature();
			System.out.println(time + "---" + temp);
		}
	}

	// inheritance
	public static NormalCar createNewCar() {
		return new SuperCar("BMW", 12);
	}

	public static void superCar() {
		NormalCar s = createNewCar();
		s.normalDrive();
		// s.superDrive();
		// the method returns a supercar
		// but as the return type is NormalCar
		// we can't use supercar's methods
		// supercar extends normalcar - so it
		// could as well just be a normalcar
		// java only knows after compilation
		// COMPILE TIME

		// System.out.println(s);
		// car.SuperCar
		// now java knows (RUNTIME)

		// TYPECASTING
		SuperCar s2 = (SuperCar) s;
		// we tell java the type
		// to know at compile time
		s2.superDrive();
		System.out.println(s);
		System.out.println(s2);
		// same object
		// car.SuperCar@5acf9800
		// ------------ unique ID
	}

	public static void interfaces() {
		Car[] cars = new Car[6];
		cars[0] = new Car("Bmw", 300);
		cars[1] = new Car("VW", 90);
		cars[2] = new Car("Opel", 260);
		cars[3] = new Car("Audi", 260);
		cars[4] = new Car("Bmw", 260);
		cars[5] = new Car("Bentley", 260);

		// Car extends Comparable
		// compareTo => -1, 0, 1
		Arrays.sort(cars);

		for (Car car : cars) {
			System.out.println(car);
		}
	}

	public static void carEquals() {
		Car c1 = new Car("BMW", 300);
		Car c2 = new Car("BMW", 300);
		Car c3 = new Car("BMW", 250);

		boolean b1 = c1.equals(c2);
		boolean b2 = c1.equals(c3);

		System.out.println(b1 + " " + b2);
	}

	public static void exceptionHandling() {
		Car c = new Car("Audi", 10);
		Car d = new Car("Audi", 0);

		try {
			c.drive();
		} catch (CarDriveException e) {
			// EXCEPTION => error handling
			System.out.println("Fehler in Drive Methode hp10");
		} catch (ArithmeticException e) {
			// RUNTIME EXCEPTION
			// normalerweise kein handling
			// Programmierfehler sollen Ausführung stoppen
			System.out.println("Division durch 0");
		}

		// if hp is 0 => throws custom exception
		try {
			d.drive();
		} catch (CarDriveException e) {
			System.out.println("Fehler in Drive Methode hp0 => " + e.getMessage());
		}

		System.out.println("After try catch");
	}

	public static void fileReader() {
		// note: new language feature => try()
		// create reader in brackets
		// closes file automatically
		// no finally needed

		BufferedReader b = null;

		try {
			FileReader r = new FileReader("testfile.txt");
			b = new BufferedReader(r);
			// buffered reader => mehr Funktionen
			while (b.ready()) {
				String line = b.readLine();
				System.out.println(line);
			}
			// file reader => only basic functions
			// char[] output = new char[11];
			// r.read(output);
			// füllt den Array
			// System.out.println(output);
			// r.read(output);
			// füllt den Array erneut
			// merkt sich den letzten Stand
			// System.out.println(output);
		} catch (FileNotFoundException e) {
			System.out.println("error by opening file");
		} catch (IOException e) {
			System.out.println("error by reading file");
		}
		// Es können nicht beliebig viele Dateien gleichzeitig geöffnet sein
		// Kernel hat Limit
		// file = RESOURCE
		// Ressourcen immer schließen!
		// "Resource leak: b is never closed"
		finally {
			try {
				if (b != null)
					b.close();
			} catch (IOException e2) {
				System.out.println("error by closing file");
			}
		}
	}

	public static void databaseProject() {
		StudentDatabase sd = new FileStudentDatabase();
		// inteface ------------ concrete implementation

		try {
			sd.addStudent("new student1");
			sd.addStudent("new student2");

			String[] students = sd.readAllStudents();

			for (String student : students) {
				System.out.println(student);
			}
		} catch (StudentDatabaseException e) {
			System.out.println("students could not be read");
			e.printStackTrace();
		}
	}

	public static void genericClasses() {

		HideMessage<String> hms = new HideMessage<String>("hidden message");
		String hiddenMsg = hms.getMessage("test");
		System.out.println(hiddenMsg);

		DiaryEntry entry = new DiaryEntry();
		HideMessage<DiaryEntry> hmd = new HideMessage<DiaryEntry>(entry);
		DiaryEntry e = hmd.getMessage("test");
		String title = e.title;
		System.out.println(title);

	}

	public static void collections() {

		// ArrayList
		// Größe flexibel
		// Java intern => Array
		ArrayList<String> students = new ArrayList<>();
		students.add("Erik");
		students.add("Monika");
		students.add("Mia");
		students.add("Bernd");

		students.remove("Erik");
		students.remove(0);

		Collections.sort(students);

		// students.clear();
		// deletes all

		for (String student : students)
			System.out.println(student);

	}

	// ENTRY POINT => will be run
	public static void main(String[] args) throws Exception {
		// aboutStrings();
		// aboutNumbers();
		// aboutChars();
		// aboutScanner();
		// aboutMathAndSwitch();
		// playWithStrings();
		// aboutLoops();
		// goethe();
		// aboutArrays();
		// moreAboutArrays();
		// ticTacToe();
		// sumExercise();
		// magicArray();
		// player();
		// car();
		// weatherProject();
		// superCar();
		// interfaces();
		// carEquals();
		// exceptionHandling();
		// fileReader();
		// databaseProject();
		// genericClasses();
		collections();
	}
}
