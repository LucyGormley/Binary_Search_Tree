/*
 * Lucy Gormley
 * C16334766 - Lab exam 1
 */

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
	protected int count;
	protected BinaryTreeNode<T> root;
	
	
	// Constructor - Create an empty binary tree
	public LinkedBinaryTree(){
		count=0;
		root = null;
		
	}
	// Constructor - Create a binary tree with element
	public LinkedBinaryTree(T element){
		count=1;
		root = new BinaryTreeNode<T>(element);
		
	}

	public T getRoot(){
		return root.element;
	}
	
	public boolean isEmpty(){
		if (count==0)
			return true;
		else
			return false;
	}
	
	public int size(){
		return count;
	}
	
	public boolean contains (T targetElement){
		
		return true;
	}
	
	public T find(T targetElement) 
	{
		BinaryTreeNode<T> current = findAgain(targetElement, root);
		if (current==null)
			
			return null;
		
		return current.element;
	}
	
	private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next)
	{
		if (next==null)
			return null;
		if (next.element.equals(targetElement))
			return next;
		BinaryTreeNode<T> temp = findAgain(targetElement, next.left);
		
		if (temp==null)
			temp = findAgain(targetElement, next.right);
		
		return temp;
	}
	
	
	
	public Iterator<T> IteratorInOrder()
	{
		ArrayList<T> tempList = new ArrayList<T>();
		inorder(root, tempList);
		
		return tempList.iterator();
		
		
	}
	
	
	protected void inorder(BinaryTreeNode<T> node, ArrayList<T> tempList){
		
		if (node !=null){
			inorder(node.left, tempList);
			tempList.add(node.element);
			inorder(node.right, tempList);
			
		}
	}
	

// Question 2 - levelOrder Traversal
	
	public Iterator<T> iteratorLevelOrder() 
	{
		ArrayList<BinaryTreeNode<T>> nodes = new ArrayList<BinaryTreeNode<T>>();
		ArrayList<T> tempList = new ArrayList<T>();
		BinaryTreeNode<T> current;

		nodes.add(root);

		while (!nodes.isEmpty()) 
		{
			current = nodes.remove(0);//.removeFirst();

			if (current != null)
			{
				tempList.add(current.getElement());
				if (current.getLeft() != null)
					nodes.add(current.getLeft());
				if (current.getRight() != null)
					nodes.add(current.getRight());
			}
			else
				tempList.add(null);
		}

		return tempList.iterator();
	}

	public BinaryTreeNode<T> getRootNode(){
		return root;
	}
	
}