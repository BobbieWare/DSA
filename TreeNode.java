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
public class TreeNode <E> implements BinaryTree<E>{
  public E data;
  public TreeNode parent;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
    data = null;
    parent=left=right=null;
  }
  
  public TreeNode(E val, TreeNode p) {
    data = val;
    parent=p;
    left=right=null;
  }

 public BinaryTree<E> left()
    // post: returns reference to (possibly empty) left subtree
 {
     return this.left;
 }
 public BinaryTree<E> right()
    // post: returns reference to (possibly empty) left subtree
 {
     return this.right;
 }
    public BinaryTree<E> parent()
    // post: returns reference to parent node, or null
    {
        return this.parent;
    }
    
    public void setLeft(TreeNode<E> newLeft)
    // post: sets left subtree to newLeft
    {
        this.left=newLeft;
    }
    public void setRight(TreeNode<E> newRight)
    // post: sets left subtree to newLeft
    {
        this.right=newRight;
    }
    // re-parents newLeft if not null
    public void setParent(TreeNode<E> newParent)
    // post: re-parents this node to parent reference, or null
    {
        this.parent=newParent;
    }
//public Iterator<E> iterator()
    // post: returns an in-order iterator of the elements
    
    public boolean isLeftChild()
    // post: returns true if this is a left child of parent
    {
        if(this.parent.left==this)
            return true;
        else
            return false;
    }
    public boolean isRightChild()
    // post: returns true if this is a left child of parent
    {
        if(this.parent.right==this)
            return true;
        else
            return false;
    }
    public E value()
    // post: returns value associated with this node
    {
        return this.data;
    }
    public void setValue(E value)
    // post: sets the value associated with this node
    {
        this.data=value;
    }
    
    public boolean isEmpty()
    //post: returns true if the data of the node is null else returns false
    {
        if(this.data==null)
            return true;
        else
            return false;
    }
}