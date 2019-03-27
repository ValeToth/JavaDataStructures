/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.tree;

import java.util.Collection;
import java.util.LinkedList;

/**
 *  the base class for Tree structres, gives varius options to manipulate the Tree
 * 
 * @author Jacopo_Wolf
 * @param <Node>
 * @param <T>
 */
public class Tree< Node extends ITreeNode<T> , T > implements ITree<Node,T>
{
/*
    variables
*/
    private Node root;
    
    /**
     * 
     * @return the root node
     */
    @Override
    public Node getRoot()
    {
        return this.root;
    }

    /**
     * sets the root node
     * @param node the new root node
     */
    @Override
    public void setRoot( Node node )
    {
        this.root = node;
    }

/*
    constructors
*/
    
    public Tree()
    {
        this(null);
    }
    public Tree( Node root )
    {
        this.root = root;
    }
    
/*
    methods
*/    
    
    /**
     * encapsulates Tree.getAllSubNodes.
     * @return a collection of all the TreeNodes in this tree.
     */
    @Override
    public Collection<ITreeNode<T>> getAllNodes()
    {
        LinkedList<ITreeNode<T>> out = new LinkedList<>();
        
        out.add(root);
        getAllSubNodes(root, out);
        
        return out;
        
    }
    
    /**
     * returns the edited out collection
     * @param <E>
     * @param root the root node
     * @param out the collecton to pass to wich elements will be added
     */
    static public<E> void getAllSubNodes ( ITreeNode<E> root, Collection<ITreeNode<E>> out )
    {      
        for ( ITreeNode<E> node : root.getSubElements() )
        {
            if ( node.hasNeighbors() )
                getAllSubNodes(node, out);
            
            out.add(node);
        }
    }
    
}
