package listClasses;

import java.util.*;


/**
 * Implements a generic sorted list using a provided Comparator. It extends
 * BasicLinkedList class.
 * 
 *  @author Dept of Computer Science, UMCP
 *  
 */

public class SortedLinkedList<T> extends BasicLinkedList<T> {
	private Comparator<T> comparator ;

	public SortedLinkedList(Comparator<T> c){
		this.comparator = c;
	}
	
	@Override
	public BasicLinkedList<T> addToFront(T data){
		throw new UnsupportedOperationException("This operation is invalid for sorted list");
	}
	@Override
	public BasicLinkedList<T> addToEnd(T data){
		throw new UnsupportedOperationException("This operation is invalid for sorted list");
	}

	public SortedLinkedList<T> remove(T data){
		remove(data, this.comparator);
		return this;
	}


	public SortedLinkedList<T> add(T data){
		if (data == null) {
			return this;
		}

		Node newnode = new Node(data);
		if (head == null) {
		// The list was empty
		head = tail = new Node(data);
		} else {
			// Check if it needs to go right at the head
			if (comparator.compare(data, head.data) <= 0) {
				newnode.next = head;
				head = newnode;
			}
			// Check if it needs to go right at the tail
			else if (comparator.compare(data, tail.data) >= 0) {
				tail.next = newnode;
				tail = newnode;
			} else {
				// It needs to be inserted into the middle of the list
				Node next = head.next;
				Node prev = head;
				while (comparator.compare(data, next.data) > 0) {
					prev = next;
					next = next.next;
				}
				// Do the actual insertion
				prev.next = newnode;
				newnode.next = next;
			}
		}
		listSize++;
		return this;
  	}
}