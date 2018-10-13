
import java.util.Scanner;

/**
 * A person with some properties, such as age and weight.
 */
public class Person {
	public int age; // years
	public int weight; // kg
	public int height; // cm
	public boolean isMale;

	/**
	 * Creates a new person and initializes its properties based on the given row of
	 * data.
	 */
	public Person(String dataRow, int i) throws IllegalPersonFormatException {

		Scanner scanner = new Scanner(dataRow);
		try {
			age = scanner.nextInt();
		} catch (Exception e) {
			throw new IllegalPersonFormatException("Person: " + i + ", Alter ungultig");
		}

		try {
			weight = scanner.nextInt();
		} catch (Exception e) {
			throw new IllegalPersonFormatException("Person: " + i + ", Gewicht ungultig");
		}
		try {
			height = scanner.nextInt();
		} catch (Exception e) {
			throw new IllegalPersonFormatException("Person: " + i + ", Grosse ungultig");
		}
		try {
			isMale = scanner.next().equals("m");
		} catch (Exception e) {
			throw new IllegalPersonFormatException("Person: " + i + ", Geschlecht ungultig");
		}

		if (age <= 0) {
			throw new IllegalPersonFormatException("Person: " + i + ", Alter kleiner als 1");
		}
		if (weight <= 0) {
			throw new IllegalPersonFormatException("Person: " + i + ", Gewicht kleiner als 1");
		}
		if (height <= 0) {
			throw new IllegalPersonFormatException("Person: " + i + ", Grosse kleiner als 1");
		}

	}

	/**
	 * Returns the body mass index of this person (in kg/m²).
	 */
	public int bodyMassIndex() {
		return (10000 * weight) / (height * height);
	}

	@Override
	public String toString() {
		String gender;
		if (isMale) {
			gender = "m";
		} else {
			gender = "w";
		}

		return "Person (" + gender + ", " + age + " Jahre, " + height + " cm, " + weight + " kg)";
	}
}
