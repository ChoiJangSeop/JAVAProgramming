package PA1;

import java.util.ArrayList;
import java.util.List;


// Template code of "PA1.java"
// Do not change the format of the class and method in "PA1.java"
// Do not use java.util.LinkedList package

class Node<T> {
	T value = null;
	
	Node<T> prev = null;
	Node<T> next = null;
	
	Node (T val) {
		this.value = val;
	}
	Node () {}
}

class Linkedlist<T> {
	
	Node<T> head = null;
	Node<T> tail = null;
	
	void addList(Linkedlist<T> list) {	//º¸·ù
		
		this.tail.next = list.head;
		list.head.prev = this.tail;
		
		this.tail = list.tail;
	}
	
	boolean equals(Linkedlist<T> list) {
		boolean result = true;
		
		Node<T> tmp1 = list.head;
		Node<T> tmp2 = this.head;
		
		if (this.size() != list.size())
			result = false;
		
		else {
			for (int i=0; i < this.size(); ++i) {
				
				if (tmp1.value != tmp2.value) {
					result =  false;
					break;
				}
				
				tmp1 = tmp1.next;
				tmp2 = tmp2.next;	
			}
		}
		return result;
	}
	
	int size() {
		int len = 0;
		if (this.head != null) {
			Node<T> tmp = new Node<T>();
			tmp = this.head;
			
			while (tmp != null) {
				++len;
				tmp = tmp.next;
			}
		}
			
		return len;
	}
	
	void push_back(T val) {
		
		if (this.size() == 0) {
			this.head = new Node<T>(val);
		}
		
		else if (this.tail == null) {
			this.tail = new Node<T>(val);
			this.head.next = this.tail;
			this.tail.prev = this.head;
		}
		
		else {
			Node<T> newNode = new Node<T>(val);
			
			newNode.prev = this.tail;
			this.tail.next = newNode;
			
			this.tail = newNode;
		}
		
	}
	void push_front(T val) {
		
		if (this.size() == 0) {
			this.head = new Node<T>(val);
		}
		else if (this.tail == null) {
			this.tail = new Node<T>(val);
			this.head.next = this.tail;
			this.tail.prev = this.head;
		}
		else {
			Node<T> newNode = new Node<T>(val);
			
			newNode.next = this.head;
			this.head.prev = newNode;
			
			this.head = newNode;
		}	
	}
	
	String print_list() {
		Node<T> tmp = this.head;
		String res = "";
		while(tmp != null) {
			System.out.print(tmp.value + " ");
			res = res + tmp.value.toString() + " ";
			tmp = tmp.next;
		}
		System.out.println();
		return res;
	}
	
	T get(int n) {
		
		T value = null;
		
		if (n > 0 && n < this.size()) {
			Node<T> cur = this.head;
			
			for (int i=0; i<n-1; ++i) 
				cur = cur.next;
			
			value = cur.value;
		}
		
		return value;
	}
	
	void set(int n, T val) {
		
		if (this.size() > n && n > 0) { 	
			Node<T> cur = this.head;
			
			for (int i=0; i<n-1; ++i) 
				cur = cur.next;
			
			cur.value = val;
		}
	}
	
	void add(int n, T val) {
		
		if (n >= 0 && n < this.size()) {
			Node<T> cur = new Node<T>();
			Node<T> newNode = new Node<T>(val);
			
			cur = this.head;
			
			if(n == 0) 
				push_front(val);
			
			else {
				for (int i=0; i<n-1; i++)
					cur = cur.next;
				
				newNode.prev = cur;
				newNode.next = cur.next;
				cur.next.prev = newNode;
				cur.next = newNode;
			}
		}
	}
	
	void erase (int n) {
		
		Node<T> cur = new Node<T>();
		Node<T> tmp = new Node<T>();
		
		if (n>=0 && n < this.size()) {
			
			if (n == this.size()-1)
				this.pop_back();
			
			else if (n == 0)
				this.pop_front();
			
			else {
				cur = this.head;
				
				for (int i=0; i<n-1; i++) 
					cur = cur.next;
				
				tmp = cur.next;
				tmp.next.prev = cur;
				cur.next = tmp.next;
			}
			//how to free 'tmp'?
		}
	}
	
	void pop_back() {
		
		if (this.size() == 1)
			this.head = null;
		
		else if (this.size() == 2)
			this.head.next = null;
		
		else if (this.size() > 2) {
			Node<T> cur = new Node<T>();
			Node<T> tmp = new Node<T>();
			
			cur = this.tail.prev;
			
			cur.next = null;
			this.tail = cur;
		}
		//how to free
	}
	void pop_front() {
		
		if (this.size() == 1)
			this.head = null;
		else if (this.size() > 1) {
			Node<T> tmp = new Node<T>();
			
			tmp = this.head;
			
			tmp.next.prev = null;
			this.head = tmp.next;
		}
		// how to free
	}
	
	List<Linkedlist<T>> split(T val) {
		List<Linkedlist<T>> arr = new ArrayList<Linkedlist<T>>();
		
		Node<T> tmp = new Node<T>();
		tmp = this.head;
		int idx = 0;

		while (tmp != null) {
			
			Linkedlist<T> t_list = new Linkedlist<T>();
			
			while ( tmp.value != val) {
				t_list.push_back(tmp.value);
				tmp = tmp.next;
				if (tmp == null) { break; }
			}
			
			if (tmp != null) { t_list.push_back(tmp.value); tmp = tmp.next; }
			arr.add(idx++, t_list);
			
		}
		return arr;
	}
	
	Linkedlist() {}
	
	Linkedlist(T val) {
		this.head = new Node<T>(val);
		tail = head;
	}
}



public class PA1 {
	public static void main(String[] args) {
		// example of using Linkedlist with generic type
		Linkedlist<Integer> list = new Linkedlist<Integer>(); 
		
	}	
}

