package noPoint;

import java.util.*;

public class Stack<E> extends ArrayList<E>{
	
	//ArrayList<T>
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<E> stack = new ArrayList<>();
	private int capacity = 999;
	public Stack() {
		
	}
	public Stack(int _capacity) {
		
		this.capacity= _capacity;
	}
	
	public boolean push(E obj) {
		if(stack.size() >= capacity ) {
			return false;
		}
		stack.add(obj);
		return true;
	}
	
	public E pop() {
		if(stack.size() == 0) {
			return null;
		}
		E Obj =  stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return Obj;
	}

	@SuppressWarnings("unchecked")
	public E peek(){
		if(stack.size() > 1) {
			return stack.get(stack.size()-1);
		}
		if(stack.size() == 0) {
		
			return (E) "null";
		}
		return stack.get(0); 
	}
	// E  w = null;
	
	// w.toDtring;
	
	public String toString() {
		if(stack.size() == 0) {
			return "\n";
		}
		
		return stack.toString() + "\n";
	}
}
