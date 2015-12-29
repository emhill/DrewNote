package edu.drew.note;

// Vishnuvardhan Allampalli - AVL TREE Implementation - CSCI 230

public class AVLTree implements NoteCollection{ 

    private static class Node { //creating Node class variables
        Node left, right;
        Node parent;
        Note note;
        int height = 0;

        public Node(Note note, Node parent) {//Node Constructor
            this.note = note;
            this.parent = parent;
        }
        
        private Note getContent() {//method to get the note from the node
			return this.note;
		}
        
        void setLeftChild(Node child) { 
            if (child != null) {	//checking if child is not null
                child.parent = this;
            }         
            this.left = child;
        }

        void setRightChild(Node child) {
            if (child != null) { //checking if child is not null
                child.parent = this;
            }
            this.right = child;
        }
    }

    private Node root = null; //initializing the root node
    
    @Override
    public boolean add(Note data) { //method to ass a note to the tree
    	if (data == null) { //checks if the note is not null
        	return false;
        }
    	insert(root, data); //calls the insert method to do the adding to the tree
        return true;
    }

    private int height(Node node) { //method that checks the height (node to root distance) of any given node
        return node == null ? -1 : node.height;
    }

    private void insert(Node node, Note note) { // method that inserts the note in the tree
        if (root == null) { //ensures root is not null, if null the the newly inserted note is placed as a new root Node.
            root = new Node(note, null); //creates a new root node
            return;
        }
        if (note.getID() < node.note.getID()) { // if ID of note is less than the ID of the Node in the function parameter
            if (node.left != null) { //checks if left node is null
                insert(node.left, note); //recursive insert call on left Node of the Node in the function parameter
            } 
            else {
                node.left = new Node(note, node); //if left node is null then a new node is inserted there
            }
            rebalanceTreeRotRight(node, note);  //tree is balanced after each left insertion by rotating right
        }
        else if (note.getID() > node.note.getID()) { // if ID of note is greater than the ID of the Node in the function parameter
            if (node.right != null) {  //checks if right node is null
                insert(node.right, note); //recursive insert call on right Node of the Node in the function parameter
            } 
            else {
                node.right = new Node(note, node); //if right node is null then a new node is inserted there
            }
            rebalanceTreeRotLeft(node, note); //tree is balanced after each right insertion by rotating left
        }
        reHeight(node); //height is calculated for the newly inserted node
    }
    
    
	@Override
	public Note lookup(long ID) { // method that retrieves the note of a given ID
		Node temp = search(ID);
			return temp.note;
	}	
		
	@Override
    public boolean remove(long ID) { //removes not by given ID
		Node target = search(ID); //retrieving the node of the ID
		if (target != null) { // Checking if null is being passed
			target = deleteNode(target); //calling delete to delete the node
		       balanceTree(target.parent); // balancing tree after delete operation
		       return true; //true if removal is success
		}
        return false; //false if removal is failure
    }
	
	@Override
	public boolean remove(Note note) { //removes note by given note
			boolean remover=false;
			if (note == null) {
				remover = false; //false if removal is failure due to note being null
			}
			else if(!contains(note)){
				remover=false; //false if removal is failure due to note not found in tree
			}
			else if(isEmpty()||note==null) {
				remover=false; //false if removal is failure due to tree being empty
			}
			else {
				long id = note.getID(); 
				Node remove=search(id); //retrieving the node of the ID
				deleteNode(remove); //calling delete to delete the node
			}
			return remover;
	}

    private Node deleteNode(Node target) {//method that actually deletes the node
        if (target.parent == null) {
        	root = null;
        	return target;  //deletes root node if the node to be deleted is root node.
        }
    	else if (isLeaf(target) && target.parent != null) { //deletes leaf node
            if (isLeftChild(target)) {
                target.parent.left = null;
            } else {
                target.parent.right = null;
            }
        } else if ((target.left == null && target.right != null) || 
        		   (target.left != null && target.right == null)) { //for exact 1 child
            Node nonNullChild = target.left == null ? target.right : target.left; 
            if (isLeftChild(target)) {
                target.parent.setLeftChild(nonNullChild); 
            } else {
                target.parent.setRightChild(nonNullChild);
            }
        } else {//for 2 children
            Node immediatePredInOrder = immediatePredInOrder(target);
            target.note = immediatePredInOrder.note;
            target = deleteNode(immediatePredInOrder);
        }
        reHeight(target.parent);//calculate height of parent after the delete operation on the given node
        return target;
    }
	
    @Override
	public boolean isEmpty() { // method returns if the tree is empty
		if (root == null){
			return true;
		}
		return false;
	}
    
    @Override
	public int getSize() { //gets the tree size from root (the levels in the tree)
	  return(size(root)); 
	}
	
	private int size(Node node) { //Gets the size of the given branch
	  if (node == null) {
		  return(0); 
	  }
	  else { 
	    return(size(node.left) + 1 + size(node.right)); 
	  } 
	}
	
	@Override
	public boolean contains(Note note) { // method that tells if a given note exists in the tree
		long noteId = note.getID(); //retrieves the ID of the given note
		if (search(noteId) != null){ //calls the search method with the ID of the given note
			return true;
		}
		return false;
	}
	
