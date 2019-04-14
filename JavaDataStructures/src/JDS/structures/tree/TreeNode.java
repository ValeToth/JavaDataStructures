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
    public Collection<TreeNode<T>> getSubElements()
    {
        return this.subNodes;
    }
    
    
/*
    constructors
*/
    
    public TreeNode ( T content )
    {
        this.content = content;
        this.subNodes = new LinkedList<>();
    }
    
    public TreeNode ()
    {
        this(null);
    }
    
    
/*
    methods
*/

    

    @Override
    public boolean hasNeighbors()
    {
        return !this.subNodes.isEmpty();
    }

    
    
    @Override
    public TreeNodeIterator iterator()
    {
        return new TreeNodeIterator(this);
    }

    

    @Override
    public Stream<TreeNode<T>> stream()
    {
        ArrayList<TreeNode<T>> out = new ArrayList<>();
        IComposite.getAllRecursive(this, out, false);
        return out.stream();
    }
    
    @Override
    public Stream<? extends IElement> parallelStream()
    {
        ArrayList<TreeNode<T>> out = new ArrayList<>();
        IComposite.getAllRecursive(this, out, false);
        return out.parallelStream();
    }
    
    
    
   
}
