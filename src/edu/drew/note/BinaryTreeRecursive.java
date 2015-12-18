package edu.drew.note;


public class BinaryTreeRecursive implements NoteCollection  {
	private Node root;

/////////////constructor for class///////////////
	public BinaryTreeRecursive(){
		root = null;
	}
	
	public BinaryTreeRecursive(Note rootNote) {
		root = new Node(rootNote);
		
	}
	
	public BinaryTreeRecursive(Note rootNote, Node right, Node left) {
		root = new Node(rootNote,right,left);	
	}

		//node class
		private class Node{
			private Node childLeft;
			private Node childRight;
			private Node parent;
			@SuppressWarnings("unused")
			private long id;
			private Note note;
			
			
			private Node(long key, Note value, Node before, Node left, Node right){
				this.id=key;
				this.note=value;
				this.parent=before;
				this.childLeft=left;
				this.childRight=right;
			}

			private Node(Note newNote) {
				this(0,newNote,null,null,null);
			}
			
			private Node(Note newNote, Node guard) {
				this(newNote.getID(),newNote,guard,null,null);
	
			}
			
			private Node(Note rootNote, Node right, Node left) {
				this(rootNote.getID(),rootNote,null,right,left);
			}
			
			private Node(Note rootNote, Node guard, Node right, Node left) {
				this(rootNote.getID(),rootNote,guard,right,left);

			}

			private void setRight(Node right) {
				this.childRight=right;
				this.getRight().setParent(this);
			}
			
			private void setLeft(Node left) {
				this.childLeft=left;
				left.parent=this;
			}
			
			private void setParent(Node guard) {
				this.parent=guard;
			}
			
			private Node getRight() {
				return this.childRight;
			}
			
			private Node getLeft() {
				return this.childLeft;
			}
			
			private Node getParent() {
				return this.parent;
			}
			
			private long getID() {
				long ID=-5;
				if(this.note!=null&&this!=null)
					ID=this.note.getID();
				return ID;
			}
			
			private Node minValue() {
	            Node localMin=null;
				if (this.getLeft() == null)
	                  localMin=this;
	            else
	                  this.getLeft().minValue();
				return localMin;
	        }
			
			private Note getContent() {
				return this.note;
			}
			
			private void clear() {
				this.id=-39;
				this.note=null;
				this.parent=null;
				this.childRight=null;
				this.childLeft=null;
			}

			private boolean hasLeft() {
				return this.getLeft()!=null;
			}

			private boolean hasRight() {
				return this.getRight()!=null;
			}
			
			private boolean isLeaf() {
				return !this.hasLeft() && !this.hasRight();
			}
		}
	//end node class	

//////////////add method//////////////////
	@Override
	public boolean add(Note newNote) {
		boolean result=false;
		Node newNode = new Node(newNote);
		if(root==null){
			root = newNode;
			result=true;
		}else{
			Node current = root;
			if(newNote.getID()<current.getID())				
				if(!current.hasLeft()) {
					current.setLeft(newNode);
					result=true;
				}else{
					add(current.getLeft(), newNote);
				}
			else
				if(!current.hasRight()) {
					current.setRight(newNode);
					result=true;
				}else{
					add(current.getRight(), newNote);
				}
		}				
		return result;
	}
	
	private boolean add(Node rootNode, Note newEntry) { 
		boolean result = false; 
		if(rootNode==null)
			result=false;
		else if (rootNode.getID() > newEntry.getID()) { 
			if (rootNode.hasLeft()) 
				result = add(rootNode.getLeft(), newEntry); 
			else 
				rootNode.setLeft(new Node(newEntry, rootNode)); 
		} else { 
			assert rootNode.getID() < newEntry.getID(); 
			if (rootNode.hasRight()) 
				result = add(rootNode.getRight(), newEntry); 
			else 
				rootNode.setRight(new Node(newEntry, rootNode)); 
			} // end if 
		return result; 
		} // end addEntry

/////////////////lookup method/////////////////
	@Override
	public Note lookup(long id) {
		Note found=null;
		Node current=root;
		Node returned=null;
		if(!contains(id))
			found=null;
		else
			if(id==current.getID())
				found=current.getContent();
			else if(id>current.getID()) {
				current=current.getRight();
				returned=lookup(current, id);
				found=returned.getContent();
			}else {
				current=current.getLeft();
				returned=lookup(current, id);
				found=returned.getContent();
			}
		return found;
	}
	
