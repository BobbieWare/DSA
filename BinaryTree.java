/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author sonia
 */
public interface BinaryTree<E> {
      
    public BinaryTree<E> parent();
    // post: returns reference to parent node, or null
    public BinaryTree<E> left();
    // post: returns reference to (possibly empty) left subtree
    public BinaryTree<E> right();
    // post: returns reference to (possibly empty) right subtree
    public void setLeft(TreeNode<E> newLeft);
    // post: sets left subtree to newLeft
    // re-parents newLeft if not null
      public void setRight(TreeNode<E> newRight);
    // post: sets right subtree to newLeft
    // re-parents newRight if not null
    public void setParent(TreeNode<E> newParent);
    // post: re-parents this node to parent reference, or null
    public boolean isLeftChild();
    // post: returns true if this is a left child of parent
       public boolean isRightChild();
    // post: returns true if this is a right child of parent
    public E value();
    // post: returns value associated with this node
    public void setValue(E value);
    // post: sets the value associated with this node
    public boolean isEmpty();
    //post: returns true if data is null for this node
}
