package ca.mdavidlawson.interview.tree;

/**
 * Abstract Tree implementation. Defines many operations of a tree and leaves
 * only operations which vary from Tree to Tree
 * 
 * @author Dave
 * 
 * @param <T>
 *            Type of data to store
 */
public abstract class Tree<T extends Comparable<T>> {
	/**
	 * The head or root of the tree
	 */
	protected Node<T> root;

	/**
	 * Find the lowest common ancestor assuming this is not a BST
	 * 
	 * @param root
	 *            The root of the tree
	 * @param node1
	 *            The first node
	 * @param node2
	 *            The second node
	 * @return The first parent node such that both nodes are dependents of that
	 *         parent
	 */
	public Node<T> findLowestCommonAncester(Node<T> root, T node1, T node2) {
		if (root == null) {
			return null;
		}
		if (root.value.equals(node1) || root.value.equals(node2)) {
			return root;
		}
		Node<T> left = findLowestCommonAncester(root.left, node1, node2);
		Node<T> right = findLowestCommonAncester(root.right, node1, node2);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		return right;

	}

	/**
	 * Find the lowest common ancestor assuming this is not a BST
	 * 
	 * @param node1
	 *            The first node
	 * @param node2
	 *            The second node
	 * @return The first parent node such that both nodes are dependents of that
	 *         parent
	 */
	public Node<T> findLowestCommonAncester(T node1, T node2) {
		return findLowestCommonAncester(root, node1, node2);
	}

	/**
	 * Insert a node
	 * 
	 * @param root
	 *            The root node to insert from
	 * @param value
	 *            The value to insert
	 */
	public abstract void insert(Node<T> root, T value);

	/**
	 * Insert a new node. If there's no root node yet, make one.
	 * 
	 * @param value
	 *            The value of the node
	 */
	public void insert(T value) {
		if (root == null) {
			root = new Node<T>(value);
			return;
		}
		insert(root, value);
	}

	/**
	 * Print the tree
	 */
	public void print() {
		BTreePrinter.printTreeNode(root);
	}

	/**
	 * Print the tree using in order traversal
	 */
	public void printInOrderTraversal() {
		printInOrderTraversal(root);

	}

	/**
	 * Print a comma delimited list of node values after traversing the tree
	 * using the in order strategy. On a BST this will return an ordered list.
	 * 
	 * @param root
	 *            The root node to begin traversal at
	 */
	public void printInOrderTraversal(Node<T> root) {
		if (root == null) {
			return;
		}
		System.out.print(", ");
		printInOrderTraversal(root.left);
		System.out.print(", " + root);
		System.out.print(", ");
		printInOrderTraversal(root.right);
	}

	/**
	 * Print the tree using post order traversal
	 */
	public void printPostOrderTraversal() {
		printPostOrderTraversal(root);

	}

	/**
	 * Print a comma delimited list of node values after traversing the tree
	 * using the Post Order strategy.
	 * 
	 * @param root
	 *            The root node to begin traversal at
	 */
	public void printPostOrderTraversal(Node<T> root) {
		if (root == null) {
			return;
		}
		System.out.print(", ");
		printInOrderTraversal(root.left);
		System.out.print(", ");
		printInOrderTraversal(root.right);
		System.out.print(", " + root);
	}

	/**
	 * Print the tree using pre order traversal
	 */
	public void printPreOrderTraversal() {
		printPreOrderTraversal(root);

	}

	/**
	 * Print a comma delimited list of node values after traversing the tree
	 * using the Pre Order strategy.
	 * 
	 * @param root
	 *            The root node to begin traversal at
	 */
	public void printPreOrderTraversal(Node<T> root) {
		if (root == null) {
			return;
		}
		System.out.print(", ");
		System.out.print(root);
		System.out.print(", ");
		printPreOrderTraversal(root.left);
		System.out.print(", ");
		printPreOrderTraversal(root.right);
	}

	/**
	 * Reverse all nodes in the Tree
	 */
	public void reverseTree() {
		reverseTree(root);
	}

	/**
	 * Reverse all nodes in the tree
	 * 
	 * @param node
	 *            Root node to reverse from
	 */
	public void reverseTree(Node<T> node) {
		if (node == null) {
			return;
		}
		Node<T> temp = node.left;
		node.left = node.right;
		node.right = temp;
		reverseTree(node.left);
		reverseTree(node.right);
	}

	/**
	 * Search for a node in the tree
	 * 
	 * @param query
	 *            The value to search for
	 * @return A node or null if there's no node by that value in the Tree.
	 *         Depending on implementation the first or last of a duplicate
	 *         valued node may be returned
	 */
	public Node<T> search(T query) {
		return search(query, root);
	}

	/**
	 * Search for a node in the tree
	 * 
	 * @param query
	 *            The value to search for
	 * @param root
	 *            The root node to search from
	 * @return A Node or Null if there's no node by that value in the Tree.
	 *         Depending on implementation the first or last of a duplicate
	 *         valued node may be returned
	 */
	public abstract Node<T> search(T query, Node<T> root);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		BTreePrinter.printTreeNode(root);
		return "";
	}

}
