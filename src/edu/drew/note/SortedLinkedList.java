//SortedLinkedList with Sequential Search by Thomas Cotroneo

package edu.drew.note;

public class SortedLinkedList<T> implements NoteCollection {
	
	private int numEntries = 0;
	private Node head = null;
	private class Node {
		private Note note;
		private Node next = null;
		public Node(Note n, Node d) {
			note = n;
			next = d;
		}
		
	}
	
	@Override
	public boolean add(Note note) {
		if (note != null) {
			Node n = head;
			if (n == null) {
				head = new Node(note, head);
				numEntries++;
				return true;
			}
			while (n != null) {
				long ID = n.note.getID();
				if (ID == n.note.getID()) {
					Node newNode = new Node(note, n.next);
					n.next = newNode;
					numEntries++;
					return true;
				}
				else
					n = n.next;
			}
			
		}
		return false;
	}

	@Override
	public Note lookup(long ID) {
		Node n = head;
		while (n != null){
			if (ID == n.note.getID()) {
				return n.note;
			}
			else	
				n = n.next;
		}
		return null;
	}

	@Override
	public boolean remove(long ID) {
		Node n = head;
		Node prev = null;
		while (n != null) {
			if (ID == n.note.getID()) {
				if (prev == null)
					head = n.next;
				else
					prev.next = n.next;
					numEntries--;
					return true;
			}
			prev = n;
			n = n.next;
		}
		return false;
	}
	
	@Override
	public boolean remove(Note note) {
		Node n = head;
		Node prev = null;
		while (n != null) {
			if (note == n.note) {
				if (prev == null)
					head = head.next;
				else
					prev.next = n.next;
					numEntries--;	
					return true;
			}
			prev = n;
			n = n.next;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return numEntries == 0;
	}

	@Override
	public int getSize() {
		return numEntries;
	}

	@Override
	public boolean contains(Note note) {
		Node n  = head;
		while (n != null) {
			if(note == n.note) {
				return true;
			}
			n = n.next;
		}
		return false;
	}
	
	/*@Override
	public boolean contains(long ID) {
		return lookup(ID) != null;
	}*/
	
	@Override
	public boolean contains(long ID) {
		Node n = head;
		while (n != null) {
			if (ID == n.note.getID()) {
				return true;
			}
			n = n.next;
		}
		return false;
	}
	
	@Override
	public Note[] toArray() {
		Note[] array = new Note[numEntries];
		Node n = head;
		int i = 0;
		while (n != null) {
			array[i] = n.note;
			n = n.next;
		}
		return array;
	}
	
}