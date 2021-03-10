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
public class StudentTests {

	public StudentTests(){
		this.blist = new BasicLinkedList<>();
		this.slist = new SortedLinkedList<>();

		blist.addToEnd("cat");
		blist.addToEnd("dog");
		blist.addToEnd("rat");
		blist.addToEnd("bat");
	}

	private BasicLinkedList<String> blist;
	private SortedLinkedList<String> slist;
	private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

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
		assertEquals("cat", blist.getFirst());
	}
	
	@Test
	public void getLastTest(){
		assertEquals("bat", blist.getLast());
	}
	
	
	@Test
	public void removeTest(){
		blist.remove("bat");
		assertEquals("rat", blist.getLast());
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
		assertEquals("expected", "actual");
	}

	@Test
    public void printListTest(){
        System.setOut(new PrintStream(outputStreamCaptor));
        blist.printList();
        assertEquals("LIST: cat dog rat bat", outputStreamCaptor.toString().stripTrailing());
        System.setOut(standardOut);
    }
}
