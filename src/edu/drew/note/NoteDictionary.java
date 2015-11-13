package edu.drew.note;

import java.util.HashMap;

public class NoteDictionary {

	private Node head;
	private int numEntries = 0;
	
	// Adds item to NodeDict
	public boolean add(String title, String text) {
		head = new Node(title, text, head);
		numEntries++; // Update number of notes
		return true; // Node added
	}
	
	// Inserts note at specific location
	public boolean insertAt(String title, String text, int spot) {
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
			prev.next = new Node(title,text,n);
			numEntries++;
			return true;
		}
	}
	
	// Removes item from NodeDict
	public String remove() {
		String removed = head.title+" : "+head.text;
		head = head.next;
		return removed;
	}
	
	// Removes specific item from NoteDict of 'title'
	public boolean remove(String title) {
		Node n = head;
		Node prev = head;
		while(n!=null) {
			if(n.title.equals(title)){
				prev.next = n.next;
				return true;
			}
			prev = n;
			n=n.next;
		}
		return false;
	}
	
	// Replaces note at 'title' with another note Node
	public boolean replace(String title,Node note) {
		Node n = head;
		Node next = head.next;
		while(n!=null) {
			if(n.title.equals(title)){
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
	
	// Returns a dictionary equivalent of the NodeDictionary
	// I dont think this is necessary... not sure though.
	public HashMap<String,String> toDict() {
		HashMap<String,String> dict = new HashMap<String,String>();
		Node n = head;
		while(n!=null){
			dict.put(n.title,n.text);
			n=n.next;
		}
		return dict;
	}
	
	// Converts NodeDictionary to a string to be printed to the console
	public String toString(){
		String dict="{";
		Node n = head;
		while(n.next!=null){
			dict += "'"+n.title+"' : '"+n.text+"', ";
			n=n.next;
		}
		dict += "'"+n.title+"' : '"+n.text+"'";
		dict+="}";
		return dict;
	}
	
	// Node class imported from other projects; modified to stores note Titles and Text
	private class Node {
	  private String title; // Note's title
	  private String text; // Note's text
	  private Node next; // Pointer to next note in the dictionary

		private Node(String Title, String Text) {
			this(Title, Text, null);	
		} 
		
		private Node(String Title, String Text, Node nextNode) {
			title = Title; // Title of note
			text = Text; // Text of the note 
			next = nextNode; // Pointer to next note
		} 
	} 
	
	public static void main(String[] args) {
		// Testing main functionality
		NoteDictionary q = new NoteDictionary();
		q.add("Hello World!", "This is my first note");
		q.add("Hello again World!", "Let's make another note");
		q.add("Third Note", "This is my third");
		System.out.println(q.toDict());
		//q.remove("Hello World!");
		System.out.println(q.toString());
	}

}
