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
	{
		return orderTime;
	}

	public void setOrderTime(int orderTime)
	{
		this.orderTime = orderTime;
	}

	public String getName()
	{
		return name;
	}

	public String getOrder()
	{
		return order;
	}
	
	@Override
	public String toString()
	{
		return name + " that ordered a " + order;
	}
}
