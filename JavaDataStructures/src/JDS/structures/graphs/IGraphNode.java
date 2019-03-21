/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import JDS.structures.tree.ITreeNode;
import java.util.Collection;
import java.util.function.Function;

/**
 *
 * @author Jacopo_Wolf
 * @param <T>
 */
public interface IGraphNode<T> extends ITreeNode<T>
{
    /**
     * the operation this node will do when called
     * @return a connected node basing on function.
     */
    public Function<T,IGraphNode<T>> function();
    
    
    @Override
    public Collection<? extends IGraphNode<T>> getSubElements();
    
    
    
}
