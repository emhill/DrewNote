package edu.drew.note;

public class SortedLinkedList implements NoteCollection {
	private Node head;
	private int numEntries;
	public SortedLinkedList(){
		head = null;
		numEntries = 0;
	}
	
	public boolean add(Note newNote) {
		Node newNode = new Node(newNote, head);
		numEntries ++;
		return true;
	}
	
	public Note lookup(long ID) {
	    Node n = head;
	    Node prev = head;
		if (numEntries == 0) {
	        return null;
	    }
		
		boolean found = false;
	    
		while(n != null) {
	        if(n.data.equals(ID)) {
	            found = true;
	            break;
	        }
	        n = n.next;
	    }
	    return n.data;
	}

	public boolean remove(long ID) {
		Node n = head;
		Node prev = head;
		while (n != null); {
			if (n.data.equals(ID)) {
				prev.next = n.next;
				return true;
			}
			prev = n;
			n = n.next;
		}
		return false;
	}

	public boolean remove(Note note) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		return numEntries == 0;
	}

	public int getSize() {
		return numEntries;
	}

	public boolean contains(Note note) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(long ID) {
		Node n = head;
		while (n != null) {
			if (n.data.equals(ID)) {
				return true;
			}
			n = n.next;
		}
		return false;
	}

	public Note[] toArray() {
		Note[] array = (Note[]) new Object[numEntries];
		Node n = head;
		int i = 0;
		while (n != null) {
			array[i] = n.data;
			i++;
			n = n.next;
		}
		return array;
	}
	
	private class Node {
		private int id; // Note's id
		private Note data; //Note's data
		private Note note; // Note Obj
		private Node next; // Pointer to next note in the dictionary

<<<<<<< HEAD
			private Node(Note newNote, Node head) {
				this(10, note,null);	
			} 
=======
		private Node(Note newNote, Node head) {
			this(newNote, head, null);	
		} 
>>>>>>> b9a552658a0ed3da356de82e35c3dfb91b08d2a8
			
		private Node(Note newNote, Node Note, Node nextNode) {
			newNote = newNote; // Unique ID of note
			Note = Note; // Note stored here
			next = nextNode; // Pointer to next note
		} 
	}
}
