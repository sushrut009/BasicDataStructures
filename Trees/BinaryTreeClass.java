import java.util.Stack ;
public class BinaryTreeClass {
    TreeNode root ;

    // Constructor-------------------------------------------------------------------
    public BinaryTreeClass() {
        root = null ;
    }
    // -----------------------------------------------------------------------------
    public void  insertInTree(int value) { // Insert into the binary search tree
        if(root == null) {
            root = new TreeNode(value) ;
            return ;
        }
        TreeNode current = root ;
        TreeNode prev = null ;
        while(current != null) {
            prev = current;
            if (value > current.key) {
                current = current.right;
            } else if (value < current.key) {
                current = current.left;
            } else {
                System.out.println("Cannot insert duplicates into the BST");
                return;
            }
        }
        if(prev.key > value) {
            prev.left = new TreeNode(value) ;
        } else {
            prev.right = new TreeNode(value);
        }
    }
    //-------------------------------------------------------------------------------
    public void displayTreeInOrder(TreeNode root) {
         if(root != null) {
             displayTreeInOrder(root.left);
             root.displayNode();
             for(int i=0 ; i< 5 ; i++) {
                 System.out.println("\t\t|\t\t");
             }
             displayTreeInOrder(root.right);
         }
    }
    // -----------------------------------------------------------------------------
    public void inOrderTreeTraversalWithoutRecursion(TreeNode root) {
        // Uses stack
        TreeNode current = root ;
        Stack<TreeNode> S = new Stack<TreeNode>() ;
        boolean leftDone = false ;

        while(true) {
            if(!leftDone) {
                while (current != null) {
                    S.push(current);
                    current = current.left;
                    leftDone = true;
                } // while
            }
            if(S.isEmpty()) break ;
            current = S.pop() ;
            if(leftDone ) {
                System.out.println(current.key);
            }
            if(current.right != null) {
                current = current.right;
                leftDone = false ;
            } else {
                if(!S.isEmpty()) {
                    while (current == S.peek().right) {
                        current = S.pop();
                    }
                }
            }
        }
    }
    
    //-------------------------------------------------------------------------------

    public TreeNode searchInBinarySearchTree(int  key , TreeNode rootNode) {
        if(rootNode == null) return null ;
        if(rootNode.key == key ) {
            return rootNode ;
        }

        if(rootNode.key  > key) {
            return searchInBinarySearchTree(key , rootNode.left);
        } else {
            return searchInBinarySearchTree(key , rootNode.right);
        }
    }
    //----------------------------------------------------------------------------------
    public TreeNode searchInBinarySearchTreeIterative(TreeNode rootNode , int key )  {
        TreeNode current = rootNode ;
        while(current != null) {
            if(current.key == key ) {
                return current ;
            } else if(current.key > key ) {
                current = current.left ;
            } else {
                current = current.right ;
            }
        }

        return null ;
    }  // searchInBinarySearchTreeIterative
   
    //----------------------------------------------------------------------------------
    public TreeNode findMinBST(TreeNode rootNode) {
        TreeNode current = rootNode ;
        while(current.left != null) {
            current = current.left ;
        }
        return current ;
    }
    //----------------------------------------------------------------------------------
    
    public TreeNode findMinRecurse(TreeNode rootNode) {
        if(rootNode.left == null) return rootNode ;
        return findMinRecurse(rootNode.left) ;
    }
    //----------------------------------------------------------------------------------

    public TreeNode findMaxBST(TreeNode rootNode) {
        TreeNode current = rootNode ;
        while(current.right != null) {
            current = current.right ;
        }
        return current ;
    }
    //----------------------------------------------------------------------------------
    public TreeNode Successor_BST(TreeNode x) {
        // We use stack so that we can go back to the parent node .
        // We do not use a parent pointer attribute , so stack is useful
        TreeNode current = root ;
        Stack<TreeNode> S = new Stack<TreeNode>() ;
        while(current != null &&current.key != x.key ) {
            S.push(current);
            if(current.key > x.key) {
                current = current.left;
            } else if(current.key < x.key){
                current = current.right ;
            }
        }
        if(current == null) return null ;

        if(current.right != null) {
            return findMinBST(current.right);
        }
        while(!S.isEmpty() && S.peek().right == current) {
            current = S.pop() ;
        }
        if(S.isEmpty()) {
            return null ;
        } else {
            return S.pop();
        }
    }

