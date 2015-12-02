package edu.drew.note;

public class DictionaryUnsortedList<T> implements NoteCollection<T>{

private Node firstNode;
private int numEntries;

private class Node{
	private long id;
	private Note Note;
	private Node next;
	
	private Node(long key, Note value){
		this(key,value,null);
	}
	
	private Node(long key, Note value, Node nextNode){
		id=key;
		Note=value;
		next=nextNode;
	}
}

	@Override
	public boolean add(Note newNote){
		firstNode=new Node(Note.getID(),newNote,firstNode);
		numEntries++;
		return true;
	}
	
	public Note[] toArray(){
		Note[] array= (Note[]) new Object[numEntries];
		Node n=firstNode;
		int i=0;
		while(n!=null){
			array[i]=n.Note;
			i++;
			n=n.next;
		}
		return array;
	}
	
	public String toString(){
		String s="";
		Node n=firstNode;
		while (n!=null){
			s+=n.Note+"->";
			n=n.next;
		}
		s+=null;
		return s;
	}
	
	public boolean isEmpty(){
		if(numEntries<1){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean remove(long ID) {
		Node n=firstNode;
		Node prev=null;
		while (n!=null){
			if (n.id==ID){
				if (prev==null){
					firstNode=n.next;
				}
				else
					prev.next=n.next;
					numEntries--;
			}
			prev=n;
			n=n.next;
		}
		return false;
	}

	@Override
	public boolean remove(Note note) {
		Node n=firstNode;
		Node prev=null;
		while (n!=null){
			if (n.Note.equals(note)){
				if (prev==null){
					firstNode=n.next;
				}
				else
					prev.next=n.next;
					numEntries--;
			}
			prev=n;
			n=n.next;
		}
		return false;
	}
	
	public void clear(){
		while(!isEmpty()){
			firstNode=firstNode.next;
			numEntries--;
		}
	}
	
	@Override
	public Note lookup(long ID) {
		Node n=firstNode;
		while(n!=null){
			if(n.id==ID){
				return n.Note;
			}
			n=n.next;
		}
		return null;
	}

	@Override
	public int getSize() {
		return numEntries;
	}

	@Override
	public boolean contains(Note note) {
		Node n=firstNode;
		while(n!=null){
			if(n.Note.equals(note)){
				return true;
			}
			n=n.next;
		}
		return false;
	}

	@Override
	public boolean contains(long ID) {
		Node n=firstNode;
		while(n!=null){
			if(n.id==ID){
				return true;
			}
			n=n.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
