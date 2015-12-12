//created by Andrew Rupkey
package edu.drew.note;

/*as one of the classes of the NoteCollection interface this
class makes a dictionary of notes based off an unsorted
linked list, the dictionary's keys are the note's id value
and the dictionary's value under these keys are the note
objects themselves*/ 
public class DictionaryUnsortedList implements NoteCollection{

private Node firstNode;
private int numEntries;

//interior node class provides linked list structure
private class Node{
	private long id;	//note's id
	private Note Note;	//note object
	private Node next;	//pointer to next node
	
	//constructor for when adding first note to empty dictionary
	private Node(long key, Note value){
		this(key,value,null);
	}
	
	//constructor for all other notes added
	private Node(long key, Note value, Node nextNode){
		id=key;			//note's id
		Note=value;		//note object
		next=nextNode;	//pointer to next node
	}
}

	//adds new entry to dictionary
	public boolean add(Note newNote){
		if(newNote!=null){
		firstNode=new Node(newNote.getID(),newNote,firstNode);
		numEntries++;
		return true;
		}
		return false;
	}
	
	//returns an array representation of the dictionary
	public Note[] toArray(){
		Note[] array= new Note[getSize()];
		Node n=firstNode;
		for(int i=0; i<getSize();i++){
			array[i]=firstNode.Note;
			i++;
			n=n.next;
		}
		return array;
	}
	
	//returns a string representation of the dictionary
	public String toString(){
		String s="";
		Node n=firstNode;
		while (n!=null){
			s+=n.Note+"->";
			n=n.next;
		}
		s+=null;
		return s;
	}
	
	//checks if dictionary is empty
	public boolean isEmpty(){
		if(numEntries<1){
			return true;
		}
		return false;
	}
	
	//removes an item from the dictionary by its id
	//returns true if successful, false if not
	public boolean remove(long ID) {
		Node n=firstNode;
		Node prev=null;
		while (n!=null){
			if (n.id==ID){
				if (prev==null){
					firstNode=n.next;
				}
				else
					prev.next=n.next;
					numEntries--;
			}
			prev=n;
			n=n.next;
		}
		return false;
	}

	//removes an item from the dictionary by its note
	//returns true if successful, false if not
	public boolean remove(Note note) {
		Node n=firstNode;
		Node prev=null;
		while (n!=null){
			if (n.Note.equals(note)){
				if (prev==null){
					firstNode=n.next;
				}
				else
					prev.next=n.next;
					numEntries--;
			}
			prev=n;
			n=n.next;
		}
		return false;
	}
	
	//removes all notes from dictionary
	public void clear(){
			firstNode=null;
			numEntries=0;
	}
	
	//searches for a note in the dictionary by its id
	//returns null if not found
	public Note lookup(long ID) {
		Node n=firstNode;
		while(n!=null){
			if(n.id==ID){
				return n.Note;
			}
			n=n.next;
		}
		return null;
	}

	//looks up size of dictionary
	public int getSize() {
		return numEntries;
	}

	//searches for a note in dictionary based off note
	public boolean contains(Note note) {
		Node n=firstNode;
		while(n!=null){
			if(n.Note.equals(note)){
				return true;
			}
			n=n.next;
		}
		return false;
	}

	//searches for a note in dictionary based off id
	public boolean contains(long ID) {
		Node n=firstNode;
		while(n!=null){
			if(n.id==ID){
				return true;
			}
			n=n.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
