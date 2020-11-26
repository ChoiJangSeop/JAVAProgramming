package week6;

//2019310036; Software; Choi Jangseop

import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

class _ContactList {

	HashMap<String, String> contactList = new HashMap<>();
	
	_ContactList() {}
	
	void add(String name, String phoneNumber)
	{
		if (contactList.containsKey(name)) { System.out.println("error"); }
		else { contactList.put(name, phoneNumber); }
	}
	
	void find(String name)
	{
		if (contactList.containsKey(name)) { System.out.println(contactList.get(name)); }
		else { System.out.println("error"); }
	}
	
	void show()
	{
		Set<String> _keySet = contactList.keySet();
		
		for (String name : _keySet)
		{
			System.out.println(name + " " + contactList.get(name));
		}
	}
	
	void delete(String name)
	{
		if (contactList.containsKey(name)) { contactList.remove(name); }
		else { System.out.println("error"); }
	}
		
}


public class Contact_List {

	public static void main(String[] args)
	{
		_ContactList c = new _ContactList();
		
		
		Scanner scan = new Scanner(System.in);
		while(true) 
		{
			String str;
			str = scan.nextLine();
			String fun_name = str.split(" ")[0];
			int param_num = 0;
			
			for(String s : str.split(" ")) { param_num++; }
			
			
			if (fun_name.equals("add")) { 
				if (param_num != 3) { System.out.println("error"); continue; }
				
				String first_param = str.split(" ")[1];
				String second_param = str.split(" ")[2];

				c.add(first_param, second_param);
			}
			
			else if (fun_name.equals("find")) {
				if (param_num != 2) { System.out.println("error"); continue;}
				
				String first_param = str.split(" ")[1];

				c.find(first_param);
			}
			
			else if (fun_name.equals("show")) { c.show(); }
			
			else if (fun_name.equals("delete")) {
				if (param_num != 2) { System.out.println("error"); continue; }
				
				String first_param = str.split(" ")[1];

				c.delete(first_param);
			}
			else { System.out.println("error"); }
		}
	}
}
