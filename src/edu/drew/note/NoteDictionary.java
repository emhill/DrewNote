package edu.drew.note;

public class NoteDictionary {

	private Node head;
	private int numEntries = 0;
	
	// Adds item to NodeDict
	public boolean add(Note note) {
		head = new Node(note.getID(), note, head);
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
			prev.next = new Node(note.getID(),note,n);
			numEntries++;
			return true;
		}
	}
	
	// Returns ID of note removed
	public long remove() {
		long removed = head.note.getID();
		head = head.next;
		return removed;
	}
	
	// Removes specific item from NoteDict of 'id'
	public boolean remove(long ID) {
		Node n = head;
		Node prev = head;
		while(n!=null) {
			if(n.note.getID() == ID){
				prev.next = n.next;
				return true;
			}
			prev = n;
			n=n.next;
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
	
	// Clears out the NodeDict
	public void clear() {
		head = null;
		numEntries = 0;
	}

	// Returns size of NodeDict
	public int getSize() {
		return numEntries;
	}
	
	public boolean isEmpty() {
		return numEntries==0;
	}
	
	// Converts NodeDictionary to a string to be printed to the console
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
	  private Note note; // Note's text
	  private Node next; // Pointer to next note in the dictionary

		private Node(long id, Note note) {
			this(id, note, null);	
		} 
		
		private Node(long id, Note note, Node nextNode) {
			id = id; // Unique ID of note
			note = note; // Note stored here
			next = nextNode; // Pointer to next note
		} 
	} 

}
