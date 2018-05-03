package task2;

import java.util.Scanner;

public class CoffeeShop
{

	public static void main(String[] args)
	{
		CoffeeQueue myShop = new CoffeeQueue();
		System.out.print("\nWelcome to your Coffee shop: \n \n ");
		System.out.println(myShop);
		Scanner keyboard = new Scanner(System.in);
		boolean again = true;
		do
		{
			System.out.print("\nWhat would you like to happen: \n\n"
					+ "1. Add a new Customer.\n"
					+ "2. Progress time by 1min.\n"
					+ "3. Progress time by 10min\n"					
					+ "4. Close the shop.\n\n");
			int option = keyboard.nextInt();
			
			if (option == 1)
			{
				System.out.println("Please enter a name for a the customer: \n");
				String name = keyboard.next();
				System.out.println("Please enter what " + name + " wants to order.");
				String order = keyboard.next();
				myShop.newCustomer(name, order);
				System.out.println(myShop);
			}
			else if (option == 2)
			{
				myShop.addTime();
				System.out.println(myShop);
			}
			else if (option == 3)
			{
				for (int i = 0; i < 10; i++)
				{
					myShop.addTime();					
				}
				System.out.println(myShop);
			}
			else if (option == 4)
			{
				again = false;
			}
			else 
			{
				System.out.println("Sorry but " + option + " isn't a valid option, please try again.");
			}

			
		} while (again);
		keyboard.close();
		
	}
	
	
	
}
