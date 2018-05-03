package task1;
import java.util.Stack;

/**
 *
 * @author ktj2012
 * 
 */
public class TreeBuilder
{

	public static TreeNode createExpressionTree(String postfix)
	// pre: a valid expression in postfix form
	// post: a root node that points to a binary tree containing a valid expression.
	{
		Stack<TreeNode> nodes = new Stack<>();
		for (int i = 0; i < postfix.length(); i++)
		{
			char ch = postfix.charAt(i);
			if (isOperator(ch))
			{
				TreeNode rightNode = nodes.pop();
				TreeNode leftNode = nodes.pop();
				nodes.push(new TreeNode(ch, leftNode, rightNode));
			}
			else
			{
				nodes.add(new TreeNode(ch, null, null));
			}
		}
		return nodes.pop();
	}

	public static String toPostfix(String infix)
	// pre: a valid expression in a string
	// post: the expression in post fix form
	{

		String postfix = "";
		Stack<Character> operator = new Stack<>();
		char popped;

		for (int i = 0; i < infix.length(); i++)
		{

			char get = infix.charAt(i);

			if (!isOperator(get))
			{
				postfix += get;
			}

			else if (get == ')')
			{
				while ((popped = operator.pop()) != '(')
				{
					postfix += popped;
				}
			}

			else
			{
				while (!operator.isEmpty() && get != '(' && precedence(operator.peek()) >= precedence(get))
				{
					postfix += operator.pop();
				}

				operator.push(get);
			}
		}
		while (!operator.isEmpty())
		{
			postfix += operator.pop();
		}
		System.out.println("\nThe expression in postfix form is " + postfix);
		return postfix;
	}

	private static boolean isOperator(char i)
	// post: whether the char is an operator
	{
		return precedence(i) > 0;
	}

	private static int precedence(char i)
	// post: the precedence of a given char
	{
		switch (i)
		{

		case '(':
			return 1;

		case ')':
			return 1;

		case '-':
			return 2;

		case '+':
			return 2;

		case '*':
			return 3;

		case '/':
			return 3;
		}
		return 0;
	}

	public static double treeEvaluator(TreeNode node)
	// pre: a root node pointing to valid tree
	// post: the value of the expression
	{
		if (node.left == null)
		{
			return getDoubleValue(node);
		}
		else if (node.data == '+')
		{
			return treeEvaluator(node.left) + treeEvaluator(node.right);
		}
		else if (node.data == '-')
		{
			return treeEvaluator(node.left) - treeEvaluator(node.right);
		}
		else if (node.data == '*')
		{
			return treeEvaluator(node.left) * treeEvaluator(node.right);
		}
		else
		{
			return treeEvaluator(node.left) / treeEvaluator(node.right);
		}
	}

	private static double getDoubleValue(TreeNode node)
	// returns the value of a node in the form of a double
	{
		return (double) Character.getNumericValue(node.data);
	}
}
