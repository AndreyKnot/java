package ua.khpi.oop.tatarenko05;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Container {
	
	private String[] mas;
	private int len;
	//---------------------------------------------------
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < len; i++)
		{
			str.append(mas[i] + " | ");
		}
		
		return str.toString();
	}
	//---------------------------------------------------
	public void add(String string)
	{
		String[] nmas = new String[len + 1];
		
		for(int i = 0; i < len; i++)
		{
			nmas[i] = mas[i];
		}
		
		nmas[len] = string;
		len++;
		mas = nmas;
	}
	//---------------------------------------------------
	public void clear()
	{
		for(int i = 0; i < len; i++)
		{
			mas[i] = null;
		}
		len = 0;
	}
	//---------------------------------------------------
	public boolean remove(String string)
	{
		boolean b = false;
		
		for(int i = 0; i < len; i++)
		{
			if(mas[i].equals(string))
			{
				b = true;
				String[] nmas = new String[len - 1];
				
				for(int j = 0; j < i; j++)
				{
						nmas[j] = mas[j];
				}
				
				for(int j = i; j+1 < len; j++)
				{
						nmas[j] = mas[j+1];
				}
				
				mas = nmas;
				len--;
				
				break;
			}
		}
		
		return b;
	}
	//---------------------------------------------------
	public Object[] toArray()
	{
		Object[] obj = new Object[len];
		
		for(int i = 0; i < len; i++)
		{
			obj[i] = mas[i];
		}
		
		return obj;
	}
	//---------------------------------------------------
		public int size()
		{
			return len;
		}
	//---------------------------------------------------
		public boolean contains(String string)
		{
			boolean con = false;
			
			for(int i = 0; i < len; i++)
			{
				if(mas[i].equals(string))
				{
					con = true;
					break;
				}
			}
			return con;
		}
	//---------------------------------------------------
	public boolean containsAll(Container container)
	{
		boolean con = false;
		int size = container.size();
		int count = 0;
		
		for(int i = 0; i < len; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(mas[i].equals(container.GetEl(j)))
				{
					count++;
					break;
				}
			}
		}
		
		if(count == len)
		{
			con = true;
		}
		
		return con;
	}
	//---------------------------------------------------
	private String GetEl(int i)
	{
		return mas[i];
	}
	//---------------------------------------------------
	public Container(String... str)
	{
		len = str.length;
		
		if(len > 0)
		{
			mas = new String[len];
			
			for(int i = 0; i < len; i++)
			{
				mas[i] = str[i];
			}
		}
	}
	//---------------------------------------------------
	public Iterator<String> iterator()
	{
		return new MyIterator<String>(); 
	}
	//---------------------------------------------------
	public class MyIterator<String> implements Iterator{
		private int ind = 0;
		
		 @Override public boolean hasNext()
		{
			if(ind < len) return true;
			else return false;
		}
		
		 @Override public Object next()
		{
			if(ind == len)
			{
				throw new NoSuchElementException();
			}
			return mas[ind++];
		}
		
		 @Override public void remove()
		{
			Container.this.remove(mas[--ind]);
		}
		
	}
}
