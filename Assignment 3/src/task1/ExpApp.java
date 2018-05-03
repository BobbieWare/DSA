package task1;
/**
 * 
 * @author ktj2012
 *
 */
public class ExpApp
{

	public static void main(String[] args)
	{
		String expression = ExpressionAnalyser.Analyse();
		if (expression != "")
		{
			String postfix = TreeBuilder.toPostfix(expression);
			TreeNode root = TreeBuilder.createExpressionTree(postfix);
			System.out.println("\nThe expression equates to " + TreeBuilder.treeEvaluator(root));
		}
		System.out.println("\nThanks for using the app.");
	}
}
