package edu.drew.note;

import java.util.Arrays;

public class DictionaryfromSA implements NoteCollection{




	//Nate Tazewell Final project

	private Note[] array;
	private int numEntries = 0;
	// Situational capacity #
	private static final int DEFAULT_CAPACITY = 20;

	public DictionaryfromSA(int capacity) {
		array = (Note[]) new Object[capacity];

		//should return a boolean, and add the note into the sorted array while also placing it 
		//in a position based on it's content
		@Override
		public boolean add(Note newNote) {
			if (!isArrayFull()) {
				array[numEntries] = newNote;
				numEntries++;
				return true;
			}

			return false;
		}

		@Override
		public Note lookup(long ID) {

			for(int i=0; i < array.length; i++) {
				if(ID == i) {
					//should return the note that the ID pertains to
					return Note;
				}
			}

		}

		@Override
		public boolean remove(long ID) {
			//takes the note away based on ID
			for(int i=0; i < array.length; i++) {
				if(ID == i) {
					array[i] = array[numEntries-1];
					numEntries--;
					array[numEntries] = null; 
					return true;
				}
			}
			return false;

			return false;
		}

		@Override
		public boolean remove(Note note) {
			//should be able to loop through the array and take away the note
			for (int i = 0; i < numEntries; i++) {
				if (array[i].equals(note)) {
					array[i] = array[numEntries-1];
					numEntries--;
					array[numEntries] = null;
					return true;
				}
			}
			return false;
			return false;
		}

		@Override
		public boolean isEmpty() {
			//returns boolean if the array is empty
			if( numEntries == 0) {
				return true;
			}
		}

		private boolean isArrayFull() {
			//return true if array is full
			return numEntries >= array.length;
		}

		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean contains(Note note) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(long ID) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Note[] toArray() {
			return Arrays.copyOf(array, numEntries);
			return null;
		}
	}


