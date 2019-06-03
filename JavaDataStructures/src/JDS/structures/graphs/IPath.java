/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import java.util.*;


/**
 * interface for all Paths
 * @author JacopoWolf
 * @param <A> the type of the Arch metadata
 */
public interface IPath<A> extends List<IGraphNode<?,A>>
{
    
    /**
     * 
     * @param <NodeT>
     * @return the source node of this Path object
     */
    public <NodeT extends IGraphNode<?,A>> NodeT getSourceNode();
    
    /**
     * 
     * @param <NodeT>
     * @return the final node reached
     */
    public <NodeT extends IGraphNode<?,A>> NodeT getDestinationNode();
    
}
