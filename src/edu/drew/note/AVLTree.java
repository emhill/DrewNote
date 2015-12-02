package edu.drew.note;



public class AVLTree implements NoteCollection{
	
	private Node root;
	private int numEntries = 0;
	private int id = assignId(numEntries);
	public AVLTree() {
		root = null;
		// TODO Auto-generated constructor stub
	}

	@Override
/*	public boolean add(Note note) {
		int Id = assignId(numEntries);
		Node anotherNode;
		if	(root == null)
		{
			root = new Node(Id, note);
		}
		else
		{
			if (root.getRight() == null)
				anotherNode = new Node(Id, note);
                anotherNodeRight = add(root.getId(), getRight(), data);
            else
                node.left = insert(node.left, data);  
		}
			
		
		
		numEntries++;
		// TODO Auto-generated method stub
		return false;
	}
	*/
	public boolean add(Note note)
	{
		
		root = insert(root, id, note);
		return true;
    }
    /* Function to insert data recursively */
    private Node insert(Node node, int id, Note note)
    {
    	
    	if (node == null)
            node = new Node(id, note);
        else
        {
            if (node.getRight() == null)
                node.right = insert((Node) node.right, id, note);
            else
                node.left = insert((Node) node.left, id, note);             
        }
        return node;
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
		return root == null;
		//return true;
	
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return numEntries;
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
	
	private int assignId(int numEntries) {
		return numEntries+1;
	}
	
	 
	
	private class Node 	{
			  public Object left;
			public Object right;
			private long noteId;// Note's ID
			  private Note note; // A note in the tree
			  private Node nodeLeft; // Link to next left node in the tree
			  private Node nodeRight;//Link to next right node in the tree

				private Node(long nId, Note newNote)
				{
					this(nId, newNote, null, null);
				} // end default constructor
				
				private Node(long nId, Note newNote, Node lNode, Node rNode)
				{
					noteId = nId;
					note = newNote;
					nodeLeft = null;
					nodeRight = null;
					
				} // end custom constructor
				
				public void setLeft(Node lNode)
			     {
			         nodeLeft = lNode;
			     }
			     /* Function to set right node */ 
			     public void setRight(Node rNode)
			     {
			         nodeRight = rNode;
			     }
			     /* Function to get left node */
			     public Node getLeft()
			     {
			         return nodeLeft;
			     }
			     /* Function to get right node */
			     public Node getRight()
			     {
			         return nodeRight;
			     }
			} // end Node class
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
