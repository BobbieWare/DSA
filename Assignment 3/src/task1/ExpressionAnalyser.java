package task1;
import java.util.Scanner;

/**
 *
 * @author ktj2012
 * 
 */
public class ExpressionAnalyser
{

	static int count = 0;
	static int nCount = 0;
	static int oCount = 0;
	static String expression = "";
	static boolean valid = true;

	public static String Analyse()
	// post: will either return a string containing a valid string, or an empty
	// string
	{
		Scanner keyboard = new Scanner(System.in);
		boolean again = false;
		do
		{
			System.out.print("\nEnter an Algebraic Expression:\t");

			expression = keyboard.next();
			variableReplacer();
			startAnalyser();
			if (nCount != oCount + 1)
			{
				valid = false;
			}
			if (valid)
			{
				System.out.print("\nThe Expression " + expression + " is Valid\n");
			}
			else
			{
				System.out.print("\nThe Expression " + expression + " is Invalid\n");
				System.out.print("Would you like to enter another expression? (y/n)\n");
				if (keyboard.next().charAt(0) == 'n')
				{
					again = false;
					expression = "";
				}

			}
		} while (again);
		keyboard.close();
		return expression;
	}

	static void variableReplacer()
	// pre: a valid string
	// post: a valid string with variables replaced with their values
	{
		for (int i = 0; i < expression.length(); i++)
		{
			if (Character.isAlphabetic(expression.charAt(i)))
			{
				System.out.println("Please enter a value for " + expression.charAt(i));
				Scanner keyboard = new Scanner(System.in);
				expression = expression.replace(expression.charAt(i), keyboard.next().charAt(0));
				keyboard.close();
			}
		}
	}

	static void startAnalyser()
	// post: begins the analyser
	{
		second();
		checkForAddSub();
	}

	static void second()
	// pre: is the first step or a number/braket must be present.
	// post: moves onto next step
	{
		checkForNumBrac();
		checkForMD();
	}

	static void checkForMD()
	// post: adds to operator count if a divide or multiply sign is found
	{
		if (expression.length() == count)
		{
			return;
		}
		if (expression.charAt(count) == '*')
		{
			count++;
			oCount++;
			checkForNumBrac();
			checkForMD();
		}
		else if (expression.charAt(count) == '/')
		{
			if (expression.charAt(count + 1) == '0')
			{
				valid = false;
			}
			oCount++;
			count++;
			checkForNumBrac();
			checkForMD();
		}
	}

	static void checkForNumBrac()
	// post: adds to number count or checks if brakets are used correctly.
	{
		if (expression.length() == count)
		{
			return;
		}
		if (Character.isDigit(expression.charAt(count)))
		{
			count++;
			nCount++;
		}
		else if (expression.charAt(count) == '(')
		{
			count++;
			startAnalyser();
			if (expression.charAt(count) == ')')
			{
				count++;
			}
			else
			{
				valid = false;
			}
		}
		else
		{
			valid = false;
		}
	}

	static void checkForAddSub()
	{
		if (expression.length() == count)
		{
			return;
		}
		if (expression.charAt(count) == '+')
		{
			count++;
			oCount++;
			second();
			checkForAddSub();
		}
		else if (expression.charAt(count) == '-')
		{
			count++;
			oCount++;
			second();
			checkForAddSub();
		}
	}
}
