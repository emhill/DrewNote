package edu.drew.note;


public class LinkedList<T> implements NoteCollection {


		
		public Node firstNote;
		public int numberOfEntries;
		
		public LinkedList() {
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
		} // Change T's to notes and print each notes!!

		
		
		@Override
		public boolean add(Note newNote) {
			//Note<T> newNote = new Note<T>(newEntry);
			newNote.setNextNote(firstNote);
			
			firstNote = newNote;
			numberOfEntries++;
			
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(Note note) {
		boolean found = false;
		Note currentNote = firstNote;
		
		while(!found && (currentNote != null)) {
			if (newEntry.equals(currentNote.data))
				found = true;
			else
				currentNote = currentNote.next;
		}
		return found;
	}

	@Override
	public boolean contains(long ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Note[] toArray() {
		Note[] result = (Note[]) new Object[numberOfEntries];
		
		int index = 0;
		
		Note currentNote = firstNote;
		while((index < numberOfEntries) && (currentNote != null)) {
			result[index] = currentNote.data;
			index++;
			currentNote = currentNote.next;
		}
		return result;
	}

}
