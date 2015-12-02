package edu.drew.note;

public interface NoteCollection<Note> {

	//Adds new entry to the collection.
	public boolean add(Note newNote);
	
	// Returns a specific note by its id
	public Note lookup(long ID);
	
	// Removes a specific note by its id
	public boolean remove(long ID);
	
	// Removes a note by its object
	public boolean remove(Note note);
	
	//Checks to see whether the collection is empty.
	//returns true if it is, and false if otherwise.
	public boolean isEmpty();
	
	//Returns the size of the note collection.
	public int getSize();
	
	//sees whether anEntry is in the collection.
	public boolean contains(Note note);
	public boolean contains(long ID);

	// Returns an array of Notes
	public Note[] toArray();
}
