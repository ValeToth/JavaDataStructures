/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.Tree;

import java.util.*;

/**
 *
 * @author Jacopo_Wolf
 * @param <T>
 */
public class TreeNode<T> implements ITreeNode<T>// Collection< ITreeNode<T> > should implement?
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
    
    public TreeNode ()
    {
        this.content = null;
        this.subNodes = new LinkedList<>();
    }
    
    
/*
    methods
*/

    
}
