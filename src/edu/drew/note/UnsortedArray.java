package edu.drew.note;

public class UnsortedArray<T> implements NoteCollection {
private Note [] s;
private int numEntries;
private int head;
public UnsortedArray(){
	 s = (Note[])new Object[numEntries];
	 numEntries = 0;
	 head = 0;
	 
	
}
public boolean add(Note newNote) {
	if(isEmpty()){
	s [head] = newNote;
	numEntries ++;
	
	return true;
}
	return false;
}
public Note lookup(long ID) {
	// TODO Auto-generated method stub
	return null;
}
public boolean remove(long ID) {
	// TODO Auto-generated method stub
	return false;
}
public boolean remove(Note note) {
	// TODO Auto-generated method stub
	return false;
}
public boolean isEmpty() {
	
	return s == null;
}
public int getSize() {
	// TODO Auto-generated method stub
	return numEntries;
}
public boolean contains(Note note) {
	// TODO Auto-generated method stub
	boolean found = false;
	int i = 0;
	while(!found && (i < s.length))
	{
		if(note.equals(s[i]))
			found = true;
		    i++;
	}
	return found;
	
}
public boolean contains(long ID) {
	// TODO Auto-generated method stub
	return false;
}
public Note[] toArray() {
	// TODO Auto-generated method stub
	Note[] result = (Note[]) new Object[numEntries];
	for(int i= 0; i < numEntries; i++)
		result[i] = s[i];
	return result;
	
}
	
}
