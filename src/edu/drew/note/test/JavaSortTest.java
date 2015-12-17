package edu.drew.note.test;

import static org.junit.Assert.*;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

import edu.drew.note.JavaSort;
import edu.drew.note.Note;

public class JavaSortTest {
	JavaSort js = new JavaSort();
	private static final int SIZE = 100;
	private Note[] array = new Note[SIZE];

	@Before
	public void setUp() throws Exception {
		initialize(array);
	}

	private void initialize(Note[] array) {
		for (int i = 0; i < array.length; i++)
			array[i] = new Note();
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
	public void testSortEmpty() {
		Note[] unsorted = {};
		Note[] sorted   = {};
		assertArrayEquals(sorted, js.sort(unsorted));
	}

	@Test
	public void testSortDefault() {
		Note n = new Note();
		Note[] unsorted = {n};
		Note[] sorted   = {n};
		assertArrayEquals(sorted, js.sort(unsorted));
	}

	@Test
	public void testSorted() {
		Note[] unsorted = array.clone();
		Note[] sorted   = array;
		assertArrayEquals(sorted, js.sort(unsorted));
	}

	@Test
	public void testUnsorted() {
		Note[] unsorted = {array[25], array[13], array[45], array[4]};
		Note[] sorted   = {array[4], array[13], array[25], array[45]};
		assertArrayEquals(sorted, js.sort(unsorted));
	}

	@Test
	public void testShuffled() {
		Note[] shuffle = new Note[SIZE];
		for (int i = 0; i < SIZE; i++)
			shuffle[i] = array[i];
		shuffleArray(shuffle);
		Note[] unsorted = shuffle;
		Note[] sorted   = array;
		assertArrayEquals(sorted, js.sort(unsorted));
	}

	@Test
	public void testReverseSorted() {
		Note[] rev = new Note[SIZE];
		int j = SIZE-1;
		for (int i = 0; i < SIZE; i++) {
			rev[j] = array[i];
			j--;
		}
		Note[] unsorted = rev;
		Note[] sorted   = array;
		assertArrayEquals(sorted, js.sort(unsorted));
	}

	@Test
	public void testTime() {
		long start, end;
		double time;
		double average = 0;
		int runs = SIZE;
		Note[] shuffle = new Note[SIZE * SIZE];
		initialize(shuffle);
		for (int i = 0; i < runs; i++) {
			shuffleArray(shuffle);
			start = System.nanoTime();
			js.sort(shuffle);
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
