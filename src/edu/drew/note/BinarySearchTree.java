package edu.drew.note;

public class BinarySearchTree implements NoteCollection{

	private Note[] note;
	private int first;
	private int last;
	
	public BinarySearchTree(){
		note = null;
		first = 0;
		last = 0;
	}

	@Override
	public boolean add(Note newNote) {
		// TODO Auto-generated method stub
		return false;
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
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public void add(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
