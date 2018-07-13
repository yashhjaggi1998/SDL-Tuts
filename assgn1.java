import java.util.*;

class generic<T1,T2 extends Number>
{
	int key,value;
	Hashtable <T1,T2> h = new Hashtable<T1,T2>();
	generic()
	{
		h.clear();
	}
	void putValue(T1 k,T2 v)
	{
		h.put(k,v);
	}
	void getValue(T1 k)
	{
		T2 temp = h.get(k);
		System.out.println(temp.intValue());
	}

	int tableSize()
	{
		return h.size();
	}
}

class assgn1
{
	public static void main(String [] args)
	{
		generic <String , Integer> obj = new generic<String , Integer>();
		obj.putValue("Yashh" , 5);
		obj.putValue("Watson" , 6);
		obj.getValue("Watson");
		System.out.println("Size of the hash table is: " + obj.tableSize());
		
	}
}