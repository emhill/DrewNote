package edu.drew.note;




public class SortedLinkedList implements NoteCollection {
	private Node head;
	private int numEntries;
	public SortedLinkedList(){
		head = null;
		numEntries = 0;
	}
	@Override
	public boolean add(Note newNote) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newNote, head);
		numEntries ++;
		return true;
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
		// TODO Auto-generated method stub
		return numEntries == 0;
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
		return null;
	}
	private class Node {
		  private int id; // Note's id
		  private Note note; // Note Obj
		  private Node next; // Pointer to next note in the dictionary

			private Node(Note newNote, Node head) {
				this(newNote, head, null);	
			} 
			
			private Node(long id, Note note, Node nextNode) {
				id = id; // Unique ID of note
				note = note; // Note stored here
				next = nextNode; // Pointer to next note
			} 
		}
}
