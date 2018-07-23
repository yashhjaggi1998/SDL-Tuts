package src;

import java.util.Objects;

//pid,price,name=>Product

public class Product
{
	private Integer pid;
	private Double price;
	private String name;

	Product(String name, Integer pid, Double price)
	{
		this.name = name;
		this.pid = pid;
		this.price = price;
	}

	Integer get_pid()
	{
		return this.pid;
	}
	void set_pid(Integer pid)
	{
		this.pid = pid;
	}
	Double get_price()
	{
		return this.price;
	}
	void set_price(Double price)
	{
		this.price = price;
	}
	String get_name()
	{
		return this.name;
	}
	void set_name(String name)
	{
		this.name = name;
	}

	Boolean equals()
	{

	}
	Integer hashCode()
	{}
}




