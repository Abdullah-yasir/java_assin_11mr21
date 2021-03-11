package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import listClasses.*;

/**
 * 
 * You need student tests if you are looking for help during office hours about
 * bugs in your code.
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests extends BasicLinkedList<String> {

	public StudentTests(){
		this.blist = new BasicLinkedList<>();
		this.slist = new SortedLinkedList<>(String.CASE_INSENSITIVE_ORDER);

		blist.addToEnd("cat");
		blist.addToEnd("dog");
		blist.addToEnd("rat");
		blist.addToEnd("bat");
	}

	private BasicLinkedList<String> blist;
	private SortedLinkedList<String> slist;
	private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	protected class Node<T> {
		protected T data;
		protected Node<T> next;

		protected Node(T data) {
			this.data = data;
			next = null;
		}
		public T getData() {
			return this.data;
		}
	}
	// @Test
	// public void test() {
	
	// 	fail("Not yet implemented");
	// }

	@Test
	public void addToEndTest(){
		assertEquals("bat", blist.getLast());
	}

	@Test
	public void addToFrontTest(){
		blist.addToFront("fox");
		assertEquals("fox", blist.getFirst());
	}

	@Test
	public void retrieveFirstElementTest(){
		assertEquals("cat", blist.retrieveFirstElement());
	}

	@Test
	public void retrieveLastElementTest(){
		assertEquals("bat", blist.retrieveLastElement());
	}

	@Test
	public void getFirstTest(){
		Node<String> node = new Node<String>("cat");
		assertEquals(node.getData(), blist.getFirst().getData());
	}
	
	@Test
	public void getLastTest(){
		Node<String> node = new Node<String>("bat");
		assertEquals(node.getData(),blist.getLast().getData());
	}
	
	
	@Test
	public void removeTest(){
		blist.remove("bat");
		assertEquals("rat", blist.getLast().getData());
	}
	
	@Test
	public void getSizeTest(){
		assertEquals(4, blist.getSize());
	}

	@Test
	public void getReverseListTest(){
		assertEquals("expected", "actual");
	}

	@Test
	public void getReverseArrayListTest(){
		ArrayList<String> newList = blist.getReverseArrayList(blist.getHead());
		assertArrayEquals(new String[]{"bat", "rat","dog","cat"}, newList.toArray());
	}
	
	@Test
	public void addTest(){
		slist.add("some");
		assertEquals("some", slist.getLast());
	}

	@Test
    public void printListTest(){
        System.setOut(new PrintStream(outputStreamCaptor));
        blist.printList();
        assertEquals("LIST: cat dog rat bat", outputStreamCaptor.toString().stripTrailing());
        System.setOut(standardOut);
    }
}
