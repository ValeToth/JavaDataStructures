/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */


package JDS_tests.structures;

import JDS.structures.tree.ITreeNode;
import JDS.structures.tree.*;


class Tree_test
{
    public static void main( String[] args )
    {
        
        Tree<ITreeNode<String>,String> tree = new Tree<>();
        
        TreeNode<String> rootnode = new TreeNode<>("rootNode"), node2;
        tree.setRoot(rootnode);
        
        rootnode.getSubElements().add( new TreeNode<>("subnode1") );
        rootnode.getSubElements().add( node2 = new TreeNode<>("subnode2") );
        node2.getSubElements().add( new TreeNode<>("subSubNode1") );
        
        for ( ITreeNode<String> node : tree.getAllNodes() ) 
        {
            System.out.println( node.getContent() );
        }
    }
}
