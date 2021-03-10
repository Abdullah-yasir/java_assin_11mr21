package listClasses;

import java.util.*;

public class BasicLinkedList<T> implements Iterable<T> {
	
	/* Node definition */
	protected class Node {
		protected T data;
		protected Node next;

		protected Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/* List Iterator definition */
	protected class ListIterator<T> implements Iterator<T>{
		Node current;
       
		public ListIterator(BasicLinkedList<T> list) { 
			current = list.getFirst(); 
		} 

		 // returns false if next element does not exist 
		public boolean hasNext() { 
			return current != null; 
		} 
		
		// return current data and update pointer 
		public T next() { 
			T data = current.data; 
			current = current.next; 
			return data; 
		} 
		
		// implement if needed 
		public void remove() { 
			throw new UnsupportedOperationException(); 
		} 
	}

	 // return Iterator instance 
    public Iterator<T> iterator() 
    { 
        return new ListIterator<T>(this); 
    } 
	/* We have both head and tail */
	protected Node head, tail;
	
	/* size */
	protected int listSize;

	public int getSize() {
		return listSize ;
	}

	protected Node reverseListRecursively(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node lastNodeInList = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;

        return lastNodeInList;
    }

	public ArrayList<T> getReverseArrayList(Node head){
        Node currentNode =  this.reverseListRecursively(this.head);
		ArrayList<T> arrList = new ArrayList<T>();
        // int arrayList = new int[listSize+1];

        try{
            while(currentNode != null){
                arrList.add(currentNode.data) ;
                currentNode = currentNode.next; 
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        return arrList;
    }

	public BasicLinkedList<T> addToEnd(T data){
		Node nodeToAdd = new Node(data);

        // if head is null, assign incoming node to it
        if(head == null){
            head = tail = nodeToAdd;
            return this;
        }

        Node nodes = head;
        // keep looping until we find a node with reference to null in its 'next'
        while(nodes.next != null){
            nodes = nodes.next;
        }
        // append nodeToAdd to the last node in list
		nodes.next = nodeToAdd;
		tail = nodeToAdd;
		listSize++;
		return this;
	}

	public BasicLinkedList<T> addToFront(T data){
		Node nodeToAdd = new Node(data);
		if (head == null) {
			head = tail = nodeToAdd;
		}else{
			// put all list in 'next' pointer of new node
			nodeToAdd.next = head;
			// now new node contains whole list, assign it back to head
			head = nodeToAdd;
		}
		listSize++;
		return this;
	}

	public Node getFirst(){
		return head;
	}

	public Node getLast(){
		return tail;
	}

	public T retrieveFirstElement(){
		if(head == null) return null;
		return head.data;
	}

	public T retrieveLastElement(){
		if(tail == null) return null;
		return tail.data;
	}

	public Boolean remove(T data){
		if(head == null) return false;
		Node nodes = head;
		while(nodes.next != null){
			if(nodes.next.data == data){
				nodes = nodes.next.next;
				return true;
			}
			nodes = nodes.next;
		}
		return false;
	}
	
}