package edu.drew.note;

import java.util.Arrays;

public class DictionaryfromSA implements NoteCollection{




	//Nate Tazewell Final project



	public DictionaryfromSA(int capacity) {
		array = (Note[]) new Object[capacity];
		private Note[] array;
		private int numEntries = 0;
		// Situational capacity #
		private static final int DEFAULT_CAPACITY = 20;

		//should return a boolean, and add the note into the sorted array while also placing it 
		//in a position based on it's content
		@Override
		//O(n)
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

					//O(n^2)
					//should return the note that the ID pertains to
					return array[i];
				}

			}

		}


		@Override
		public boolean remove(long ID) {

			//O(n^2)
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

			//O(n^2)
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
		}


		@Override
		public boolean isEmpty() {
			//returns boolean if the array is empty
			if( numEntries == 0) {
				return true;
			}
		}


		private boolean isArrayFull() {
			//O(n)
			//return true if array is full
			return numEntries >= array.length;
		}


		@Override
		//O(1)
		//returns the size
		public int getSize() {
			return numEntries;
			// TODO Auto-generated method stub

		}


		//returns a boolean if the array matches the input
		@Override
		public boolean contains(Note note) {
			for (int i = 0; i < numEntries; i++) {
				if (array[i].equals(note)) {
					return true;
				}
			}	

		}

		//O(n^2)
		//returns a boolean if the ID matches the ID input
		@Override
		public boolean contains(long ID) {
			// TODO Auto-generated method stub
			for(int i=0; i < array.length; i++) {
				if(ID == i) {
					return true;
				}

			}

		}
//sets everything in an array
		@Override
		public Note[] toArray() {
			return Arrays.copyOf(array, numEntries);
			return null;
		}
	}



