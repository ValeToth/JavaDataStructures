/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.tree;

import JDS.patterns.composite.IComposite;
import java.util.Collection;

/**
 * base interface for TreeNodes
 * @author Jacopo_Wolf
 * @param <T> type of content
 */
public interface ITreeNode<T> extends IComposite<T>
{    
    @Override
    public Collection<? extends ITreeNode<T>> getSubElements(); 
    
    boolean hasNeighbors();  
}
