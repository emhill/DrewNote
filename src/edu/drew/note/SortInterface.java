package edu.drew.note;
import java.util.HashMap;
import java.util.LinkedList;

public interface SortInterface {
	
	public Note[] sort(Note[] s);
	
	public LinkedList<Note> sort(LinkedList<Note> l);
	
	public HashMap<T,Note> sort(HashMap<T,Note>);
	
}
