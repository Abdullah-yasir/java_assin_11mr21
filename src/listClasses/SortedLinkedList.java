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
	private Comparator<String> comparator ;

	public SortedLinkedList(Comparator<String> c){
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
			if (comparator.compare(data.toString(), head.data.toString()) <= 0) {
				newnode.next = head;
				head = newnode;
			}
			// Check if it needs to go right at the tail
			else if (comparator.compare(data.toString(), tail.data.toString()) >= 0) {
				tail.next = newnode;
				tail = newnode;
			} else {
				// It needs to be inserted into the middle of the list
				Node next = head.next;
				Node prev = head;
				while (comparator.compare(data.toString(), next.data.toString()) > 0) {
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