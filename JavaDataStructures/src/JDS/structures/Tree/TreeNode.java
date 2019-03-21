/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.Tree;

import JDS.patterns.composite.IComposite;
import JDS.patterns.composite.IElement;
import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;

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
    public Collection<TreeNode<T>> getSubElements()
    {
        return this.subNodes;
    }

    @Override
    public boolean containsRecursive( Predicate<IElement> predicate )
    {
        ArrayList<IElement> out = new  ArrayList<>();
        IComposite.getAllRecursive(this, out);
        return out.stream().anyMatch( predicate );
    }

    @Override
    public Collection<TreeNode<T>> findRecursive( Predicate<IElement> predicate )
    {
        ArrayList<IElement> out = new  ArrayList<>();
        IComposite.getAllRecursive(this, out);
        ArrayList<TreeNode<T>> convOut = new ArrayList<>();
        out.stream().filter(predicate).forEach( (el) -> convOut.add((TreeNode<T>)el) );
        return convOut;
    }



    
}
