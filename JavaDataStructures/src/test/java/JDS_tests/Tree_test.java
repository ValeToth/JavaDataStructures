/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */


package JDS_tests;

import JDS.structures.tree.*;


class Tree_test
{
    public static void main( String[] args )
    {
        
        Tree<ITreeNode<String>,String> tree = new Tree<>();
        
        TreeNode<String> rootnode = new TreeNode<>("rootNode"), node2;
        tree.setRoot(rootnode);
        
        rootnode.getConnectedElements().add( new TreeNode<>("subnode1") );
        rootnode.getConnectedElements().add( node2 = new TreeNode<>("subnode2") );
        node2.getConnectedElements().add( new TreeNode<>("subSubNode1") );
        
        for ( ITreeNode<String> node : tree.getAllNodes() ) 
        {
            System.out.println( node.getContent() );
        }
    }
}
