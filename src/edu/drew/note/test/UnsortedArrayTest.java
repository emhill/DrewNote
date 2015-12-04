package edu.drew.note.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.drew.note.ArrayListCollection;
import edu.drew.note.Note;
import edu.drew.note.UnsortedArray;

public class UnsortedArrayTest {
	private static final int SIZE = 100;
	private Note[] array = new Note[SIZE];
	private UnsortedArray notes = new UnsortedArray();
	
	
	protected void setUp() {
		array = new Note[SIZE];
		for (int i = 0; i < SIZE; i++)
			array[i] = new Note();
	}

	private Note addOneElement() {
		notes = new UnsortedArray();
		Note n = new Note();
		notes.add(n);
		return n;
	}
	
	private int addManyElements() {
		notes = new UnsortedArray();
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
		notes = new UnsortedArray();
		assertTrue(notes.isEmpty());
	}
	
	@Test
	public void testIsNotEmpty() {
		notes = new UnsortedArray();
		notes.add(new Note());
		assertFalse(notes.isEmpty());
	}
	
	@Test
	public void testSizeOne() {
		notes = new UnsortedArray();
		notes.add(new Note());
		assertEquals(1, notes.getSize());
	}

}
