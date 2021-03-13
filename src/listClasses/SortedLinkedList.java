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

	protected class SortListComp implements Comparator<T>{
		@Override
		public int compare(T o1, T o2) {
			if(o1.toString().compareTo(o2.toString()) == 0){
				return 1;
			}
			return -1;
		}
	}
	public SortedLinkedList<T> add(T data){
		// throw new UnsupportedOperationException("This method is not implemented yet!");
		Node nodeToAdd = new Node(data);
		Node current = head, index = null;
		T temp;
		
		// comparator.compare(head, nodeToAdd);
        // if head is null, assign incoming node to it
        if(current == null){
            head = tail = nodeToAdd;
            return this;
        }

        // keep looping until we find a node with reference to null in its 'next'
        while(current.next != null){
            current = current.next;
        }
        // append nodeToAdd to the last node in list
		current.next = nodeToAdd;
		tail = nodeToAdd;
		listSize++;

		// sort the list 
		index = current.next;
		while(current.next != null){
			if(current.data.toString().compareTo(index.data.toString()) == 0){
				temp = current.data;
				current.data = index.data;
				index.data = temp;
			}
			if(index.next != null) index = index.next;
			else break;
		}
		return this;
		
	}


}