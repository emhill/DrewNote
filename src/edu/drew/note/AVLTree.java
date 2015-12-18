package edu.drew.note;

public class AVLTree implements NoteCollection{

    private static class Node {
        Node left, right;
        Node parent;
        Note note;
       //int value;
        int height = 0;

        public Node(Note note, Node parent) {
            this.note = note;
            this.parent = parent;
        }
        
        private Note getContent() {
			return this.note;
		}
        
        void setLeftChild(Node child) {
            if (child != null) {
                child.parent = this;
            }

            this.left = child;
        }

        void setRightChild(Node child) {
            if (child != null) {
                child.parent = this;
            }

            this.right = child;
        }
    }

    private Node root = null;
    
    public boolean add(Note data) {
    	if (data == null) {
        	return false;
        }
    	insert(root, data);
        return true;
    }

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    private void insert(Node node, Note note) {
        if (root == null) {
            root = new Node(note, null);
            return;
        }
        
        if (note.getID() < node.note.getID()) {
            if (node.left != null) {
                insert(node.left, note);
            } 
            else {
                node.left = new Node(note, node);
            }
           
            rebalanceTreeRotRight(node, note);
        }
            
            else if (note.getID() > node.note.getID()) {
            
            if (node.right != null) {
                insert(node.right, note);
            } 
            else {
                node.right = new Node(note, node);
            }

            rebalanceTreeRotLeft(node, note);
        }

        reHeight(node);
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
    
//	@Override
//	public boolean remove(Note note) {
//		
//		if (note == null) {
//			return false;
//		}
//	    Node target = search(note.getID());
//	    
//        if (target == null) {
//        	return false;
//        }
//       
//        target = deleteNode(target);
//        balanceTree(target.parent);
//        return true;
//		// TODO Auto-generated method stub
//	}

	@Override
    public boolean remove(long ID) {
// Checking if null is being passed
//		String id  = Long.toString(ID);
//		if(id != null) {
			Node target = search(ID); //retrieving the node of the ID
			//System.out.println(target);	
			if (target != null) {
//					return false;
//        	}
//			else {
				target = deleteNode(target); //calling delete to delete the node
		        balanceTree(target.parent); // balancing tree after delete operation
		        return true;
			}
        
//		}
		return false;
    }
	
	@Override
	public boolean remove(Note note) {
			boolean remover=false;
			if (note == null) {
				remover = false;
			}
			else if(!contains(note)){
				remover=false;
			}
			else if(isEmpty()||note==null) {
				remover=false;
			}
			else {
				long id = note.getID();
				Node remove=search(id);
				deleteNode(remove);
			}
			return remover;
	}

    private Node deleteNode(Node target) {
        if (target.parent == null) {
        	root = null;
        	return target;
        }
    	else if (isLeaf(target) && target.parent != null) { //leaf - 
            if (isLeftChild(target)) {
                target.parent.left = null;
            } else {
                target.parent.right = null;
            }
        } else if ((target.left == null && target.right != null) || 
        		   (target.left != null && target.right == null)) { //exact 1 child
            Node nonNullChild = target.left == null ? target.right : target.left; 
            if (isLeftChild(target)) {
                target.parent.setLeftChild(nonNullChild); 
            } else {
                target.parent.setRightChild(nonNullChild);
            }
        } else {//2 children
            Node immediatePredInOrder = immediatePredInOrder(target);
            target.note = immediatePredInOrder.note;
            target = deleteNode(immediatePredInOrder);
        }

        reHeight(target.parent);
        return target;
    }
    // what if the parent is null.check for that case everywhere. 
    // What if I have a single node in the tree
    
    

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
            } else {
                rotateLeftThenRight(node);
            }
        } else if (difference == 2) {
            if (height(node.right.right) >= height(node.right.left)) {
                rotateLeft(node);
            } else {
                rotateRightThenLeft(node);
            }
        }

        if (parent != null) {
            balanceTree(parent);
        }

        reHeight(node);
    }

	public boolean contains(Note note) {
		long noteId = note.getID();
		if (search(noteId) != null){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean contains(long ID) {
		if (search(ID) != null){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	
    public Node search(long ID) {
        return binarySearch(root, ID);
    }

    private Node binarySearch(Node node, long key) {
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
    
	@Override
	public Note lookup(long ID) {
		Node temp = search(ID);
			return temp.note;
	}
	
//	 public Note[] toArray() {
//		 	Node n = root;
//	    	Note[] notes = preOrderArray(n);
//			return notes;
//	 }
//	  
//	 private Note[] preOrderArray(Node node) {
//			Note[] notes = new Note[getSize()];
//			Node n = root;
//			if (node != null) {
//				for(int i=0;i<getSize(); i++) {
//					notes[i] = n.note;
//					preOrderArray(node.left);
//		            //notes[i] = n.note;
//		            preOrderArray(node.right);
//		            //notes[i] = n.note;
//				}
//			}
//			return notes;
//	 }

	public static class Counter {
		private int value;
		public Counter(int initialValue) { value = initialValue; }
		public boolean decrement() { value--; return value == 0; }
		public boolean expired() { return value <= 0; }
		}
		
		
		public Node inOrderTraverse(Node rootNode, Counter counter){
		if  (rootNode != null && ! counter.expired()) {
		Node left = inOrderTraverse(rootNode.left, counter);
		if (left != null) {
		return left;
				       } else if (counter.decrement()) {
				            return rootNode;
				       } else {
				            return inOrderTraverse(rootNode.right, counter); 
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
						//System.out.println(i+":"+array[i-1]);
					}
					return array;
				}
    public void traverseInOrder() {
        //System.out.println("ROOT " + root.toString());
        inorder(root);
        //System.out.println();
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
           // System.out.print(node.toString());
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
       AVLTree avl = new AVLTree();
       Note happy = new Note();
       Note sad = new Note();
       
//        avl.add(happy);
//        avl.traverseInOrder();
//        avl.add(sad);
//        avl.traverseInOrder();
//        System.out.println(avl.getSize());
//        
       /* avl.insert(1);
        avl.traverseInOrder();
        avl.insert(2);
        avl.traverseInOrder();
        avl.insert(3);
        avl.traverseInOrder();
        avl.insert(4);
        avl.traverseInOrder();
        avl.delete(1);
        avl.traverseInOrder();
        avl.insert(5);
        avl.traverseInOrder();
        avl.insert(6);
        avl.traverseInOrder();
        avl.delete(3);
        avl.traverseInOrder();
        avl.delete(5);
        avl.traverseInOrder();
  */
    }

	
		

	public boolean isEmpty() {
		if (root == null){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}



	/**
	* Gets the size of the current binary tree.
	*/
	public int getSize() {
	  return(size(root)); 
	}
	/**
	* Gets the size of the given branch
	* @param node The branch to count from.
	*/
	private int size(Node node) { 
	  if (node == null) return(0); 
	  else { 
	    return(size(node.left) + 1 + size(node.right)); 
	  } 
	}



}