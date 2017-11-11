package ca.mdavidlawson.interview.tree;

/**
 * My Implementation of a Binary Search Tree
 * 
 * @author Dave
 * 
 * @param <T>
 *            The Type of data this tree will store
 */
public class BinarySearchTree<T extends Comparable<T>> extends Tree<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.mdavidlawson.interview.tree.Tree#findLowestCommonAncester(ca.mdavidlawson
	 * .interview.tree.Node, java.lang.Comparable, java.lang.Comparable)
	 */
	@Override
	public Node<T> findLowestCommonAncester(Node<T> head, T value1, T value2) {
		if (head == null) {
			return head;
		}

		if (value1.compareTo(head.value) < 0
				&& value2.compareTo(head.value) < 0) {
			return findLowestCommonAncester(head.left, value1, value2);
		}

		if (value1.compareTo(head.value) > 0
				&& value2.compareTo(head.value) > 0) {
			return findLowestCommonAncester(head.right, value1, value2);
		}

		return head;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.mdavidlawson.interview.tree.Tree#insert(ca.mdavidlawson.interview.
	 * tree.Node, java.lang.Comparable)
	 */
	@Override
	public void insert(Node<T> head, T value) {
		if (value.compareTo(head.value) < 0) {
			if (head.left == null) {
				head.left = new Node<T>(value);
				return;
			}
			insert(head.left, value);
		} else {
			if (head.right == null) {
				head.right = new Node<T>(value);
				return;
			}
			insert(head.right, value);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.mdavidlawson.interview.tree.Tree#search(java.lang.Comparable,
	 * ca.mdavidlawson.interview.tree.Node)
	 */
	@Override
	public Node<T> search(T query, Node<T> head) {

		if (head == null) {
			return null;
		}
		if (query.equals(head.value)) {
			return head;
		}
		if (query.compareTo(head.value) < 0) {
			return search(query, head.left);
		}
		return search(query, head.right);
	}

}
