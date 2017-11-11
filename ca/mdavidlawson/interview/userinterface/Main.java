package ca.mdavidlawson.interview.userinterface;

import java.util.Random;
import java.util.Scanner;

import ca.mdavidlawson.interview.tree.BinarySearchTree;
import ca.mdavidlawson.interview.tree.Node;

/**
 * Simply displays a basic menus system to allow the user to create and display
 * a Tree. Currently only Binary Search Trees are supported
 * 
 */
public class Main {


	/**
	 * Display the main menu and init the scanner to capture user input
	 * 
	 * @param args
	 *            Not used
	 */
	public static void main(String[] args) {

		System.out.println("Welcome to Dave's Tree Program \n");

		// bind scanner to system in and ensure it's always closed
		Scanner userScanner = new Scanner(System.in);
		try {
			// show the main menu
			mainMenu(userScanner);
		} finally {
			userScanner.close();
		}
	}


	/**
	 * Display main menu
	 * 
	 * @param scanner
	 *            Scanner to use to capture user input.
	 */
	private static void mainMenu(Scanner scanner) {
		while (true) {
			System.out.println("=== Main menu ===");
			System.out.println("[1] Create A new Binary Search Tree");
			System.out.println("[q] Exit");
			System.out.println("Selection: ");
			switch (scanner.next()) {
			case "1":
				binarySearchTreeSelectionMenu(scanner);
				break;
			case "q":
				System.exit(0);
				break;
			default:
				System.out.println("Invalid response");
				continue;
			}
		}
	}
	/**
	 * Main Binary Tree interaction menu. Allows the user to perform various
	 * operations on the tree
	 * 
	 * @param scanner
	 *            Scanner to use to capture user input
	 * @param tree
	 *            The tree as it can be of any data type
	 */
	private static void binarySearchTreeMainMenuInteger(Scanner scanner,
			BinarySearchTree<Integer> tree) {

		// commonly used variables
		Integer firstNode, secondNode;
		Node<Integer> resultNode;
		Random rand = new Random(System.currentTimeMillis());
		while (true) {
			System.out.println("\n\n=== Binary Tree Menu ===");
			tree.print();

			System.out.println("[1] Add data to Tree");
			System.out.println("[2] Print Tree");
			System.out.println("[3] Display using traversal methods");
			System.out.println("[4] Search");
			System.out.println("[5] Find common ancester");
			System.out.println("[6] Populate with sample data");
			System.out.println("[b] back ");
			System.out.println("[q] Exit");

			System.out.println("Please make a selection: ");
			switch (scanner.next()) {
			case "1":
				while (true) {
					// add data to the tree
					System.out.println("Enter value to add: ");
					if (scanner.hasNextInt()) {
						tree.insert(scanner.nextInt());
						break;
					}
					System.out.println("Invalid input, must be an integer");
					scanner.next();
				}
				break;
			case "2":
				// print the tree
				tree.print();
				break;
			case "3":
				// traverse the tree
				while (true) {
					System.out.println("Which traversal method?");
					System.out.println("[1] pre order");
					System.out.println("[2] in order");
					System.out.println("[3] post order");
					System.out.println("Please make a selection: ");
					switch (scanner.next()) {
					case "1":
						tree.printPreOrderTraversal();
						break;
					case "2":
						tree.printInOrderTraversal();
						break;
					case "3":
						tree.printPostOrderTraversal();
						break;
					default:
						System.out.println("invalid selection");
						continue;

					}
					break;
				}
				break;
			case "4":
				// search for the existance of a value
				while (true) {
					System.out.println("Enter your search query: ");
					if (scanner.hasNextInt()) {
						resultNode = tree.search(scanner.nextInt());
						System.out
								.println(resultNode == null ? "Node is not present"
										: "Node is present");
						break;
					}
					System.out.println("Invalid input, must be Integer");
					scanner.next();
					;
				}
				break;
			case "5":
				// search for the lowest common ancestor
				while (true) {
					System.out.println("First Node:");
					if (scanner.hasNextInt()) {
						firstNode = scanner.nextInt();
					} else {
						System.out.println("Invalid input, must be Integer");
						scanner.next();
						continue;
					}
					break;
				}

				while (true) {
					System.out.println("Second Node:");
					if (scanner.hasNextInt()) {
						secondNode = scanner.nextInt();

						resultNode = tree.findLowestCommonAncester(firstNode,
								secondNode);
						System.out.println("Result is: ");
						System.out.println(resultNode);
					} else {
						System.out.println("Invalid input, must be Integer");
						scanner.next();
						continue;
					}

					break;
				}
				break;
			case "6":
				for (int i = 0; i < rand.nextInt(15); ++i) {
					tree.insert(rand.nextInt(20));
				}
				break;
			case "q":
				System.exit(0);
			case "b":
				return;
			default:
				System.out.println("Invalid response");
				continue;
			}

		}
	}

