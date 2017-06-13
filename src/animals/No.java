package animals;

public class No {

	No parent;
	No rChild;
	No lChild;

}

class Caracteristica extends No {
	String caracteristica;

	public Caracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

}

class Animal extends No {
	String name;

	public Animal(final String name) {
		this.name = name;
	}

}
