/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;


import JDS.patterns.composite.*;
import java.util.*;


/**
 *
 * @author JacopoWolf
 * @param <G>
 */
public final class GraphNodeIterator< G extends IGraphNode> implements ICompositeIterator< G >
{
    
    private Iterator<G> iterator;

    
    /**
     * new instance of GraphNodeIterator starting from the specified Node
     * @param sourceTreeNode 
     */
    public GraphNodeIterator( G sourceTreeNode )
    {
        LinkedList<G> reachableNodes = new LinkedList<>();
        IComposite.getAllRecursive(sourceTreeNode, reachableNodes);
        this.iterator = reachableNodes.iterator();
    }
    
    
    @Override
    public boolean hasNext()
    {
        return iterator.hasNext();
    }

    @Override
    public G next()
    {
        return iterator.next();
    }
    
}
