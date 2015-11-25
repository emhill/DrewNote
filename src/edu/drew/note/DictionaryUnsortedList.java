package edu.drew.note;

public class DictionaryUnsortedList<T> extends Note{

	public DictionaryUnsortedList(String t, String txt) {
		super(t, txt);
		// TODO Auto-generated constructor stub
	}

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
	
	public void add(long key, Note value){
		firstNode=new Node(key,value,firstNode);
		numEntries++;
	}
	
	public T[] toArray(){
		T[] array= (T[]) new Object[numEntries];
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
	
	public int getCurrentSize(){
		return numEntries;
	}
	
	public T remove(){
		T result=firstNode.Note;
		firstNode=firstNode.next;
		numEntries--;
		return result;
	}
	
	public boolean T remove(long key){
		Node n=firstNode;
		Node prev=null;
		while (n!=null){
			if (n.id==key){
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
			remove();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
