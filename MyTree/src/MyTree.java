/*
 * Lucy Gormley
 * Creates Binary Search tree, removes element as requested by user
 * Displays tree in levelOrder and InOrder Traversal
 * Displays max and min values
 * Removes min value and displays remaining tree in InOrder Traversal
 */

import java.util.Scanner;
import java.util.Iterator;

public class MyTree 
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<Integer>();

		//Question 1 - creates BST and prints values in ascending order

		tree.addElement(new Integer(26));  
		tree.addElement(new Integer(34));
		tree.addElement(new Integer(12));
		tree.addElement(new Integer(78));
		tree.addElement(new Integer(14));
		tree.addElement(new Integer(45));
		tree.addElement(new Integer(32));
		tree.addElement(new Integer(50));
		tree.addElement(new Integer(8));
		tree.addElement(new Integer(12));

		Iterator<Integer> iterator = tree.IteratorInOrder();

		System.out.println("Binary Search Tree Values: \n");		
		while (iterator.hasNext())
			System.out.print(iterator.next()+ "  ");


		//Question 2 - LevelOrder Traversal

		Iterator<Integer> iteratorLO = tree.iteratorLevelOrder();

		System.out.println("\n\nBinary Search Tree in LevelOrder Traversal: \n");		
		while (iteratorLO.hasNext())
			System.out.println(iteratorLO.next()+ "  ");


		//Question 3 - Find Value - User inputs value, if found, value will be removed in q4

		System.out.print("\nEnter the value you are looking for> ");
		int inputValue = scan.nextInt();
		scan.nextLine();
		Integer found = tree.find(inputValue);
		if (found==null)
		{
			System.out.println("\nRequested element not found.");
		}
		else
		{
			System.out.println("\nRequested element found.");
		}


		//Question 4 - Remove requested element- value input by user is removed from tree

		if (found==null)
		{
			System.out.println("\nRequested element could not be removed from tree.");
		}
		else
		{
			System.out.println("\nRequested element removed from tree.");
			tree.removeElement(inputValue);
			iterator = tree.IteratorInOrder();
		}


		//Question 5 - Inorder Traversal

		iterator = tree.IteratorInOrder();

		System.out.println("\nRemaining Binary Search Tree in Inorder traversal: \n");		
		while (iterator.hasNext())
			System.out.println(iterator.next()+ "  ");


		//Question 6 - FindMax() - finds max value and prints in q7

		tree.findMax();

		//Question 7 - prints max value of bst

		System.out.print("\nMaximum value of Binary Search Tree: " + tree.findMax());


		//Question 8 + 9 - removeMin() method in LinkedBinarySearchTree class

		System.out.print("\nMinimum value of Binary Search Tree is " + tree.findMin() + ", and has been removed from the tree.");
		tree.removeMin();

		iterator = tree.IteratorInOrder();
		System.out.println("\nRemaining Binary Search Tree in Inorder traversal: \n");		
		while (iterator.hasNext())
			System.out.println(iterator.next()+ "  ");
	}

}