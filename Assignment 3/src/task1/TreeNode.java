package task1;
/**
 * 
 * @author ktj2012
 *
 */
public class TreeNode
{

	public char data;
	public TreeNode left;
	public TreeNode right;

	public TreeNode()
	{
		data = '#';
		left = right = null;
	}

	public TreeNode(char val)
	{
		data = val;
		left = right = null;
	}

	public TreeNode(char val, TreeNode l, TreeNode r)
	{
		data = val;
		left = l;
		right = r;
	}

	public TreeNode left()
	// post: returns reference to (possibly empty) left subtree
	{
		return this.left;
	}

	public TreeNode right()
	// post: returns reference to (possibly empty) left subtree
	{
		return this.right;
	}

	public void setLeft(TreeNode newLeft)
	// post: sets left subtree to newLeft
	{
		this.left = newLeft;
	}

	public void setRight(TreeNode newRight)
	// post: sets left subtree to newLeft
	{
		this.right = newRight;
	}

	public char value()
	// post: returns value associated with this node
	{
		return this.data;
	}

	public boolean isEmpty()
	// post: returns true if the data of the node is null else returns false
	{
		if (this.data == '#')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
