public class BinaryTreeNode<T> 
{

	T element;
	BinaryTreeNode<T> left, right;

	// Constructor, create a node object
	BinaryTreeNode (T obj){
		element = obj;
		left = null;
		right = null;
	}

	//count number of children of a node
	public int numChildren(){

		int children =0;
		if (left != null)
			children = 1 + left.numChildren();
		if (right !=null)
			children = 1 + right.numChildren();

		return children;
	}

	public T getElement(){

		return element;
	}

	public BinaryTreeNode<T> getLeft(){

		return left;
	}

	public BinaryTreeNode<T> getRight(){

		return right;
	}

	public  void setElement(T element){

		this.element = element;
	}

	public  void setLeft(BinaryTreeNode<T> left){

		this.left = left;
	}

	public  void setRight(BinaryTreeNode<T> right){

		this.right = right;
	}


}