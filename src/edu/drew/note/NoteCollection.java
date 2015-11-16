package edu.drew.note;

public interface NoteCollection<T> {

	//Adds new entry to the collection.
	public boolean add(Note newNote);
	
	// Removes a Note and returns it
	public long remove();
	
	// Removes a specific note
	public boolean remove(long ID);
	
	//Checks to see whether the collection is empty.
	//returns true if it is, and false if otherwise.
	public boolean isEmpty();
	
	//Returns the size of the note collection.
	public int getSize();
	
	//sees whether anEntry is in the collection.
	public boolean contains(Note note);

	// Returns an array of ...? 
	public Note[] toArray(Note[] array);
}
