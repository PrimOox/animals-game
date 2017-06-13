package animals;

public class Node {

	Node parent;
	Node rChild;
	Node lChild;

}

class Caracteristica extends Node {
	String caracteristica;

	public Caracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

}

class Animal extends Node {
	String name;

	public Animal(final String name) {
		this.name = name;
	}

}
