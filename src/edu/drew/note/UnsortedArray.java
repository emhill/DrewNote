package edu.drew.note;

public class UnsortedArray<T> implements NoteCollection<T> {
private Note [] s;
private int head;
public UnsortedArray(){
	 s = null;
	 head = 0;
	
}
@Override
public boolean add(Note newNote) {
	if(isEmpty()){
	s [head] = newNote;
	head ++;
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
	// TODO Auto-generated method stub
	
	return null;
}
	
}
