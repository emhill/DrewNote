package edu.drew.note;

// Implementation of a sorted note dictionary create my Chris Thurber

public class DictionarySortedList implements NoteCollection{

	private Node head = new Node();
	private int numEntries = 0;
	
	// Adds item to data structure
	public boolean add(Note note) {
		if (note == null) {
			return false;
		}
		head = new Node(note, head);
		numEntries++; // Update number of notes
		return true; // Node added
	}
	
	// Inserts note at specific location
	public boolean insertAt(Note note, int spot) {
		if(spot>numEntries) return false;
		else {
			int count = 0;
			Node n = head;
			Node prev = head;
			while(count<spot){
				prev = n;
				n = n.next;
				count++;
			}
			prev.next = new Node(note,n);
			numEntries++;
			return true;
		}
	}
	
	// Returns ID of note removed
	public long remove() {
		long removed = head.id;
		head = head.next;
		return removed;
	}

	// Removes Note object 'note' from the data structure
	public boolean remove(Note note) {
		Node n = head;
		while(n!=null) {
			if(n.note.equals(note)) {
				return true;
			}
			n=n.next;
		}
		return false;
	}
	
	// Removes specific item from data structure with 'id'
	public boolean remove(long ID) {
		Node n = head;
		Node prev = head;
		while(n!=null) {
			if(n.id == ID){
				prev.next = n.next;
				return true;
			}
			prev = n;
			n=n.next;
		}
		return false;
	}
	
	// Searches the data structure for a note with 'ID'
	public Note lookup(long ID) {
		Node n = head;
		while(n!=null){
			if(n.note.getID() ==ID) {
				return n.note;
			}
			n=n.next;
		}
		return null;
	}
	
	// Checks if the data structure contains 'note'
	public boolean contains(Note note) {
		Node n  = head;
		while(n!=null) {
			if(n.note.equals(note)) {
				return true;
			}
			n=n.next;
		}
		return false;
	}
	
	// Checks if the data structure contains a note with 'ID'
	public boolean contains(long ID) {
		Node n = head;
		while(n!=null) {
			if(n.note.getID() == ID) {
				return true;
			}
		}
		return false;
	}
	
	// Replaces note at 'id' with another note Node
	public boolean replace(long ID,Node note) {
		Node n = head;
		Node next = head.next;
		while(n!=null) {
			if(n.id == ID){
				n = note;
				n.next = next;
				return true;
			}
			n=n.next;
			if(n.next!=null)next = n.next;
		}
		return false;
	}
	
	// Clears out the data structure
	public void clear() {
		head = null;
		numEntries = 0;
	}

	// Returns size of data structure
	public int getSize() {
		return numEntries;
	}
	
	// Determines whether or not data structure is empty
	public boolean isEmpty() {
		return numEntries==0;
	}
	
	// Converts data structure to an array
	public Note[] toArray() {
		Note[] notes = new Note[getSize()];
		Node n = head;
		for(int i=0;i<getSize(); i++) {
			notes[i] = head.note;
			n=n.next;
		}
		return notes;
	}
	
	// Converts data structure to a string to be printed to the console
	public String toString(){
		String dict="{";
		Node n = head;
		while(n.next!=null){
			dict += "'"+n.id+"' : '"+n.note.getTitle()+"', ";
			n=n.next;
		}
		dict += "'"+numEntries+"' : '"+n.note.getTitle()+"'";
		dict+="}";
		return dict;
	}
	
	// Node class imported from other projects; modified to stores note ids and Text
	private class Node {
		private int id; // Note's id
		private Note note; // Note Obj
		private Node next; // Pointer to next note in the dictionary
	
		public Node() {
			note = null;
			next = null;
		}

		private Node(Note note) {
			this(note, null);	
		} 
			
		private Node(Note note, Node nextNode) {
			note = note; // Note stored here
			next = nextNode; // Pointer to next note
		}

	}

	public static void main(String[] args) {
		DictionarySortedList thing = new DictionarySortedList();
		Note a = new Note("Hello","hello");
		thing.add(a);
		thing.add(a);
		thing.contains(a);
	}
	
}
