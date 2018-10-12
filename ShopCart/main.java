package ShopCart;

import java.util.*;
import java.sql.*;  


class Product
{
	String name, category;
	float price;

	Product(String name, float price , String category)
	{
		this.name = name;
		this.price = price;
		this.category = category;
	}
}


public class sc
{
	public static void main(String[] args) 
	{
		try
		{  
			Class.forName("com.mysql.jdbc.Driver"); //registration of MySQL driver
			Connection con = DriverManager.getConnection("jdbc:mysql://10.10.15.202/test","te3238","te3238");
			PreparedStatement stmt = con.prepareStatement("select count(*) from Products");
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			int total_products = rs.getInt(1);	
			rs.close();
			stmt.close();
			
			Map<Integer,Product> all_products = new Hashtable<Integer,Product>();
			Product[] p = new Product[total_products];
			PreparedStatement stmt1 = con.prepareStatement("select * from Products");
			ResultSet rs1 = stmt1.executeQuery();	  
			int i = 0;
			while(rs1.next())
			{
				p[i] = new Product(rs1.getString(2),rs1.getFloat(3),rs1.getString(4));
				all_products.put(i+1,p[i]);
				i++;
			}
			for(Product value : all_products.values())
				System.out.println(value.name + " - " + value.price + " - " + value.category) ;

		//alternate display
		//for(Map.Entry<Integer, Product> entry : map.entrySet())
			//System.out.println(entry.getKey() +  entry.getValue().name);

			ArrayList <Product> cart_products = new ArrayList <Product> ();

			cart_products.add(p[1]);
			cart_products.add(p[2]);

			Iterator itr = cart_products.iterator();
			for(Product product : cart_products)
			{
				 System.out.println(product.name); 
			}
		con.close();

		}catch(Exception e)
		{ 
			System.out.println(e);
		} 

	}
}
