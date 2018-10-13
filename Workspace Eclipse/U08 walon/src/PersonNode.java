public class PersonNode {

	Person value;
	PersonNode next;
	// Neu jetzt mit prev
	PersonNode prev;

	public PersonNode(Person value) {
		this.value = value;
	}
}
