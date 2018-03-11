/*
 * Lucy Gormley
 * C16334766 - Lab exam 1
 */

/**
 * LinkedBinarySearchTree implements the BinarySearchTreeADT interface 
 * with links.
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T>
implements BinarySearchTreeADT<T>
{

	/**
	 * Creates an empty binary search tree.
	 */
	public LinkedBinarySearchTree() 
	{
		super();
	}		

	/**
	 * Creates a binary search with the specified element as its root.
	 *
	 * @param element the element that will be the root of the new binary
	 *        search tree
	 */
	public LinkedBinarySearchTree(T element) 
	{
		super(element);


	}		
	/**
	 * Adds the specified object to the binary search tree in the
	 * appropriate position according to its natural order.  Note that
	 * equal elements are added to the right.
	 *
	 * @param element the element to be added to the binary search tree
	 */
	public void addElement(T element) 
	{

		Comparable<T> comparableElement = (Comparable<T>) element;

		if (isEmpty())
			root = new BinaryTreeNode<T>(element);
		else 
		{
			if (comparableElement.compareTo(root.getElement()) < 0)
				// 	if (element.compareTo(root.getElement()) < 0)
			{
				if (root.getLeft() == null) 
					root.setLeft(new BinaryTreeNode<T>(element));
				else
					addElement(element, root.getLeft());
			}

			else
			{
				if (root.getRight() == null) 
					root.setRight(new BinaryTreeNode<T>(element));
				else
					addElement(element, root.getRight());
			}
		}

		count++;
	}

	/**
	 * Adds the specified object to the binary search tree in the
	 * appropriate position according to its natural order.  Note that
	 * equal elements are added to the right.
	 *
	 * @param element the element to be added to the binary search tree
	 */
	private void addElement(T element, BinaryTreeNode<T> node) 
	{
		Comparable<T> comparableElement = (Comparable<T>)element;

		if (comparableElement.compareTo(node.getElement()) < 0)
		{
			if (node.getLeft() == null) 
				node.setLeft(new BinaryTreeNode<T>(element));
			else
				addElement(element, node.getLeft());
		}
		else
		{
			if (node.getRight() == null) 
				node.setRight(new BinaryTreeNode<T>(element));
			else
				addElement(element, node.getRight());
		}
	}	


	/**
	 * Removes the first element that matches the specified target
	 * element from the binary search tree and returns a reference to
	 * it.  
	 *
	 * @param targetElement the element being sought in the binary search tree
	 * 
	 */
	public T removeElement(T targetElement)

	{
		T result = null;

		if (isEmpty())

			return  result;
		else
		{
			BinaryTreeNode<T> parent = null;
			if (((Comparable<T>)targetElement).equals(root.element)) 
			{
				result =  root.element;     
				root=replacement(root);
				count--;
			}
			else //
			{                
				parent = root;
				if (((Comparable)targetElement).compareTo(root.element) < 0)
					result = removeElement(targetElement, root.getLeft(), parent); // find the target element
				else
					result = removeElement(targetElement, root.getRight(), parent);
			}
		}

		return result;
	}		
	/**
	 * Removes the first element that matches the specified target
	 * element from the binary search tree and returns a reference to
	 * it.  
	 *
	 * @param targetElement the element being sought in the binary search tree
	 * @param node the node from which to search
	 * @param parent the parent of the node from which to search
	 * 
	 */
	private T removeElement(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent)

	{
		T result = null;

		if (node == null)

			return null;
		else
		{
			if (((Comparable<T>)targetElement).equals(node.element)) 
			{
				result =  node.element;
				BinaryTreeNode<T> temp = replacement(node);
				if (parent.right == node) // set link from parent to the replacement element.
					parent.right = temp;		

				else 
					parent.left = temp; 

				count--;
			}
			else 
			{                
				parent = node;
				if (((Comparable)targetElement).compareTo(node.element) < 0)
					result = removeElement(targetElement, node.getLeft(), parent);
				else
					result = removeElement(targetElement, node.getRight(), parent);
			}
		}

		return result;
	}		
	/**
	 * Returns a reference to a node that will replace the one
	 * specified for removal.  In the case where the removed node has 
	 * two children, the Inorder successor is used as its replacement.
	 *
	 * @param node the node to be removed
	 * @return a reference to the replacing node
	 */
	private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) // node is the node to be removed
	{
		BinaryTreeNode<T> result = null;

		if ((node.left == null) && (node.right == null)) // no child - remove a leaf node
			result = null;

		else if ((node.left != null) && (node.right == null)) // node with only child
			result = node.left;

		else if ((node.left == null) && (node.right != null)) //node with only child
			result = node.right;

		else // node with 2 children
		{
			BinaryTreeNode<T> current = node.right;
			BinaryTreeNode<T> parent = node;		

			while (current.left != null)
			{
				parent = current;
				current = current.left;
			}

			if (node.right ==current)   // replacement is current, node is to be removed, node links directly to current.
				current.left = node.left;
			else 
			{
				parent.left = current.right;
				current.right = node.right;
				current.left = node.left;
			}

			result = current;
		}

		return result;
	}
	
	//Question 6 - findMax() method - finds max value, called and printed in MyTree class

		public T findMax() 
		{
			T result = null;
			if (root.right == null) 

				result = root.element;

			else 
			{
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> current = root.right;		
				while (current.right != null) 
				{
					parent = current;
					current = current.right;
				}
				result =  current.element;
			}		   
			return result;
		}
		
		

	// Question 8 - removeMin() method - called in MyTree class
	
	public T removeMin()
	{
		T result = null;
		
		if (root.left == null) 
		{
			result = root.element;
		}
		else 
		{
			BinaryTreeNode<T> parent = root;
			BinaryTreeNode<T> current = root.left;		
			while (current.left != null) 
			{
				parent = current;
				current = current.left;
			}
			result =  current.element;
			removeElement(current.element);
		}
		return result;
	}
	
	public T findMin() // used to display min value in MyTree class q9
	{
		T result = null;
		
		if (root.left == null) 
		{
			result = root.element;
		}
		else 
		{
			BinaryTreeNode<T> parent = root;
			BinaryTreeNode<T> current = root.left;		
			while (current.left != null) 
			{
				parent = current;
				current = current.left;
			}
			result =  current.element;
		}
		return result;
	}
}