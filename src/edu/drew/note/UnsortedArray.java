package edu.drew.note;

import java.util.Arrays;



public class UnsortedArray implements NoteCollection {
private Note [] s;
private int numEntries;
private static final int CAPACITY = 10;
public UnsortedArray(int capacity){
	 s = new Note[capacity];
	 numEntries = 0;
	
	 
	
}
@Override
public boolean add(Note newNote) {
	if(!isArrayFull()){
	s [numEntries] = newNote;
	numEntries ++;
	return true;
}
	return false;
}

private boolean isArrayFull() {
			//return true if array is full
			return numEntries >= s.length;
		}
@Override
public Note lookup(long ID) {
	// TODO Auto-generated method stub
	for(int i = 0; i < s.length;i++){
		if(ID == i){
			return s[i];
		}
		
	}
	return null;
}
public boolean remove(long ID) {
	// TODO Auto-generated method stub
	
	
	return false;
	

}
@Override
public int getSize() {
	// TODO Auto-generated method stub
	return numEntries;
}
@Override
public boolean remove(Note note) {
	// TODO Auto-generated method stub
	for(int i = 0; i< numEntries; i ++){
		if(s[i].equals(note)){
			s[i] = s[numEntries -1];
			numEntries--;
			s[numEntries] = null;
			return true;
		}
			
	}
	return false;
}
@Override
public boolean isEmpty() {
	
	return numEntries == 0;
}

@Override
public boolean contains(Note note) {
	// TODO Auto-generated method stub
	boolean found = false;
	int i = 0;
	while(!found && (i < s.length))
	{
		if(note.equals(s[i])){
			found = true;
		    i++;
		}
	}
	return found;
	
}
@Override
public boolean contains(long ID) {
	// TODO Auto-generated method stub
	
	return false;
}
@Override
public Note[] toArray() {
	// TODO Auto-generated method stub
	
    return Arrays.copyOf(s,numEntries);
}

	
}