    //----------------------------------------------------------------------------
    public TreeNode Predecessor_BST(TreeNode x) {
        // We use stack so that we can go back to the parent node .
        // We do not use a parent pointer attribute , so stack is useful
         TreeNode current = root ;
         Stack<TreeNode> S = new Stack<TreeNode>() ;
         while(current != null && current.key != x.key ) {
             S.push(current);
             if(current.key > x.key) {
                 current = current.left;
             } else if(current.key < x.key){
                 current = current.right ;
             }
         }
         if(current  == null) {
             return null ;
         }
         if(current.left != null) {
           return findMaxBST(current.left) ;
         }
         while(!S.isEmpty() && S.peek().right != current) {
             current = S.pop() ;
         }
         if( S.isEmpty()) {
             return null ;
         } else {
             return S.pop();
         }
    }
    //-----------------------------------------------------------------------------
    public void visitNode(TreeNode t) {
        System.out.println(t.key + " ");
    }
    //-----------------------------------------------------------------------------
    public void inOrderTreeTraversalWithoutRecursionNoStack(TreeNode T) {
       // Morris Inorder Traversal without stack
        TreeNode current = root ; // Root is pointed by the current node
        TreeNode predecessor ;
        while(current != null) {
            if(current.left == null) {
                visitNode(current) ;
                current = current.right ;
            } else  {
                predecessor = current.left ;
                while(predecessor.right != current && predecessor.right != null ) {
                    predecessor = predecessor.right ;
                }
                if(predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left ;
                } else {
                    predecessor.right = null ;
                    visitNode(current);
                    current = current.right;
                }
            }
        }
    }
    //------------------------------------------------------------------------------
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null ) return null ;

        if(root.key > key ) {
            root.left = deleteNode(root.left, key ) ;
        } else if(root.key < key) {
            root.right = deleteNode(root.right , key ) ;
        } else {
            // root has the key as its value
            if(root.left == null) {
                return root.right ;
            } else if(root.right == null) {
                return root.left ;
            } else {
                // two children case
                root.key = findMinBST(root.right).key ;
                root.right = deleteNode(root.right , root.key) ;

            }
        }
        return root ;
     }
    
  //---------------------------------------------------------------------------------
  
  public ArrayList<ArrayList<Integer>> levelOrderTraversalNonRecursive(TreeNode root ) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>() ; // Final array List of array list
      Queue<TreeNode> q = new LinkedList<TreeNode>() ;
      q.offer(root) ;
      q.offer(null) ;
      ArrayList<Integer> curr = new ArrayList<Integer>() ;
      Stack<ArrayList<Integer>> S = new Stack<ArrayList<Integer>>();
      TreeNode T ;
      while(!q.isEmpty()) {
          T = q.poll() ;
          if(T != null) {
              curr.add(T.key) ;
              if(T.left != null) {
                  q.offer(T.left) ;
              }
              if(T.right != null) {
                  q.offer(T.right);
              }
          } else {
              ArrayList<Integer> c_curr = new ArrayList<Integer>(curr) ;
              S.push(c_curr);
              res.add(c_curr);
              curr.clear();
              if(!q.isEmpty())
                  q.offer(null);
          }
      }

      while(!S.isEmpty()) {
          System.out.println(S.pop());
      }
      return res ;
    }
 }


 //----------------------------------------------------------------------------------------

  public int totalNodesInBinaryTree(TreeNode root) {
		// Recursive
		if(root == null ) return 0 ;
		int nodesInLeftSubtree = 0;
		int nodesInRightSubtree = 0 ;
		if(root.left != null) {
		   nodesInLeftSubtree = totalNodesInBinaryTree(root.left);
	    } 
	    if(root.right != null) {
	    	nodesInRightSubtree = totalNodesInBinaryTree(root.right);
	    }
	    return 1 + nodesInLeftSubtree + nodesInRightSubtree ;	
	}

  //----------------------------------------------------------------------------------------
  
  	public int maxInBinaryTreeWithoutRecursion(TreeNode root) {
		// We can use level order traversal
	    Queue<TreeNode> q = new LinkedList<TreeNode>() ;
	    int max = Integer.MIN_VALUE ;
	    q.offer(root) ;
	    q.offer(null) ;
	    TreeNode T ;
	    while(!q.isEmpty()) {
	    	T = q.poll();
	    	if(T != null) {
	    		max = java.lang.Math.max(max,T.key);
	    		if(T.left != null) {
	    			q.offer(T.left) ;
	    		}
	    		if(T.right != null) {
	    			q.offer(T.right) ;
	    		}
	    	} else {
	    		if(!q.isEmpty()) {
	    		  q.offer(null);
	    		}
	    	}
	    	
	    }    
	    return max ;
	}
