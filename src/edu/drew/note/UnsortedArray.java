package edu.drew.note;

import java.util.Arrays;



public class UnsortedArray implements NoteCollection {
private Note [] s;
private int numEntries = 0;
private static final int CAPACITY = 100;
public UnsortedArray(){
	this(CAPACITY);
}
public UnsortedArray(int capacity){
	s = new Note[capacity];
	
	 
	
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
	for(int i = 0; i < numEntries;i++){
		if(ID == i){
			return s[i];
		}
		
	}
	return null;
}
@Override
public boolean remove(long ID) {
	// TODO Auto-generated method stub
	for(int i = 0; i < s.length; i ++){
		if(i == ID){
			s[i] = s[numEntries -1];
			numEntries--;
			s[numEntries] = null;
			return true;
		}
	}
	
	
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
		if(note.equals(s[i])){
			s[i] = s[numEntries-1];
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
	int i =0;
	while(!found && (i <s.length)){
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
	for(int i=0; i < s.length; i++) {
			if(ID == i) {

		return true;
			
		}
		
	}
	return false;
}
@Override
public Note[] toArray() {
	// TODO Auto-generated method stub
	
    return Arrays.copyOf(s,numEntries);
}
//public static void main(String[]args){
	//NoteCollection nc = new UnsortedArray(20);
	//nc.add(new Note());
	//nc.add(new Note());
	//Note [] a = nc.toArray();
	//System.out.println("Enter a note");
}