	@Override
	public boolean contains(long ID) { //method that tells if a given ID exists in the tree
		if (search(ID) != null){ //calls the search method with the given ID
			return true;
		}
		return false;
	}
	
//////////////toArray method///////////////
	@Override
	public Note[] toArray() {
		Note[] array = new Note[getSize()];
		for(int i=1;i<array.length+1;i++) { //because by starting at 1 you end up being 1 iteration short
			if(root!=null)
				array[i-1] = inOrderTraverse(root, new Counter(i)).getContent(); //array index must be reduced by one in order to match the test case for loop
				//System.out.println(i+":"+array[i-1]);
			}
			return array;
	}
	
	
//////////////////////////////Private Methods to Search, Balance, Traverse////////////////////////////////////
	
	public Node search(long ID) { //calls binarysearch method to search for the given ID in the tree
		 return binarySearch(root, ID);
	}

	private Node binarySearch(Node node, long key) { //returns the node if found in the tree using binarysearch algorithm
		if (node == null) return null;
		if (key == node.note.getID()) {
			return node;
	    }
        if (key < node.note.getID() && node.left != null) {
	        return binarySearch(node.left, key);
        }
        if (key > node.note.getID() && node.right != null) {
            return binarySearch(node.right, key);
        }
        return null;
	}
	
	public static class Counter {
		private int value;
		public Counter(int initialValue) { 
			value = initialValue; 
		}
		public boolean decrement() { 
			value--; return value == 0; 
		}
		public boolean expired() { 
			return value <= 0; 
		}
	}
	
    public Node inOrderTraverse(Node rootNode, Counter counter){ //traverses the tree inOrder (LPR)
    	if  (rootNode != null && ! counter.expired()) {
		Node left = inOrderTraverse(rootNode.left, counter);
			if (left != null) {
				return left;
			} 
			else if (counter.decrement()) {
				return rootNode;
			} 
			else {
				return inOrderTraverse(rootNode.right, counter); 
			}
    	} 
    	else {
    		return null;
    	}
    }

	private void rebalanceTreeRotLeft(Node node, Note note) {
		if (height(node.right) - height(node.left) == 2) { //right heavier
			if (note.getID() > node.right.note.getID())
		        rotateLeft(node);
		    else {
		        rotateRightThenLeft(node);
		    }
		}
	}

	private void rebalanceTreeRotRight(Node node, Note note) {
		if (height(node.left) - height(node.right) == 2) { //left heavier
		    if (note.getID() < node.left.note.getID()) {
		        rotateRight(node);
		    } 
		    else {
		        rotateLeftThenRight(node);
		    }
		}
	}

    private void rotateRight(Node pivot) {
        Node parent = pivot.parent;
        Node leftChild = pivot.left;
        Node rightChildOfLeftChild = leftChild.right;
        pivot.setLeftChild(rightChildOfLeftChild);
        leftChild.setRightChild(pivot);
        if (parent == null) {
            this.root = leftChild;
            leftChild.parent = null;
            return;
        }
        if (parent.left == pivot) {
            parent.setLeftChild(leftChild);
        } else {
            parent.setRightChild(leftChild);
        }
        reHeight(pivot);
        reHeight(leftChild);
    }

    private void rotateLeft(Node pivot) {
        Node parent = pivot.parent;
        Node rightChild = pivot.right;
        Node leftChildOfRightChild = rightChild.left;
        pivot.setRightChild(leftChildOfRightChild);
        rightChild.setLeftChild(pivot);
        if (parent == null) {
            this.root = rightChild;
            rightChild.parent = null;
            return;
        }
        if (parent.left == pivot) {
            parent.setLeftChild(rightChild);
        } else {
            parent.setRightChild(rightChild);
        }
        reHeight(pivot);
        reHeight(rightChild);
    }

    private void reHeight(Node node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private void rotateLeftThenRight(Node node) {
        rotateLeft(node.left);
        rotateRight(node);
    }

    private void rotateRightThenLeft(Node node) {
        rotateRight(node.right);
        rotateLeft(node);
    }
    
    private Node immediatePredInOrder(Node node) {
        Node current = node.left;
        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    private boolean isLeftChild(Node child) {
        if (child == null || child.parent == null){
        	return false;
        }
    	return (child.parent.left == child);
    }

    @SuppressWarnings("unused")
	private boolean isRightChild(Node child) {
        if (child == null || child.parent == null){
        	return false;
        }
    	return (child.parent.right == child);
    }
    
    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    private int calDifference(Node node) {
        int rightHeight = height(node.right);
        int leftHeight = height(node.left);
        return rightHeight - leftHeight;
    }

    private void balanceTree(Node node) {
        if (node == null) {
        	return;
        }
    	int difference = calDifference(node);
        Node parent = node.parent;
        if (difference == -2) {
           if (height(node.left.left) >= height(node.left.right)) {
               rotateRight(node);
           } 
           else {
               rotateLeftThenRight(node);
           }
        } 
        else if (difference == 2) {
           if (height(node.right.right) >= height(node.right.left)) {
               rotateLeft(node);
            } 
            else {
               rotateRightThenLeft(node);
           }
       }
       if (parent != null) {
           balanceTree(parent);
       }
       reHeight(node);
   }

   public static void main(String[] args) {
	
    }
}