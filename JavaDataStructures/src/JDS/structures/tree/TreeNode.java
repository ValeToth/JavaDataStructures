/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.tree;

import JDS.patterns.composite.*;
import java.util.*;
import java.util.stream.*;

/**
 *  rappresents a node in the tree structure with a content of type T
 * 
 * @author Jacopo_Wolf
 * @param <T> the content of this Node
 */
public class TreeNode<T> implements ITreeNode<T>
{

/*
    variables
*/
    
    private T content;
    protected LinkedList<TreeNode<T>> subNodes;
    
    /**
     * 
     * @return the content in this TreeNode
     */
    @Override
    public T getContent()
    {
        return content;
    }

    /**
     * sets the content of this TreeNode
     * @param content the new content
     */
    @Override
    public void setContent( T content )
    {
        this.content = content;
    }
    
    /**
     * 
     * @return the Nodes directly under this TreeNode
     */
    @Override
    public Collection<TreeNode<T>> getSubElements()
    {
        return this.subNodes;
    }
    
    
/*
    constructors
*/
    /**
     * new instance of a TreeNode with the specified content
     * @param content 
     */
    public TreeNode ( T content )
    {
        this.content = content;
        this.subNodes = new LinkedList<>();
    }
    
    /**
     * new empty TreeNode instance
     */
    public TreeNode ()
    {
        this(null);
    }
    
    
/*
    methods
*/

    
    /**
     * 
     * @return if this TReeNode has neighbor nodes under it
     */
    @Override
    public boolean hasNeighbors()
    {
        return !this.subNodes.isEmpty();
    }

    
    /**
     * 
     * @return the iterator of every TreeNode under this node
     */
    @Override
    public TreeNodeIterator iterator()
    {
        return new TreeNodeIterator(this);
    }

    
    /**
     * 
     * @return the stram of every TreeNode under this node
     */
    @Override
    public Stream<TreeNode<T>> stream()
    {
        ArrayList<TreeNode<T>> out = new ArrayList<>();
        IComposite.getAllRecursive(this, out, false);
        return out.stream();
    }
    
    /**
     * the parallel stream of every TreeNode under this node
     * @return 
     */
    @Override
    public Stream<? extends IElement> parallelStream()
    {
        ArrayList<TreeNode<T>> out = new ArrayList<>();
        IComposite.getAllRecursive(this, out, false);
        return out.parallelStream();
    }
    
    
    
   
}
