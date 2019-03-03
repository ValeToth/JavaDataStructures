/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.Tree;

import java.util.*;

/**
 *
 * @author Jacopo_Wolf
 * @param <T>
 * @param <Node>
 */
public class TreeNode<T, Node extends TreeNode<T,Node> > implements ITreeNode<T>
{

/*
    variables
*/
    
    private T content;
    protected LinkedList<Node> subNodes;
    
    @Override
    public T getContent()
    {
        return content;
    }

    @Override
    public void setContent( T content )
    {
        this.content = content;
    }
    
    @Override
    public Collection<Node> getSubNodes()
    {
        return this.subNodes;
    }

    
/*
    constructors
*/
    
    public TreeNode ()
    {
        this.content = null;
        this.subNodes = new LinkedList<>();
    }
    
    
/*
    methods
*/

    

    @Override
    public boolean hasNeighbors()
    {
        return !this.subNodes.isEmpty();
    }

    
}
