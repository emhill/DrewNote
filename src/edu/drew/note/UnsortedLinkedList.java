package edu.drew.note;


public class UnsortedLinkedList<T> implements NoteCollection {


		
		public Node firstNote;
		public int numberOfEntries;
		
		public UnsortedLinkedList() {
			numberOfEntries = 0;
			firstNote = null;
		}
		private class Node 
		{
		  private Note    data; // Entry in bag
		  private Node next; // Link to next node

			private Node(Note dataPortion)
			{
				this(dataPortion, null);	
			} // end constructor
			
			private Node(Note dataPortion, Node nextNode)
			{
				data = dataPortion;
				next = nextNode;	
			} // end constructor
		} 

		
		@Override
		public boolean add(Note newNote) {
			
			firstNote = new Node(newNote, firstNote);
			numberOfEntries++;
			return true;
		}

	@Override
	public Note lookup(long ID) {
		Node n = firstNote;
		int i = 0;
		while (n != null) { 
			if (n.data.equals(ID)){
				return n.data;
			}
			else
				n = n.next;
		}
	
		return null;
	}

	@Override
	public boolean remove(long ID) {
		Node n = firstNote;
		Node prev = firstNote;
		while (n != null) {
			if (n.data.equals(ID)) {
				// remove the node
				if (prev == n) // only for the first case
					firstNote = n.next;
				else
					prev.next = n.next; // all other cases
				numberOfEntries--;
				return true;
			}
			prev = n;
			n = n.next;
		}
		return false;
	}

	@Override
	public boolean remove(Note note) {
		Node n = firstNote;
		Node prev = firstNote;
		while (n != null) {
			if (n.data.equals(note)) {
				// remove the node
				if (prev == n) // only for the first case
					firstNote = n.next;
				else
					prev.next = n.next; // all other cases
				numberOfEntries--;
				return true;
			}
			prev = n;
			n = n.next;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (numberOfEntries == 0){
			return true;
		}
		else 
			return false;
	}

	@Override
	public int getSize() {
		Node n = firstNote;
		int i = 0;
		while (n != null) { 
			// do something 
			if (n.data.equals(n)) {
				i++;
			}
			n = n.next;
		}
		return i; 
	}

	@Override
	public boolean contains(Note note) {
		boolean found = false;
		Node n = firstNote;
		int i = 0;
		while (n != null) { 
			if (n.data.equals(note)){
				return true;
			}
			else
				n = n.next;
		}
	
		return false;
	}

	@Override
	public boolean contains(long ID) {
		boolean found = false;
		Node n = firstNote;
		int i = 0;
		while (n != null) { // could also be for i < numEntries
			// do something -- copy
			if (n.data.equals(ID)){
				return true;
			}
			else
				n = n.next;
		}
	
		return false;
	}

	@Override
	public Note[] toArray() {
		Note[] array = new Note[numberOfEntries];
		Node n = firstNote;
		int i = 0;
		while (n != null) { // could also be for i < numEntries
			// do something -- copy
			array[i] = n.data;
			i++;
			n = n.next;
		}
		return array;
	}
//	public static void main(String[] args) {
//		UnsortedLinkedList<Note> LL = new UnsortedLinkedList<Note>();
//		LL.add(new Note());
//		LL.add(new Note());
//		Note n = new Note();
////		System.out.println(LL.contains(n));
//		LL.add(n);
////		System.out.println(LL.contains(n));
//		Note[] array = LL.toArray();
//		LL.contains(new Note());
//		System.out.println(LL.contains(2));
//		for (int i = 0; i < array.length; i++){
//			System.out.println(array[i]);
//		
//		}
//	}
}
