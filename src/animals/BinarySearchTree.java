package animals;

import javax.swing.*;

public class BinarySearchTree {

	private Node root;
	static final String ROOT_CARAC = "vive na água";
	static final String ROOT_R = "Macaco";
	static final String ROOT_L = "Tubarão";

	public BinarySearchTree() {
		root = new Caracteristica(ROOT_CARAC);
		root.rChild = new Animal(ROOT_R);
		root.lChild = new Animal(ROOT_L);

		root.rChild.parent = root;
		root.lChild.parent = root;
		root.parent = root;
	}

	public Node getRoot() {
		return root;
	}

	private static void msgWin() {
		JOptionPane.showMessageDialog(null, "Acertei de novo!");
	}

	private static int perguntar(Node node, String what) {
		if (what.equals("caracteristica"))
			return JOptionPane.showConfirmDialog(null,
					String.format("O animal que você pensou %s?", ((Caracteristica) node).caracteristica), "Animais",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		else if (what.equals("adivinhar"))
			return JOptionPane.showConfirmDialog(null,
					String.format("O animal que você pensou é %s?", ((Animal) node).name), "Animais",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		return -1;
	}

	public Node preOrder(Node atual) {
		if (!(atual instanceof Caracteristica))
			return atual;

		if (perguntar(atual, "caracteristica") == 0) {
			atual = preOrder(atual.lChild);

			if (atual != null) {
				if (perguntar(atual, "adivinhar") == 0)
					msgWin();
				else
					inserirNode(atual, "L");
			}
		} else {
			atual = preOrder(atual.rChild);

			if (atual != null) {
				if (perguntar(atual, "guess") == 0)
					msgWin();
				else
					inserirNode(atual, "R");
			}
		}

		return null;
	}

	public void inserirNode(Node noAtual, String val) {
		String animalAtual = ((Animal) noAtual).name;
		String animalNovo = JOptionPane.showInputDialog("Em qual animal você pensou?");

		while (animalNovo == null || animalNovo.isEmpty() || !animalNovo.matches("[A-Z a-z]*"))
			animalNovo = JOptionPane.showInputDialog("Em qual animal você pensou?");

		Animal animal = new Animal(animalNovo);

		String msg = String.format("Um(a) %s _____________ mas um(a) %s não.", animalNovo, animalAtual);
		String diff = JOptionPane.showInputDialog(msg);

		while (diff == null || diff.isEmpty() || !diff.matches("[A-Z a-z]*"))
			diff = JOptionPane.showInputDialog(msg);

		Caracteristica newCaract = new Caracteristica(diff);

		if (val.equals("L"))
			noAtual.parent.lChild = newCaract;
		else if (val.equals("R"))
			noAtual.parent.rChild = newCaract;

		animal.parent = newCaract;
		newCaract.parent = noAtual.parent;
		newCaract.lChild = animal;
		newCaract.rChild = noAtual;
	}

}