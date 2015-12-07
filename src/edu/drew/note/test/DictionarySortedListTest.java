package edu.drew.note.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import java.util.Random;
import org.junit.Test;
import edu.drew.note.DictionarySortedList;
import edu.drew.note.Note;

public class DictionarySortedListTest extends TestCase {
	private static final int SIZE = 100;
	private Note[] array = new Note[SIZE];
	private Note[] shuffled=new Note[SIZE];
	private DictionarySortedList notes = new DictionarySortedList();
	
	@Override
	protected void setUp() {
		array = new Note[SIZE];
		for (int i = 0; i < SIZE; i++){
			array[i] = new Note("HELLO","It's me, Adelle");
			shuffled[i]=array[i];
		}
		shuffleArray(shuffled);
	}

	private Note addOneElement() {
		notes = new DictionarySortedList();
		Note n = new Note();
		notes.add(n);
		return n;
	}
	
	private int addManyElements() {
		notes = new DictionarySortedList();
		for (int i = 0; i < SIZE; i++)
			notes.add(array[i]);
		return SIZE;
	}
	
	@Test
	public void testAddNullElement() {
		int n = notes.getSize();
		// no exceptions!
		notes.add(null);
		assertEquals(n, notes.getSize());
	}
	
	@Test
	public void testIsEmpty() {
		notes = new DictionarySortedList();
		assertTrue(notes.isEmpty());
	}
	
	@Test
	public void testIsNotEmpty() {
		notes = new DictionarySortedList();
		notes.add(new Note());
		assertFalse(notes.isEmpty());
	}
	
	@Test
	public void testSizeOne() {
		notes = new DictionarySortedList();
		notes.add(new Note());
		assertEquals(1, notes.getSize());
	}
	
	@Test
	public void testSizeMany() {
		int size = addManyElements();
		assertEquals(size, notes.getSize());
	}
	
	@Test
	public void testAddOne() {
		Note n = addOneElement();
		assertEquals(1, notes.getSize());
		assertTrue(notes.contains(n));
	}
	
	@Test
	public void testAddMany() {
		notes.clear();
		int size = addManyElements();
		assertEquals(size, notes.getSize());
		for (int i = 0; i < size; i++) {
			assertTrue(notes.contains(array[i].getID()));
			assertTrue(notes.contains(array[i]));
		}
	}
	
	@Test
	public void testAddManyShuffled() {
		notes = new DictionarySortedList();
		for (int i = 0; i < SIZE; i++)
			notes.add(shuffled[i]);
		assertEquals(SIZE, notes.getSize());
		for (int i = 0; i < SIZE; i++) {
			assertTrue(notes.contains(array[i]));
			assertTrue(notes.contains(array[i].getID()));
		}
		System.out.println("HERE: "+notes.toString());
	}
	
	@Test
	public void testLookupOne() {
		Note n = addOneElement();
		assertEquals(n, notes.lookup(n.getID()));
		assertTrue(notes.contains(n));
	}
	
	@Test
	public void testLookupMany() {
		int size = addManyElements();
		assertEquals(size, notes.getSize());
		for (int i = 0; i < size; i++) {
			assertEquals(array[i], notes.lookup(array[i].getID()));
		}
	}
	
	@Test
	public void testRemoveOneNote() {
		Note n = addOneElement();
		notes.remove(n);
		assertFalse(notes.contains(n));
	}
	
	@Test
	public void testRemoveOneNoteByID() {
		Note n = addOneElement();
		notes.remove(n.getID());
		assertFalse(notes.contains(n.getID()));
	}
	
	@Test
	public void testRemoveEmpty() {
		notes = new DictionarySortedList();
		Note n = new Note();
		// below should throw no exceptions!
		notes.remove(null);
		notes.remove(n);
		notes.remove(n.getID()); 
	}
	
	@Test
	public void testRemoveManyNotes() {
		int size = addManyElements();
		for (int i = 0; i < size; i++) {
			notes.remove(array[i]);
			assertFalse(notes.contains(array[i]));
		}
	}

	@Test
	public void testRemoveManyNotesByID() {
		int size = addManyElements();
		for (int i = 0; i < size; i++) {
			notes.remove(array[i].getID());
			assertFalse(notes.contains(array[i].getID()));
		}
	}
	
	@Test
	public void testRemoveManyShuffledNotesByID() {
		notes = new DictionarySortedList();
		for (int i = 0; i < SIZE; i++)
			notes.add(shuffled[i]);
		assertEquals(SIZE, notes.getSize());
		for (int i = 0; i < SIZE; i++) {
			notes.remove(array[i].getID());
			assertFalse(notes.contains(array[i].getID()));
		}
	}
	
	@Test
	public void testToArrayEmpty() {
		notes = new DictionarySortedList();
		Note[] a = notes.toArray();
		assertEquals(0, a.length);
	}
	
	@Test
	public void testToArrayOne() {
		Note n = addOneElement();
		Note[] a = notes.toArray();
		assertEquals(1, a.length);
		assertEquals(n, a[0]);
	}

	@Test
	public void testToArrayMany() {
		int size = addManyElements();
		Note[] a = notes.toArray();
		assertEquals(size, a.length);
		// since the input order is the sorted order, 
		// should be able to check all
//		for (int i = 0; i < size; i++) {
//			assertEquals(array[i], a[i]);
//		}
	}
	
	private void shuffleArray(Note[] ar)
	{
		Random rnd = new Random();
		for (int i = ar.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Simple swap
			Note a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}
	
	@Test
	public void testTime() {
		long start, end;
		double time;
		double average = 0;
		int runs = SIZE;
		Note[] shuffle = new Note[SIZE * SIZE];
		long[] ids = new long[SIZE * SIZE];
		for (int i = 0; i < shuffle.length; i++) {
			shuffle[i] = new Note();
			ids[i] = shuffle[i].getID();
		}
		
		for (int j = 0; j < runs; j++) {
			shuffleArray(shuffle);
			start = System.nanoTime();
			// begin test
			notes = new DictionarySortedList();
			for (int i = 0; i < shuffle.length; i++)
				notes.add(shuffle[i]);
			for (int i = 0; i < shuffle.length; i++)
				notes.remove(ids[i]);
			// end test
			end = System.nanoTime();
			time = (end - start) / 1000000d;
			System.out.println(time + "ms ");
			average += time;
		}
		System.out.println("---------------------------\n" + 
							"Average Time for " + runs + " runs: " +
							average / runs + " ms");
	}

}
