package edu.drew.note;

import java.util.Date;

// Implementation of a sorted note dictionary create my Chris Thurber

public class DictionarySortedList implements NoteCollection {

	private Node head;
	private int numEntries = 0;
	
	// Adds item to data structure based on its creation date
	// -- Not working for "many" cases
	/*public boolean add(Note note) {
		System.out.println(this.toString());
		if(note != null && numEntries == 0) {
			head = new Node(note,head);
			numEntries++;
			return true;
		}
		else if(note != null && numEntries > 1) {
			Date created = note.getCreated();
			Node n = head;
			
			while(n!=null){
				if(n.note.getCreated().equals(created)) {
					Node t = new Node(note,n.next);
					n.next = t;
					numEntries++;
					return true;
				} else if(created.after(n.note.getCreated())) {
					n = n.next;
				} else {
					Node t = new Node(note,n.next);
					n.next = t;
					numEntries++;
					return true;
				}
			}
		}
		return false;
	}*/
	
	// Adds item to data structure in order of Note's ID 
	public boolean add(Note note) {
		if(note != null) {
			Node n = head;
			
			if(n == null) {
				head = new Node(note,head);
				numEntries++;
				return true;
			}
			
			while(n!=null) {
				long curNodeID = n.note.getID();
				if (curNodeID == n.note.getID()) {
					Node q = new Node(note, n.next);
					n.next = q;
					numEntries++;
					return true;
				}
				else if(curNodeID > note.getID()) {
					n = n.next;
				} 
			}
		}
		return false;
	}
	
	// Adds item to data structure
	/*public boolean add(Note note) {
		if (note != null) {
			head = new Node(note, head);
			numEntries++;
			return true; // Node added
		}
		return false;
	}*/
	
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
		long removed = head.note.getID();
		head = head.next;
		numEntries--;
		return removed;
	}

	// Removes Note object 'note' from the data structure
	public boolean remove(Note note) {
		
		Node n = head;
		Node prev = null;
		while(n!=null) {
			if(n.note.equals(note)) {
				if (prev == null) {
					head = head.next;
				}
				else {
					prev.next = n.next; // all other cases
				}
				return true;
			}
			prev = n;
			n=n.next;
		}
		return false;
	}
	
	// Removes specific item from data structure with 'id'
	public boolean remove(long ID) {
		
		Node n = head;
		Node prev = null;
		while(n!=null) {
			if(n.note.getID() == ID) {
				if (prev == null) {
					head = head.next;
				}
				else {
					prev.next = n.next; // all other cases
				}
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
		while(n.note!=null){
			if(n.note.getID() == ID) {
				return n.note;
			}
			n=n.next;
		}
		return null;
	}
	
	// Checks if the data structure contains 'note'
	public boolean contains(Note note) {
		if(numEntries == 0) {
			return false;
		}
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
		if(numEntries == 0) {
			return false;
		}
		Node n = head;
		while(n!=null) {
			if(n.note.getID() == ID) {
				return true;
			}
			n = n.next;
		}
		return false;
	}
	
	// Replaces note at 'id' with another note Node
	public boolean replace(long ID,Node note) {
		Node n = head;
		Node next = head.next;
		while(n!=null) {
			if(n.note.getID() == ID){
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
		head = new Node();
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
			notes[i] = n.note;
			n=n.next;
		}
		return notes;
	}
	
	//returns a string representation of the dictionary
	public String toString(){
		String str="";
		Node n= head;
		while (n!=null){
			str += n.note+"->";
			n = n.next;
		}
		str += null;
		return str;
	}
	
	// Node class imported from other projects; modified to stores note ids and Text
	private class Node {
		private long id;
		private Note note; // Note Obj
		private Node next; // Pointer to next note in the dictionary
	
		public Node() {
			note = new Note();
			id = note.getID();
			next = null;
		}

		private Node(Note n) {
			id = n.getID();
			note = n;
			next = null;
		} 
			
		private Node(Note n, Node nextNode) {
			id = n.getID();
			note = n; // Note stored here
			next = nextNode; // Pointer to next note
		}

	}
	
}
