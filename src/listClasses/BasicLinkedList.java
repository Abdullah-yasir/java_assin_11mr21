package listClasses;

import java.util.*;

public class BasicLinkedList<T> implements Iterable<T> {
	/* We have both head and tail */
	protected Node head, tail;
	
	/* size */
	protected int listSize;
		
	/* Node definition */
	protected class Node {
		protected T data;
		protected Node next;

		protected Node(T data) {
			this.data = data;
			next = null;
		}
		public T getData() {
			return this.data;
		}
	}

	/* List Iterator definition */
	protected class ListIterator implements Iterator<T>{
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
        return new ListIterator(this); 
    } 
	
	public int getSize() {
		return listSize+1;
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
		Node current = head;

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

	public Node getHead(){
		return head;
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

	public Boolean remove(T data, Comparator<T> c){
		// Store head node
        Node temp = head, prev = null;
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == data) {
            head = temp.next; // Changed head
            return true;
        }
 
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }
 
        // If key was not present in linked list
        if (temp == null)
            return false;
 
        // Unlink the node from linked list
        prev.next = temp.next;

		// updating tail
		Node lastNodeInList = this.head;
        while(lastNodeInList.next != null){
            lastNodeInList = lastNodeInList.next;
        }
        tail = lastNodeInList;
		return true;
	}

	public Boolean remove(T data){
		// Store head node
        Node temp = head, prev = null;
 
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == data) {
            head = temp.next; // Changed head
            return true;
        }
 
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }
 
        // If key was not present in linked list
        if (temp == null)
            return false;
 
        // Unlink the node from linked list
        prev.next = temp.next;

		// updating tail
		Node lastNodeInList = this.head;
        while(lastNodeInList.next != null){
            lastNodeInList = lastNodeInList.next;
        }
        tail = lastNodeInList;
		return true;
	}


	public void printList(){
        Node lastNodeInList = this.head;
        if(lastNodeInList == null){
            throw new NullPointerException("List is empty, populate it before printing");
        } else {
            System.out.print("LIST: ");
            while(lastNodeInList.next !=null){
                System.out.print(lastNodeInList.data + " ");
                lastNodeInList = lastNodeInList.next;
            }
           if(lastNodeInList.next == null){
               System.out.println(lastNodeInList.data + " ");
           }
        }
    }
	
}