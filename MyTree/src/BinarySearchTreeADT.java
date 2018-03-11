public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> 
{
    
    public void addElement(T element);
    /** 
     * Adds the specified element to the proper location in this tree. 
     *
     * @param element the element to be added to this tree
     */
   
    public T removeElement(T targetElement);	
    /** 
     * Removes and returns the specified element from this tree. 
     *
     * @param targetElement the element to be removed from the tree
     * @return the element to be removed from the tree
     */ 
    
}