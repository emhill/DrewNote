package edu.drew.note;

public interface NoteCollection<T> {

//Checks to see whether the collection is empty.
//returns true if it is, and false if otherwise.
public boolean isEmpty();

//Returns the size of the note collection.
public int size();

//sees whether anEntry is in the collection.
public boolean contains(T anEntry);
//Adds new entry to the collection.
public boolean add(T newEntry);
//
public T [] toArray(T[] array);
}
