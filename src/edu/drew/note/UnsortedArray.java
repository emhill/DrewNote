package edu.drew.note;

public class UnsortedArray<T> implements NoteCollection<T> {
private Note [] s;
private int numEntries;
private int head;
public UnsortedArray(){
	 s = (Note[])new Object[numEntries];
	 numEntries = 0;
	 head = 0;
	 
	
}
@Override
public boolean add(Note newNote) {
	if(isEmpty()){
	s [head] = newNote;
	numEntries ++;
	
	return true;
}
	return false;
}
@Override
public Note lookup(long ID) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public boolean remove(long ID) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean remove(Note note) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean isEmpty() {
	
	return s == null;
}
@Override
public int getSize() {
	// TODO Auto-generated method stub
	return numEntries;
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
	// TODO Auto-generated method stub
	Note[] result = (Note[]) new Object[numEntries];
	for(int i =0; i < numEntries; i++)
		result[i] = s[i];
	return result;
	
}
	
}
