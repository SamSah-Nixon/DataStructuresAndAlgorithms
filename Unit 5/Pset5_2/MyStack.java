
public interface MyStack<E>
{
  /**
  *Insert Object of type E at the top of this stack.
  *
  *@param o the Object being added to this stack
  */
  public void push(E o);

  /**
  *If this stack is not empty, remove the element that is currently at
  *   the top return this object.  If the stack is empty return null.
  *@return The object of type E at the top of this stack or null
  *   if the stack is empty
  */
  public E pop();

  /**
  *If this stack is not empty, return the element that is currently at
  *   the top.  If this stack is empty return null.  The contents of the stack
  *   is unchanged.
  *@return The object of type E at the top of this stack or null if the stack
  *   is empty
  */
  public E peek();

  /**
  *If this stack is empty, return true otherwise return false.
  *
  *@return A boolean with value true if this stack is empty and false if it is not.
  */
  public boolean isEmpty();

  /**
   * Return the number of elments currently in the stack.
   *
   * @return An int indicating the current size of the stack.
   */
  public int size();
}
