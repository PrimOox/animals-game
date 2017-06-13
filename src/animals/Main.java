package animals;

import javax.swing.*;

public class Main {

	static final String THINK = "Pense em um animal";
	static final String TITLE = "Animais";
	
	public static void main(String[] args) {
		newGame();		
	}
	
	private static void newGame() {
		BinarySearchTree tree = new BinarySearchTree();
		
		while (JOptionPane.showConfirmDialog(null, THINK, TITLE, JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION)
            tree.preOrder(tree.getRoot());
		
	}
	
}
