/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs.specific;

import JDS.structures.graphs.*;

/**
 *
 * @author Jacopo_Wolf
 * @param <T>
 */
public class WeightedGraphNode<T> extends GraphNode<T, Integer>
{

    /**
     *  instantiates a new WeighedGraphNode
     */
    public WeightedGraphNode ()
    {
    }
    
    /**
     *  instantiates a new WeighedGraphNode
     * @param content add this to the new instance
     */
    public WeightedGraphNode( T content )
    {
        super(content);
    }

    
    
    
    @Override
    public void addGraphNode ( IGraphNode<T, Integer> node, Integer archValue)
    {
        this.connections.add( new Arch<>(archValue, node) );
    }

    @Override
    public void addGraphNode( IGraphNode<T, Integer> node )
    {
        this.connections.add( new Arch<>(Integer.MAX_VALUE, node) );
    }
    
    
}