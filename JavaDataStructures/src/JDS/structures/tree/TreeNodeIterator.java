/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.tree;

import JDS.patterns.composite.*;
import java.util.*;



/**
 *
 * @author JacopoWolf
 * @param <T>
 */
public final class TreeNodeIterator<T> implements ICompositeIterator<ITreeNode<T>>
{

    private Iterator<ITreeNode<T>> iterator;

    
    /**
     * new instance of TreeNodeIterator
     * @param sourceTreeNode 
     */
    public TreeNodeIterator( ITreeNode<T> sourceTreeNode )
    {
        LinkedList<ITreeNode<T>> allTreeNodes = new LinkedList<>();
        IComposite.getAllRecursive(sourceTreeNode, allTreeNodes, false);
        this.iterator = allTreeNodes.iterator();
    }
    
    
    @Override
    public boolean hasNext()
    {
        return iterator.hasNext();
    }

    @Override
    public ITreeNode<T> next()
    {
        return iterator.next();
    }
    
}
