package edu.drew.note;

import java.util.ArrayList;

public class ArrayListCollection implements NoteCollection {
	private ArrayList<Note> notes = new ArrayList<Note>();
	
	@Override
	public boolean add(Note newNote) {
		notes.add(newNote);
		return true;
	}

	@Override
	public Note lookup(long ID) {
		for (Note n : notes)
			if (n.getID() == ID)
				return n;
		return null;
	}

	@Override
	public boolean remove(long ID) {
		for (int i = 0; i < notes.size(); i++) {
			if (notes.get(i).getID() == ID) {
				notes.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(Note note) {
		return notes.remove(note);
	}

	@Override
	public boolean isEmpty() {
		return notes.size() == 0;
	}

	@Override
	public int getSize() {
		return notes.size();
	}

	@Override
	public boolean contains(Note note) {
		return notes.contains(note);
	}

	@Override
	public boolean contains(long ID) {
		return lookup(ID) != null;
	}

	@Override
	public Note[] toArray() {
		Object[] o = notes.toArray();
		Note[] a = new Note[o.length];
		for (int i = 0; i < o.length; i++)
			a[i] = (Note) o[i];
		return a;
	}

}
