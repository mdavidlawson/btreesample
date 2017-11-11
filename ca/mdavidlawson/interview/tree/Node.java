package ca.mdavidlawson.interview.tree;

/**
 * Simple node to store some sort of data
 * 
 * @author Dave
 * 
 * @param <K>
 *            The data to store
 */
public class Node<K extends Comparable<K>> implements Comparable<K> {
	Node<K> left;
	Node<K> right;
	K value;

	public Node(K value2) {
		value = value2;
	}

	@Override
	public int compareTo(K o) {
		return value.compareTo(o);
	}

	@Override
	public String toString() {
		return value.toString();
	}

}