import java.util.*;

class Product
{
	String name, remarks;
	float price;
	int quantity;

	Product(String name, float price , int quantity , String remarks)
	{
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.remarks = remarks;
	}
}


public class sc
{
	public static void main(String[] args) 
	{
		Map<Integer,Product> all_products = new Hashtable<Integer,Product>();

		Product p1 = new Product("Shoes",2100,4,"Good pair");	
		Product p2 = new Product("Shirt",1200,3,"Good shirt");
		Product p3 = new Product("Deo",120,6,"Good deo");
	
		all_products.put(1,p1);
		all_products.put(2,p2);
		all_products.put(3,p3);

		for(Product value : all_products.values())
			System.out.println(value.name + " - " + value.price + " - " + value.quantity + " - " + value.remarks) ;

		//alternate display
		//for(Map.Entry<Integer, Product> entry : map.entrySet())
			//System.out.println(entry.getKey() +  entry.getValue().name);

		ArrayList <Product> cart_products = new ArrayList <Product> ();

		cart_products.add(p1);
		cart_products.add(p2);

		Iterator itr = cart_products.iterator();
		for(Product product : cart_products)
		{
			 System.out.println(product.name); 
		}


	}
}