	private static void binarySearchTreeMainMenuString(Scanner scanner,
			BinarySearchTree<Character> tree) {

		// commonly used variables no need to instantiate every time the loop is
		// run
		char firstNode, secondNode;
		Node<Character> resultNode;
		String tempUserSelection;
		Random rand = new Random(System.currentTimeMillis());
		while (true) {
			System.out.println("\n\n=== Binary Tree Menu ===");
			tree.print();

			System.out.println("[1] Add data to Tree");
			System.out.println("[2] Print Tree");
			System.out.println("[3] Display using traversal methods");
			System.out.println("[4] Search");
			System.out.println("[5] Find common ancester");
			System.out.println("[6] Populate with sample data");
			System.out.println("[b] back ");
			System.out.println("[q] Exit");

			System.out.println("Please make a selection: ");
			switch (scanner.next()) {
			case "1":
				// add data to the tree
				System.out.println("Enter value to add: ");
				tempUserSelection = scanner.next();

				// warn of truncation
				if (tempUserSelection.length() > 1) {
					System.out
							.println("Input will be truncated, using only the first char");
				}

				tree.insert(tempUserSelection.charAt(0));
				break;
			case "2":
				// print the tree
				tree.print();
				break;
			case "3":
				// traverse the tree
				while (true) {
					System.out.println("Which traversal method?");
					System.out.println("[1] pre order");
					System.out.println("[2] in order");
					System.out.println("[3] post order");
					System.out.println("Please make a selection: ");
					switch (scanner.next()) {
					case "1":
						tree.printPreOrderTraversal();
						break;
					case "2":
						tree.printInOrderTraversal();
						break;
					case "3":
						tree.printPostOrderTraversal();
						break;
					default:
						System.out.println("invalid selection");
						continue;

					}
					break;
				}
				break;
			case "4":
				// search for the existence of a value
				System.out.println("Enter your search query: ");
				tempUserSelection = scanner.next();

				// warn of truncation
				if (tempUserSelection.length() > 1) {
					System.out
							.println("Input will be truncated, using only the first char");
				}

				resultNode = tree.search(tempUserSelection.charAt(0));
				System.out.println(resultNode == null ? "Node is not present"
						: "Node is present");
				break;
			case "5":
				// search for the lowest common ancestor

				System.out.println("First Node:");
				tempUserSelection = scanner.next();
				if (tempUserSelection.length() > 1) {
					System.out
							.println("Input will be truncated, using only the first char");
				}
				firstNode = tempUserSelection.charAt(0);

				System.out.println("Second Node:");
				tempUserSelection = scanner.next();
				if (tempUserSelection.length() > 1) {
					System.out
							.println("Input will be truncated, using only the first char");
				}
				secondNode = tempUserSelection.charAt(0);

				resultNode = tree.findLowestCommonAncester(firstNode,
						secondNode);
				System.out.println("Result is: ");
				System.out.println(resultNode);

				break;
			case "6":
				for (int i = 0; i < rand.nextInt(15); ++i) {
					tree.insert((char) (rand.nextInt(24) + 'a'));
				}
				break;
			case "q":
				System.exit(0);
			case "b":
				return;
			default:
				System.out.println("Invalid response");
				continue;
			}
		}

	}

	/**
	 * Displays prompt to create Integer or Character binary search tree.
	 * 
	 * @param scanner
	 *            Scanner to use to capture user input
	 */
	private static void binarySearchTreeSelectionMenu(Scanner scanner) {
		while (true) {
			System.out.println("=== New Binary Tree ===");
			System.out.println("[1] Integer binary tree");
			System.out.println("[2] Char binary tree");
			System.out.println("[b] Back to main menu");
			System.out.println("[q] Exit");
			switch (scanner.next()) {
			case "1":
				binarySearchTreeMainMenuInteger(scanner,
						new BinarySearchTree<Integer>());
				break;
			case "2":
				binarySearchTreeMainMenuString(scanner,
						new BinarySearchTree<Character>());
				break;
			case "q":
				System.exit(0);
			case "b":
				return;
			default:
				System.out.println("Invalid response");
				continue;

			}
		}

	}
}
