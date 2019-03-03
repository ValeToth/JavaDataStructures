/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.Tree;

import java.util.stream.Stream;

/**
 *
 * @author Jacopo_Wolf
 * @param <T>
 * @param <Node>
 */
public class Tree<T, Node extends ITreeNode<T> > implements ITree<Node>
{
/*
    variables
*/
    private Node root;
    
    @Override
    public Node getRoot()
    {
        return this.root;
    }

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
    
    
    @Override
    public Stream<Node> getAllNodesStream()
    {
        //TODO: implement
    }
    
}
