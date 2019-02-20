package task2;

public class Customer
{
	String name;
	String order;
	int orderTime;
	
	public Customer(String name, String order, int orderTime)
	{
		this.name = name;
		this.order = order;
		this.orderTime = orderTime;
	}

	public int getOrderTime()
	// post: Ammount of minutes for order to be done, only when customer is at the front of the queue.
	{
		return orderTime;
	}

	public void setOrderTime(int orderTime)
	// post: Changes the order time to a given value. 
	{
		this.orderTime = orderTime;
	}

	public String getName()
	// post: returns name of customer.
	{
		return name;
	}

	public String getOrder()
	// post: returns customers order
	{
		return order;
	}
	
	@Override
	public String toString()
	// post: returns customers name and their order.
	{
		return name + " that ordered a " + order;
	}
}
