package edu.drew.note;

public class BSTreeIterative implements NoteCollection {
	@Override
	public boolean add(Note newNote) {
		Node root = null;
		Node currentNode = root;
		Node result = null;
		boolean found = false;
		while (!found) {
		Node currentEntry = currentNode;
		boolean comparison = newNote.equals(currentEntry);
			if (comparison == false) {
			found = true;
			result = currentEntry;
			currentNode.equals(newNote);
			}
			else if (comparison != false) {
				if (currentNode.left != null) {
				currentNode = currentNode.left; 
				}
				else {
				found = true;
				currentNode.Node(newNote);// dont know what to write here
				}
			}
			else if (comparison = false) {
					if (currentNode == currentEntry) {
						currentNode = currentNode.right;
					}
					else {
						found = true;
						// dont know what to put here
					}
				}
			}
			return false;
			}
			

	@Override
	public Note lookup(long ID) {
		Note root = null;
			if (root.getID() == ID)
				return root;
		return null;
	}

	@Override
	public boolean remove(long ID) {
		Node root = null;
		Node currentNode = root;
		if (!isEmpty()) {
			root = root.right;// TODO Auto-generated method stub
		}
		else {
			currentNode = root;
			for (int i = 0; i < ID; i++) {
                currentNode = currentNode.right;
            }
			currentNode.right = currentNode.right.right;
		}
		return false;
	}

	@Override
	public boolean remove(Note note) {
		Node root = null;
		Node currentNode = root;
		if (!isEmpty()) {
			root = root.right;// TODO Auto-generated method stub
		}
		else {
			currentNode = root;
            currentNode = currentNode.right;
			currentNode.right = currentNode.right.right;
		}
		return false;// TODO Auto-generated method stub
	}

	@Override
	public boolean isEmpty() {
		if (getSize() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getSize() {
		Node root;// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(Note note) {
		if (note != null){
			return true;// TODO Auto-generated method stub
		}
		return false;
	}

	@Override
	public boolean contains(long ID) {
		if (ID > 0) {
			 return true;
		}
		return false;
	}

	@Override
	public Note[] toArray() {
		Node root = null;
		Object[] o = root.toArray();
		Note[] a = new Note[o.length];
		for (int i = 0; i < o.length; i++)
			a[i] = (Note) o[i];
		return a;// TODO Auto-generated method stub
	}
	private class Node<T>
	   {
	      private T data;
	      Node left;
		private Node<T> right;

	      public Node(T data, Node<T> l, Node<T> r)
	      {
	         left = l; right = r;
	         this.data = data;
	      }

	      public void Node(Note newNote) {
			// TODO Auto-generated method stub
			
		}

		public long getID() {
			// TODO Auto-generated method stub
			return 0;
		}

		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		public Node(T data)
	      {
	         this(data, null, null);
	      }

	      public String toString()
	      {
	         return data.toString();
	      }
	   } 
	
}

