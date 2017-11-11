package ca.mdavidlawson.interview.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility class for printing Trees.
 * 
 * Code adapted from
 * http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
 */
public class BTreePrinter {

	/**
	 * Check if each element is null in the tree
	 * 
	 * @param list
	 *            the list of nodes
	 * @return
	 */
	private static <T extends Comparable<T>> boolean isAllElementsNull(
			List<Node<T>> list) {
		for (Node<T> node : list) {
			if (node != null)
				return false;
		}

		return true;
	}

	/**
	 * Calculate the max level of the tree, the highest node
	 * 
	 * @param TreeNode
	 * @return
	 */
	private static <T extends Comparable<T>> int maxLevel(Node<T> TreeNode) {
		if (TreeNode == null)
			return 0;

		return Math.max(BTreePrinter.maxLevel(TreeNode.left),
				BTreePrinter.maxLevel(TreeNode.right)) + 1;
	}

	/**
	 * Print a node in the tree
	 * 
	 * @param list
	 *            The nodes in the tree
	 * @param level
	 *            the current level to print
	 * @param maxLevel
	 *            The max level of the tree, the height
	 */
	private static <T extends Comparable<T>> void printTreeNode(
			List<Node<T>> list, int level, int maxLevel) {

		// Ensure there's something to print
		if (list.isEmpty() || BTreePrinter.isAllElementsNull(list)) {
			return;
		}

		// calculations to help with placing /'s and whitespace
		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		// Print the whitespace to the root node
		BTreePrinter.printWhitespaces(firstSpaces);

		// If the node is null then we just need to fill in spaces to the next
		// node
		List<Node<T>> newTreeNodes = new ArrayList<Node<T>>();
		for (Node<T> TreeNode : list) {
			if (TreeNode != null) {
				System.out.print(TreeNode.value);
				newTreeNodes.add(TreeNode.left);
				newTreeNodes.add(TreeNode.right);
			} else {
				newTreeNodes.add(null);
				newTreeNodes.add(null);
				System.out.print(" ");
			}

			BTreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		// Start printing the tree branches. Branches will be printed using / if
		// their left and \ if their right
		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < list.size(); j++) {
				BTreePrinter.printWhitespaces(firstSpaces - i);
				if (list.get(j) == null) {
					BTreePrinter.printWhitespaces(endgeLines + endgeLines + i
							+ 1);
					continue;
				}

				if (list.get(j).left != null)
					System.out.print("/");
				else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(i + i - 1);

				if (list.get(j).right != null)
					System.out.print("\\");
				else
					BTreePrinter.printWhitespaces(1);

				BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printTreeNode(newTreeNodes, level + 1, maxLevel);
	}

	/**
	 * Start printing the Tree
	 * 
	 * @param root
	 *            the root of the tree
	 */
	public static <T extends Comparable<T>> void printTreeNode(Node<T> root) {

		int maxLevel = BTreePrinter.maxLevel(root);
		printTreeNode(Collections.singletonList(root), 1, maxLevel);
	}

	/**
	 * Print a number of whitespace characters
	 * 
	 * @param count
	 *            the number of spaces to print
	 */
	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

}