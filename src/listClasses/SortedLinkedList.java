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
	private Comparator<T> comparator;

	public SortedLinkedList(Comparator<T> c){
		this.comparator = c;
		// new Comparator<T>(){
		// 	@Override
		// 	public int compare(T o1, T o2) {
		// 		// TODO Auto-generated method stub
		// 		return 0;
		// 	}
		// };
	}



	public SortedLinkedList<T> add(T data){
		// throw new UnsupportedOperationException("This method is not implemented yet!");
		Node nodeToAdd = new Node(data);
		Node current = head;
		
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
		return this;
		
	}


}