	private Node lookup(Node current, long id) {
		Node found=null;
		if(id==current.getID())
			found=current;
		else if(id>current.getID()) {
			current=current.getRight();
			found=lookup(current, id);
		}else {
			current=current.getLeft();
			found=lookup(current, id);
		}
		return found;
		
	}
	
	private Node lookupNode(long id) {
		Node current=root;
		Node found=null;
		if(!contains(id))
			found=null;
		else
			if(id==current.getID())
				found=current;
			else if(id<current.getID()) {
				current=current.getRight();
				lookup(current, id);
			}else {
				current=current.getLeft();
				lookup(current, id);
			}
		return found;
	}


/////////////remove by ID method////////////////
	@Override
	public boolean remove(long id) {
		Node found=null;
		Node reorder=null;
		boolean success=false;
		if(!contains(id)) {
			success=false;
			System.out.println("Note not found.");
		}else if(isEmpty())
			success=false;
			System.out.println("The tree is empty! You can't remove from an empty tree.");
		found=lookupNode(id);
		if(found==null) {
			success=false;
		}else if(root.getID()==found.getID()&&found.isLeaf()) {
			root=null;
			success=true;
		}else if(found.isLeaf()) {
			if(found.getParent().getLeft()==found) {
				reorder=found.getParent();
				found=null;
				success=true;
			}else if(found.getParent().getRight()==found) {
				reorder=found.getParent();
				success=true;
			}
		}else {
			reorder=found.minValue();
			new Node(reorder.getID(),reorder.getContent(),found.getParent(),found.getRight(),found.getLeft());
			found.clear();
			reorder.clear();
			success=true;
		}
		return success;
	}

//////////////remove by Note method//////////////
	@Override
	public boolean remove(Note note) {
		boolean remover=false;
		if(!contains(note)){
			remover=false;
		}else if(isEmpty()||note==null) {
			remover=false;
		}else {
			long id = note.getID();
			remover=remove(id);
		}
		return remover;
	}


	
///////////////isEmpty method////////////////
	@Override
	public boolean isEmpty() {
		return root==null;
	}

////////////////getSize method///////////////
	@Override
	public int getSize() {
		return getSize(root);
	}
	
	private int getSize(Node currentRoot) {
		int size=0;
		if(currentRoot==null||currentRoot.getContent()==null) 
			size=0;
		else
			size = 1 + getSize(currentRoot.getLeft()) + getSize(currentRoot.getRight());
		return size;
	}

///////////////contains Note method//////////////
	@Override
	public boolean contains(Note note) {
		boolean success=false;
		if(!isEmpty()||note!=null)
			success=contains(note.getID());
		else
			success=false;
		return success;
	}

///////////////contains ID method////////////////
	@Override
	public boolean contains(long id) {
		return contains(root, id);
	}
	
	///overloading???///
	private boolean contains(Node current, long id) {
		if(isEmpty()||current==null)
			return false;
		else if(current.getID()==id)
			return true;
		else if(current.getID()<id)
			current=current.getRight();
			
		else if(current.getID()>id)
			current=current.getLeft();
		return contains(current, id);
	}


	 public static class Counter {
		   private int value;
		   public Counter(int initialValue) { value = initialValue; }
		   public boolean decrement() { value--; return value == 0; }
		   public boolean expired() { return value <= 0; }
		}


		public Node inOrderTraverse(Node rootNode, Counter counter){
		   if  (rootNode != null && ! counter.expired()) {
		       Node left = inOrderTraverse(rootNode.getLeft(), counter);
		       if (left != null) {
		            return left;
		       } else if (counter.decrement()) {
		            return rootNode;
		       } else {
		            return inOrderTraverse(rootNode.getRight(), counter); 
		       }
		   } else {
		       return null;
		   }
		}
	
	//////////////toArray method///////////////
	@Override
	public Note[] toArray() {
		Note[] array = new Note[getSize()];
		for(int i=1;i<array.length+1;i++) { //because by starting at 1 you end up being 1 iteration short
			if(root!=null)
				array[i-1] = inOrderTraverse(root, new Counter(i)).getContent(); //array index must be reduced by one in order to match the test case for loop
				System.out.println(i+":"+array[i-1]);
			}
			return array;
		}

	}
